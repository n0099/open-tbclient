package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaCodec mediaCodec;

        @Override // org.webrtc.MediaCodecWrapper
        public void foundSei(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, byteBuffer) == null) {
            }
        }

        public MediaCodecWrapperImpl(MediaCodec mediaCodec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaCodec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mediaCodec = mediaCodec;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public int dequeueInputBuffer(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                return this.mediaCodec.dequeueInputBuffer(j);
            }
            return invokeJ.intValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        @TargetApi(19)
        public void setParameters(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
                this.mediaCodec.setParameters(bundle);
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048576, this, mediaFormat, surface, mediaCrypto, i) == null) {
                this.mediaCodec.configure(mediaFormat, surface, mediaCrypto, i);
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        @TargetApi(18)
        public Surface createInputSurface() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mediaCodec.createInputSurface();
            }
            return (Surface) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mediaCodec.flush();
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public ByteBuffer[] getInputBuffers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mediaCodec.getInputBuffers();
            }
            return (ByteBuffer[]) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public ByteBuffer[] getOutputBuffers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mediaCodec.getOutputBuffers();
            }
            return (ByteBuffer[]) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public MediaFormat getOutputFormat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mediaCodec.getOutputFormat();
            }
            return (MediaFormat) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.mediaCodec.release();
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.mediaCodec.start();
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                this.mediaCodec.stop();
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, bufferInfo, j)) == null) {
                return this.mediaCodec.dequeueOutputBuffer(bufferInfo, j);
            }
            return invokeLJ.intValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void releaseOutputBuffer(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.mediaCodec.releaseOutputBuffer(i, z);
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Integer.valueOf(i4)}) == null) {
                this.mediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            }
        }
    }

    public MediaCodecWrapperFactoryImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // org.webrtc.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(str));
        }
        return (MediaCodecWrapper) invokeL.objValue;
    }
}
