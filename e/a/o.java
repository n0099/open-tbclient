package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f71513a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f71514b;

    public static o b() {
        if (f71513a == null) {
            synchronized (o.class) {
                if (f71513a == null) {
                    f71513a = new o();
                    f71514b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f71513a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f71514b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
