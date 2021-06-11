package d.a.l0.h.o;

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
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.h0.m.h;
import d.a.l0.a.k;
import d.a.l0.a.r0.i;
import d.a.l0.a.v1.c.e.a;
import d.a.l0.a.v2.l0;
import d.a.l0.a.v2.q0;
import d.a.l0.h.s.a;
/* loaded from: classes3.dex */
public class d extends d.a.l0.a.t0.c {
    public static final boolean w = k.f46875a;
    public long v;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.a1.b {
        public a() {
        }

        @Override // d.a.l0.a.a1.b
        public void a(int i2, d.a.l0.a.a1.a aVar) {
            a.c cVar = (a.c) aVar;
            if (cVar == null || TextUtils.isEmpty(cVar.f51348a)) {
                return;
            }
            d.a.l0.h.o.c.m().I(d.this.O());
            d.a.l0.h.o.c.m().x(cVar);
            d.a.l0.h.c.j.b.h();
            d.this.Z0();
            d.this.Y0();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.c {
        public b() {
        }

        @Override // d.a.l0.a.v1.c.e.a.c
        public boolean a(Message message) {
            int i2 = message.what;
            if (i2 == 100) {
                d.a.l0.a.v1.c.a.e().h(new d.a.l0.a.v1.c.c(4));
                d.this.G0();
                d.a.l0.h.o.c.m().H();
                d.a.l0.a.a2.d.g().t();
                return true;
            } else if (i2 == 102) {
                boolean a2 = d.a.l0.a.c1.a.H().a();
                d.a.l0.a.c1.a.H().d(a2);
                if (d.this.f48391f != null) {
                    d.this.f48391f.onNightModeCoverChanged(a2, false);
                }
                return true;
            } else if (i2 == 103) {
                d.a.l0.a.a2.e i3 = d.a.l0.a.a2.e.i();
                if (i3 != null) {
                    i3.T().i();
                    d.a.l0.a.n1.q.a.g().v();
                }
                d.this.G0();
                d.a.l0.h.o.c.m().H();
                return true;
            } else if (i2 == 106) {
                d.a.l0.a.a2.d.g().t();
                return true;
            } else if (i2 != 107) {
                switch (i2) {
                    case 123:
                        d.a.l0.a.v2.c.r(message);
                        return true;
                    case 124:
                        d.a.l0.a.v2.c.q(message);
                        return true;
                    case 125:
                        d.a.l0.a.v1.c.d.a.b(message);
                        return true;
                    case 126:
                        d.a.l0.a.v1.c.d.a.d(message);
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
            if (d.w) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
            }
            d.this.v = System.currentTimeMillis();
            d.a.l0.h.f0.h.f(d.this.O());
            d.this.f48391f.finishLoadingAnimator();
            d.a.l0.a.r1.h.h("preload", "startup");
            int j = d.a.l0.h.o.c.m().j();
            HybridUbcFlow p = d.a.l0.a.r1.h.p("startup");
            p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            p.A("codecache", String.valueOf(j));
            p.C(new UbcFlowEvent("na_first_paint"));
            p.x();
            long e2 = p.e("na_first_paint", "naStart");
            d.a.l0.h.o.c.m().i(new d.a.l0.h.w.b(e2));
            if (d.w) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + e2);
            }
            d.a.l0.h.m0.d.A().D();
            d.a.l0.h.t.a.f().init();
        }
    }

    public d(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // d.a.l0.a.t0.c
    @NonNull
    public a.c Q() {
        return new b();
    }

    @Override // d.a.l0.a.t0.c
    public boolean V() {
        return d.a.l0.a.a2.d.g().r().N().d0() == 1;
    }

    public final void V0() {
        c1();
        if (d.a.l0.a.a2.d.g().C()) {
            f.V().G(O(), new a());
            if (d.a.l0.h.o.c.m().v() && d.a.l0.h.o.c.m().q()) {
                d.a.l0.h.o.c.m().F(this.f48391f);
            }
        }
    }

    public long W0() {
        return this.v;
    }

    public d.a.l0.a.l0.a X0() {
        return d.a.l0.h.o.c.m().n();
    }

    public final void Y0() {
        d.a.l0.h.m0.d.A().m();
    }

    @Override // d.a.l0.a.t0.c
    public void Z() {
        d.a.l0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f48392g.k());
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f46865e = j.j;
        F(fVar);
        d.a.l0.a.h0.g.d m = this.f48392g.m();
        if (m == null || !m.K()) {
            if (T()) {
                d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
                if (i2 != null) {
                    i2.E().E();
                }
                d.a.l0.h.f0.h.e(j.j, O());
                return;
            }
            g.b i3 = this.f48392g.i("navigateBack");
            i3.n(g.f45754i, g.f45753h);
            i3.g();
            i3.a();
        }
    }

    public final void Z0() {
        d.a.l0.h.m0.d.A().F();
    }

    public boolean a1() {
        return this.v > 0;
    }

    @Override // d.a.l0.a.t0.c
    public void b0() {
        d1();
        d.a.l0.h.f0.b.c().b();
        d.a.l0.h.y.e.b.b().e();
        r().f(true);
        V0();
        V8Engine.setCrashKeyValue("game_title", O() == null ? "" : O().K());
    }

    public void b1() {
        q0.b0(new c());
        d.a.l0.h.m0.f.j();
        d.a.l0.h.m0.e.b();
    }

    public final void c1() {
        this.v = 0L;
    }

    @Override // d.a.l0.a.t0.c
    public void d0() {
        d.a.l0.h.b.d.w();
        i.i();
        d.a.l0.h.f0.h.e("exit", O());
        f.V().k(this.f48391f);
        f.c0();
        d.a.l0.h.l0.a.a().b();
        SwanInspectorEndpoint.v().q();
        d.a.l0.h.f0.b.c().b();
        d.a.l0.h.y.e.b.b().e();
    }

    public final void d1() {
        if (r().e()) {
            if (l0.f(O().a0())) {
                if (w) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + O().a0());
                }
                d.a.l0.h.o.c.C();
                return;
            }
            SwanCoreVersion i0 = O().i0();
            if (i0 != null && l0.f(i0.swanCoreVersionName) && d.a.l0.a.f1.e.a.a(O().S())) {
                if (w) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                d.a.l0.h.o.c.C();
            }
        }
    }

    @Override // d.a.l0.a.t0.c
    public void h0() {
        super.h0();
        d.a.l0.h.o.c.m().h(this.f48391f);
    }

    @Override // d.a.l0.a.t0.c
    public void j0() {
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public int l() {
        return 1;
    }

    @Override // d.a.l0.a.t0.c
    public void l0() {
        f.V().E(this.f48391f);
    }

    @Override // d.a.l0.a.t0.c
    public void m0() {
    }

    @Override // d.a.l0.a.t0.c
    public void o0() {
    }

    @Override // d.a.l0.a.t0.c
    public void q0() {
    }

    @Override // d.a.l0.a.t0.c
    public void s0() {
    }

    @Override // d.a.l0.a.t0.c
    public void v0(boolean z, boolean z2) {
        if (z) {
            d.a.l0.a.j2.k.A();
            if (z2) {
                d.a.l0.h.f0.h.f(O());
            }
        }
    }
}
