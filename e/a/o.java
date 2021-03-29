package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f67437a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f67438b;

    public static o b() {
        if (f67437a == null) {
            synchronized (o.class) {
                if (f67437a == null) {
                    f67437a = new o();
                    f67438b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f67437a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f67438b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
