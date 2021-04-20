package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f68430a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f68431b;

    public static o b() {
        if (f68430a == null) {
            synchronized (o.class) {
                if (f68430a == null) {
                    f68430a = new o();
                    f68431b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f68430a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f68431b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
