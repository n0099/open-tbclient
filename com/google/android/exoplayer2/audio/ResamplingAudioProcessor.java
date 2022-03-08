package com.google.android.exoplayer2.audio;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public final class ResamplingAudioProcessor implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer buffer;
    public int channelCount;
    public int encoding;
    public boolean inputEnded;
    public ByteBuffer outputBuffer;
    public int sampleRateHz;

    public ResamplingAudioProcessor() {
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
        this.sampleRateHz = -1;
        this.channelCount = -1;
        this.encoding = 0;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i2, int i3, int i4) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
                throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
            }
            if (this.sampleRateHz == i2 && this.channelCount == i3 && this.encoding == i4) {
                return false;
            }
            this.sampleRateHz = i2;
            this.channelCount = i3;
            this.encoding = i4;
            if (i4 == 2) {
                this.buffer = AudioProcessor.EMPTY_BUFFER;
                return true;
            }
            return true;
        }
        return invokeIII.booleanValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.encoding;
            return (i2 == 0 || i2 == 2) ? false : true;
        }
        return invokeV.booleanValue;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[LOOP:2: B:27:0x0085->B:28:0x0087, LOOP_START, PHI: r0 
      PHI: (r0v3 int) = (r0v2 int), (r0v4 int) binds: [B:18:0x0045, B:28:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void queueInput(ByteBuffer byteBuffer) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int i4 = limit - position;
            int i5 = this.encoding;
            if (i5 == Integer.MIN_VALUE) {
                i4 /= 3;
            } else if (i5 != 3) {
                if (i5 == 1073741824) {
                    i2 = i4 / 2;
                    if (this.buffer.capacity() >= i2) {
                        this.buffer = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
                    } else {
                        this.buffer.clear();
                    }
                    i3 = this.encoding;
                    if (i3 != Integer.MIN_VALUE) {
                        while (position < limit) {
                            this.buffer.put(byteBuffer.get(position + 1));
                            this.buffer.put(byteBuffer.get(position + 2));
                            position += 3;
                        }
                    } else if (i3 == 3) {
                        while (position < limit) {
                            this.buffer.put((byte) 0);
                            this.buffer.put((byte) ((byteBuffer.get(position) & 255) + a.f29502g));
                            position++;
                        }
                    } else if (i3 != 1073741824) {
                        throw new IllegalStateException();
                    } else {
                        while (position < limit) {
                            this.buffer.put(byteBuffer.get(position + 2));
                            this.buffer.put(byteBuffer.get(position + 3));
                            position += 4;
                        }
                    }
                    byteBuffer.position(byteBuffer.limit());
                    this.buffer.flip();
                    this.outputBuffer = this.buffer;
                }
                throw new IllegalStateException();
            }
            i2 = i4 * 2;
            if (this.buffer.capacity() >= i2) {
            }
            i3 = this.encoding;
            if (i3 != Integer.MIN_VALUE) {
            }
            byteBuffer.position(byteBuffer.limit());
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
            this.sampleRateHz = -1;
            this.channelCount = -1;
            this.encoding = 0;
        }
    }
}
