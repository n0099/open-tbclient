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
/* loaded from: classes2.dex */
public final class GlobalSetting {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String TT_SDK_WRAPPER = "TT";

    /* renamed from: a  reason: collision with root package name */
    public static volatile CustomLandingPageListener f68928a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Integer f68929b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f68930c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f68931d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Boolean f68932e = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f68933f = true;

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, String> f68934g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile String f68935h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile String f68936i;
    public static volatile String j;
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
        f68934g = new HashMap();
        f68935h = null;
        f68936i = null;
        j = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f68929b : (Integer) invokeV.objValue;
    }

    public static String getCustomADActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f68935h : (String) invokeV.objValue;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f68928a : (CustomLandingPageListener) invokeV.objValue;
    }

    public static String getCustomLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? k : (String) invokeV.objValue;
    }

    public static String getCustomPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f68936i : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? l : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? j : (String) invokeV.objValue;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f68934g : (Map) invokeV.objValue;
    }

    public static boolean isAgreePrivacyStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f68932e == null || f68932e.booleanValue() : invokeV.booleanValue;
    }

    public static boolean isEnableMediationTool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f68930c : invokeV.booleanValue;
    }

    public static boolean isEnableVideoDownloadingCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f68931d : invokeV.booleanValue;
    }

    public static boolean isLocationAllowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f68933f : invokeV.booleanValue;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65550, null, z) == null) && f68932e == null) {
            f68932e = Boolean.valueOf(z);
        }
    }

    public static void setAllowLocation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            f68933f = z;
        }
    }

    public static void setChannel(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65552, null, i2) == null) && f68929b == null) {
            f68929b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            f68935h = str;
        }
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, customLandingPageListener) == null) {
            f68928a = customLandingPageListener;
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            k = str;
        }
    }

    public static void setCustomPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            f68936i = str;
        }
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            l = str;
        }
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            j = str;
        }
    }

    public static void setEnableMediationTool(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            f68930c = z;
        }
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            f68931d = z;
        }
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, map) == null) || map == null) {
            return;
        }
        f68934g.putAll(map);
    }
}
