package d.a.t.a.g;

import android.content.Context;
import d.a.t.a.h.e;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f64629c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f64630d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f64631e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f64632f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f64633a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64634b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f64630d = availableProcessors;
        f64631e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f64632f = (f64630d * 2) + 1;
    }

    public a(Context context) {
        this.f64633a = null;
        this.f64634b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f64631e, f64632f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64633a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f64629c == null) {
            synchronized (a.class) {
                if (f64629c == null) {
                    f64629c = new a(context);
                }
            }
        }
        return f64629c;
    }

    public void b(Runnable runnable) {
        try {
            this.f64633a.submit(runnable);
        } catch (Throwable th) {
            e.c("TaskManager", "Exception ", th);
        }
    }
}
