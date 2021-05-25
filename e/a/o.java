package e.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static o f68257a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f68258b;

    public static o b() {
        if (f68257a == null) {
            synchronized (o.class) {
                if (f68257a == null) {
                    f68257a = new o();
                    f68258b = Executors.newFixedThreadPool(1);
                }
            }
        }
        return f68257a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f68258b.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
