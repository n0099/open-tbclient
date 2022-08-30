package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, boolean z) {
        InterceptResult invokeLZ;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, context, z)) == null) {
            try {
                connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 1) {
                    if (type == 0) {
                        c.b("TelephonyUtils", "流量");
                        return 1;
                    }
                    return 0;
                }
                c.b("TelephonyUtils", "WIFI");
                boolean a = g.a(context, "android.permission.CHANGE_NETWORK_STATE");
                StringBuilder sb = new StringBuilder();
                sb.append("CHANGE_NETWORK_STATE=");
                sb.append(a);
                c.a("TelephonyUtils", sb.toString());
                if (a && z && a(connectivityManager, context)) {
                    c.b("TelephonyUtils", "流量数据 WIFI 同开");
                    return 3;
                }
                return 2;
            }
            return 0;
        }
        return invokeLZ.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return "android" + Build.VERSION.RELEASE;
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.VERSION.SDK_INT <= 28 : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str = Build.MANUFACTURER;
            c.a(Constants.PHONE_BRAND, str);
            return "HUAWEI".equalsIgnoreCase(str);
        }
        return invokeV.booleanValue;
    }

    public static boolean a(ConnectivityManager connectivityManager, Context context) {
        InterceptResult invokeLL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, connectivityManager, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    return telephonyManager.isDataEnabled();
                }
                Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                declaredMethod.setAccessible(true);
                boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
                StringBuilder sb = new StringBuilder();
                sb.append("data is on ---------");
                sb.append(booleanValue);
                c.b("TelephonyUtils", sb.toString());
                return booleanValue;
            } catch (Exception unused) {
                c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null || 1 != telephonyManager.getSimState();
        }
        return invokeL.booleanValue;
    }
}
