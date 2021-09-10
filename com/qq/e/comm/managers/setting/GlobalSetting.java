package com.qq.e.comm.managers.setting;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
public final class GlobalSetting {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String TT_SDK_WRAPPER = "TT";

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f75346a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f75347b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f75348c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f75349d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f75350e = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f75351f = true;

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, String> f75352g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f75353h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f75354i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile String f75355j;
    public static volatile String k;
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
        f75352g = new HashMap();
        f75353h = null;
        f75354i = null;
        f75355j = null;
        k = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f75347b : (Integer) invokeV.objValue;
    }

    public static String getCustomADActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f75353h : (String) invokeV.objValue;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f75346a : (CustomLandingPageListener) invokeV.objValue;
    }

    public static String getCustomLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? k : (String) invokeV.objValue;
    }

    public static String getCustomPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f75354i : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? l : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f75355j : (String) invokeV.objValue;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f75352g : (Map) invokeV.objValue;
    }

    public static Boolean isAgreePrivacyStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f75350e : (Boolean) invokeV.objValue;
    }

    public static boolean isAgreePrivacyStrategyNonNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f75350e != null) {
                return f75350e.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isEnableMediationTool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f75348c : invokeV.booleanValue;
    }

    public static boolean isEnableVideoDownloadingCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f75349d : invokeV.booleanValue;
    }

    public static boolean isLocationAllowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f75351f : invokeV.booleanValue;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65551, null, z) == null) && f75350e == null) {
            f75350e = Boolean.valueOf(z);
        }
    }

    public static void setAllowLocation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            f75351f = z;
        }
    }

    public static void setChannel(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65553, null, i2) == null) && f75347b == null) {
            f75347b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            f75353h = str;
        }
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, customLandingPageListener) == null) {
            f75346a = customLandingPageListener;
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            k = str;
        }
    }

    public static void setCustomPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            f75354i = str;
        }
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            l = str;
        }
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            f75355j = str;
        }
    }

    public static void setEnableMediationTool(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            f75348c = z;
        }
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, null, z) == null) {
            f75349d = z;
        }
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, map) == null) || map == null) {
            return;
        }
        f75352g.putAll(map);
    }
}
