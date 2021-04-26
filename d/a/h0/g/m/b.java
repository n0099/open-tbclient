package d.a.h0.g.m;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.widget.j;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.p.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import d.a.h0.a.n1.c.e.a;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.e;
import d.a.h0.a.z0.f;
import d.a.h0.g.q.a;
/* loaded from: classes3.dex */
public class b extends d.a.h0.a.o0.c {
    public static final boolean w = k.f43101a;
    public long v;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.u0.b {
        public a() {
        }

        @Override // d.a.h0.a.u0.b
        public void a(int i2, d.a.h0.a.u0.a aVar) {
            a.c cVar = (a.c) aVar;
            if (cVar == null || TextUtils.isEmpty(cVar.f46760a)) {
                return;
            }
            d.a.h0.g.m.a.m().I(b.this.M());
            d.a.h0.g.m.a.m().x(cVar);
            d.a.h0.g.c.j.b.h();
            b.this.W0();
            b.this.V0();
        }
    }

    /* renamed from: d.a.h0.g.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0955b implements a.c {
        public C0955b() {
        }

        @Override // d.a.h0.a.n1.c.e.a.c
        public boolean a(Message message) {
            int i2 = message.what;
            if (i2 == 100) {
                d.a.h0.a.n1.c.a.e().h(new d.a.h0.a.n1.c.c(4));
                b.this.D0();
                d.a.h0.g.m.a.m().H();
                d.e().r();
                return true;
            } else if (i2 == 102) {
                boolean a2 = d.a.h0.a.w0.a.z().a();
                d.a.h0.a.w0.a.z().d(a2);
                if (b.this.f43478f != null) {
                    b.this.f43478f.onNightModeCoverChanged(a2, false);
                }
                return true;
            } else if (i2 == 103) {
                e h2 = e.h();
                if (h2 != null) {
                    h2.R().i();
                    d.a.h0.a.g1.o.a.h().w();
                }
                b.this.D0();
                d.a.h0.g.m.a.m().H();
                return true;
            } else if (i2 == 106) {
                d.e().r();
                return true;
            } else if (i2 != 107) {
                switch (i2) {
                    case 123:
                        d.a.h0.a.i2.b.r(message);
                        return true;
                    case 124:
                        d.a.h0.a.i2.b.q(message);
                        return true;
                    case 125:
                        d.a.h0.a.n1.c.d.a.b(message);
                        return true;
                    case 126:
                        d.a.h0.a.n1.c.d.a.d(message);
                        return true;
                    default:
                        return false;
                }
            } else {
                h.a(message);
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.w) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
            }
            b.this.v = System.currentTimeMillis();
            d.a.h0.g.c0.d.f(b.this.M());
            b.this.f43478f.finishLoadingAnimator();
            i.g("preload", "startup");
            int j = d.a.h0.g.m.a.m().j();
            HybridUbcFlow o = i.o("startup");
            o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            o.y("codecache", String.valueOf(j));
            o.A(new UbcFlowEvent("na_first_paint"));
            o.w();
            long e2 = o.e("na_first_paint", "naStart");
            d.a.h0.g.m.a.m().i(new d.a.h0.g.u.b(e2));
            if (b.w) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + e2);
            }
            d.a.h0.g.i0.c.A().D();
            d.a.h0.g.r.a.c().init();
        }
    }

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // d.a.h0.a.o0.c
    @NonNull
    public a.c O() {
        return new C0955b();
    }

    public final void S0() {
        Z0();
        if (d.e().z()) {
            f.V().G(M(), new a());
            if (d.a.h0.g.m.a.m().v() && d.a.h0.g.m.a.m().q()) {
                d.a.h0.g.m.a.m().F(this.f43478f);
            }
        }
    }

    @Override // d.a.h0.a.o0.c
    public boolean T() {
        return d.e().p().L().a0() == 1;
    }

    public long T0() {
        return this.v;
    }

    public d.a.h0.g.i.a U0() {
        return d.a.h0.g.m.a.m().n();
    }

    public final void V0() {
        d.a.h0.g.i0.c.A().m();
    }

    public final void W0() {
        d.a.h0.g.i0.c.A().F();
    }

    @Override // d.a.h0.a.o0.c
    public void X() {
        d.a.h0.a.c0.c.g("SwanApp", "onBackPressed back stack count:" + this.f43479g.k());
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45414d = j.j;
        D(fVar);
        d.a.h0.a.e0.l.c m = this.f43479g.m();
        if (m == null || !m.I()) {
            if (R()) {
                e h2 = e.h();
                if (h2 != null) {
                    h2.C().D();
                }
                d.a.h0.g.c0.d.e(j.j, M());
                return;
            }
            f.b i2 = this.f43479g.i("navigateBack");
            i2.n(d.a.h0.a.e0.l.f.f42033i, d.a.h0.a.e0.l.f.f42032h);
            i2.g();
            i2.a();
        }
    }

    public boolean X0() {
        return this.v > 0;
    }

    @Override // d.a.h0.a.o0.c
    public void Y() {
        a1();
        d.a.h0.g.c0.b.c().b();
        d.a.h0.g.w.f.b.b().e();
        p().e(true);
        S0();
        V8Engine.setCrashKeyValue("game_title", M() == null ? "" : M().J());
    }

    public void Y0() {
        k0.X(new c());
        d.a.h0.g.i0.d.b();
    }

    public final void Z0() {
        this.v = 0L;
    }

    @Override // d.a.h0.a.o0.c
    public void a0() {
        d.a.h0.g.b.d.w();
        d.a.h0.g.l.i.i();
        d.a.h0.g.c0.d.e("exit", M());
        d.a.h0.a.z0.f.V().m(this.f43478f);
        d.a.h0.a.z0.f.d0();
        d.a.h0.g.h0.a.a().b();
        SwanInspectorEndpoint.v().q();
        d.a.h0.g.c0.b.c().b();
        d.a.h0.g.w.f.b.b().e();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a1() {
        boolean z;
        if (!p().d()) {
            return;
        }
        SwanCoreVersion s = d.a.h0.g.m.a.m().s();
        long h2 = d.a.h0.a.b2.b.h(M().X());
        if (h2 != 0 && s != null) {
            long j = s.swanCoreVersion;
            if (j != 0 && j < h2) {
                if (w) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + h2 + ", runtimeSwanCoreVersion:" + s.swanCoreVersion);
                }
                d.a.h0.g.m.a.C();
                return;
            }
        }
        SwanCoreVersion f0 = M().f0();
        if (s != null && f0 != null) {
            long j2 = s.swanCoreVersion;
            if (j2 != 0 && j2 < f0.swanCoreVersion && d.a.h0.a.y0.e.a.a(M().R())) {
                z = true;
                if (z) {
                    return;
                }
                if (w) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                d.a.h0.g.m.a.C();
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // d.a.h0.a.o0.c
    public void e0() {
        super.e0();
        d.a.h0.g.m.a.m().h(this.f43478f);
    }

    @Override // d.a.h0.a.o0.c
    public void g0() {
    }

    @Override // d.a.h0.a.o0.c
    public void i0() {
        d.a.h0.a.z0.f.V().E(this.f43478f);
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public int j() {
        return 1;
    }

    @Override // d.a.h0.a.o0.c
    public void j0() {
    }

    @Override // d.a.h0.a.o0.c
    public void l0() {
    }

    @Override // d.a.h0.a.o0.c
    public void n0() {
    }

    @Override // d.a.h0.a.o0.c
    public void p0() {
    }

    @Override // d.a.h0.a.o0.c
    public void s0(boolean z, boolean z2) {
        if (z) {
            d.a.h0.a.z1.h.y();
            if (z2) {
                d.a.h0.g.c0.d.f(M());
            }
        }
    }
}
