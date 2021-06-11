package d.a.n0.x.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f66911a;

    /* renamed from: b  reason: collision with root package name */
    public static int f66912b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f66913c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f66914e;

        public a(Runnable runnable) {
            this.f66914e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f66914e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f66912b = availableProcessors;
        f66913c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f66911a;
        if (timer != null) {
            timer.cancel();
            f66911a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f66911a;
        if (timer != null) {
            return timer;
        }
        f66911a = new Timer();
        f66911a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f66911a;
    }

    public static void c(Runnable runnable) {
        f66913c.execute(runnable);
    }
}
