package d.a.n0.b0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f51258a;

    public static Handler a() {
        if (f51258a == null) {
            synchronized (f.class) {
                if (f51258a == null) {
                    f51258a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f51258a;
    }

    public static void b(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            a().post(runnable);
        } else {
            runnable.run();
        }
    }
}
