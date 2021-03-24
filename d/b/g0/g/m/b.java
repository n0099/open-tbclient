package d.b.g0.g.m;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.widget.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.p.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.e.a;
import d.b.g0.a.r1.d;
import d.b.g0.a.r1.e;
import d.b.g0.a.z0.f;
import d.b.g0.g.q.a;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.o0.c {
    public static final boolean w = k.f45050a;
    public long v;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.u0.b {
        public a() {
        }

        @Override // d.b.g0.a.u0.b
        public void a(int i, d.b.g0.a.u0.a aVar) {
            a.c cVar = (a.c) aVar;
            if (cVar == null || TextUtils.isEmpty(cVar.f48544a)) {
                return;
            }
            d.b.g0.g.m.a.m().I(b.this.M());
            d.b.g0.g.m.a.m().x(cVar);
            d.b.g0.g.c.j.b.h();
            b.this.W0();
            b.this.V0();
        }
    }

    /* renamed from: d.b.g0.g.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0983b implements a.c {
        public C0983b() {
        }

        @Override // d.b.g0.a.n1.c.e.a.c
        public boolean a(Message message) {
            int i = message.what;
            if (i == 100) {
                d.b.g0.a.n1.c.a.e().h(new d.b.g0.a.n1.c.c(4));
                b.this.D0();
                d.b.g0.g.m.a.m().H();
                d.e().v();
                return true;
            } else if (i == 102) {
                boolean a2 = d.b.g0.a.w0.a.z().a();
                d.b.g0.a.w0.a.z().d(a2);
                if (b.this.f45410f != null) {
                    b.this.f45410f.onNightModeCoverChanged(a2, false);
                }
                return true;
            } else if (i == 103) {
                e y = e.y();
                if (y != null) {
                    y.R().i();
                    d.b.g0.a.g1.o.a.h().w();
                }
                b.this.D0();
                d.b.g0.g.m.a.m().H();
                return true;
            } else if (i == 106) {
                d.e().v();
                return true;
            } else if (i != 107) {
                switch (i) {
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        d.b.g0.a.i2.b.r(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                        d.b.g0.a.i2.b.q(message);
                        return true;
                    case 125:
                        d.b.g0.a.n1.c.d.a.b(message);
                        return true;
                    case 126:
                        d.b.g0.a.n1.c.d.a.d(message);
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
            d.b.g0.g.c0.d.f(b.this.M());
            b.this.f45410f.finishLoadingAnimator();
            i.g("preload", "startup");
            int j = d.b.g0.g.m.a.m().j();
            HybridUbcFlow o = i.o("startup");
            o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            o.y("codecache", String.valueOf(j));
            o.A(new UbcFlowEvent("na_first_paint"));
            o.w();
            long e2 = o.e("na_first_paint", "naStart");
            d.b.g0.g.m.a.m().i(new d.b.g0.g.u.b(e2));
            if (b.w) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + e2);
            }
            d.b.g0.g.i0.c.A().D();
            d.b.g0.g.r.a.c().init();
        }
    }

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // d.b.g0.a.o0.c
    @NonNull
    public a.c O() {
        return new C0983b();
    }

    public final void S0() {
        Z0();
        if (d.e().x()) {
            f.V().u(M(), new a());
            if (d.b.g0.g.m.a.m().v() && d.b.g0.g.m.a.m().q()) {
                d.b.g0.g.m.a.m().F(this.f45410f);
            }
        }
    }

    @Override // d.b.g0.a.o0.c
    public boolean T() {
        return d.e().s().L().a0() == 1;
    }

    public long T0() {
        return this.v;
    }

    public d.b.g0.g.i.a U0() {
        return d.b.g0.g.m.a.m().n();
    }

    public final void V0() {
        d.b.g0.g.i0.c.A().m();
    }

    public final void W0() {
        d.b.g0.g.i0.c.A().F();
    }

    @Override // d.b.g0.a.o0.c
    public void X() {
        d.b.g0.a.c0.c.g("SwanApp", "onBackPressed back stack count:" + this.f45411g.k());
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47253d = j.j;
        D(fVar);
        d.b.g0.a.e0.l.c m = this.f45411g.m();
        if (m == null || !m.v()) {
            if (R()) {
                e y = e.y();
                if (y != null) {
                    y.C().D();
                }
                d.b.g0.g.c0.d.e(j.j, M());
                return;
            }
            f.b i = this.f45411g.i("navigateBack");
            i.n(d.b.g0.a.e0.l.f.i, d.b.g0.a.e0.l.f.f44013h);
            i.g();
            i.a();
        }
    }

    public boolean X0() {
        return this.v > 0;
    }

    @Override // d.b.g0.a.o0.c
    public void Y() {
        a1();
        d.b.g0.g.c0.b.c().b();
        d.b.g0.g.w.f.b.b().e();
        s().e(true);
        S0();
        V8Engine.setCrashKeyValue("game_title", M() == null ? "" : M().J());
    }

    public void Y0() {
        k0.X(new c());
        d.b.g0.g.i0.d.b();
    }

    public final void Z0() {
        this.v = 0L;
    }

    @Override // d.b.g0.a.o0.c
    public void a0() {
        d.b.g0.g.b.d.w();
        d.b.g0.g.l.i.i();
        d.b.g0.g.c0.d.e("exit", M());
        d.b.g0.a.z0.f.V().w(this.f45410f);
        d.b.g0.a.z0.f.d0();
        d.b.g0.g.h0.a.a().b();
        SwanInspectorEndpoint.v().q();
        d.b.g0.g.c0.b.c().b();
        d.b.g0.g.w.f.b.b().e();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a1() {
        boolean z;
        if (!s().d()) {
            return;
        }
        SwanCoreVersion s = d.b.g0.g.m.a.m().s();
        long h2 = d.b.g0.a.b2.b.h(M().X());
        if (h2 != 0 && s != null) {
            long j = s.swanCoreVersion;
            if (j != 0 && j < h2) {
                if (w) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + h2 + ", runtimeSwanCoreVersion:" + s.swanCoreVersion);
                }
                d.b.g0.g.m.a.C();
                return;
            }
        }
        SwanCoreVersion f0 = M().f0();
        if (s != null && f0 != null) {
            long j2 = s.swanCoreVersion;
            if (j2 != 0 && j2 < f0.swanCoreVersion && d.b.g0.a.y0.e.a.a(M().R())) {
                z = true;
                if (z) {
                    return;
                }
                if (w) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                d.b.g0.g.m.a.C();
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // d.b.g0.a.o0.c
    public void e0() {
        super.e0();
        d.b.g0.g.m.a.m().h(this.f45410f);
    }

    @Override // d.b.g0.a.o0.c
    public void g0() {
    }

    @Override // d.b.g0.a.r1.m, d.b.g0.a.r1.h
    public int h() {
        return 1;
    }

    @Override // d.b.g0.a.o0.c
    public void i0() {
        d.b.g0.a.z0.f.V().q(this.f45410f);
    }

    @Override // d.b.g0.a.o0.c
    public void j0() {
    }

    @Override // d.b.g0.a.o0.c
    public void l0() {
    }

    @Override // d.b.g0.a.o0.c
    public void n0() {
    }

    @Override // d.b.g0.a.o0.c
    public void p0() {
    }

    @Override // d.b.g0.a.o0.c
    public void s0(boolean z, boolean z2) {
        if (z) {
            d.b.g0.a.z1.h.y();
            if (z2) {
                d.b.g0.g.c0.d.f(M());
            }
        }
    }
}
