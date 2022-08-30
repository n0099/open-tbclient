package com.google.android.exoplayer2.audio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public final class SonicAudioProcessor implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float CLOSE_THRESHOLD = 0.01f;
    public static final float MAXIMUM_PITCH = 8.0f;
    public static final float MAXIMUM_SPEED = 8.0f;
    public static final float MINIMUM_PITCH = 0.1f;
    public static final float MINIMUM_SPEED = 0.1f;
    public static final int MIN_BYTES_FOR_SPEEDUP_CALCULATION = 1024;
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer buffer;
    public int channelCount;
    public long inputBytes;
    public boolean inputEnded;
    public ByteBuffer outputBuffer;
    public long outputBytes;
    public int outputSampleRateHz;
    public int pendingOutputSampleRateHz;
    public float pitch;
    public int sampleRateHz;
    public ShortBuffer shortBuffer;
    public Sonic sonic;
    public float speed;

    public SonicAudioProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputSampleRateHz = -1;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.pendingOutputSampleRateHz = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i, i2, i3)) == null) {
            if (i3 == 2) {
                int i4 = this.pendingOutputSampleRateHz;
                if (i4 == -1) {
                    i4 = i;
                }
                if (this.sampleRateHz == i && this.channelCount == i2 && this.outputSampleRateHz == i4) {
                    return false;
                }
                this.sampleRateHz = i;
                this.channelCount = i2;
                this.outputSampleRateHz = i4;
                return true;
            }
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        return invokeIII.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.sonic = new Sonic(this.sampleRateHz, this.channelCount, this.speed, this.pitch, this.outputSampleRateHz);
            this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
            this.inputBytes = 0L;
            this.outputBytes = 0L;
            this.inputEnded = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ByteBuffer byteBuffer = this.outputBuffer;
            this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.channelCount : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.outputSampleRateHz : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.outputSampleRateHz != this.sampleRateHz : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        InterceptResult invokeV;
        Sonic sonic;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.inputEnded && ((sonic = this.sonic) == null || sonic.getSamplesAvailable() == 0) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.sonic.queueEndOfStream();
            this.inputEnded = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            if (byteBuffer.hasRemaining()) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.inputBytes += remaining;
                this.sonic.queueInput(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
            }
            int samplesAvailable = this.sonic.getSamplesAvailable() * this.channelCount * 2;
            if (samplesAvailable > 0) {
                if (this.buffer.capacity() < samplesAvailable) {
                    ByteBuffer order = ByteBuffer.allocateDirect(samplesAvailable).order(ByteOrder.nativeOrder());
                    this.buffer = order;
                    this.shortBuffer = order.asShortBuffer();
                } else {
                    this.buffer.clear();
                    this.shortBuffer.clear();
                }
                this.sonic.getOutput(this.shortBuffer);
                this.outputBytes += samplesAvailable;
                this.buffer.limit(samplesAvailable);
                this.outputBuffer = this.buffer;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.sonic = null;
            ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
            this.buffer = byteBuffer;
            this.shortBuffer = byteBuffer.asShortBuffer();
            this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
            this.channelCount = -1;
            this.sampleRateHz = -1;
            this.outputSampleRateHz = -1;
            this.inputBytes = 0L;
            this.outputBytes = 0L;
            this.inputEnded = false;
            this.pendingOutputSampleRateHz = -1;
        }
    }

    public long scaleDurationForSpeedup(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            long j2 = this.outputBytes;
            if (j2 >= 1024) {
                int i = this.outputSampleRateHz;
                int i2 = this.sampleRateHz;
                if (i == i2) {
                    return Util.scaleLargeTimestamp(j, this.inputBytes, j2);
                }
                return Util.scaleLargeTimestamp(j, this.inputBytes * i, j2 * i2);
            }
            return (long) (this.speed * j);
        }
        return invokeJ.longValue;
    }

    public void setOutputSampleRateHz(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.pendingOutputSampleRateHz = i;
        }
    }

    public float setPitch(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f)) == null) {
            this.pitch = Util.constrainValue(f, 0.1f, 8.0f);
            return f;
        }
        return invokeF.floatValue;
    }

    public float setSpeed(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f)) == null) {
            float constrainValue = Util.constrainValue(f, 0.1f, 8.0f);
            this.speed = constrainValue;
            return constrainValue;
        }
        return invokeF.floatValue;
    }
}
