package com.google.android.exoplayer2.drm;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import java.util.Map;
/* loaded from: classes7.dex */
public final class WidevineUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";
    public transient /* synthetic */ FieldHolder $fh;

    public WidevineUtil() {
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

    public static long getDurationRemainingSec(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, str)) == null) {
            if (map != null) {
                try {
                    String str2 = map.get(str);
                    return str2 != null ? Long.parseLong(str2) : C.TIME_UNSET;
                } catch (NumberFormatException unused) {
                    return C.TIME_UNSET;
                }
            }
            return C.TIME_UNSET;
        }
        return invokeLL.longValue;
    }

    public static Pair<Long, Long> getLicenseDurationRemainingSec(DrmSession<?> drmSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, drmSession)) == null) {
            Map<String, String> queryKeyStatus = drmSession.queryKeyStatus();
            if (queryKeyStatus == null) {
                return null;
            }
            return new Pair<>(Long.valueOf(getDurationRemainingSec(queryKeyStatus, PROPERTY_LICENSE_DURATION_REMAINING)), Long.valueOf(getDurationRemainingSec(queryKeyStatus, PROPERTY_PLAYBACK_DURATION_REMAINING)));
        }
        return (Pair) invokeL.objValue;
    }
}
