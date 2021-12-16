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
/* loaded from: classes4.dex */
public class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaCodec mediaCodec;

        public MediaCodecWrapperImpl(MediaCodec mediaCodec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaCodec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mediaCodec = mediaCodec;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048576, this, mediaFormat, surface, mediaCrypto, i2) == null) {
                this.mediaCodec.configure(mediaFormat, surface, mediaCrypto, i2);
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        @TargetApi(18)
        public Surface createInputSurface() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mediaCodec.createInputSurface() : (Surface) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public int dequeueInputBuffer(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? this.mediaCodec.dequeueInputBuffer(j2) : invokeJ.intValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, bufferInfo, j2)) == null) ? this.mediaCodec.dequeueOutputBuffer(bufferInfo, j2) : invokeLJ.intValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mediaCodec.flush();
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void foundSei(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, byteBuffer) == null) {
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public ByteBuffer[] getInputBuffers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mediaCodec.getInputBuffers() : (ByteBuffer[]) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public ByteBuffer[] getOutputBuffers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mediaCodec.getOutputBuffers() : (ByteBuffer[]) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public MediaFormat getOutputFormat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mediaCodec.getOutputFormat() : (MediaFormat) invokeV.objValue;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void queueInputBuffer(int i2, int i3, int i4, long j2, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), Integer.valueOf(i5)}) == null) {
                this.mediaCodec.queueInputBuffer(i2, i3, i4, j2, i5);
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.mediaCodec.release();
            }
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void releaseOutputBuffer(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.mediaCodec.releaseOutputBuffer(i2, z);
            }
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
    }

    public MediaCodecWrapperFactoryImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // org.webrtc.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new MediaCodecWrapperImpl(MediaCodec.createByCodecName(str)) : (MediaCodecWrapper) invokeL.objValue;
    }
}
