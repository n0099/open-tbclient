package d.b.g;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    public static volatile l f43093b;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f43094a = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    public static l a() {
        if (f43093b == null) {
            synchronized (l.class) {
                if (f43093b == null) {
                    f43093b = new l();
                }
            }
        }
        return f43093b;
    }

    public Executor b() {
        return this.f43094a;
    }
}
