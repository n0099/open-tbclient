package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class GlobalSetting {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String COPPA = "coppa";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String TT_SDK_WRAPPER = "TT";
    public static volatile Integer a = null;
    public static volatile boolean b = false;
    public static volatile boolean c = true;
    public static volatile Integer d;
    public static volatile Boolean e;
    public static volatile Boolean f;
    public static volatile Boolean g;
    public static volatile Map<String, String> h;
    public static volatile Map<String, String> i;
    public static final Map<String, String> j;
    public static final JSONObject k;
    public static volatile String l;
    public static volatile String m;
    public static volatile String n;
    public static volatile String o;
    public static volatile String p;
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
        h = new HashMap();
        i = new HashMap();
        j = new HashMap();
        k = new JSONObject();
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
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

    public static Boolean getAgreeReadAndroidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? g : (Boolean) invokeV.objValue;
    }

    public static Boolean getAgreeReadDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f : (Boolean) invokeV.objValue;
    }

    public static Integer getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a : (Integer) invokeV.objValue;
    }

    public static String getCustomADActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? l : (String) invokeV.objValue;
    }

    public static String getCustomLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? o : (String) invokeV.objValue;
    }

    public static String getCustomPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? m : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? p : (String) invokeV.objValue;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? n : (String) invokeV.objValue;
    }

    public static Map<String, String> getExtraUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Collections.unmodifiableMap(h) : (Map) invokeV.objValue;
    }

    public static Integer getPersonalizedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d : (Integer) invokeV.objValue;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? j : (Map) invokeV.objValue;
    }

    public static JSONObject getSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? k : (JSONObject) invokeV.objValue;
    }

    public static boolean isAgreePrivacyStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? e == null || e.booleanValue() : invokeV.booleanValue;
    }

    public static boolean isAgreeReadAndroidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (g == null) {
                return true;
            }
            return g.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean isAgreeReadDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (f == null) {
                return true;
            }
            return f.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean isEnableMediationTool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? b : invokeV.booleanValue;
    }

    public static boolean isEnableVideoDownloadingCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? c : invokeV.booleanValue;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65555, null, z) == null) && e == null) {
            e = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, null, z) == null) {
            g = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            f = Boolean.valueOf(z);
        }
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, map) == null) || map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt("agree_privacy", new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e2.toString());
        }
    }

    public static void setChannel(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65559, null, i2) == null) && a == null) {
            a = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            l = str;
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, str) == null) {
            o = str;
        }
    }

    public static void setCustomPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, str) == null) {
            m = str;
        }
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
            p = str;
        }
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, str) == null) {
            n = str;
        }
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65565, null, z) == null) {
            try {
                k.putOpt("ecais", Boolean.valueOf(z));
            } catch (JSONException unused) {
            }
        }
    }

    public static void setEnableMediationTool(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, null, z) == null) {
            b = z;
        }
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65567, null, z) == null) {
            c = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setExtraUserData(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, null, map) == null) || map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
            while (r0.hasNext()) {
            }
        }
        h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65569, null, map, z) == null) || map == null) {
            return;
        }
        if (z) {
            i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            k.putOpt("media_ext", new JSONObject(i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, null, i2) == null) {
            d = Integer.valueOf(i2);
        }
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, null, map) == null) || map == null) {
            return;
        }
        j.putAll(map);
    }
}
