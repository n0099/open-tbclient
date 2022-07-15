package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderWrapper;
import org.webrtc.VideoFrame;
/* loaded from: classes8.dex */
public class VideoDecoderWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VideoDecoderWrapper() {
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

    @CalledByNative
    public static VideoDecoder.Callback createDecoderCallback(final long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? new VideoDecoder.Callback() { // from class: com.repackage.cr9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // org.webrtc.VideoDecoder.Callback
            public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, videoFrame, num, num2) == null) {
                    VideoDecoderWrapper.nativeOnDecodedFrame(j, videoFrame, num, num2);
                }
            }
        } : (VideoDecoder.Callback) invokeJ.objValue;
    }

    public static native void nativeOnDecodedFrame(long j, VideoFrame videoFrame, Integer num, Integer num2);
}
