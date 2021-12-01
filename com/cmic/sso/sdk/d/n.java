package com.cmic.sso.sdk.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes12.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            } catch (Exception e2) {
                e2.printStackTrace();
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
                c.b("TelephonyUtils", CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING);
                boolean a = g.a(context, "android.permission.CHANGE_NETWORK_STATE");
                StringBuilder sb = new StringBuilder();
                sb.append("CHANGE_NETWORK_STATE=");
                sb.append(a);
                c.a("TelephonyUtils", sb.toString());
                if (a && !TextUtils.isEmpty(str) && a(context, connectivityManager)) {
                    c.b("TelephonyUtils", "流量数据 WIFI 同开");
                    return 3;
                }
                return 2;
            }
            return 0;
        }
        return invokeLL.intValue;
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
            c.a("brand", str);
            return "HUAWEI".equalsIgnoreCase(str);
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context, ConnectivityManager connectivityManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, connectivityManager)) == null) {
            try {
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
