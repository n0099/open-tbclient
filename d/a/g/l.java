package d.a.g;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    public static volatile l f40740b;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f40741a = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    public static l a() {
        if (f40740b == null) {
            synchronized (l.class) {
                if (f40740b == null) {
                    f40740b = new l();
                }
            }
        }
        return f40740b;
    }

    public Executor b() {
        return this.f40741a;
    }
}
