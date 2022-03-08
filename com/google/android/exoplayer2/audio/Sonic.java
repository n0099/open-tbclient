package com.google.android.exoplayer2.audio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class Sonic {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AMDF_FREQUENCY = 4000;
    public static final int MAXIMUM_PITCH = 400;
    public static final int MINIMUM_PITCH = 65;
    public transient /* synthetic */ FieldHolder $fh;
    public final short[] downSampleBuffer;
    public short[] inputBuffer;
    public int inputBufferSize;
    public final int inputSampleRateHz;
    public int maxDiff;
    public final int maxPeriod;
    public final int maxRequired;
    public int minDiff;
    public final int minPeriod;
    public int newRatePosition;
    public final int numChannels;
    public int numInputSamples;
    public int numOutputSamples;
    public int numPitchSamples;
    public int oldRatePosition;
    public short[] outputBuffer;
    public int outputBufferSize;
    public final float pitch;
    public short[] pitchBuffer;
    public int pitchBufferSize;
    public int prevMinDiff;
    public int prevPeriod;
    public final float rate;
    public int remainingInputToCopy;
    public final float speed;

    public Sonic(int i2, int i3, float f2, float f3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.inputSampleRateHz = i2;
        this.numChannels = i3;
        this.minPeriod = i2 / 400;
        int i7 = i2 / 65;
        this.maxPeriod = i7;
        int i8 = i7 * 2;
        this.maxRequired = i8;
        this.downSampleBuffer = new short[i8];
        this.inputBufferSize = i8;
        this.inputBuffer = new short[i8 * i3];
        this.outputBufferSize = i8;
        this.outputBuffer = new short[i8 * i3];
        this.pitchBufferSize = i8;
        this.pitchBuffer = new short[i8 * i3];
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.prevPeriod = 0;
        this.speed = f2;
        this.pitch = f3;
        this.rate = i2 / i4;
    }

    private void adjustRate(float f2, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.numOutputSamples == i2) {
            return;
        }
        int i5 = this.inputSampleRateHz;
        int i6 = (int) (i5 / f2);
        while (true) {
            if (i6 <= 16384 && i5 <= 16384) {
                break;
            }
            i6 /= 2;
            i5 /= 2;
        }
        moveNewSamplesToPitchBuffer(i2);
        int i7 = 0;
        while (true) {
            int i8 = this.numPitchSamples;
            if (i7 < i8 - 1) {
                while (true) {
                    i3 = this.oldRatePosition;
                    int i9 = (i3 + 1) * i6;
                    i4 = this.newRatePosition;
                    if (i9 <= i4 * i5) {
                        break;
                    }
                    enlargeOutputBufferIfNeeded(1);
                    int i10 = 0;
                    while (true) {
                        int i11 = this.numChannels;
                        if (i10 < i11) {
                            this.outputBuffer[(this.numOutputSamples * i11) + i10] = interpolate(this.pitchBuffer, (i11 * i7) + i10, i5, i6);
                            i10++;
                        }
                    }
                    this.newRatePosition++;
                    this.numOutputSamples++;
                }
                int i12 = i3 + 1;
                this.oldRatePosition = i12;
                if (i12 == i5) {
                    this.oldRatePosition = 0;
                    Assertions.checkState(i4 == i6);
                    this.newRatePosition = 0;
                }
                i7++;
            } else {
                removePitchSamples(i8 - 1);
                return;
            }
        }
    }

    private void changeSpeed(float f2) {
        int i2;
        int insertPitchPeriod;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65538, this, f2) == null) || (i2 = this.numInputSamples) < this.maxRequired) {
            return;
        }
        int i3 = 0;
        do {
            if (this.remainingInputToCopy > 0) {
                insertPitchPeriod = copyInputToOutput(i3);
            } else {
                int findPitchPeriod = findPitchPeriod(this.inputBuffer, i3, true);
                if (f2 > 1.0d) {
                    insertPitchPeriod = findPitchPeriod + skipPitchPeriod(this.inputBuffer, i3, f2, findPitchPeriod);
                } else {
                    insertPitchPeriod = insertPitchPeriod(this.inputBuffer, i3, f2, findPitchPeriod);
                }
            }
            i3 += insertPitchPeriod;
        } while (this.maxRequired + i3 <= i2);
        removeProcessedInputSamples(i3);
    }

    private int copyInputToOutput(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            int min = Math.min(this.maxRequired, this.remainingInputToCopy);
            copyToOutput(this.inputBuffer, i2, min);
            this.remainingInputToCopy -= min;
            return min;
        }
        return invokeI.intValue;
    }

    private void copyToOutput(short[] sArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, sArr, i2, i3) == null) {
            enlargeOutputBufferIfNeeded(i3);
            int i4 = this.numChannels;
            System.arraycopy(sArr, i2 * i4, this.outputBuffer, this.numOutputSamples * i4, i4 * i3);
            this.numOutputSamples += i3;
        }
    }

    private void downSampleInput(short[] sArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, this, sArr, i2, i3) == null) {
            int i4 = this.maxRequired / i3;
            int i5 = this.numChannels;
            int i6 = i3 * i5;
            int i7 = i2 * i5;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = 0;
                for (int i10 = 0; i10 < i6; i10++) {
                    i9 += sArr[(i8 * i6) + i7 + i10];
                }
                this.downSampleBuffer[i8] = (short) (i9 / i6);
            }
        }
    }

    private void enlargeInputBufferIfNeeded(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i2) == null) {
            int i3 = this.numInputSamples + i2;
            int i4 = this.inputBufferSize;
            if (i3 > i4) {
                int i5 = i4 + (i4 / 2) + i2;
                this.inputBufferSize = i5;
                this.inputBuffer = Arrays.copyOf(this.inputBuffer, i5 * this.numChannels);
            }
        }
    }

    private void enlargeOutputBufferIfNeeded(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            int i3 = this.numOutputSamples + i2;
            int i4 = this.outputBufferSize;
            if (i3 > i4) {
                int i5 = i4 + (i4 / 2) + i2;
                this.outputBufferSize = i5;
                this.outputBuffer = Arrays.copyOf(this.outputBuffer, i5 * this.numChannels);
            }
        }
    }

    private int findPitchPeriod(short[] sArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{sArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i4 = this.inputSampleRateHz;
            int i5 = i4 > 4000 ? i4 / 4000 : 1;
            if (this.numChannels == 1 && i5 == 1) {
                i3 = findPitchPeriodInRange(sArr, i2, this.minPeriod, this.maxPeriod);
            } else {
                downSampleInput(sArr, i2, i5);
                int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i5, this.maxPeriod / i5);
                if (i5 != 1) {
                    int i6 = findPitchPeriodInRange * i5;
                    int i7 = i5 * 4;
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
                        i3 = findPitchPeriodInRange(sArr, i2, i8, i9);
                    } else {
                        downSampleInput(sArr, i2, 1);
                        i3 = findPitchPeriodInRange(this.downSampleBuffer, 0, i8, i9);
                    }
                } else {
                    i3 = findPitchPeriodInRange;
                }
            }
            int i12 = previousPeriodBetter(this.minDiff, this.maxDiff, z) ? this.prevPeriod : i3;
            this.prevMinDiff = this.minDiff;
            this.prevPeriod = i3;
            return i12;
        }
        return invokeCommon.intValue;
    }

    private int findPitchPeriodInRange(short[] sArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65545, this, sArr, i2, i3, i4)) == null) {
            int i5 = i2 * this.numChannels;
            int i6 = 1;
            int i7 = 255;
            int i8 = 0;
            int i9 = 0;
            while (i3 <= i4) {
                int i10 = 0;
                for (int i11 = 0; i11 < i3; i11++) {
                    i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
                }
                if (i10 * i8 < i6 * i3) {
                    i8 = i3;
                    i6 = i10;
                }
                if (i10 * i7 > i9 * i3) {
                    i7 = i3;
                    i9 = i10;
                }
                i3++;
            }
            this.minDiff = i6 / i8;
            this.maxDiff = i9 / i7;
            return i8;
        }
        return invokeLIII.intValue;
    }

    private int insertPitchPeriod(short[] sArr, int i2, float f2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{sArr, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)})) == null) {
            if (f2 < 0.5f) {
                i4 = (int) ((i3 * f2) / (1.0f - f2));
            } else {
                this.remainingInputToCopy = (int) ((i3 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                i4 = i3;
            }
            int i5 = i3 + i4;
            enlargeOutputBufferIfNeeded(i5);
            int i6 = this.numChannels;
            System.arraycopy(sArr, i2 * i6, this.outputBuffer, this.numOutputSamples * i6, i6 * i3);
            overlapAdd(i4, this.numChannels, this.outputBuffer, this.numOutputSamples + i3, sArr, i2 + i3, sArr, i2);
            this.numOutputSamples += i5;
            return i4;
        }
        return invokeCommon.intValue;
    }

    private short interpolate(short[] sArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65547, this, sArr, i2, i3, i4)) == null) {
            short s = sArr[i2];
            short s2 = sArr[i2 + this.numChannels];
            int i5 = this.newRatePosition * i3;
            int i6 = this.oldRatePosition;
            int i7 = i6 * i4;
            int i8 = (i6 + 1) * i4;
            int i9 = i8 - i5;
            int i10 = i8 - i7;
            return (short) (((s * i9) + ((i10 - i9) * s2)) / i10);
        }
        return invokeLIII.shortValue;
    }

    private void moveNewSamplesToPitchBuffer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i2) == null) {
            int i3 = this.numOutputSamples - i2;
            int i4 = this.numPitchSamples + i3;
            int i5 = this.pitchBufferSize;
            if (i4 > i5) {
                int i6 = i5 + (i5 / 2) + i3;
                this.pitchBufferSize = i6;
                this.pitchBuffer = Arrays.copyOf(this.pitchBuffer, i6 * this.numChannels);
            }
            short[] sArr = this.outputBuffer;
            int i7 = this.numChannels;
            System.arraycopy(sArr, i2 * i7, this.pitchBuffer, this.numPitchSamples * i7, i7 * i3);
            this.numOutputSamples = i2;
            this.numPitchSamples += i3;
        }
    }

    public static void overlapAdd(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), sArr, Integer.valueOf(i4), sArr2, Integer.valueOf(i5), sArr3, Integer.valueOf(i6)}) == null) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i4 * i3) + i7;
                int i9 = (i6 * i3) + i7;
                int i10 = (i5 * i3) + i7;
                for (int i11 = 0; i11 < i2; i11++) {
                    sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                    i8 += i3;
                    i10 += i3;
                    i9 += i3;
                }
            }
        }
    }

    private boolean previousPeriodBetter(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i2 == 0 || this.prevPeriod == 0) {
                return false;
            }
            return z ? i3 <= i2 * 3 && i2 * 2 > this.prevMinDiff * 3 : i2 > this.prevMinDiff;
        }
        return invokeCommon.booleanValue;
    }

    private void processStreamInput() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            int i2 = this.numOutputSamples;
            float f2 = this.speed;
            float f3 = this.pitch;
            float f4 = f2 / f3;
            float f5 = this.rate * f3;
            double d2 = f4;
            if (d2 <= 1.00001d && d2 >= 0.99999d) {
                copyToOutput(this.inputBuffer, 0, this.numInputSamples);
                this.numInputSamples = 0;
            } else {
                changeSpeed(f4);
            }
            if (f5 != 1.0f) {
                adjustRate(f5, i2);
            }
        }
    }

    private void removePitchSamples(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, this, i2) == null) || i2 == 0) {
            return;
        }
        short[] sArr = this.pitchBuffer;
        int i3 = this.numChannels;
        System.arraycopy(sArr, i2 * i3, sArr, 0, (this.numPitchSamples - i2) * i3);
        this.numPitchSamples -= i2;
    }

    private void removeProcessedInputSamples(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i2) == null) {
            int i3 = this.numInputSamples - i2;
            short[] sArr = this.inputBuffer;
            int i4 = this.numChannels;
            System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
            this.numInputSamples = i3;
        }
    }

    private int skipPitchPeriod(short[] sArr, int i2, float f2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{sArr, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)})) == null) {
            if (f2 >= 2.0f) {
                i4 = (int) (i3 / (f2 - 1.0f));
            } else {
                this.remainingInputToCopy = (int) ((i3 * (2.0f - f2)) / (f2 - 1.0f));
                i4 = i3;
            }
            enlargeOutputBufferIfNeeded(i4);
            overlapAdd(i4, this.numChannels, this.outputBuffer, this.numOutputSamples, sArr, i2, sArr, i2 + i3);
            this.numOutputSamples += i4;
            return i4;
        }
        return invokeCommon.intValue;
    }

    public void getOutput(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, shortBuffer) == null) {
            int min = Math.min(shortBuffer.remaining() / this.numChannels, this.numOutputSamples);
            shortBuffer.put(this.outputBuffer, 0, this.numChannels * min);
            int i2 = this.numOutputSamples - min;
            this.numOutputSamples = i2;
            short[] sArr = this.outputBuffer;
            int i3 = this.numChannels;
            System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
        }
    }

    public int getSamplesAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.numOutputSamples : invokeV.intValue;
    }

    public void queueEndOfStream() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i3 = this.numInputSamples;
            float f2 = this.speed;
            float f3 = this.pitch;
            int i4 = this.numOutputSamples + ((int) ((((i3 / (f2 / f3)) + this.numPitchSamples) / (this.rate * f3)) + 0.5f));
            enlargeInputBufferIfNeeded((this.maxRequired * 2) + i3);
            int i5 = 0;
            while (true) {
                i2 = this.maxRequired;
                int i6 = this.numChannels;
                if (i5 >= i2 * 2 * i6) {
                    break;
                }
                this.inputBuffer[(i6 * i3) + i5] = 0;
                i5++;
            }
            this.numInputSamples += i2 * 2;
            processStreamInput();
            if (this.numOutputSamples > i4) {
                this.numOutputSamples = i4;
            }
            this.numInputSamples = 0;
            this.remainingInputToCopy = 0;
            this.numPitchSamples = 0;
        }
    }

    public void queueInput(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shortBuffer) == null) {
            int remaining = shortBuffer.remaining();
            int i2 = this.numChannels;
            int i3 = remaining / i2;
            enlargeInputBufferIfNeeded(i3);
            shortBuffer.get(this.inputBuffer, this.numInputSamples * this.numChannels, ((i2 * i3) * 2) / 2);
            this.numInputSamples += i3;
            processStreamInput();
        }
    }
}
