package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class SoftwareVideoEncoderFactory implements VideoEncoderFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SoftwareVideoEncoderFactory() {
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

    public static VideoCodecInfo[] supportedCodecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_VP8, new HashMap()));
            if (LibvpxVp9Encoder.nativeIsSupported()) {
                arrayList.add(new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_VP9, new HashMap()));
            }
            return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
        }
        return (VideoCodecInfo[]) invokeV.objValue;
    }

    @Override // org.webrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, videoCodecInfo)) == null) {
            if (videoCodecInfo.name.equalsIgnoreCase(PeerConnectionClient.VIDEO_CODEC_VP8)) {
                return new LibvpxVp8Encoder();
            }
            if (videoCodecInfo.name.equalsIgnoreCase(PeerConnectionClient.VIDEO_CODEC_VP9) && LibvpxVp9Encoder.nativeIsSupported()) {
                return new LibvpxVp9Encoder();
            }
            return null;
        }
        return (VideoEncoder) invokeL.objValue;
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? supportedCodecs() : (VideoCodecInfo[]) invokeV.objValue;
    }
}
