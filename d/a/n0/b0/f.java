package d.a.n0.b0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f54935a;

    public static Handler a() {
        if (f54935a == null) {
            synchronized (f.class) {
                if (f54935a == null) {
                    f54935a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f54935a;
    }

    public static void b(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            a().post(runnable);
        } else {
            runnable.run();
        }
    }
}
