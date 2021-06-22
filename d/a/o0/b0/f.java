package d.a.o0.b0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f55060a;

    public static Handler a() {
        if (f55060a == null) {
            synchronized (f.class) {
                if (f55060a == null) {
                    f55060a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f55060a;
    }

    public static void b(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            a().post(runnable);
        } else {
            runnable.run();
        }
    }
}
