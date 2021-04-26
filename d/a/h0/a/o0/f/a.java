package d.a.h0.a.o0.f;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.alipay.sdk.widget.j;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.p.h;
import d.a.h0.a.i2.p;
import d.a.h0.a.i2.p0;
import d.a.h0.a.i2.v;
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import d.a.h0.a.n1.c.e.a;
import d.a.h0.a.q0.c;
import d.a.h0.a.t1.k.p0.g;
import d.a.h0.a.u0.d;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z0.f;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.o0.c {
    public static final boolean v = k.f43101a;

    /* renamed from: d.a.h0.a.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0721a implements Runnable {
        public RunnableC0721a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.u1.b.d();
            f.V().E(a.this.f43478f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.g1.o.a.h().y();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.e0.n.b<Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.e0.n.b
        /* renamed from: b */
        public void a(Boolean bool) {
            if (a.this.f43478f == null || !bool.booleanValue()) {
                return;
            }
            a.this.f43478f.onBackPressed();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.b {
        public d() {
        }

        @Override // d.a.h0.a.q0.c.b
        public void a() {
            if (a.this.f43478f != null) {
                a.this.f43478f.moveTaskToBack(true);
                p0.b().e(1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a.c {
        public e() {
        }

        @Override // d.a.h0.a.n1.c.e.a.c
        public boolean a(Message message) {
            int i2 = message.what;
            if (i2 == 100) {
                d.a.h0.a.n1.c.a.e().h(new d.a.h0.a.n1.c.c(4));
                a.this.D0();
                d.a.h0.a.r1.d.e().r();
                return true;
            } else if (i2 == 127) {
                d.a.h0.a.c1.c.a.a(Integer.valueOf(d.a.h0.a.c1.c.b.c()));
                return true;
            } else if (i2 == 129) {
                int p = d.a.h0.a.i2.b.m().p();
                d.a.h0.a.c0.c.g("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                if (a.this.f43478f != null && a.this.f43478f.isBackground() && p != -1 && a.this.f43478f.getTaskId() != p) {
                    d.a.h0.a.c0.c.g("SwanAppFrame", "resetCore: purgeSwanApp");
                    d.a.h0.a.r1.d.e().r();
                }
                return true;
            } else if (i2 == 102) {
                boolean a2 = d.a.h0.a.w0.a.z().a();
                d.a.h0.a.w0.a.z().d(a2);
                if (a.this.f43478f != null) {
                    a.this.f43478f.onNightModeCoverChanged(a2, false);
                }
                return true;
            } else if (i2 == 103) {
                d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
                if (h2 != null) {
                    h2.R().i();
                    d.a.h0.a.g1.o.a.h().w();
                }
                a.this.D0();
                return true;
            } else if (i2 == 106) {
                d.a.h0.a.r1.d.e().r();
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
                    default:
                        return false;
                }
            } else {
                h.a(message);
                return true;
            }
        }
    }

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // d.a.h0.a.o0.c
    @NonNull
    public a.c O() {
        return new e();
    }

    public final boolean V0(d.a.h0.a.y0.e.b bVar) {
        if (bVar != null && !d.a.h0.a.m1.a.a.y(bVar)) {
            if (bVar.F() != 0) {
                if (v) {
                    Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                }
                return false;
            }
            SwanAppConfigData D = d.a.h0.a.r1.d.e().p().D();
            if (D == null) {
                if (v) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                }
                return false;
            } else if (!d.e.h(bVar.G(), bVar.n1()).exists()) {
                if (v) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                }
                return false;
            } else {
                return !g.e(bVar, D);
            }
        }
        if (v) {
            Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
        }
        return false;
    }

    public final c.b W0() {
        return new d();
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
                d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
                if (h2 != null) {
                    h2.C().D();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.h0.a.r1.e.T());
                f.V().x(new d.a.h0.a.k0.b.c(hashMap));
                d.a.h0.a.c0.c.g("SwanAppFrame", j.f2016c);
                d.a.h0.a.z0.g.a().d(false);
                return;
            }
            d.a.h0.a.i2.f.a(P(), this.f43478f);
            f.b i2 = this.f43479g.i("navigateBack");
            i2.n(d.a.h0.a.e0.l.f.f42033i, d.a.h0.a.e0.l.f.f42032h);
            i2.g();
            i2.a();
        }
    }

    public final String X0() {
        return d.a.h0.a.y0.e.b.e1(M(), d.a.h0.a.z0.f.V().u());
    }

    @Override // d.a.h0.a.o0.c
    public void Y() {
        this.f43478f.setRequestedOrientation(1);
        d.a.h0.a.i2.e.a(this.f43478f);
        if (d.a.h0.a.e0.e.d()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        d.a.h0.a.y1.a.d().a();
        d.a.h0.a.y1.a.d().i("frame_create");
        d.a.h0.a.f1.f.e().i(true);
        d.a.h0.a.f1.f.e().k();
        e1();
        Y0();
        V8Engine.setCrashKeyValue("app_title", M().J());
    }

    public final void Y0() {
        d.a.h0.a.z1.e.w();
        if (z()) {
            b1();
            b.a M = M();
            if (V0(M)) {
                if (v) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                d.a.h0.a.z0.f.V().e(M, null);
                return;
            }
            if (v) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            d.a.h0.a.z0.f.V().G(M, null);
        }
    }

    public final boolean Z0() {
        d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
        if (e2.z()) {
            b.a L = e2.p().L();
            String S = L.S();
            String T = L.T();
            if (TextUtils.isEmpty(L.S()) || TextUtils.equals(S, T)) {
                return false;
            }
            d.a.h0.a.r1.g H = p().H();
            if (H.b(L.S())) {
                return !H.c(S, Boolean.FALSE).booleanValue();
            }
            return true;
        }
        return false;
    }

    @Override // d.a.h0.a.o0.c
    public void a0() {
        d.a.h0.a.u1.b.f();
        d.a.h0.a.f1.f.e().l();
        d.a.h0.a.w0.a.J().a();
        d.a.h0.a.z0.f.V().m(this.f43478f);
    }

    public final void a1(boolean z) {
        d.a.h0.a.z1.l.b.e(M());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.f12196e = SearchFlowEvent.EventType.END;
            d.a.h0.a.z1.l.b.a(searchFlowEvent);
        }
    }

    public final void b1() {
        b.a M = M();
        if (v) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (M == null) {
            if (v) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion T = d.a.h0.a.e0.w.d.L().T();
        long h2 = d.a.h0.a.b2.b.h(M.X());
        if (h2 != 0 && T != null && h2 > T.swanCoreVersion) {
            d.a.h0.a.e0.w.d.t0(true);
            return;
        }
        SwanCoreVersion f0 = M.f0();
        ExtensionCore K = d.a.h0.a.e0.w.d.L().K();
        ExtensionCore N = M.N();
        boolean z = false;
        boolean z2 = T != null && f0 != null && T.swanCoreVersion < f0.swanCoreVersion && d.a.h0.a.y0.e.a.a(M.R());
        if (K != null && N != null && K.extensionCoreVersionCode < N.extensionCoreVersionCode && d.a.h0.a.y0.e.a.b(M.R())) {
            z = true;
        }
        if (z2 || z) {
            if (v) {
                Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
            }
            d.a.h0.a.e0.w.d.t0(true);
        }
    }

    @Override // d.a.h0.a.o0.c
    public void c0() {
    }

    public final void c1() {
        if (Z0()) {
            p.j(new b(this), "saveUpdateList");
        }
    }

    @Override // d.a.h0.a.o0.c
    public boolean d0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (d.a.h0.a.q0.a.b().c()) {
                d.a.h0.a.q0.a.b().f(this.f43478f, new c());
                return true;
            }
            d.a.h0.a.e0.l.f fVar = this.f43479g;
            if (fVar != null && fVar.k() == 1) {
                d.a.h0.a.q0.b bVar = new d.a.h0.a.q0.b();
                bVar.i();
                if (bVar.j()) {
                    d.a.h0.a.q0.c.c().j(this.f43478f, bVar.g(), bVar.f(), W0());
                    return true;
                }
            }
        }
        return super.d0(i2, keyEvent);
    }

    public final String d1(String str) {
        b.a M = M();
        return (TextUtils.isEmpty(str) && M != null && U(M.G())) ? d.a.h0.a.z0.f.V().h() : str;
    }

    @Override // d.a.h0.a.o0.c
    public void e0() {
        super.e0();
        if (d.a.h0.a.e0.w.d.L().N() != null) {
            d.a.h0.a.e0.w.d.L().N().e(this.f43478f);
        }
    }

    public final void e1() {
        b.a M = M();
        if (v) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + M.f0());
        }
        if (M.f0() == null || !M.f0().a()) {
            if (v) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            M.Q0(d.a.h0.a.b2.b.e(0));
            if (v) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + M.f0());
            }
        }
    }

    @Override // d.a.h0.a.o0.c
    public void g0() {
    }

    @Override // d.a.h0.a.o0.c
    public void i0() {
        ExecutorUtilsExt.postOnElastic(new RunnableC0721a(), "registerScreenshotEvent", 2);
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public int j() {
        return 0;
    }

    @Override // d.a.h0.a.o0.c
    public void j0() {
    }

    @Override // d.a.h0.a.o0.c
    public void l0() {
        i.n().A(new UbcFlowEvent("frame_start_end"));
        d.a.h0.a.y1.a.d().i("frame_start_end");
    }

    @Override // d.a.h0.a.o0.c
    public void n0() {
    }

    @Override // d.a.h0.a.o0.c
    public void p0() {
    }

    @Override // d.a.h0.a.o0.c
    public void s0(boolean z, boolean z2) {
        d.a.h0.a.c0.c.g("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String X0 = X0();
        JSONObject b2 = v.b(M().m("_naExtParams"));
        if (v) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + X0);
        }
        String d1 = d1(X0);
        if (z) {
            d.a.h0.a.z1.e.t();
            d.a.h0.a.f1.f.e().i(z2);
            HybridUbcFlow o = i.o("startup");
            b.a M = M();
            if (z2) {
                if (v) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + d1);
                }
                d.a.h0.a.z1.g.c(2);
                if (!TextUtils.isEmpty(d1)) {
                    if (b2.optString("_naScene", "").equals("message")) {
                        d.a.h0.a.t1.k.p0.a.e("backtohome", "message", d1);
                    } else {
                        d.a.h0.a.z1.e.r(d1, M);
                        d.a.h0.a.e0.f.l(true);
                        o.D(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                        o.z("type", "2");
                        d.a.h0.a.s0.k.f.b.d("2");
                        boolean b3 = d.a.h0.a.t1.k.g0.a.c().b(d1);
                        d.a.h0.a.t1.k.p0.a.e("backtohome", b3 ? "message" : "relaunch", d1);
                        if (d.a.h0.a.t1.k.p0.a.h(d1) && !b3) {
                            d.a.h0.a.t1.k.p0.a.p("reLaunch");
                        }
                    }
                } else if (d.a.h0.a.a2.d.a()) {
                    d.a.h0.a.t1.k.p0.a.e("backtohome", "relaunch", d.a.h0.a.z0.f.V().h());
                } else {
                    d.a.h0.a.f1.f.e().i(false);
                    o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    o.z("type", "3");
                    d.a.h0.a.s0.k.f.b.d("3");
                    d.a.h0.a.z1.e.p(M);
                    d.a.h0.a.z1.e.m(M);
                }
                if (N().hasResumed()) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    o.A(ubcFlowEvent);
                    d.a.h0.a.y1.a.d().i("na_page_show");
                }
                d.a.h0.a.y1.a.d().i("frame_new_intent");
                d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
                p.R().j();
                p.i().a();
                if (d.a.h0.a.e0.s.a.f42290g) {
                    if (v) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData D = p.D();
                    if (v) {
                        d.a.h0.a.e0.s.a.e().k();
                    }
                    d.a.h0.a.e0.s.a.e().i(D);
                } else if (v) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                d.a.h0.a.z1.h.y();
            } else {
                o.D(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            c1();
            a1(true);
        }
    }
}
