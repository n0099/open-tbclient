package com.qq.e.comm.managers.setting;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.pi.CustomLandingPageListener;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class GlobalSetting {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String TT_SDK_WRAPPER = "TT";
    public static volatile CustomLandingPageListener a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f60834b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f60835c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f60836d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Integer f60837e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Boolean f60838f;

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, String> f60839g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f60840h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f60841i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile String f60842j;

    /* renamed from: k  reason: collision with root package name */
    public static volatile String f60843k;
    public static volatile String l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1162709102, "Lcom/qq/e/comm/managers/setting/GlobalSetting;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1162709102, "Lcom/qq/e/comm/managers/setting/GlobalSetting;");
                return;
            }
        }
        f60839g = new HashMap();
        f60840h = null;
        f60841i = null;
        f60842j = null;
        f60843k = null;
        l = null;
    }

    public GlobalSetting() {
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

    public static Integer getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f60834b : (Integer) invokeV.objValue;
    }

    public static String getCustomADActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f60840h : (String) invokeV.objValue;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a : (CustomLandingPageListener) invokeV.objValue;
    }

    public static String getCustomLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f60843k : (String) invokeV.objValue;
    }

    public static String getCustomPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f60841i : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? l : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f60842j : (String) invokeV.objValue;
    }

    public static Integer getPersonalizedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f60837e : (Integer) invokeV.objValue;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f60839g : (Map) invokeV.objValue;
    }

    public static boolean isAgreePrivacyStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f60838f == null || f60838f.booleanValue() : invokeV.booleanValue;
    }

    public static boolean isEnableMediationTool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f60835c : invokeV.booleanValue;
    }

    public static boolean isEnableVideoDownloadingCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f60836d : invokeV.booleanValue;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65550, null, z) == null) && f60838f == null) {
            f60838f = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65551, null, i2) == null) && f60834b == null) {
            f60834b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            f60840h = str;
        }
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, customLandingPageListener) == null) {
            a = customLandingPageListener;
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            f60843k = str;
        }
    }

    public static void setCustomPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            f60841i = str;
        }
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            l = str;
        }
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            f60842j = str;
        }
    }

    public static void setEnableMediationTool(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            f60835c = z;
        }
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            f60836d = z;
        }
    }

    public static void setPersonalizedState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65560, null, i2) == null) {
            f60837e = Integer.valueOf(i2);
        }
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, map) == null) || map == null) {
            return;
        }
        f60839g.putAll(map);
    }
}
