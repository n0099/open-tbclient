package d.b.g;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    public static volatile l f43495b;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f43496a = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    public static l a() {
        if (f43495b == null) {
            synchronized (l.class) {
                if (f43495b == null) {
                    f43495b = new l();
                }
            }
        }
        return f43495b;
    }

    public Executor b() {
        return this.f43496a;
    }
}
