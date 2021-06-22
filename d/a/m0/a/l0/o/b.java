package d.a.m0.a.l0.o;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.a2.d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b extends HandlerThread {

    /* renamed from: i  reason: collision with root package name */
    public static final long f47135i = TimeUnit.SECONDS.toMillis(d.a.m0.a.r1.l.b.b());

    /* renamed from: e  reason: collision with root package name */
    public volatile Handler f47136e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f47137f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f47138g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f47139h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47137f.run();
            b.this.f();
        }
    }

    public b(@NonNull Runnable runnable) {
        super("WatchDogThread");
        this.f47139h = new AtomicBoolean(false);
        setDaemon(true);
        this.f47137f = runnable;
        this.f47138g = new a();
    }

    public final boolean c() {
        SwanAppActivity x = d.g().x();
        return (x == null || x.isFinishing() || x.isDestroyed() || x.getFrame() == null || !x.getFrame().P().hasResumed()) ? false : true;
    }

    public synchronized void d() {
        if (!this.f47139h.get() && this.f47136e != null) {
            this.f47136e.removeCallbacks(this.f47138g);
        }
    }

    public synchronized void e(Runnable runnable) {
        if (!this.f47139h.get() && this.f47136e != null) {
            this.f47136e.postDelayed(runnable, f47135i);
        }
    }

    public final synchronized void f() {
        if (!this.f47139h.get() && this.f47136e != null) {
            this.f47136e.removeCallbacks(this.f47138g);
            this.f47136e.postDelayed(this.f47138g, f47135i);
        }
    }

    public synchronized void g() {
        i();
        if (this.f47136e != null) {
            this.f47136e.removeCallbacksAndMessages(null);
            this.f47136e = null;
            quitSafely();
        }
    }

    public void h() {
        f();
    }

    public void i() {
        d();
        this.f47139h.set(true);
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.f47136e = new Handler(getLooper());
        if (c()) {
            f();
        }
    }
}
