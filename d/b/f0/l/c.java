package d.b.f0.l;

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
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f43014a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* renamed from: b  reason: collision with root package name */
    public static String f43015b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f43016c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f43017d = 60000;

    /* renamed from: e  reason: collision with root package name */
    public static long f43018e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static long f43019f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static long f43020g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f43021h = false;

    static {
        long j = f43017d * 60;
        f43018e = j;
        f43019f = j * 24;
    }

    public static String a() {
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

    public static String b(Context context) {
        try {
            if (!TextUtils.isEmpty(f43016c)) {
                return f43016c;
            }
            String o = d.b.f0.b.a.g(context).o();
            f43016c = o;
            if (!TextUtils.isEmpty(o)) {
                return f43016c;
            }
            String str = new String(f());
            f43016c = str;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            d.b.f0.b.a.g(context).r(f43016c);
            return f43016c;
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
            jSONObject2.put("8", d.b.f0.a.f42808b);
            jSONObject2.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "1.0.5");
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "");
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            jSONObject2.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, 1);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, j(context));
            jSONObject2.put(SoUtils.SO_EVENT_ID_V8_SO, d.b.f0.g.a.a(context));
            jSONObject2.put(SoUtils.SO_EVENT_ID_DEFAULT, d.b.f0.g.a.b(context));
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
            char[] charArray = f43014a.toCharArray();
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
            return TextUtils.isEmpty(b2) ? d.b.f0.b.a.g(context).H() : b2;
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
            if (!TextUtils.isEmpty(f43015b)) {
                return f43015b;
            }
            String j0 = d.b.f0.b.a.g(context).j0();
            f43015b = j0;
            if (!TextUtils.isEmpty(j0)) {
                return f43015b;
            }
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (signature != null) {
                String d2 = g.d(signature.toByteArray());
                f43015b = d2;
                if (TextUtils.isEmpty(d2)) {
                    return "";
                }
                d.b.f0.b.a.g(context).U(f43015b);
                return f43015b;
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
            d.b.f0.h.b.c(context).j();
            d.b.f0.h.b.c(context).e();
            long currentTimeMillis = System.currentTimeMillis();
            long T = d.b.f0.b.a.g(context).T();
            long x = d.b.f0.b.a.g(context).x();
            long j = currentTimeMillis - T;
            if (j >= x) {
                d.b.f0.b.a.g(context).q(currentTimeMillis);
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
        if (currentTimeMillis - f43020g < 1000) {
            return f43021h;
        }
        boolean z = s(context) && n(context);
        f43021h = z;
        f43020g = currentTimeMillis;
        return z;
    }

    public static void p(Context context) {
        try {
            String V = d.b.f0.b.a.g(context).V();
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
                d.b.f0.h.b.c(context).f(jSONArray.toString(), "1077103", 2);
                d.b.f0.b.a.g(context).F(a2);
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
