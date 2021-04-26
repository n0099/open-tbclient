package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f67528a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f67529b;

    public static o b() {
        if (f67528a == null) {
            synchronized (o.class) {
                if (f67528a == null) {
                    f67528a = new o();
                    f67529b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f67528a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f67529b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
