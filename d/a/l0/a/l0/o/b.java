package d.a.l0.a.l0.o;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.a2.d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: i  reason: collision with root package name */
    public static final long f43351i = TimeUnit.SECONDS.toMillis(d.a.l0.a.r1.l.b.b());

    /* renamed from: e  reason: collision with root package name */
    public volatile Handler f43352e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f43353f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f43354g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f43355h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f43353f.run();
            b.this.f();
        }
    }

    public b(@NonNull Runnable runnable) {
        super("WatchDogThread");
        this.f43355h = new AtomicBoolean(false);
        setDaemon(true);
        this.f43353f = runnable;
        this.f43354g = new a();
    }

    public final boolean c() {
        SwanAppActivity x = d.g().x();
        return (x == null || x.isFinishing() || x.isDestroyed() || x.getFrame() == null || !x.getFrame().P().hasResumed()) ? false : true;
    }

    public synchronized void d() {
        if (!this.f43355h.get() && this.f43352e != null) {
            this.f43352e.removeCallbacks(this.f43354g);
        }
    }

    public synchronized void e(Runnable runnable) {
        if (!this.f43355h.get() && this.f43352e != null) {
            this.f43352e.postDelayed(runnable, f43351i);
        }
    }

    public final synchronized void f() {
        if (!this.f43355h.get() && this.f43352e != null) {
            this.f43352e.removeCallbacks(this.f43354g);
            this.f43352e.postDelayed(this.f43354g, f43351i);
        }
    }

    public synchronized void g() {
        i();
        if (this.f43352e != null) {
            this.f43352e.removeCallbacksAndMessages(null);
            this.f43352e = null;
            quitSafely();
        }
    }

    public void h() {
        f();
    }

    public void i() {
        d();
        this.f43355h.set(true);
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.f43352e = new Handler(getLooper());
        if (c()) {
            f();
        }
    }
}
