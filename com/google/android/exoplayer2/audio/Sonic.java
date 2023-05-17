package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class Sonic {
    public static final int AMDF_FREQUENCY = 4000;
    public static final int MAXIMUM_PITCH = 400;
    public static final int MINIMUM_PITCH = 65;
    public final short[] downSampleBuffer;
    public short[] inputBuffer;
    public int inputBufferSize;
    public final int inputSampleRateHz;
    public int maxDiff;
    public final int maxPeriod;
    public final int maxRequired;
    public int minDiff;
    public final int minPeriod;
    public final int numChannels;
    public int numInputSamples;
    public int numOutputSamples;
    public int numPitchSamples;
    public short[] outputBuffer;
    public int outputBufferSize;
    public final float pitch;
    public short[] pitchBuffer;
    public int pitchBufferSize;
    public int prevMinDiff;
    public final float rate;
    public int remainingInputToCopy;
    public final float speed;
    public int oldRatePosition = 0;
    public int newRatePosition = 0;
    public int prevPeriod = 0;

    public Sonic(int i, int i2, float f, float f2, int i3) {
        this.inputSampleRateHz = i;
        this.numChannels = i2;
        this.minPeriod = i / 400;
        int i4 = i / 65;
        this.maxPeriod = i4;
        int i5 = i4 * 2;
        this.maxRequired = i5;
        this.downSampleBuffer = new short[i5];
        this.inputBufferSize = i5;
        this.inputBuffer = new short[i5 * i2];
        this.outputBufferSize = i5;
        this.outputBuffer = new short[i5 * i2];
        this.pitchBufferSize = i5;
        this.pitchBuffer = new short[i5 * i2];
        this.speed = f;
        this.pitch = f2;
        this.rate = i / i3;
    }

    private void adjustRate(float f, int i) {
        int i2;
        int i3;
        if (this.numOutputSamples == i) {
            return;
        }
        int i4 = this.inputSampleRateHz;
        int i5 = (int) (i4 / f);
        while (true) {
            if (i5 <= 16384 && i4 <= 16384) {
                break;
            }
            i5 /= 2;
            i4 /= 2;
        }
        moveNewSamplesToPitchBuffer(i);
        int i6 = 0;
        while (true) {
            int i7 = this.numPitchSamples;
            boolean z = true;
            if (i6 < i7 - 1) {
                while (true) {
                    i2 = this.oldRatePosition;
                    int i8 = (i2 + 1) * i5;
                    i3 = this.newRatePosition;
                    if (i8 <= i3 * i4) {
                        break;
                    }
                    enlargeOutputBufferIfNeeded(1);
                    int i9 = 0;
                    while (true) {
                        int i10 = this.numChannels;
                        if (i9 < i10) {
                            this.outputBuffer[(this.numOutputSamples * i10) + i9] = interpolate(this.pitchBuffer, (i10 * i6) + i9, i4, i5);
                            i9++;
                        }
                    }
                    this.newRatePosition++;
                    this.numOutputSamples++;
                }
                int i11 = i2 + 1;
                this.oldRatePosition = i11;
                if (i11 == i4) {
                    this.oldRatePosition = 0;
                    if (i3 != i5) {
                        z = false;
                    }
                    Assertions.checkState(z);
                    this.newRatePosition = 0;
                }
                i6++;
            } else {
                removePitchSamples(i7 - 1);
                return;
            }
        }
    }

    private void changeSpeed(float f) {
        int insertPitchPeriod;
        int i = this.numInputSamples;
        if (i < this.maxRequired) {
            return;
        }
        int i2 = 0;
        do {
            if (this.remainingInputToCopy > 0) {
                insertPitchPeriod = copyInputToOutput(i2);
            } else {
                int findPitchPeriod = findPitchPeriod(this.inputBuffer, i2, true);
                if (f > 1.0d) {
                    insertPitchPeriod = findPitchPeriod + skipPitchPeriod(this.inputBuffer, i2, f, findPitchPeriod);
                } else {
                    insertPitchPeriod = insertPitchPeriod(this.inputBuffer, i2, f, findPitchPeriod);
                }
            }
            i2 += insertPitchPeriod;
        } while (this.maxRequired + i2 <= i);
        removeProcessedInputSamples(i2);
    }

    private void moveNewSamplesToPitchBuffer(int i) {
        int i2 = this.numOutputSamples - i;
        int i3 = this.numPitchSamples + i2;
        int i4 = this.pitchBufferSize;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.pitchBufferSize = i5;
            this.pitchBuffer = Arrays.copyOf(this.pitchBuffer, i5 * this.numChannels);
        }
        short[] sArr = this.outputBuffer;
        int i6 = this.numChannels;
        System.arraycopy(sArr, i * i6, this.pitchBuffer, this.numPitchSamples * i6, i6 * i2);
        this.numOutputSamples = i;
        this.numPitchSamples += i2;
    }

    private int copyInputToOutput(int i) {
        int min = Math.min(this.maxRequired, this.remainingInputToCopy);
        copyToOutput(this.inputBuffer, i, min);
        this.remainingInputToCopy -= min;
        return min;
    }

    private void enlargeInputBufferIfNeeded(int i) {
        int i2 = this.numInputSamples + i;
        int i3 = this.inputBufferSize;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.inputBufferSize = i4;
            this.inputBuffer = Arrays.copyOf(this.inputBuffer, i4 * this.numChannels);
        }
    }

    private void enlargeOutputBufferIfNeeded(int i) {
        int i2 = this.numOutputSamples + i;
        int i3 = this.outputBufferSize;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.outputBufferSize = i4;
            this.outputBuffer = Arrays.copyOf(this.outputBuffer, i4 * this.numChannels);
        }
    }

    private void removePitchSamples(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.pitchBuffer;
        int i2 = this.numChannels;
        System.arraycopy(sArr, i * i2, sArr, 0, (this.numPitchSamples - i) * i2);
        this.numPitchSamples -= i;
    }

    private void removeProcessedInputSamples(int i) {
        int i2 = this.numInputSamples - i;
        short[] sArr = this.inputBuffer;
        int i3 = this.numChannels;
        System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
        this.numInputSamples = i2;
    }

    public void getOutput(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.numChannels, this.numOutputSamples);
        shortBuffer.put(this.outputBuffer, 0, this.numChannels * min);
        int i = this.numOutputSamples - min;
        this.numOutputSamples = i;
        short[] sArr = this.outputBuffer;
        int i2 = this.numChannels;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public void queueInput(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.numChannels;
        int i2 = remaining / i;
        enlargeInputBufferIfNeeded(i2);
        shortBuffer.get(this.inputBuffer, this.numInputSamples * this.numChannels, ((i * i2) * 2) / 2);
        this.numInputSamples += i2;
        processStreamInput();
    }

    private void copyToOutput(short[] sArr, int i, int i2) {
        enlargeOutputBufferIfNeeded(i2);
        int i3 = this.numChannels;
        System.arraycopy(sArr, i * i3, this.outputBuffer, this.numOutputSamples * i3, i3 * i2);
        this.numOutputSamples += i2;
    }

    private void downSampleInput(short[] sArr, int i, int i2) {
        int i3 = this.maxRequired / i2;
        int i4 = this.numChannels;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.downSampleBuffer[i7] = (short) (i8 / i5);
        }
    }

    private boolean previousPeriodBetter(int i, int i2, boolean z) {
        if (i == 0 || this.prevPeriod == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.prevMinDiff * 3) {
                return false;
            }
            return true;
        } else if (i <= this.prevMinDiff) {
            return false;
        } else {
            return true;
        }
    }

    private int findPitchPeriod(short[] sArr, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = this.inputSampleRateHz;
        if (i5 > 4000) {
            i2 = i5 / 4000;
        } else {
            i2 = 1;
        }
        if (this.numChannels == 1 && i2 == 1) {
            i3 = findPitchPeriodInRange(sArr, i, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i, i2);
            int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i2, this.maxPeriod / i2);
            if (i2 != 1) {
                int i6 = findPitchPeriodInRange * i2;
                int i7 = i2 * 4;
                int i8 = i6 - i7;
                int i9 = i6 + i7;
                int i10 = this.minPeriod;
                if (i8 < i10) {
                    i8 = i10;
                }
                int i11 = this.maxPeriod;
                if (i9 > i11) {
                    i9 = i11;
                }
                if (this.numChannels == 1) {
                    i3 = findPitchPeriodInRange(sArr, i, i8, i9);
                } else {
                    downSampleInput(sArr, i, 1);
                    i3 = findPitchPeriodInRange(this.downSampleBuffer, 0, i8, i9);
                }
            } else {
                i3 = findPitchPeriodInRange;
            }
        }
        if (previousPeriodBetter(this.minDiff, this.maxDiff, z)) {
            i4 = this.prevPeriod;
        } else {
            i4 = i3;
        }
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = i3;
        return i4;
    }

    private int findPitchPeriodInRange(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.numChannels;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                i9 += Math.abs(sArr[i4 + i10] - sArr[(i4 + i2) + i10]);
            }
            if (i9 * i7 < i5 * i2) {
                i7 = i2;
                i5 = i9;
            }
            if (i9 * i6 > i8 * i2) {
                i6 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.minDiff = i5 / i7;
        this.maxDiff = i8 / i6;
        return i7;
    }

    private int insertPitchPeriod(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.remainingInputToCopy = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        enlargeOutputBufferIfNeeded(i4);
        int i5 = this.numChannels;
        System.arraycopy(sArr, i * i5, this.outputBuffer, this.numOutputSamples * i5, i5 * i2);
        overlapAdd(i3, this.numChannels, this.outputBuffer, this.numOutputSamples + i2, sArr, i + i2, sArr, i);
        this.numOutputSamples += i4;
        return i3;
    }

    private short interpolate(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[i + this.numChannels];
        int i4 = this.newRatePosition * i2;
        int i5 = this.oldRatePosition;
        int i6 = i5 * i3;
        int i7 = (i5 + 1) * i3;
        int i8 = i7 - i4;
        int i9 = i7 - i6;
        return (short) (((s * i8) + ((i9 - i8) * s2)) / i9);
    }

    private int skipPitchPeriod(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.remainingInputToCopy = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        enlargeOutputBufferIfNeeded(i3);
        overlapAdd(i3, this.numChannels, this.outputBuffer, this.numOutputSamples, sArr, i, sArr, i + i2);
        this.numOutputSamples += i3;
        return i3;
    }

    public static void overlapAdd(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    private void processStreamInput() {
        int i = this.numOutputSamples;
        float f = this.speed;
        float f2 = this.pitch;
        float f3 = f / f2;
        float f4 = this.rate * f2;
        double d = f3;
        if (d <= 1.00001d && d >= 0.99999d) {
            copyToOutput(this.inputBuffer, 0, this.numInputSamples);
            this.numInputSamples = 0;
        } else {
            changeSpeed(f3);
        }
        if (f4 != 1.0f) {
            adjustRate(f4, i);
        }
    }

    public int getSamplesAvailable() {
        return this.numOutputSamples;
    }

    public void queueEndOfStream() {
        int i;
        int i2 = this.numInputSamples;
        float f = this.speed;
        float f2 = this.pitch;
        int i3 = this.numOutputSamples + ((int) ((((i2 / (f / f2)) + this.numPitchSamples) / (this.rate * f2)) + 0.5f));
        enlargeInputBufferIfNeeded((this.maxRequired * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.maxRequired;
            int i5 = this.numChannels;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.inputBuffer[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.numInputSamples += i * 2;
        processStreamInput();
        if (this.numOutputSamples > i3) {
            this.numOutputSamples = i3;
        }
        this.numInputSamples = 0;
        this.remainingInputToCopy = 0;
        this.numPitchSamples = 0;
    }
}
