package d.a.l0.a.v2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSException;
/* loaded from: classes3.dex */
public class u0 implements d.a.l0.a.v2.e1.b<Exception> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49157i = d.a.l0.a.k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public long f49158e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f49159f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f49160g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f49161h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: d.a.l0.a.v2.u0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0944a implements Runnable {
            public RunnableC0944a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u0.f49157i) {
                    Log.d("SwanH2HeartBeatManager", "do updateCore, isStop=" + u0.this.f49161h);
                }
                if (u0.this.f49161h) {
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
                u0.this.f49161h = false;
                synchronized (u0.class) {
                    u0.this.f49158e = System.currentTimeMillis();
                    if (u0.this.f49160g != null) {
                        u0.this.f49159f.removeCallbacks(u0.this.f49160g);
                    }
                    u0.this.f49160g = new RunnableC0944a();
                    long a2 = d.a.l0.n.j.i.l.a(300) * 1000;
                    u0.this.f49159f.postDelayed(u0.this.f49160g, a2);
                    if (u0.f49157i) {
                        Log.d("SwanH2HeartBeatManager", "wait next heart beat: " + a2);
                    }
                }
                return;
            }
            d.a.l0.a.v1.b.d.b(c.class, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.n.b.j(new d.a.l0.n.i.m.h(0), new d.a.l0.a.h0.m.i(u0.this, true));
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
        public static final u0 f49165a = new u0(null);
    }

    public /* synthetic */ u0(a aVar) {
        this();
    }

    public static u0 j() {
        return d.f49165a;
    }

    @AnyThread
    public final void i() {
        q.k(new b(), "SwanH2HeartBeatManager");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v2.e1.b
    /* renamed from: k */
    public void onCallback(Exception exc) {
        d.a.l0.n.h.a pmsError;
        this.f49160g = null;
        if (f49157i) {
            Log.w("SwanH2HeartBeatManager", "onCallback", exc);
        }
        if (exc != null) {
            Throwable cause = exc.getCause();
            if ((cause instanceof PMSException) && (pmsError = ((PMSException) cause).getPmsError()) != null && pmsError.f51679d >= 500) {
                m();
                d.a.l0.n.j.i.l.f51828a = false;
                d.a.l0.a.e0.d.h("SwanH2HeartBeatManager", "update core heartBeat exception: code=" + pmsError.f51679d);
                return;
            }
            l();
        }
    }

    public void l() {
        if (d.a.l0.n.j.i.l.f51828a) {
            if (f49157i) {
                Log.d("SwanH2HeartBeatManager", "startHeartBeat");
            }
            q.k(new a(), "SwanH2HeartBeatManager");
        }
    }

    public void m() {
        if (d.a.l0.n.j.i.l.f51828a) {
            if (f49157i) {
                Log.d("SwanH2HeartBeatManager", "stopHeartBeat");
            }
            this.f49161h = true;
            Runnable runnable = this.f49160g;
            if (runnable != null) {
                this.f49159f.removeCallbacks(runnable);
            }
            this.f49160g = null;
        }
    }

    public u0() {
        this.f49161h = false;
        this.f49159f = new Handler(Looper.getMainLooper());
    }
}
