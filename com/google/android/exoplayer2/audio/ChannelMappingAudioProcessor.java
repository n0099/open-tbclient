package com.google.android.exoplayer2.audio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class ChannelMappingAudioProcessor implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean active;
    public ByteBuffer buffer;
    public int channelCount;
    public boolean inputEnded;
    public ByteBuffer outputBuffer;
    public int[] outputChannels;
    public int[] pendingOutputChannels;
    public int sampleRateHz;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public ChannelMappingAudioProcessor() {
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
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
        this.channelCount = -1;
        this.sampleRateHz = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = this.outputChannels;
            if (iArr == null) {
                return this.channelCount;
            }
            return iArr.length;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.sampleRateHz;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.active;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.inputEnded && this.outputBuffer == AudioProcessor.EMPTY_BUFFER) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.inputEnded = true;
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
            this.outputChannels = null;
            this.active = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i, i2, i3)) == null) {
            boolean z3 = !Arrays.equals(this.pendingOutputChannels, this.outputChannels);
            int[] iArr = this.pendingOutputChannels;
            this.outputChannels = iArr;
            if (iArr == null) {
                this.active = false;
                return z3;
            } else if (i3 == 2) {
                if (!z3 && this.sampleRateHz == i && this.channelCount == i2) {
                    return false;
                }
                this.sampleRateHz = i;
                this.channelCount = i2;
                if (i2 != this.outputChannels.length) {
                    z = true;
                } else {
                    z = false;
                }
                this.active = z;
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.outputChannels;
                    if (i4 >= iArr2.length) {
                        return true;
                    }
                    int i5 = iArr2[i4];
                    if (i5 < i2) {
                        boolean z4 = this.active;
                        if (i5 != i4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.active = z2 | z4;
                        i4++;
                    } else {
                        throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
                    }
                }
            } else {
                throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
            }
        } else {
            return invokeIII.booleanValue;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int length = ((limit - position) / (this.channelCount * 2)) * this.outputChannels.length * 2;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            while (position < limit) {
                for (int i : this.outputChannels) {
                    this.buffer.putShort(byteBuffer.getShort((i * 2) + position));
                }
                position += this.channelCount * 2;
            }
            byteBuffer.position(limit);
            this.buffer.flip();
            this.outputBuffer = this.buffer;
        }
    }

    public void setChannelMap(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) {
            this.pendingOutputChannels = iArr;
        }
    }
}
