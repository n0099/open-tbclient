package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final boolean d;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        boolean z;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1436789922, "Lcom/cmic/sso/sdk/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1436789922, "Lcom/cmic/sso/sdk/e/m;");
                return;
            }
        }
        a = Build.BRAND;
        b = Build.MODEL;
        c = "android" + Build.VERSION.RELEASE;
        if (Build.VERSION.SDK_INT <= 28) {
            z = true;
        } else {
            z = false;
        }
        d = z;
        e = Build.MANUFACTURER;
    }

    public static int a(Context context, boolean z, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeCommon;
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Boolean.valueOf(z), aVar})) == null) {
            try {
                connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                networkInfo = null;
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (networkInfo != null && networkInfo.isAvailable()) {
                int type = networkInfo.getType();
                if (type == 1) {
                    c.b("TelephonyUtils", "WIFI");
                    boolean a2 = g.a(context, "android.permission.CHANGE_NETWORK_STATE");
                    c.a("TelephonyUtils", "CHANGE_NETWORK_STATE=" + a2);
                    if (a2 && z && a(connectivityManager, context, aVar)) {
                        c.b("TelephonyUtils", "流量数据 WIFI 同开");
                        return 3;
                    }
                    return 2;
                }
                if (type == 0) {
                    c.b("TelephonyUtils", "流量");
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return c;
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return d;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = e;
            c.a("brand", str);
            return "HUAWEI".equalsIgnoreCase(str);
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || 1 != telephonyManager.getSimState()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(ConnectivityManager connectivityManager, Context context, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, connectivityManager, context, aVar)) == null) {
            try {
                Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                declaredMethod.setAccessible(true);
                boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
                c.b("TelephonyUtils", "data is on ---------" + booleanValue);
                if (Build.VERSION.SDK_INT >= 26) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        if (telephonyManager.createForSubscriptionId(SubscriptionManager.getDefaultSubscriptionId()).isDataEnabled()) {
                            aVar.a("networkTypeByAPI", "1");
                        } else {
                            aVar.a("networkTypeByAPI", "0");
                        }
                    }
                } else {
                    aVar.a("networkTypeByAPI", "-1");
                }
                return booleanValue;
            } catch (Exception unused) {
                c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
