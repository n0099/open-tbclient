package d.b.j0.v.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f63380a;

    /* renamed from: b  reason: collision with root package name */
    public static int f63381b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f63382c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f63383e;

        public a(Runnable runnable) {
            this.f63383e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f63383e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f63381b = availableProcessors;
        f63382c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f63380a;
        if (timer != null) {
            timer.cancel();
            f63380a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f63380a;
        if (timer != null) {
            return timer;
        }
        f63380a = new Timer();
        f63380a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f63380a;
    }

    public static void c(Runnable runnable) {
        f63382c.execute(runnable);
    }
}
