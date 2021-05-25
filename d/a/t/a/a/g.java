package d.a.t.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class g {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f64537e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64538f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f64539g;

        public a(SharedPreferences sharedPreferences, String str, Object obj) {
            this.f64537e = sharedPreferences;
            this.f64538f = str;
            this.f64539g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.n(this.f64537e, this.f64538f, this.f64539g);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f64540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64541f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Set f64542g;

        public b(Context context, String str, Set set) {
            this.f64540e = context;
            this.f64541f = str;
            this.f64542g = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64540e.getSharedPreferences("track_sp", 0).edit().putStringSet(this.f64541f, this.f64542g).apply();
        }
    }

    public static Set<String> b(Context context) {
        return h(context, "track_connection", new HashSet());
    }

    public static int c(Context context) {
        return g(context, Constants.KEY_LOGIN_OPEN_TYPE, -1);
    }

    public static Set<String> d(Context context) {
        return h(context, "track_request", new HashSet());
    }

    public static boolean e(Context context, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("real_time_track");
        return g(context, sb.toString(), 0) == 1;
    }

    public static boolean f(Context context) {
        return g(context, "track_upload_state", 1) == 1;
    }

    public static int g(Context context, String str, int i2) {
        return context.getSharedPreferences("track_sp", 0).getInt(str, i2);
    }

    public static Set<String> h(Context context, String str, Set<String> set) {
        return context.getSharedPreferences("track_sp", 0).getStringSet(str, set);
    }

    public static void i(Context context, int i2, int i3) {
        l(context, i2 + "real_time_track", i3);
    }

    public static void j(Context context, int i2) {
        l(context, "track_upload_state", i2);
    }

    public static void k(Context context, Set<String> set) {
        q(context, "track_connection", set);
    }

    public static void l(Context context, String str, int i2) {
        p(context, str, Integer.valueOf(i2));
    }

    public static void m(Context context, int i2) {
        l(context, Constants.KEY_LOGIN_OPEN_TYPE, i2);
    }

    public static void n(SharedPreferences sharedPreferences, String str, Object obj) {
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

    public static void o(Context context, Set<String> set) {
        q(context, "track_request", set);
    }

    public static void p(Context context, String str, Object obj) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("track_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                d.a.t.a.g.a.a(context).b(new a(sharedPreferences, str, obj));
            } else {
                n(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            d.a.t.a.h.e.b("TrackUtils", th.getMessage());
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void q(Context context, String str, Set<String> set) {
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                d.a.t.a.g.a.a(context).b(new b(context, str, set));
            } else {
                context.getSharedPreferences("track_sp", 0).edit().putStringSet(str, set).apply();
            }
        } catch (Throwable th) {
            d.a.t.a.h.e.b("TrackUtils", th.getMessage());
        }
    }
}
