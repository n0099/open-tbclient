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
    public static a f68429c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f68430d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f68431e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f68432f;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f68433a;

    /* renamed from: b  reason: collision with root package name */
    public Context f68434b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f68430d = availableProcessors;
        f68431e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f68432f = (f68430d * 2) + 1;
    }

    public a(Context context) {
        this.f68433a = null;
        this.f68434b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f68431e, f68432f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f68433a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        if (f68429c == null) {
            synchronized (a.class) {
                if (f68429c == null) {
                    f68429c = new a(context);
                }
            }
        }
        return f68429c;
    }

    public void b(Runnable runnable) {
        try {
            this.f68433a.submit(runnable);
        } catch (Throwable th) {
            e.c("TaskManager", "Exception ", th);
        }
    }
}
