package d.a.s.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f63854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f63856g;

        public a(SharedPreferences sharedPreferences, String str, Object obj) {
            this.f63854e = sharedPreferences;
            this.f63855f = str;
            this.f63856g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.z(this.f63854e, this.f63855f, this.f63856g);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f63857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63858f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Set f63859g;

        public b(Context context, String str, Set set) {
            this.f63857e = context;
            this.f63858f = str;
            this.f63859g = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f63857e.getSharedPreferences("track_sp", 0).edit().putStringSet(this.f63858f, this.f63859g).apply();
        }
    }

    public static void A(Context context, Set<String> set) {
        D(context, "track_request", set);
    }

    public static void B(Context context, String str, Object obj) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("track_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                d.a.s.a.f.a.a(context).b(new a(sharedPreferences, str, obj));
            } else {
                z(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            d.a.s.a.g.d.b("TrackUtils", th.getMessage());
        }
    }

    public static void C(Context context, String str, String str2) {
        B(context, str, str2);
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void D(Context context, String str, Set<String> set) {
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                d.a.s.a.f.a.a(context).b(new b(context, str, set));
            } else {
                context.getSharedPreferences("track_sp", 0).edit().putStringSet(str, set).apply();
            }
        } catch (Throwable th) {
            d.a.s.a.g.d.b("TrackUtils", th.getMessage());
        }
    }

    public static void b(Context context) {
        D(context, "track_connection", new HashSet());
        D(context, "track_request", new HashSet());
    }

    public static Set<String> c(Context context) {
        return o(context, "track_connection", new HashSet());
    }

    public static long d(Context context) {
        return m(context, Constants.KEY_LOGIN_CALL_TIME, 0L);
    }

    public static String[] e(Context context) {
        return n(context, Constants.KEY_LOGIN_FLAG, "0:1Y:ext").split(":");
    }

    public static int f(Context context) {
        return l(context, Constants.KEY_LOGIN_OPEN_TYPE, -1);
    }

    public static Set<String> g(Context context) {
        return o(context, "track_request", new HashSet());
    }

    public static int h(Context context) {
        return l(context, "track_upload_state_fail_count", 1);
    }

    public static boolean i(Context context, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("real_time_track");
        return l(context, sb.toString(), 0) == 1;
    }

    public static boolean j(Context context) {
        return l(context, "track_upload_state", 1) == 1;
    }

    public static boolean k(Context context) {
        long m = m(context, "track_upload_time", -1L);
        if (m > 0) {
            return System.currentTimeMillis() - m >= 21600000;
        }
        r(context);
        return false;
    }

    public static int l(Context context, String str, int i2) {
        return context.getSharedPreferences("track_sp", 0).getInt(str, i2);
    }

    public static long m(Context context, String str, long j) {
        return context.getSharedPreferences("track_sp", 0).getLong(str, j);
    }

    public static String n(Context context, String str, String str2) {
        return context.getSharedPreferences("track_sp", 0).getString(str, str2);
    }

    public static Set<String> o(Context context, String str, Set<String> set) {
        return context.getSharedPreferences("track_sp", 0).getStringSet(str, set);
    }

    public static void p(Context context, int i2, int i3) {
        u(context, i2 + "real_time_track", i3);
    }

    public static void q(Context context, int i2) {
        u(context, "track_upload_state_fail_count", i2);
    }

    public static void r(Context context) {
        y(context, "track_upload_time", System.currentTimeMillis());
    }

    public static void s(Context context, int i2) {
        u(context, "track_upload_state", i2);
    }

    public static void t(Context context, Set<String> set) {
        D(context, "track_connection", set);
    }

    public static void u(Context context, String str, int i2) {
        B(context, str, Integer.valueOf(i2));
    }

    public static void v(Context context) {
        y(context, Constants.KEY_LOGIN_CALL_TIME, System.currentTimeMillis());
    }

    public static void w(Context context, String str, String str2) {
        if (j(context)) {
            C(context, Constants.KEY_LOGIN_FLAG, System.currentTimeMillis() + ":" + str + ":" + str2);
        }
    }

    public static void x(Context context, int i2) {
        u(context, Constants.KEY_LOGIN_OPEN_TYPE, i2);
    }

    public static void y(Context context, String str, long j) {
        B(context, str, Long.valueOf(j));
    }

    public static void z(SharedPreferences sharedPreferences, String str, Object obj) {
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
}
