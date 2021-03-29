package d.b.s.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f64670e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64671f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f64672g;

        public a(SharedPreferences sharedPreferences, String str, Object obj) {
            this.f64670e = sharedPreferences;
            this.f64671f = str;
            this.f64672g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.D(this.f64670e, this.f64671f, this.f64672g);
        }
    }

    public static void A(Context context, String str, boolean z) {
        E(context, str, Boolean.valueOf(z));
    }

    public static void B(Context context, int i) {
        C(context, "conn_type", i);
    }

    public static void C(Context context, String str, int i) {
        E(context, str, Integer.valueOf(i));
    }

    public static void D(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof Boolean) {
            sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
        } else if (obj instanceof Integer) {
            sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
        } else if (obj instanceof Long) {
            sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
        } else if (obj instanceof Float) {
            sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
        } else if (obj instanceof String) {
            sharedPreferences.edit().putString(str, (String) obj).apply();
        }
    }

    public static void E(Context context, String str, Object obj) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("blcp_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                d.b.s.a.f.a.a(context).b(new a(sharedPreferences, str, obj));
            } else {
                D(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            d.b("SpUtils", th.getMessage());
        }
    }

    public static void F(Context context, String str, String str2) {
        E(context, str, str2);
    }

    public static String b(Context context) {
        return p(context, "blcp_app_id", "");
    }

    public static boolean c(Context context) {
        return n(context, "bddns_enable", false);
    }

    public static int d(Context context) {
        return o(context, "conn_type", 1);
    }

    public static String e(Context context) {
        return p(context, "blcp_cuid", "");
    }

    public static int f(Context context) {
        return o(context, "key_vip_connect_type", 3);
    }

    public static int g(Context context) {
        return o(context, "lcp_env_debug", 0);
    }

    public static String h(Context context, int i) {
        return p(context, "protocol_priority" + i, " : : ");
    }

    public static int i(Context context) {
        return o(context, "protocols_size", 1);
    }

    public static String j(Context context) {
        return p(context, "blcp_token", "");
    }

    public static boolean k(Context context) {
        return !TextUtils.isEmpty(j(context));
    }

    public static boolean l(Context context) {
        return n(context, "lcp_debug", false);
    }

    public static boolean m(Context context) {
        return n(context, "small_flow", false);
    }

    public static boolean n(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("blcp_sp", 0).getBoolean(str, z);
    }

    public static int o(Context context, String str, int i) {
        if (context == null) {
            return -1;
        }
        return context.getSharedPreferences("blcp_sp", 0).getInt(str, i);
    }

    public static String p(Context context, String str, String str2) {
        return context == null ? "" : context.getSharedPreferences("blcp_sp", 0).getString(str, str2);
    }

    public static void q(Context context, String str) {
        F(context, "blcp_app_id", str);
    }

    public static void r(Context context, boolean z) {
        A(context, "bddns_enable", z);
    }

    public static void s(Context context, String str) {
        F(context, "blcp_cuid", str);
    }

    public static void t(Context context, int i) {
        C(context, "key_vip_connect_type", i);
    }

    public static void u(Context context, int i) {
        C(context, "lcp_env_debug", i);
    }

    public static void v(Context context, boolean z) {
        A(context, "lcp_debug", z);
    }

    public static void w(Context context, String str, int i) {
        F(context, "protocol_priority" + i, str);
    }

    public static void x(Context context, int i) {
        C(context, "protocols_size", i);
    }

    public static void y(Context context, boolean z) {
        A(context, "small_flow", z);
    }

    public static void z(Context context, String str) {
        F(context, "blcp_token", str);
    }
}
