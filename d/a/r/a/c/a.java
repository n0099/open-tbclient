package d.a.r.a.c;

import d.a.r.a.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f64356b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f64357c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f64358d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f64359e;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f64360a;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f64357c = availableProcessors;
        f64358d = Math.max(4, Math.min(availableProcessors - 1, 4));
        f64359e = (f64357c * 3) + 1;
    }

    public a() {
        this.f64360a = null;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f64358d, f64359e, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.f64360a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        Executors.newSingleThreadExecutor();
    }

    public static a a() {
        if (f64356b == null) {
            synchronized (a.class) {
                if (f64356b == null) {
                    f64356b = new a();
                }
            }
        }
        return f64356b;
    }

    public final boolean b(Runnable runnable) {
        try {
            this.f64360a.submit(runnable);
            return true;
        } catch (Throwable th) {
            c.b("UBCTaskManager", "Exception ", th);
            return false;
        }
    }
}
