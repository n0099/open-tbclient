package d.b.r.a.f;

import android.content.Context;
import d.b.r.a.g.d;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f65353c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f65354d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f65355e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f65356f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f65357a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65358b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f65354d = availableProcessors;
        f65355e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f65356f = (f65354d * 2) + 1;
    }

    public a(Context context) {
        this.f65357a = null;
        this.f65358b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f65355e, f65356f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f65357a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f65353c == null) {
            synchronized (a.class) {
                if (f65353c == null) {
                    f65353c = new a(context);
                }
            }
        }
        return f65353c;
    }

    public void b(Runnable runnable) {
        try {
            this.f65357a.submit(runnable);
        } catch (Throwable th) {
            d.c("TaskManager", "Exception ", th);
        }
    }
}
