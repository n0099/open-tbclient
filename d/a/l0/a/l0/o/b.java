package d.a.l0.a.l0.o;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.a2.d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b extends HandlerThread {

    /* renamed from: i  reason: collision with root package name */
    public static final long f47027i = TimeUnit.SECONDS.toMillis(d.a.l0.a.r1.l.b.b());

    /* renamed from: e  reason: collision with root package name */
    public volatile Handler f47028e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f47029f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f47030g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f47031h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47029f.run();
            b.this.f();
        }
    }

    public b(@NonNull Runnable runnable) {
        super("WatchDogThread");
        this.f47031h = new AtomicBoolean(false);
        setDaemon(true);
        this.f47029f = runnable;
        this.f47030g = new a();
    }

    public final boolean c() {
        SwanAppActivity x = d.g().x();
        return (x == null || x.isFinishing() || x.isDestroyed() || x.getFrame() == null || !x.getFrame().P().hasResumed()) ? false : true;
    }

    public synchronized void d() {
        if (!this.f47031h.get() && this.f47028e != null) {
            this.f47028e.removeCallbacks(this.f47030g);
        }
    }

    public synchronized void e(Runnable runnable) {
        if (!this.f47031h.get() && this.f47028e != null) {
            this.f47028e.postDelayed(runnable, f47027i);
        }
    }

    public final synchronized void f() {
        if (!this.f47031h.get() && this.f47028e != null) {
            this.f47028e.removeCallbacks(this.f47030g);
            this.f47028e.postDelayed(this.f47030g, f47027i);
        }
    }

    public synchronized void g() {
        i();
        if (this.f47028e != null) {
            this.f47028e.removeCallbacksAndMessages(null);
            this.f47028e = null;
            quitSafely();
        }
    }

    public void h() {
        f();
    }

    public void i() {
        d();
        this.f47031h.set(true);
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.f47028e = new Handler(getLooper());
        if (c()) {
            f();
        }
    }
}
