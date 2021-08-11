package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.VideoDecoder;
/* loaded from: classes2.dex */
public abstract class WrappedNativeVideoDecoder implements VideoDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WrappedNativeVideoDecoder() {
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

    @Override // org.webrtc.VideoDecoder
    public abstract long createNativeVideoDecoder();

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, decodeInfo)) == null) {
            throw new UnsupportedOperationException("Not implemented.");
        }
        return (VideoCodecStatus) invokeLL.objValue;
    }

    @Override // org.webrtc.VideoDecoder
    public String getImplementationName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new UnsupportedOperationException("Not implemented.");
        }
        return (String) invokeV.objValue;
    }

    @Override // org.webrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new UnsupportedOperationException("Not implemented.");
        }
        return invokeV.booleanValue;
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, settings, callback)) == null) {
            throw new UnsupportedOperationException("Not implemented.");
        }
        return (VideoCodecStatus) invokeLL.objValue;
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new UnsupportedOperationException("Not implemented.");
        }
        return (VideoCodecStatus) invokeV.objValue;
    }
}
