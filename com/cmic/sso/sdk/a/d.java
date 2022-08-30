package com.cmic.sso.sdk.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.cmic.sso.sdk.e.k;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? System.currentTimeMillis() >= k.a("sso_config_xf", "client_valid", 0L) : invokeV.booleanValue;
    }

    public static boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            return "1".equals(k.a("sso_config_xf", "CLOSE_IPV6_LIST", !z ? "0" : "1"));
        }
        return invokeZ.booleanValue;
    }

    public static boolean c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) {
            String str = !z ? "0" : "1";
            return "1".equals(k.a("sso_config_xf", "CLOSE_M008_APPID_LIST", str)) || "1".equals(k.a("sso_config_xf", "CLOSE_M008_SDKVERSION_LIST", str));
        }
        return invokeZ.booleanValue;
    }

    public static boolean d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, null, z)) == null) {
            return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC : "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC);
        }
        return invokeZ.booleanValue;
    }

    public static boolean e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC : "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC);
        }
        return invokeZ.booleanValue;
    }

    public static boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65547, null, z)) == null) {
            return "1".equals(k.a("sso_config_xf", "CLOSE_LOGS_VERSION", z ? "1" : "0"));
        }
        return invokeZ.booleanValue;
    }

    public static boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            return "1".equals(k.a("sso_config_xf", "CLOSE_IPV4_LIST", !z ? "0" : "1"));
        }
        return invokeZ.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String a = k.a("sso_config_xf", "https_get_phone_scrip_host", (String) null);
            return TextUtils.isEmpty(a) ? str : a;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String a = k.a("sso_config_xf", "config_host", (String) null);
            return TextUtils.isEmpty(a) ? str : a;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            String a = k.a("sso_config_xf", "logHost", "");
            return TextUtils.isEmpty(a) ? str : a;
        }
        return (String) invokeL.objValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? k.a("sso_config_xf", "pauseTime", i) : invokeI.intValue;
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? k.a("sso_config_xf", "maxFailedLogTimes", i) : invokeI.intValue;
    }
}
