package d.a.k0.v.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f62334a;

    /* renamed from: b  reason: collision with root package name */
    public static int f62335b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f62336c;

    /* loaded from: classes4.dex */
    public static class a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f62337e;

        public a(Runnable runnable) {
            this.f62337e = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f62337e.run();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f62335b = availableProcessors;
        f62336c = Executors.newFixedThreadPool(availableProcessors);
    }

    public static void a() {
        Timer timer = f62334a;
        if (timer != null) {
            timer.cancel();
            f62334a = null;
        }
    }

    public static Timer b(Runnable runnable) {
        Timer timer = f62334a;
        if (timer != null) {
            return timer;
        }
        f62334a = new Timer();
        f62334a.scheduleAtFixedRate(new a(runnable), 0L, 2000L);
        return f62334a;
    }

    public static void c(Runnable runnable) {
        f62336c.execute(runnable);
    }
}
