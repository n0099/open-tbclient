package d.b.g0.a.o0.f;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.alipay.sdk.widget.j;
import com.baidu.android.imsdk.internal.Constants;
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
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.p.h;
import d.b.g0.a.i2.p;
import d.b.g0.a.i2.p0;
import d.b.g0.a.i2.v;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.e.a;
import d.b.g0.a.q0.c;
import d.b.g0.a.t1.k.p0.g;
import d.b.g0.a.u0.d;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z0.f;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.o0.c {
    public static final boolean v = k.f45050a;

    /* renamed from: d.b.g0.a.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0749a implements Runnable {
        public RunnableC0749a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.u1.b.d();
            f.V().q(a.this.f45410f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.g1.o.a.h().y();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.e0.n.b<Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.e0.n.b
        /* renamed from: b */
        public void a(Boolean bool) {
            if (a.this.f45410f == null || !bool.booleanValue()) {
                return;
            }
            a.this.f45410f.onBackPressed();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.b {
        public d() {
        }

        @Override // d.b.g0.a.q0.c.b
        public void a() {
            if (a.this.f45410f != null) {
                a.this.f45410f.moveTaskToBack(true);
                p0.b().e(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.c {
        public e() {
        }

        @Override // d.b.g0.a.n1.c.e.a.c
        public boolean a(Message message) {
            int i = message.what;
            if (i == 100) {
                d.b.g0.a.n1.c.a.e().h(new d.b.g0.a.n1.c.c(4));
                a.this.D0();
                d.b.g0.a.r1.d.e().v();
                return true;
            } else if (i == 127) {
                d.b.g0.a.c1.c.a.a(Integer.valueOf(d.b.g0.a.c1.c.b.c()));
                return true;
            } else if (i == 129) {
                int p = d.b.g0.a.i2.b.m().p();
                d.b.g0.a.c0.c.g("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                if (a.this.f45410f != null && a.this.f45410f.isBackground() && p != -1 && a.this.f45410f.getTaskId() != p) {
                    d.b.g0.a.c0.c.g("SwanAppFrame", "resetCore: purgeSwanApp");
                    d.b.g0.a.r1.d.e().v();
                }
                return true;
            } else if (i == 102) {
                boolean a2 = d.b.g0.a.w0.a.z().a();
                d.b.g0.a.w0.a.z().d(a2);
                if (a.this.f45410f != null) {
                    a.this.f45410f.onNightModeCoverChanged(a2, false);
                }
                return true;
            } else if (i == 103) {
                d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
                if (y != null) {
                    y.R().i();
                    d.b.g0.a.g1.o.a.h().w();
                }
                a.this.D0();
                return true;
            } else if (i == 106) {
                d.b.g0.a.r1.d.e().v();
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

    @Override // d.b.g0.a.o0.c
    @NonNull
    public a.c O() {
        return new e();
    }

    public final boolean V0(d.b.g0.a.y0.e.b bVar) {
        if (bVar != null && !d.b.g0.a.m1.a.a.y(bVar)) {
            if (bVar.F() != 0) {
                if (v) {
                    Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                }
                return false;
            }
            SwanAppConfigData D = d.b.g0.a.r1.d.e().s().D();
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

    @Override // d.b.g0.a.o0.c
    public void X() {
        d.b.g0.a.c0.c.g("SwanApp", "onBackPressed back stack count:" + this.f45411g.k());
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47253d = j.j;
        D(fVar);
        d.b.g0.a.e0.l.c m = this.f45411g.m();
        if (m == null || !m.v()) {
            if (R()) {
                d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
                if (y != null) {
                    y.C().D();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.b.g0.a.r1.e.T());
                f.V().N(new d.b.g0.a.k0.b.c(hashMap));
                d.b.g0.a.c0.c.g("SwanAppFrame", j.f2032c);
                d.b.g0.a.z0.g.a().d(false);
                return;
            }
            d.b.g0.a.i2.f.a(P(), this.f45410f);
            f.b i = this.f45411g.i("navigateBack");
            i.n(d.b.g0.a.e0.l.f.i, d.b.g0.a.e0.l.f.f44013h);
            i.g();
            i.a();
        }
    }

    public final String X0() {
        return d.b.g0.a.y0.e.b.e1(M(), d.b.g0.a.z0.f.V().I());
    }

    @Override // d.b.g0.a.o0.c
    public void Y() {
        this.f45410f.setRequestedOrientation(1);
        d.b.g0.a.i2.e.a(this.f45410f);
        if (d.b.g0.a.e0.e.d()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        d.b.g0.a.y1.a.d().a();
        d.b.g0.a.y1.a.d().i("frame_create");
        d.b.g0.a.f1.f.e().i(true);
        d.b.g0.a.f1.f.e().k();
        e1();
        Y0();
        V8Engine.setCrashKeyValue("app_title", M().J());
    }

    public final void Y0() {
        d.b.g0.a.z1.e.w();
        if (x()) {
            b1();
            b.a M = M();
            if (V0(M)) {
                if (v) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                d.b.g0.a.z0.f.V().g(M, null);
                return;
            }
            if (v) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            d.b.g0.a.z0.f.V().u(M, null);
        }
    }

    public final boolean Z0() {
        d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
        if (e2.x()) {
            b.a L = e2.s().L();
            String S = L.S();
            String T = L.T();
            if (TextUtils.isEmpty(L.S()) || TextUtils.equals(S, T)) {
                return false;
            }
            d.b.g0.a.r1.g H = s().H();
            if (H.b(L.S())) {
                return !H.c(S, Boolean.FALSE).booleanValue();
            }
            return true;
        }
        return false;
    }

    @Override // d.b.g0.a.o0.c
    public void a0() {
        d.b.g0.a.u1.b.f();
        d.b.g0.a.f1.f.e().l();
        d.b.g0.a.w0.a.J().a();
        d.b.g0.a.z0.f.V().w(this.f45410f);
    }

    public final void a1(boolean z) {
        d.b.g0.a.z1.l.b.e(M());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.f12654e = SearchFlowEvent.EventType.END;
            d.b.g0.a.z1.l.b.a(searchFlowEvent);
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
        SwanCoreVersion T = d.b.g0.a.e0.w.d.L().T();
        long h2 = d.b.g0.a.b2.b.h(M.X());
        if (h2 != 0 && T != null && h2 > T.swanCoreVersion) {
            d.b.g0.a.e0.w.d.t0(true);
            return;
        }
        SwanCoreVersion f0 = M.f0();
        ExtensionCore K = d.b.g0.a.e0.w.d.L().K();
        ExtensionCore N = M.N();
        boolean z = false;
        boolean z2 = T != null && f0 != null && T.swanCoreVersion < f0.swanCoreVersion && d.b.g0.a.y0.e.a.a(M.R());
        if (K != null && N != null && K.extensionCoreVersionCode < N.extensionCoreVersionCode && d.b.g0.a.y0.e.a.b(M.R())) {
            z = true;
        }
        if (z2 || z) {
            if (v) {
                Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
            }
            d.b.g0.a.e0.w.d.t0(true);
        }
    }

    @Override // d.b.g0.a.o0.c
    public void c0() {
    }

    public final void c1() {
        if (Z0()) {
            p.j(new b(this), "saveUpdateList");
        }
    }

    @Override // d.b.g0.a.o0.c
    public boolean d0(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (d.b.g0.a.q0.a.b().c()) {
                d.b.g0.a.q0.a.b().f(this.f45410f, new c());
                return true;
            }
            d.b.g0.a.e0.l.f fVar = this.f45411g;
            if (fVar != null && fVar.k() == 1) {
                d.b.g0.a.q0.b bVar = new d.b.g0.a.q0.b();
                bVar.i();
                if (bVar.j()) {
                    d.b.g0.a.q0.c.c().j(this.f45410f, bVar.g(), bVar.f(), W0());
                    return true;
                }
            }
        }
        return super.d0(i, keyEvent);
    }

    public final String d1(String str) {
        b.a M = M();
        return (TextUtils.isEmpty(str) && M != null && U(M.G())) ? d.b.g0.a.z0.f.V().l() : str;
    }

    @Override // d.b.g0.a.o0.c
    public void e0() {
        super.e0();
        if (d.b.g0.a.e0.w.d.L().N() != null) {
            d.b.g0.a.e0.w.d.L().N().d(this.f45410f);
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
            M.Q0(d.b.g0.a.b2.b.e(0));
            if (v) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + M.f0());
            }
        }
    }

    @Override // d.b.g0.a.o0.c
    public void g0() {
    }

    @Override // d.b.g0.a.r1.m, d.b.g0.a.r1.h
    public int h() {
        return 0;
    }

    @Override // d.b.g0.a.o0.c
    public void i0() {
        ExecutorUtilsExt.postOnElastic(new RunnableC0749a(), "registerScreenshotEvent", 2);
    }

    @Override // d.b.g0.a.o0.c
    public void j0() {
    }

    @Override // d.b.g0.a.o0.c
    public void l0() {
        i.n().A(new UbcFlowEvent("frame_start_end"));
        d.b.g0.a.y1.a.d().i("frame_start_end");
    }

    @Override // d.b.g0.a.o0.c
    public void n0() {
    }

    @Override // d.b.g0.a.o0.c
    public void p0() {
    }

    @Override // d.b.g0.a.o0.c
    public void s0(boolean z, boolean z2) {
        d.b.g0.a.c0.c.g("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String X0 = X0();
        JSONObject b2 = v.b(M().m("_naExtParams"));
        if (v) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + X0);
        }
        String d1 = d1(X0);
        if (z) {
            d.b.g0.a.z1.e.t();
            d.b.g0.a.f1.f.e().i(z2);
            HybridUbcFlow o = i.o("startup");
            b.a M = M();
            if (z2) {
                if (v) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + d1);
                }
                d.b.g0.a.z1.g.c(2);
                if (!TextUtils.isEmpty(d1)) {
                    if (b2.optString("_naScene", "").equals("message")) {
                        d.b.g0.a.t1.k.p0.a.e("backtohome", "message", d1);
                    } else {
                        d.b.g0.a.z1.e.r(d1, M);
                        d.b.g0.a.e0.f.l(true);
                        o.D(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                        o.z("type", "2");
                        d.b.g0.a.s0.k.f.b.d("2");
                        boolean b3 = d.b.g0.a.t1.k.g0.a.c().b(d1);
                        d.b.g0.a.t1.k.p0.a.e("backtohome", b3 ? "message" : "relaunch", d1);
                        if (d.b.g0.a.t1.k.p0.a.h(d1) && !b3) {
                            d.b.g0.a.t1.k.p0.a.p("reLaunch");
                        }
                    }
                } else if (d.b.g0.a.a2.d.a()) {
                    d.b.g0.a.t1.k.p0.a.e("backtohome", "relaunch", d.b.g0.a.z0.f.V().l());
                } else {
                    d.b.g0.a.f1.f.e().i(false);
                    o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    o.z("type", "3");
                    d.b.g0.a.s0.k.f.b.d("3");
                    d.b.g0.a.z1.e.p(M);
                    d.b.g0.a.z1.e.m(M);
                }
                if (N().hasResumed()) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    o.A(ubcFlowEvent);
                    d.b.g0.a.y1.a.d().i("na_page_show");
                }
                d.b.g0.a.y1.a.d().i("frame_new_intent");
                d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
                s.R().j();
                s.z().a();
                if (d.b.g0.a.e0.s.a.f44263g) {
                    if (v) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData D = s.D();
                    if (v) {
                        d.b.g0.a.e0.s.a.e().k();
                    }
                    d.b.g0.a.e0.s.a.e().i(D);
                } else if (v) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                d.b.g0.a.z1.h.y();
            } else {
                o.D(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            c1();
            a1(true);
        }
    }
}
