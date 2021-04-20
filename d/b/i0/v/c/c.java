package d.b.i0.v.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f62959a;

    /* renamed from: b  reason: collision with root package name */
    public static int f62960b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f62961c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f62962e;

        public a(Runnable runnable) {
            this.f62962e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f62962e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f62960b = availableProcessors;
        f62961c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f62959a;
        if (timer != null) {
            timer.cancel();
            f62959a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f62959a;
        if (timer != null) {
            return timer;
        }
        f62959a = new Timer();
        f62959a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f62959a;
    }

    public static void c(Runnable runnable) {
        f62961c.execute(runnable);
    }
}
