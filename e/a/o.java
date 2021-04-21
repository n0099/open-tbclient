package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f68577a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f68578b;

    public static o b() {
        if (f68577a == null) {
            synchronized (o.class) {
                if (f68577a == null) {
                    f68577a = new o();
                    f68578b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f68577a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f68578b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
