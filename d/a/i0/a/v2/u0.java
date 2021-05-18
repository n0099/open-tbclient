package d.a.i0.a.v2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSException;
/* loaded from: classes3.dex */
public class u0 implements d.a.i0.a.v2.e1.b<Exception> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45307i = d.a.i0.a.k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public long f45308e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f45309f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f45310g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f45311h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: d.a.i0.a.v2.u0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0877a implements Runnable {
            public RunnableC0877a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u0.f45307i) {
                    Log.d("SwanH2HeartBeatManager", "do updateCore, isStop=" + u0.this.f45311h);
                }
                if (u0.this.f45311h) {
                    return;
                }
                u0.this.i();
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ProcessUtils.isMainProcess()) {
                u0.this.f45311h = false;
                synchronized (u0.class) {
                    u0.this.f45308e = System.currentTimeMillis();
                    if (u0.this.f45310g != null) {
                        u0.this.f45309f.removeCallbacks(u0.this.f45310g);
                    }
                    u0.this.f45310g = new RunnableC0877a();
                    long a2 = d.a.i0.n.j.i.l.a(300) * 1000;
                    u0.this.f45309f.postDelayed(u0.this.f45310g, a2);
                    if (u0.f45307i) {
                        Log.d("SwanH2HeartBeatManager", "wait next heart beat: " + a2);
                    }
                }
                return;
            }
            d.a.i0.a.v1.b.d.b(c.class, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.n.b.j(new d.a.i0.n.i.m.h(0), new d.a.i0.a.h0.m.i(u0.this, true));
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            u0.j().l();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final u0 f45315a = new u0(null);
    }

    public /* synthetic */ u0(a aVar) {
        this();
    }

    public static u0 j() {
        return d.f45315a;
    }

    @AnyThread
    public final void i() {
        q.k(new b(), "SwanH2HeartBeatManager");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.v2.e1.b
    /* renamed from: k */
    public void onCallback(Exception exc) {
        d.a.i0.n.h.a pmsError;
        this.f45310g = null;
        if (f45307i) {
            Log.w("SwanH2HeartBeatManager", "onCallback", exc);
        }
        if (exc != null) {
            Throwable cause = exc.getCause();
            if ((cause instanceof PMSException) && (pmsError = ((PMSException) cause).getPmsError()) != null && pmsError.f47829d >= 500) {
                m();
                d.a.i0.n.j.i.l.f47978a = false;
                d.a.i0.a.e0.d.h("SwanH2HeartBeatManager", "update core heartBeat exception: code=" + pmsError.f47829d);
                return;
            }
            l();
        }
    }

    public void l() {
        if (d.a.i0.n.j.i.l.f47978a) {
            if (f45307i) {
                Log.d("SwanH2HeartBeatManager", "startHeartBeat");
            }
            q.k(new a(), "SwanH2HeartBeatManager");
        }
    }

    public void m() {
        if (d.a.i0.n.j.i.l.f47978a) {
            if (f45307i) {
                Log.d("SwanH2HeartBeatManager", "stopHeartBeat");
            }
            this.f45311h = true;
            Runnable runnable = this.f45310g;
            if (runnable != null) {
                this.f45309f.removeCallbacks(runnable);
            }
            this.f45310g = null;
        }
    }

    public u0() {
        this.f45311h = false;
        this.f45309f = new Handler(Looper.getMainLooper());
    }
}
