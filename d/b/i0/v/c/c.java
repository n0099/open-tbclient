package d.b.i0.v.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f61949a;

    /* renamed from: b  reason: collision with root package name */
    public static int f61950b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f61951c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f61952e;

        public a(Runnable runnable) {
            this.f61952e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f61952e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f61950b = availableProcessors;
        f61951c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f61949a;
        if (timer != null) {
            timer.cancel();
            f61949a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f61949a;
        if (timer != null) {
            return timer;
        }
        f61949a = new Timer();
        f61949a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f61949a;
    }

    public static void c(Runnable runnable) {
        f61951c.execute(runnable);
    }
}
