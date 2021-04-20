package d.b.i0.z;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f64221a;

    public static Handler a() {
        if (f64221a == null) {
            synchronized (f.class) {
                if (f64221a == null) {
                    f64221a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f64221a;
    }

    public static void b(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            a().post(runnable);
        } else {
            runnable.run();
        }
    }
}
