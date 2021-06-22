package d.a.r.a.c;

import d.a.r.a.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f68178b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f68179c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f68180d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f68181e;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f68182a;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f68179c = availableProcessors;
        f68180d = Math.max(4, Math.min(availableProcessors - 1, 4));
        f68181e = (f68179c * 3) + 1;
    }

    public a() {
        this.f68182a = null;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f68180d, f68181e, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.f68182a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        Executors.newSingleThreadExecutor();
    }

    public static a a() {
        if (f68178b == null) {
            synchronized (a.class) {
                if (f68178b == null) {
                    f68178b = new a();
                }
            }
        }
        return f68178b;
    }

    public final boolean b(Runnable runnable) {
        try {
            this.f68182a.submit(runnable);
            return true;
        } catch (Throwable th) {
            c.b("UBCTaskManager", "Exception ", th);
            return false;
        }
    }
}
