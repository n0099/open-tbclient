package d.a.o0.x.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f67036a;

    /* renamed from: b  reason: collision with root package name */
    public static int f67037b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f67038c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f67039e;

        public a(Runnable runnable) {
            this.f67039e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f67039e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f67037b = availableProcessors;
        f67038c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f67036a;
        if (timer != null) {
            timer.cancel();
            f67036a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f67036a;
        if (timer != null) {
            return timer;
        }
        f67036a = new Timer();
        f67036a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f67036a;
    }

    public static void c(Runnable runnable) {
        f67038c.execute(runnable);
    }
}
