package d.a.c.e.m;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f38729b = new h();

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f38730a = new ScheduledThreadPoolExecutor(1);

    public static h a() {
        return f38729b;
    }

    public void b(Runnable runnable) {
        if (this.f38730a.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.f38730a.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void c(Runnable runnable) {
        try {
            this.f38730a.submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
