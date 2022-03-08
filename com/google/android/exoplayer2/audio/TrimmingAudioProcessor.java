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
/* loaded from: classes7.dex */
public final class TrimmingAudioProcessor implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer buffer;
    public int channelCount;
    public byte[] endBuffer;
    public int endBufferSize;
    public boolean inputEnded;
    public boolean isActive;
    public ByteBuffer outputBuffer;
    public int pendingTrimStartBytes;
    public int sampleRateHz;
    public int trimEndSamples;
    public int trimStartSamples;

    public TrimmingAudioProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
        this.channelCount = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i2, int i3, int i4) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            if (i4 == 2) {
                this.channelCount = i3;
                this.sampleRateHz = i2;
                int i5 = this.trimEndSamples;
                this.endBuffer = new byte[i5 * i3 * 2];
                this.endBufferSize = 0;
                int i6 = this.trimStartSamples;
                this.pendingTrimStartBytes = i3 * i6 * 2;
                boolean z = this.isActive;
                boolean z2 = (i6 == 0 && i5 == 0) ? false : true;
                this.isActive = z2;
                return z != z2;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
            this.inputEnded = false;
            this.pendingTrimStartBytes = 0;
            this.endBufferSize = 0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sampleRateHz : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isActive : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.inputEnded && this.outputBuffer == AudioProcessor.EMPTY_BUFFER : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.inputEnded = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int i2 = limit - position;
            int min = Math.min(i2, this.pendingTrimStartBytes);
            this.pendingTrimStartBytes -= min;
            byteBuffer.position(position + min);
            if (this.pendingTrimStartBytes > 0) {
                return;
            }
            int i3 = i2 - min;
            int length = (this.endBufferSize + i3) - this.endBuffer.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int constrainValue = Util.constrainValue(length, 0, this.endBufferSize);
            this.buffer.put(this.endBuffer, 0, constrainValue);
            int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i3);
            byteBuffer.limit(byteBuffer.position() + constrainValue2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i4 = i3 - constrainValue2;
            int i5 = this.endBufferSize - constrainValue;
            this.endBufferSize = i5;
            byte[] bArr = this.endBuffer;
            System.arraycopy(bArr, constrainValue, bArr, 0, i5);
            byteBuffer.get(this.endBuffer, this.endBufferSize, i4);
            this.endBufferSize += i4;
            this.buffer.flip();
            this.outputBuffer = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            flush();
            this.buffer = AudioProcessor.EMPTY_BUFFER;
            this.channelCount = -1;
            this.sampleRateHz = -1;
            this.endBuffer = null;
        }
    }

    public void setTrimSampleCount(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.trimStartSamples = i2;
            this.trimEndSamples = i3;
        }
    }
}
