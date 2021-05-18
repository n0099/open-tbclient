package d.a.i0.a.l0.o;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.a2.d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: i  reason: collision with root package name */
    public static final long f43177i = TimeUnit.SECONDS.toMillis(d.a.i0.a.r1.l.b.b());

    /* renamed from: e  reason: collision with root package name */
    public volatile Handler f43178e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f43179f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f43180g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f43181h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f43179f.run();
            b.this.f();
        }
    }

    public b(@NonNull Runnable runnable) {
        super("WatchDogThread");
        this.f43181h = new AtomicBoolean(false);
        setDaemon(true);
        this.f43179f = runnable;
        this.f43180g = new a();
    }

    public final boolean c() {
        SwanAppActivity x = d.g().x();
        return (x == null || x.isFinishing() || x.isDestroyed() || x.getFrame() == null || !x.getFrame().P().hasResumed()) ? false : true;
    }

    public synchronized void d() {
        if (!this.f43181h.get() && this.f43178e != null) {
            this.f43178e.removeCallbacks(this.f43180g);
        }
    }

    public synchronized void e(Runnable runnable) {
        if (!this.f43181h.get() && this.f43178e != null) {
            this.f43178e.postDelayed(runnable, f43177i);
        }
    }

    public final synchronized void f() {
        if (!this.f43181h.get() && this.f43178e != null) {
            this.f43178e.removeCallbacks(this.f43180g);
            this.f43178e.postDelayed(this.f43180g, f43177i);
        }
    }

    public synchronized void g() {
        i();
        if (this.f43178e != null) {
            this.f43178e.removeCallbacksAndMessages(null);
            this.f43178e = null;
            quitSafely();
        }
    }

    public void h() {
        f();
    }

    public void i() {
        d();
        this.f43181h.set(true);
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.f43178e = new Handler(getLooper());
        if (c()) {
            f();
        }
    }
}
