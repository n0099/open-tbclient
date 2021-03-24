package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f67432a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f67433b;

    public static o b() {
        if (f67432a == null) {
            synchronized (o.class) {
                if (f67432a == null) {
                    f67432a = new o();
                    f67433b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f67432a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f67433b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
