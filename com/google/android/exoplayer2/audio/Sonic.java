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
/* loaded from: classes6.dex */
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

    public Sonic(int i, int i2, float f2, float f3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.inputSampleRateHz = i;
        this.numChannels = i2;
        this.minPeriod = i / 400;
        int i6 = i / 65;
        this.maxPeriod = i6;
        int i7 = i6 * 2;
        this.maxRequired = i7;
        this.downSampleBuffer = new short[i7];
        this.inputBufferSize = i7;
        this.inputBuffer = new short[i7 * i2];
        this.outputBufferSize = i7;
        this.outputBuffer = new short[i7 * i2];
        this.pitchBufferSize = i7;
        this.pitchBuffer = new short[i7 * i2];
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.prevPeriod = 0;
        this.speed = f2;
        this.pitch = f3;
        this.rate = i / i3;
    }

    private void adjustRate(float f2, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i)}) == null) || this.numOutputSamples == i) {
            return;
        }
        int i4 = this.inputSampleRateHz;
        int i5 = (int) (i4 / f2);
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
                    Assertions.checkState(i3 == i5);
                    this.newRatePosition = 0;
                }
                i6++;
            } else {
                removePitchSamples(i7 - 1);
                return;
            }
        }
    }

    private void changeSpeed(float f2) {
        int i;
        int insertPitchPeriod;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65538, this, f2) == null) || (i = this.numInputSamples) < this.maxRequired) {
            return;
        }
        int i2 = 0;
        do {
            if (this.remainingInputToCopy > 0) {
                insertPitchPeriod = copyInputToOutput(i2);
            } else {
                int findPitchPeriod = findPitchPeriod(this.inputBuffer, i2, true);
                if (f2 > 1.0d) {
                    insertPitchPeriod = findPitchPeriod + skipPitchPeriod(this.inputBuffer, i2, f2, findPitchPeriod);
                } else {
                    insertPitchPeriod = insertPitchPeriod(this.inputBuffer, i2, f2, findPitchPeriod);
                }
            }
            i2 += insertPitchPeriod;
        } while (this.maxRequired + i2 <= i);
        removeProcessedInputSamples(i2);
    }

    private int copyInputToOutput(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            int min = Math.min(this.maxRequired, this.remainingInputToCopy);
            copyToOutput(this.inputBuffer, i, min);
            this.remainingInputToCopy -= min;
            return min;
        }
        return invokeI.intValue;
    }

    private void copyToOutput(short[] sArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, sArr, i, i2) == null) {
            enlargeOutputBufferIfNeeded(i2);
            int i3 = this.numChannels;
            System.arraycopy(sArr, i * i3, this.outputBuffer, this.numOutputSamples * i3, i3 * i2);
            this.numOutputSamples += i2;
        }
    }

    private void downSampleInput(short[] sArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, this, sArr, i, i2) == null) {
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
    }

    private void enlargeInputBufferIfNeeded(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            int i2 = this.numInputSamples + i;
            int i3 = this.inputBufferSize;
            if (i2 > i3) {
                int i4 = i3 + (i3 / 2) + i;
                this.inputBufferSize = i4;
                this.inputBuffer = Arrays.copyOf(this.inputBuffer, i4 * this.numChannels);
            }
        }
    }

    private void enlargeOutputBufferIfNeeded(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i) == null) {
            int i2 = this.numOutputSamples + i;
            int i3 = this.outputBufferSize;
            if (i2 > i3) {
                int i4 = i3 + (i3 / 2) + i;
                this.outputBufferSize = i4;
                this.outputBuffer = Arrays.copyOf(this.outputBuffer, i4 * this.numChannels);
            }
        }
    }

    private int findPitchPeriod(short[] sArr, int i, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{sArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int i3 = this.inputSampleRateHz;
            int i4 = i3 > 4000 ? i3 / 4000 : 1;
            if (this.numChannels == 1 && i4 == 1) {
                i2 = findPitchPeriodInRange(sArr, i, this.minPeriod, this.maxPeriod);
            } else {
                downSampleInput(sArr, i, i4);
                int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i4, this.maxPeriod / i4);
                if (i4 != 1) {
                    int i5 = findPitchPeriodInRange * i4;
                    int i6 = i4 * 4;
                    int i7 = i5 - i6;
                    int i8 = i5 + i6;
                    int i9 = this.minPeriod;
                    if (i7 < i9) {
                        i7 = i9;
                    }
                    int i10 = this.maxPeriod;
                    if (i8 > i10) {
                        i8 = i10;
                    }
                    if (this.numChannels == 1) {
                        i2 = findPitchPeriodInRange(sArr, i, i7, i8);
                    } else {
                        downSampleInput(sArr, i, 1);
                        i2 = findPitchPeriodInRange(this.downSampleBuffer, 0, i7, i8);
                    }
                } else {
                    i2 = findPitchPeriodInRange;
                }
            }
            int i11 = previousPeriodBetter(this.minDiff, this.maxDiff, z) ? this.prevPeriod : i2;
            this.prevMinDiff = this.minDiff;
            this.prevPeriod = i2;
            return i11;
        }
        return invokeCommon.intValue;
    }

    private int findPitchPeriodInRange(short[] sArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65545, this, sArr, i, i2, i3)) == null) {
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
        return invokeLIII.intValue;
    }

    private int insertPitchPeriod(short[] sArr, int i, float f2, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{sArr, Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (f2 < 0.5f) {
                i3 = (int) ((i2 * f2) / (1.0f - f2));
            } else {
                this.remainingInputToCopy = (int) ((i2 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
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
        return invokeCommon.intValue;
    }

    private short interpolate(short[] sArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65547, this, sArr, i, i2, i3)) == null) {
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
        return invokeLIII.shortValue;
    }

    private void moveNewSamplesToPitchBuffer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i) == null) {
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
    }

    public static void overlapAdd(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), sArr, Integer.valueOf(i3), sArr2, Integer.valueOf(i4), sArr3, Integer.valueOf(i5)}) == null) {
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
    }

    private boolean previousPeriodBetter(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i == 0 || this.prevPeriod == 0) {
                return false;
            }
            return z ? i2 <= i * 3 && i * 2 > this.prevMinDiff * 3 : i > this.prevMinDiff;
        }
        return invokeCommon.booleanValue;
    }

    private void processStreamInput() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            int i = this.numOutputSamples;
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
                adjustRate(f5, i);
            }
        }
    }

    private void removePitchSamples(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, this, i) == null) || i == 0) {
            return;
        }
        short[] sArr = this.pitchBuffer;
        int i2 = this.numChannels;
        System.arraycopy(sArr, i * i2, sArr, 0, (this.numPitchSamples - i) * i2);
        this.numPitchSamples -= i;
    }

    private void removeProcessedInputSamples(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i) == null) {
            int i2 = this.numInputSamples - i;
            short[] sArr = this.inputBuffer;
            int i3 = this.numChannels;
            System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
            this.numInputSamples = i2;
        }
    }

    private int skipPitchPeriod(short[] sArr, int i, float f2, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{sArr, Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (f2 >= 2.0f) {
                i3 = (int) (i2 / (f2 - 1.0f));
            } else {
                this.remainingInputToCopy = (int) ((i2 * (2.0f - f2)) / (f2 - 1.0f));
                i3 = i2;
            }
            enlargeOutputBufferIfNeeded(i3);
            overlapAdd(i3, this.numChannels, this.outputBuffer, this.numOutputSamples, sArr, i, sArr, i + i2);
            this.numOutputSamples += i3;
            return i3;
        }
        return invokeCommon.intValue;
    }

    public void getOutput(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, shortBuffer) == null) {
            int min = Math.min(shortBuffer.remaining() / this.numChannels, this.numOutputSamples);
            shortBuffer.put(this.outputBuffer, 0, this.numChannels * min);
            int i = this.numOutputSamples - min;
            this.numOutputSamples = i;
            short[] sArr = this.outputBuffer;
            int i2 = this.numChannels;
            System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
        }
    }

    public int getSamplesAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.numOutputSamples : invokeV.intValue;
    }

    public void queueEndOfStream() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.numInputSamples;
            float f2 = this.speed;
            float f3 = this.pitch;
            int i3 = this.numOutputSamples + ((int) ((((i2 / (f2 / f3)) + this.numPitchSamples) / (this.rate * f3)) + 0.5f));
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

    public void queueInput(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shortBuffer) == null) {
            int remaining = shortBuffer.remaining();
            int i = this.numChannels;
            int i2 = remaining / i;
            enlargeInputBufferIfNeeded(i2);
            shortBuffer.get(this.inputBuffer, this.numInputSamples * this.numChannels, ((i * i2) * 2) / 2);
            this.numInputSamples += i2;
            processStreamInput();
        }
    }
}
