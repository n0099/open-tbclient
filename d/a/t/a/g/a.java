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
    public static a f68347c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f68348d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f68349e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f68350f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f68351a;

    /* renamed from: b  reason: collision with root package name */
    public Context f68352b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f68348d = availableProcessors;
        f68349e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f68350f = (f68348d * 2) + 1;
    }

    public a(Context context) {
        this.f68351a = null;
        this.f68352b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f68349e, f68350f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f68351a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f68347c == null) {
            synchronized (a.class) {
                if (f68347c == null) {
                    f68347c = new a(context);
                }
            }
        }
        return f68347c;
    }

    public void b(Runnable runnable) {
        try {
            this.f68351a.submit(runnable);
        } catch (Throwable th) {
            e.c("TaskManager", "Exception ", th);
        }
    }
}
