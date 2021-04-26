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
    public static a f63941c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f63942d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f63943e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f63944f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f63945a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63946b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f63942d = availableProcessors;
        f63943e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f63944f = (f63942d * 2) + 1;
    }

    public a(Context context) {
        this.f63945a = null;
        this.f63946b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f63943e, f63944f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f63945a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f63941c == null) {
            synchronized (a.class) {
                if (f63941c == null) {
                    f63941c = new a(context);
                }
            }
        }
        return f63941c;
    }

    public void b(Runnable runnable) {
        try {
            this.f63945a.submit(runnable);
        } catch (Throwable th) {
            d.c("TaskManager", "Exception ", th);
        }
    }
}
