package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f71617a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f71618b;

    public static o b() {
        if (f71617a == null) {
            synchronized (o.class) {
                if (f71617a == null) {
                    f71617a = new o();
                    f71618b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f71617a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f71618b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
