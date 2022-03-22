package org.webrtc;

import com.baidu.rtc.PeerConnectionClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class VideoCodecType {
    public static final /* synthetic */ VideoCodecType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final VideoCodecType H264;
    public static final VideoCodecType VP8;
    public static final VideoCodecType VP9;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mimeType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(319204827, "Lorg/webrtc/VideoCodecType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(319204827, "Lorg/webrtc/VideoCodecType;");
                return;
            }
        }
        VP8 = new VideoCodecType(PeerConnectionClient.VIDEO_CODEC_VP8, 0, "video/x-vnd.on2.vp8");
        VP9 = new VideoCodecType(PeerConnectionClient.VIDEO_CODEC_VP9, 1, "video/x-vnd.on2.vp9");
        VideoCodecType videoCodecType = new VideoCodecType(PeerConnectionClient.VIDEO_CODEC_H264, 2, "video/avc");
        H264 = videoCodecType;
        $VALUES = new VideoCodecType[]{VP8, VP9, videoCodecType};
    }

    public VideoCodecType(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mimeType = str2;
    }

    public static VideoCodecType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VideoCodecType) Enum.valueOf(VideoCodecType.class, str) : (VideoCodecType) invokeL.objValue;
    }

    public static VideoCodecType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VideoCodecType[]) $VALUES.clone() : (VideoCodecType[]) invokeV.objValue;
    }

    public String mimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mimeType : (String) invokeV.objValue;
    }
}
