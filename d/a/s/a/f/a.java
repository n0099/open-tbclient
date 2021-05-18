package d.a.s.a.f;

import android.content.Context;
import d.a.s.a.g.d;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f64628c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f64629d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f64630e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f64631f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f64632a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64633b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f64629d = availableProcessors;
        f64630e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f64631f = (f64629d * 2) + 1;
    }

    public a(Context context) {
        this.f64632a = null;
        this.f64633b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f64630e, f64631f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64632a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f64628c == null) {
            synchronized (a.class) {
                if (f64628c == null) {
                    f64628c = new a(context);
                }
            }
        }
        return f64628c;
    }

    public void b(Runnable runnable) {
        try {
            this.f64632a.submit(runnable);
        } catch (Throwable th) {
            d.c("TaskManager", "Exception ", th);
        }
    }
}
