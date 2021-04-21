package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class z0 {

    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Runnable f66056e;

        /* renamed from: f  reason: collision with root package name */
        public final String f66057f;

        /* renamed from: g  reason: collision with root package name */
        public final String f66058g = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        public a(Runnable runnable, String str) {
            this.f66056e = runnable;
            this.f66057f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f66056e.run();
            } catch (Exception e2) {
                e2.printStackTrace();
                y0.f("TrackerDr", "Thread:" + this.f66057f + " exception\n" + this.f66058g, e2);
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
