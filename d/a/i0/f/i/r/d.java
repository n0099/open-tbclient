package d.a.i0.f.i.r;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f46656a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        f46656a.postDelayed(runnable, j);
    }

    public static void b(Runnable runnable) {
        f46656a.removeCallbacks(runnable);
    }

    public static void c(Runnable runnable) {
        d(runnable, 0L);
    }

    public static void d(Runnable runnable, long j) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            f46656a.postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }
}
