package com.cmic.sso.sdk.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.cmic.sso.sdk.e.k;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            return k.a("sso_config_xf", "maxFailedLogTimes", i);
        }
        return invokeI.intValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return k.a("sso_config_xf", "pauseTime", i);
        }
        return invokeI.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            String a = k.a("sso_config_xf", "logHost", "");
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, null, z)) == null) {
            if (z) {
                str = "CU";
            } else {
                str = "";
            }
            return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", str).contains("CU");
        }
        return invokeZ.booleanValue;
    }

    public static boolean e(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            if (z) {
                str = "CT";
            } else {
                str = "";
            }
            return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", str).contains("CT");
        }
        return invokeZ.booleanValue;
    }

    public static boolean f(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65547, null, z)) == null) {
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            return "1".equals(k.a("sso_config_xf", "CLOSE_LOGS_VERSION", str));
        }
        return invokeZ.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String a = k.a("sso_config_xf", "config_host", (String) null);
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String a = k.a("sso_config_xf", "https_get_phone_scrip_host", (String) null);
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (System.currentTimeMillis() >= k.a("sso_config_xf", "client_valid", 0L)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            return "1".equals(k.a("sso_config_xf", "CLOSE_IPV4_LIST", str));
        }
        return invokeZ.booleanValue;
    }

    public static boolean b(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            return "1".equals(k.a("sso_config_xf", "CLOSE_IPV6_LIST", str));
        }
        return invokeZ.booleanValue;
    }

    public static boolean c(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) {
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            if (!"1".equals(k.a("sso_config_xf", "CLOSE_M008_APPID_LIST", str)) && !"1".equals(k.a("sso_config_xf", "CLOSE_M008_SDKVERSION_LIST", str))) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }
}
