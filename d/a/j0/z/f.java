package d.a.j0.z;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f62925a;

    public static Handler a() {
        if (f62925a == null) {
            synchronized (f.class) {
                if (f62925a == null) {
                    f62925a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f62925a;
    }

    public static void b(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            a().post(runnable);
        } else {
            runnable.run();
        }
    }
}
