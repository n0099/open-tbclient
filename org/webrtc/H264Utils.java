package org.webrtc;

import com.baidu.rtc.PeerConnectionClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class H264Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static VideoCodecInfo DEFAULT_H264_BASELINE_PROFILE_CODEC = null;
    public static VideoCodecInfo DEFAULT_H264_HIGH_PROFILE_CODEC = null;
    public static final String H264_CONSTRAINED_BASELINE_3_1 = "42e01f";
    public static final String H264_CONSTRAINED_HIGH_3_1 = "640c1f";
    public static final String H264_FMTP_LEVEL_ASYMMETRY_ALLOWED = "level-asymmetry-allowed";
    public static final String H264_FMTP_PACKETIZATION_MODE = "packetization-mode";
    public static final String H264_FMTP_PROFILE_LEVEL_ID = "profile-level-id";
    public static final String H264_LEVEL_3_1 = "1f";
    public static final String H264_PROFILE_CONSTRAINED_BASELINE = "42e0";
    public static final String H264_PROFILE_CONSTRAINED_HIGH = "640c";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(665453181, "Lorg/webrtc/H264Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(665453181, "Lorg/webrtc/H264Utils;");
                return;
            }
        }
        DEFAULT_H264_BASELINE_PROFILE_CODEC = new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_H264, getDefaultH264Params(false));
        DEFAULT_H264_HIGH_PROFILE_CODEC = new VideoCodecInfo(PeerConnectionClient.VIDEO_CODEC_H264, getDefaultH264Params(true));
    }

    public H264Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Map<String, String> getDefaultH264Params(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("level-asymmetry-allowed", "1");
            hashMap.put("packetization-mode", "1");
            hashMap.put("profile-level-id", z ? "640c1f" : "42e01f");
            return hashMap;
        }
        return (Map) invokeZ.objValue;
    }

    public static boolean isSameH264Profile(Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, map2)) == null) ? nativeIsSameH264Profile(map, map2) : invokeLL.booleanValue;
    }

    public static native boolean nativeIsSameH264Profile(Map<String, String> map, Map<String, String> map2);
}
