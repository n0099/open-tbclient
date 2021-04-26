package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class z0 {

    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Runnable f64418e;

        /* renamed from: f  reason: collision with root package name */
        public final String f64419f;

        /* renamed from: g  reason: collision with root package name */
        public final String f64420g = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        public a(Runnable runnable, String str) {
            this.f64418e = runnable;
            this.f64419f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f64418e.run();
            } catch (Exception e2) {
                e2.printStackTrace();
                y0.f("TrackerDr", "Thread:" + this.f64419f + " exception\n" + this.f64420g, e2);
            }
        }
    }

    public static void a(@Nullable String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new Thread(new a(runnable, str), str).start();
    }

    public static boolean b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
