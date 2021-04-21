package d.b.j0.z;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f64642a;

    public static Handler a() {
        if (f64642a == null) {
            synchronized (f.class) {
                if (f64642a == null) {
                    f64642a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f64642a;
    }

    public static void b(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            a().post(runnable);
        } else {
            runnable.run();
        }
    }
}
