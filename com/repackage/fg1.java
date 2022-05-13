package com.repackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fg1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String b = null;
    public static String c = null;
    public static long d = 60000;
    public static long e;
    public static long f;
    public static long g;
    public static boolean h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755708895, "Lcom/repackage/fg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755708895, "Lcom/repackage/fg1;");
                return;
            }
        }
        long j = d * 60;
        e = j;
        f = j * 24;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Calendar calendar = Calendar.getInstance();
                int i = calendar.get(1);
                int i2 = calendar.get(5);
                return i + "" + (calendar.get(2) + 1) + "" + i2;
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(c)) {
                    return c;
                }
                String p = ue1.f(context).p();
                c = p;
                if (!TextUtils.isEmpty(p)) {
                    return c;
                }
                String str = new String(f());
                c = str;
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                ue1.f(context).k(c);
                return c;
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject c(Context context, JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("1", e(context));
                jSONObject2.put("2", context.getPackageName());
                jSONObject2.put("3", g(context));
                jSONObject2.put("4", gg1.b(context));
                jSONObject2.put("5", str);
                jSONObject2.put("6", System.currentTimeMillis());
                jSONObject2.put("7", "");
                jSONObject2.put("8", te1.b);
                jSONObject2.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject2.put("10", "1.1.1");
                jSONObject2.put("11", "");
                jSONObject2.put("12", "");
                jSONObject2.put("13", 1);
                jSONObject2.put("14", i(context));
                jSONObject2.put("26", "");
                jSONObject2.put("24", rf1.a(context));
                jSONObject2.put("module_section", jSONArray);
                return jSONObject2;
            } catch (Throwable th) {
                d(th);
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) {
        }
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            char[] cArr = new char[16];
            try {
                char[] charArray = a.toCharArray();
                for (int i = 0; i < 16; i++) {
                    int nextInt = new Random().nextInt(62);
                    if (nextInt >= 0 && nextInt < charArray.length) {
                        cArr[i] = charArray[nextInt];
                    }
                }
            } catch (Throwable th) {
                d(th);
            }
            return new String(cArr).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Throwable th;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    d(th);
                    return str;
                }
            } catch (Throwable th3) {
                th = th3;
                str = "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            String k = k(context);
            if (TextUtils.isEmpty(k)) {
                String b2 = b(context);
                return TextUtils.isEmpty(b2) ? ue1.f(context).J() : b2;
            }
            return k;
        }
        return (String) invokeL.objValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return -1;
                }
                if (activeNetworkInfo.getType() == 1) {
                    return 1;
                }
                return p(context);
            } catch (Throwable th) {
                d(th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            context.deleteDatabase("");
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable th) {
                d(th);
                networkInfo = null;
            }
            if (networkInfo == null) {
                return 0;
            }
            if (1 == networkInfo.getType()) {
                return 2;
            }
            networkInfo.getType();
            return 1;
        }
        return invokeL.intValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(b)) {
                    return b;
                }
                String m0 = ue1.f(context).m0();
                b = m0;
                if (!TextUtils.isEmpty(m0)) {
                    return b;
                }
                Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
                if (signature != null) {
                    String d2 = jg1.d(signature.toByteArray());
                    b = d2;
                    if (TextUtils.isEmpty(d2)) {
                        return "";
                    }
                    ue1.f(context).V(b);
                    return b;
                }
                return "";
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            try {
                o(context);
                tf1.c(context).j();
                tf1.c(context).e();
                long currentTimeMillis = System.currentTimeMillis();
                long T = ue1.f(context).T();
                long x = ue1.f(context).x();
                long j = currentTimeMillis - T;
                if (j >= x) {
                    ue1.f(context).r(currentTimeMillis);
                    eg1.a(context, x);
                    return;
                }
                eg1.a(context, x - j);
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    return q(context);
                }
                if (context != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                        if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && runningAppProcessInfo.pkgList != null && runningAppProcessInfo.pkgList.length != 0 && Arrays.asList(runningAppProcessInfo.pkgList).contains(context.getPackageName())) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - g < 1000) {
                return h;
            }
            boolean z = r(context) && m(context);
            h = z;
            g = currentTimeMillis;
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            try {
                String X = ue1.f(context).X();
                String a2 = a();
                if (TextUtils.isEmpty(a2) || !TextUtils.equals(X, a2)) {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", context.getPackageName());
                    jSONObject.put("1", g(context));
                    jSONObject.put("2", "1.1.1");
                    jSONObject.put("3", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                    jSONObject.put("4", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                    tf1.c(context).f(jSONArray.toString(), "1077103", 2);
                    ue1.f(context).A(a2);
                }
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static int p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return 5;
                }
            } catch (Throwable th) {
                d(th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                if (kg1.a(context, "android.permission.GET_TASKS")) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager.getRunningTasks(1) == null || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null) {
                        return false;
                    }
                    return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
                }
                return true;
            } catch (Throwable th) {
                d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                return ((PowerManager) context.getSystemService("power")).isScreenOn();
            } catch (Throwable th) {
                d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
