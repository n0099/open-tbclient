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
    public static a f64658c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f64659d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f64660e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f64661f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f64662a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64663b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f64659d = availableProcessors;
        f64660e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f64661f = (f64659d * 2) + 1;
    }

    public a(Context context) {
        this.f64662a = null;
        this.f64663b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f64660e, f64661f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64662a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f64658c == null) {
            synchronized (a.class) {
                if (f64658c == null) {
                    f64658c = new a(context);
                }
            }
        }
        return f64658c;
    }

    public void b(Runnable runnable) {
        try {
            this.f64662a.submit(runnable);
        } catch (Throwable th) {
            d.c("TaskManager", "Exception ", th);
        }
    }
}
