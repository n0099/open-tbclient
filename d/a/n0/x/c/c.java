package d.a.n0.x.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f63196a;

    /* renamed from: b  reason: collision with root package name */
    public static int f63197b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f63198c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f63199e;

        public a(Runnable runnable) {
            this.f63199e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f63199e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f63197b = availableProcessors;
        f63198c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f63196a;
        if (timer != null) {
            timer.cancel();
            f63196a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f63196a;
        if (timer != null) {
            return timer;
        }
        f63196a = new Timer();
        f63196a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f63196a;
    }

    public static void c(Runnable runnable) {
        f63198c.execute(runnable);
    }
}
