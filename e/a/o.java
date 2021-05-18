package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f68214a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f68215b;

    public static o b() {
        if (f68214a == null) {
            synchronized (o.class) {
                if (f68214a == null) {
                    f68214a = new o();
                    f68215b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f68214a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f68215b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
