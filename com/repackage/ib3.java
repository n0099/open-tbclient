package com.repackage;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.utility.PermissionChecker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.StandardCharsets;
import java.util.List;
/* loaded from: classes6.dex */
public class ib3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static WifiConfiguration a(fb3 fb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fb3Var)) == null) {
            int b = jb3.b(fb3Var);
            if (f(fb3Var.a)) {
                WifiConfiguration wifiConfiguration = new WifiConfiguration();
                wifiConfiguration.SSID = "\"" + fb3Var.a + "\"";
                if (!TextUtils.isEmpty(fb3Var.b)) {
                    wifiConfiguration.BSSID = fb3Var.b;
                }
                if (b == 0) {
                    jb3.d(wifiConfiguration, 0);
                } else if (b == 1) {
                    jb3.d(wifiConfiguration, 1);
                    String[] strArr = wifiConfiguration.wepKeys;
                    strArr[0] = "\"" + fb3Var.d + "\"";
                } else if (b == 2) {
                    jb3.d(wifiConfiguration, 2);
                    wifiConfiguration.preSharedKey = "\"" + fb3Var.d + "\"";
                } else if (b == 3) {
                    jb3.d(wifiConfiguration, 3);
                    WifiEnterpriseConfig wifiEnterpriseConfig = new WifiEnterpriseConfig();
                    wifiEnterpriseConfig.setEapMethod(0);
                    wifiEnterpriseConfig.setIdentity(fb3Var.c);
                    wifiEnterpriseConfig.setPassword(fb3Var.d);
                    wifiConfiguration.enterpriseConfig = wifiEnterpriseConfig;
                }
                return wifiConfiguration;
            }
            return null;
        }
        return (WifiConfiguration) invokeL.objValue;
    }

    public static WifiConfiguration b(Context context, WifiManager wifiManager, WifiInfo wifiInfo) {
        InterceptResult invokeLLL;
        List<WifiConfiguration> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, wifiManager, wifiInfo)) == null) {
            if (wifiInfo != null && f(wifiInfo.getSSID()) && (d = d(context, wifiManager)) != null) {
                for (WifiConfiguration wifiConfiguration : d) {
                    if (TextUtils.equals(e(wifiConfiguration.SSID), e(wifiInfo.getSSID()))) {
                        return wifiConfiguration;
                    }
                }
            }
            return null;
        }
        return (WifiConfiguration) invokeLLL.objValue;
    }

    public static WifiConfiguration c(Context context, WifiManager wifiManager, fb3 fb3Var) {
        InterceptResult invokeLLL;
        List<WifiConfiguration> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, wifiManager, fb3Var)) == null) {
            if (fb3Var != null && f(fb3Var.a) && (d = d(context, wifiManager)) != null) {
                for (WifiConfiguration wifiConfiguration : d) {
                    if (TextUtils.equals(e(wifiConfiguration.SSID), fb3Var.a)) {
                        return wifiConfiguration;
                    }
                }
            }
            return null;
        }
        return (WifiConfiguration) invokeLLL.objValue;
    }

    public static List<WifiConfiguration> d(Context context, WifiManager wifiManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, wifiManager)) == null) {
            if (wifiManager == null) {
                return null;
            }
            try {
                if (ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_FINE_LOCATION) != 0) {
                    return null;
                }
                return wifiManager.getConfiguredNetworks();
            } catch (Exception e) {
                hx1.b("SwanWifiUtils", Log.getStackTraceString(e));
                return null;
            }
        }
        return (List) invokeLL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (length = str.length()) <= 1 || str.charAt(0) != '\"') {
                return str;
            }
            int i = length - 1;
            return str.charAt(i) == '\"' ? str.substring(1, i) : str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.equals("<unknown ssid>")) {
                return false;
            }
            return StandardCharsets.UTF_8.newEncoder().canEncode(str);
        }
        return invokeL.booleanValue;
    }
}
