package d.a.j0.l;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f40467a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* renamed from: b  reason: collision with root package name */
    public static String f40468b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f40469c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f40470d = 60000;

    /* renamed from: e  reason: collision with root package name */
    public static long f40471e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static long f40472f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static long f40473g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f40474h = false;

    static {
        long j = f40470d * 60;
        f40471e = j;
        f40472f = j * 24;
    }

    public static String a() {
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

    public static String b(Context context) {
        try {
            if (!TextUtils.isEmpty(f40469c)) {
                return f40469c;
            }
            String o = d.a.j0.b.a.g(context).o();
            f40469c = o;
            if (!TextUtils.isEmpty(o)) {
                return f40469c;
            }
            String str = new String(f());
            f40469c = str;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            d.a.j0.b.a.g(context).r(f40469c);
            return f40469c;
        } catch (Throwable th) {
            d(th);
            return "";
        }
    }

    public static JSONObject c(Context context, JSONObject jSONObject, String str) {
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
            jSONObject2.put("4", d.l(context));
            jSONObject2.put("5", str);
            jSONObject2.put("6", System.currentTimeMillis());
            jSONObject2.put("7", "");
            jSONObject2.put("8", d.a.j0.a.f40249b);
            jSONObject2.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
            jSONObject2.put("10", "1.0.5");
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "");
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            jSONObject2.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, 1);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, j(context));
            jSONObject2.put(SoUtils.SO_EVENT_ID_V8_SO, d.a.j0.g.a.a(context));
            jSONObject2.put(SoUtils.SO_EVENT_ID_DEFAULT, d.a.j0.g.a.b(context));
            jSONObject2.put("module_section", jSONArray);
            return jSONObject2;
        } catch (Throwable th) {
            d(th);
            return null;
        }
    }

    public static void d(Throwable th) {
    }

    public static String e(Context context) {
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            d(th);
            return "";
        }
    }

    public static byte[] f() {
        char[] cArr = new char[16];
        try {
            char[] charArray = f40467a.toCharArray();
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

    public static String g() {
        return Build.VERSION.RELEASE;
    }

    public static String h(Context context) {
        Throwable th;
        String str;
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

    public static String i(Context context) {
        String l = l(context);
        if (TextUtils.isEmpty(l)) {
            String b2 = b(context);
            return TextUtils.isEmpty(b2) ? d.a.j0.b.a.g(context).H() : b2;
        }
        return l;
    }

    public static int j(Context context) {
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

    public static int k(Context context) {
        NetworkInfo networkInfo;
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

    public static String l(Context context) {
        try {
            if (!TextUtils.isEmpty(f40468b)) {
                return f40468b;
            }
            String j0 = d.a.j0.b.a.g(context).j0();
            f40468b = j0;
            if (!TextUtils.isEmpty(j0)) {
                return f40468b;
            }
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (signature != null) {
                String d2 = g.d(signature.toByteArray());
                f40468b = d2;
                if (TextUtils.isEmpty(d2)) {
                    return "";
                }
                d.a.j0.b.a.g(context).U(f40468b);
                return f40468b;
            }
            return "";
        } catch (Throwable th) {
            d(th);
            return "";
        }
    }

    public static void m(Context context) {
        try {
            p(context);
            d.a.j0.h.b.c(context).j();
            d.a.j0.h.b.c(context).e();
            long currentTimeMillis = System.currentTimeMillis();
            long T = d.a.j0.b.a.g(context).T();
            long x = d.a.j0.b.a.g(context).x();
            long j = currentTimeMillis - T;
            if (j >= x) {
                d.a.j0.b.a.g(context).q(currentTimeMillis);
                b.a(context, x);
            } else {
                b.a(context, x - j);
            }
        } catch (Throwable th) {
            d(th);
        }
    }

    public static boolean n(Context context) {
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

    public static boolean o(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f40473g < 1000) {
            return f40474h;
        }
        boolean z = s(context) && n(context);
        f40474h = z;
        f40473g = currentTimeMillis;
        return z;
    }

    public static void p(Context context) {
        try {
            String V = d.a.j0.b.a.g(context).V();
            String a2 = a();
            if (TextUtils.isEmpty(a2) || !TextUtils.equals(V, a2)) {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", context.getPackageName());
                jSONObject.put("1", h(context));
                jSONObject.put("2", "1.0.5");
                jSONObject.put("3", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("4", System.currentTimeMillis());
                jSONArray.put(jSONObject);
                d.a.j0.h.b.c(context).f(jSONArray.toString(), "1077103", 2);
                d.a.j0.b.a.g(context).F(a2);
            }
        } catch (Throwable th) {
            d(th);
        }
    }

    public static int q(Context context) {
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

    public static boolean r(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
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

    public static boolean s(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            d(th);
            return false;
        }
    }
}
