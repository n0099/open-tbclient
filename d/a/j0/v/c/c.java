package d.a.j0.v.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f61610a;

    /* renamed from: b  reason: collision with root package name */
    public static int f61611b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f61612c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f61613e;

        public a(Runnable runnable) {
            this.f61613e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f61613e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f61611b = availableProcessors;
        f61612c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f61610a;
        if (timer != null) {
            timer.cancel();
            f61610a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f61610a;
        if (timer != null) {
            return timer;
        }
        f61610a = new Timer();
        f61610a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f61610a;
    }

    public static void c(Runnable runnable) {
        f61612c.execute(runnable);
    }
}
