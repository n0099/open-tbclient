package d.a.m0.l;

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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f43638a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* renamed from: b  reason: collision with root package name */
    public static String f43639b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f43640c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f43641d = 60000;

    /* renamed from: e  reason: collision with root package name */
    public static long f43642e;

    /* renamed from: f  reason: collision with root package name */
    public static long f43643f;

    /* renamed from: g  reason: collision with root package name */
    public static long f43644g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f43645h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1720449666, "Ld/a/m0/l/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1720449666, "Ld/a/m0/l/c;");
                return;
            }
        }
        long j = f43641d * 60;
        f43642e = j;
        f43643f = j * 24;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Calendar calendar = Calendar.getInstance();
                int i2 = calendar.get(1);
                int i3 = calendar.get(5);
                return i2 + "" + (calendar.get(2) + 1) + "" + i3;
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
                if (!TextUtils.isEmpty(f43640c)) {
                    return f43640c;
                }
                String p = d.a.m0.b.a.h(context).p();
                f43640c = p;
                if (!TextUtils.isEmpty(p)) {
                    return f43640c;
                }
                String str = new String(f());
                f43640c = str;
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                d.a.m0.b.a.h(context).s(f43640c);
                return f43640c;
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
                jSONObject2.put("3", h(context));
                jSONObject2.put("4", d.j(context));
                jSONObject2.put("5", str);
                jSONObject2.put("6", System.currentTimeMillis());
                jSONObject2.put("7", "");
                jSONObject2.put("8", d.a.m0.a.f43422b);
                jSONObject2.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject2.put("10", "1.0.7");
                jSONObject2.put("11", "");
                jSONObject2.put("12", "");
                jSONObject2.put("13", 1);
                jSONObject2.put("14", j(context));
                jSONObject2.put("26", d.a.m0.g.a.a(context));
                jSONObject2.put("24", d.a.m0.g.a.b(context, true, false));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            char[] cArr = new char[16];
            try {
                char[] charArray = f43638a.toCharArray();
                for (int i2 = 0; i2 < 16; i2++) {
                    int nextInt = new Random().nextInt(62);
                    if (nextInt >= 0 && nextInt < charArray.length) {
                        cArr[i2] = charArray[nextInt];
                    }
                }
            } catch (Throwable th) {
                d(th);
            }
            return new String(cArr).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Throwable th;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String l = l(context);
            if (TextUtils.isEmpty(l)) {
                String b2 = b(context);
                return TextUtils.isEmpty(b2) ? d.a.m0.b.a.h(context).J() : b2;
            }
            return l;
        }
        return (String) invokeL.objValue;
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return -1;
                }
                if (activeNetworkInfo.getType() == 1) {
                    return 1;
                }
                return q(context);
            } catch (Throwable th) {
                d(th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
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

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(f43639b)) {
                    return f43639b;
                }
                String m0 = d.a.m0.b.a.h(context).m0();
                f43639b = m0;
                if (!TextUtils.isEmpty(m0)) {
                    return f43639b;
                }
                Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
                if (signature != null) {
                    String d2 = g.d(signature.toByteArray());
                    f43639b = d2;
                    if (TextUtils.isEmpty(d2)) {
                        return "";
                    }
                    d.a.m0.b.a.h(context).W(f43639b);
                    return f43639b;
                }
                return "";
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            try {
                p(context);
                d.a.m0.h.b.c(context).j();
                d.a.m0.h.b.c(context).e();
                long currentTimeMillis = System.currentTimeMillis();
                long V = d.a.m0.b.a.h(context).V();
                long y = d.a.m0.b.a.h(context).y();
                long j = currentTimeMillis - V;
                if (j >= y) {
                    d.a.m0.b.a.h(context).r(currentTimeMillis);
                    b.a(context, y);
                    return;
                }
                b.a(context, y - j);
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    return r(context);
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

    public static boolean o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f43644g < 1000) {
                return f43645h;
            }
            boolean z = s(context) && n(context);
            f43645h = z;
            f43644g = currentTimeMillis;
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, context) == null) {
            try {
                String X = d.a.m0.b.a.h(context).X();
                String a2 = a();
                if (TextUtils.isEmpty(a2) || !TextUtils.equals(X, a2)) {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", context.getPackageName());
                    jSONObject.put("1", h(context));
                    jSONObject.put("2", "1.0.7");
                    jSONObject.put("3", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                    jSONObject.put("4", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                    d.a.m0.h.b.c(context).f(jSONArray.toString(), "1077103", 2);
                    d.a.m0.b.a.h(context).H(a2);
                }
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static int q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
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

    public static boolean r(Context context) {
        InterceptResult invokeL;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                if (h.a(context, "android.permission.GET_TASKS")) {
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

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
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
