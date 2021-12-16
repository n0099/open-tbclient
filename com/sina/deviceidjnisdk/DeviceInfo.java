package com.sina.deviceidjnisdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
/* loaded from: classes3.dex */
public class DeviceInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceInfo() {
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

    @SuppressLint({"MissingPermission"})
    public static String getDeviceId(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String str = null;
            if (isPermissionGranted(context, s.f57419c)) {
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                } catch (Exception unused) {
                }
                if (telephonyManager == null) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    deviceId = telephonyManager.getDeviceId(0);
                } else {
                    deviceId = telephonyManager.getDeviceId();
                }
                if (deviceId != null) {
                    str = deviceId;
                }
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? getDeviceId(context) : (String) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static String getImsi(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (isPermissionGranted(context, s.f57419c)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                str = telephonyManager.getSubscriberId();
            } else {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getMacAddress(Context context) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str = null;
            if (isPermissionGranted(context, s.f57420d)) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                        return null;
                    }
                    str = connectionInfo.getMacAddress();
                } catch (Exception unused) {
                    str = "";
                }
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isPermissionGranted(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) ? context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 : invokeLL.booleanValue;
    }
}
