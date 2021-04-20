package d.b.c.e.m;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f42377b = new h();

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f42378a = new ScheduledThreadPoolExecutor(1);

    public static h a() {
        return f42377b;
    }

    public void b(Runnable runnable) {
        if (this.f42378a.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.f42378a.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void c(Runnable runnable) {
        try {
            this.f42378a.submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
