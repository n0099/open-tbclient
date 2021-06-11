package d.a.r.a.c;

import d.a.r.a.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f68074b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f68075c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f68076d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f68077e;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f68078a;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f68075c = availableProcessors;
        f68076d = Math.max(4, Math.min(availableProcessors - 1, 4));
        f68077e = (f68075c * 3) + 1;
    }

    public a() {
        this.f68078a = null;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f68076d, f68077e, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.f68078a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        Executors.newSingleThreadExecutor();
    }

    public static a a() {
        if (f68074b == null) {
            synchronized (a.class) {
                if (f68074b == null) {
                    f68074b = new a();
                }
            }
        }
        return f68074b;
    }

    public final boolean b(Runnable runnable) {
        try {
            this.f68078a.submit(runnable);
            return true;
        } catch (Throwable th) {
            c.b("UBCTaskManager", "Exception ", th);
            return false;
        }
    }
}
