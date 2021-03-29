package d.b.s.a.f;

import android.content.Context;
import d.b.s.a.g.d;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f64659c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f64660d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f64661e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f64662f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f64663a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64664b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f64660d = availableProcessors;
        f64661e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f64662f = (f64660d * 2) + 1;
    }

    public a(Context context) {
        this.f64663a = null;
        this.f64664b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f64661e, f64662f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64663a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f64659c == null) {
            synchronized (a.class) {
                if (f64659c == null) {
                    f64659c = new a(context);
                }
            }
        }
        return f64659c;
    }

    public void b(Runnable runnable) {
        try {
            this.f64663a.submit(runnable);
        } catch (Throwable th) {
            d.c("TaskManager", "Exception ", th);
        }
    }
}
