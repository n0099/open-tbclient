package d.a.k0.z;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f63649a;

    public static Handler a() {
        if (f63649a == null) {
            synchronized (f.class) {
                if (f63649a == null) {
                    f63649a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f63649a;
    }

    public static void b(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            a().post(runnable);
        } else {
            runnable.run();
        }
    }
}
