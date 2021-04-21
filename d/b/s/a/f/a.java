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
    public static a f65617c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f65618d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f65619e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f65620f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f65621a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65622b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f65618d = availableProcessors;
        f65619e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f65620f = (f65618d * 2) + 1;
    }

    public a(Context context) {
        this.f65621a = null;
        this.f65622b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f65619e, f65620f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f65621a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f65617c == null) {
            synchronized (a.class) {
                if (f65617c == null) {
                    f65617c = new a(context);
                }
            }
        }
        return f65617c;
    }

    public void b(Runnable runnable) {
        try {
            this.f65621a.submit(runnable);
        } catch (Throwable th) {
            d.c("TaskManager", "Exception ", th);
        }
    }
}
