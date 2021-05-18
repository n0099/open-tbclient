package d.a.g;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    public static volatile l f39985b;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f39986a = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    public static l a() {
        if (f39985b == null) {
            synchronized (l.class) {
                if (f39985b == null) {
                    f39985b = new l();
                }
            }
        }
        return f39985b;
    }

    public Executor b() {
        return this.f39986a;
    }
}
