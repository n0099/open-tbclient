package d.a.i0.a.t0.f;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.alipay.sdk.widget.j;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.i0.a.a1.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.g1.g;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.h0.i.i;
import d.a.i0.a.h0.m.h;
import d.a.i0.a.k;
import d.a.i0.a.v0.c;
import d.a.i0.a.v1.c.e.a;
import d.a.i0.a.v2.l0;
import d.a.i0.a.v2.w;
import d.a.i0.a.v2.x0;
import java.util.HashMap;
import org.json.JSONObject;
@Autowired
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.t0.c {
    public static final boolean v = k.f43025a;

    /* renamed from: d.a.i0.a.t0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0812a implements Runnable {
        public RunnableC0812a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.i0.a.v2.f.d(a.this.f44541f)) {
                d.a.i0.a.d2.d.g();
                d.a.i0.a.g1.f.V().E(a.this.f44541f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.n1.q.a.g().y();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.i0.a.h0.j.b<Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            if (a.this.f44541f == null || !bool.booleanValue()) {
                return;
            }
            a.this.f44541f.onBackPressed();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.b {
        public d() {
        }

        @Override // d.a.i0.a.v0.c.b
        public void a() {
            if (a.this.f44541f != null) {
                a.this.f44541f.moveTaskToBack(true);
                x0.b().e(1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a.c {
        public e() {
        }

        @Override // d.a.i0.a.v1.c.e.a.c
        public boolean a(Message message) {
            int i2 = message.what;
            if (i2 == 100) {
                d.a.i0.a.v1.c.a.e().h(new d.a.i0.a.v1.c.c(4));
                a.this.G0();
                a.this.c1();
                d.a.i0.a.a2.d.g().t();
                return true;
            } else if (i2 == 127) {
                int c2 = d.a.i0.a.j1.e.b.c();
                int a2 = d.a.i0.a.j1.e.b.a(c2);
                if (!d.a.i0.a.j1.e.b.e()) {
                    d.a.i0.a.j1.e.a.a(Integer.valueOf(c2), String.valueOf(a2));
                }
                return true;
            } else if (i2 == 129) {
                int p = d.a.i0.a.v2.c.m().p();
                d.a.i0.a.e0.d.g("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                if (a.this.f44541f != null && a.this.f44541f.isBackground() && p != -1 && a.this.f44541f.getTaskId() != p) {
                    d.a.i0.a.e0.d.g("SwanAppFrame", "resetCore: purgeSwanApp");
                    d.a.i0.a.a2.d.g().t();
                }
                return true;
            } else if (i2 == 102) {
                boolean a3 = d.a.i0.a.c1.a.H().a();
                d.a.i0.a.c1.a.H().d(a3);
                if (a.this.f44541f != null) {
                    a.this.f44541f.onNightModeCoverChanged(a3, false);
                }
                return true;
            } else if (i2 == 103) {
                d.a.i0.a.a2.e i3 = d.a.i0.a.a2.e.i();
                if (i3 != null) {
                    i3.T().i();
                    d.a.i0.a.n1.q.a.g().v();
                }
                a.this.G0();
                a.this.b1();
                return true;
            } else if (i2 == 106) {
                d.a.i0.a.a2.d.g().t();
                return true;
            } else if (i2 != 107) {
                switch (i2) {
                    case 123:
                        d.a.i0.a.v2.c.r(message);
                        return true;
                    case 124:
                        d.a.i0.a.v2.c.q(message);
                        return true;
                    case 125:
                        d.a.i0.a.v1.c.d.a.b(message);
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

    /* loaded from: classes2.dex */
    public static class f {
        public void a() {
        }

        public void b() {
            d.a.i0.a.l2.b.u(false);
        }
    }

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // d.a.i0.a.t0.c
    @NonNull
    public a.c Q() {
        return new e();
    }

    @Override // d.a.i0.a.t0.c
    public void Z() {
        a0(1);
    }

    @Override // d.a.i0.a.t0.c
    public void a0(int i2) {
        d.a.i0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f44542g.k());
        e1(i2);
        d.a.i0.a.h0.g.d m = this.f44542g.m();
        if (m == null || !m.K()) {
            if (T()) {
                d.a.i0.a.a2.e i3 = d.a.i0.a.a2.e.i();
                if (i3 != null) {
                    i3.E().E();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.i0.a.a2.e.V());
                d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.c(hashMap));
                d.a.i0.a.e0.d.g("SwanAppFrame", j.f2016c);
                g.a().d(false);
                return;
            }
            d.a.i0.a.v2.g.a(R(), this.f44541f);
            g.b i4 = this.f44542g.i("navigateBack");
            i4.n(d.a.i0.a.h0.g.g.f41904i, d.a.i0.a.h0.g.g.f41903h);
            i4.g();
            i4.a();
        }
    }

    @Override // d.a.i0.a.t0.c
    public void b0() {
        this.f44541f.setRequestedOrientation(1);
        d.a.i0.a.v2.f.a(this.f44541f);
        if (d.a.i0.a.h0.a.d()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        d.a.i0.a.i2.a.d().a();
        d.a.i0.a.i2.a.d().i("frame_create");
        d.a.i0.a.m1.g.f().n(true);
        d.a.i0.a.m1.g.f().p();
        n1();
        i1();
        V8Engine.setCrashKeyValue("app_title", O().K());
    }

    public final void b1() {
        f h1 = h1();
        if (h1 != null) {
            h1.a();
        }
    }

    public final void c1() {
        f h1 = h1();
        if (h1 != null) {
            h1.b();
        }
    }

    @Override // d.a.i0.a.t0.c
    public void d0() {
        d.a.i0.a.d2.d.j();
        d.a.i0.a.d2.d.h();
        d.a.i0.a.m1.g.f().q();
        d.a.i0.a.c1.a.U().a();
        d.a.i0.a.g1.f.V().k(this.f44541f);
        d.a.i0.a.n2.h.b.n();
    }

    public final boolean d1(d.a.i0.a.f1.e.b bVar) {
        if (bVar != null && !d.a.i0.a.u1.a.a.A(bVar)) {
            if (bVar.G() != 0) {
                if (v) {
                    Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                }
                return false;
            }
            SwanAppConfigData F = d.a.i0.a.a2.d.g().r().F();
            if (F == null) {
                if (v) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                }
                return false;
            } else if (!e.C0550e.i(bVar.H(), bVar.u1()).exists()) {
                if (v) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                }
                return false;
            } else {
                return !d.a.i0.a.c2.f.p0.g.p(bVar, F);
            }
        }
        if (v) {
            Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
        }
        return false;
    }

    public final void e1(int i2) {
        String str = i2 != 2 ? i2 != 3 ? "virtual" : "gesture" : PrefetchEvent.STATE_CLICK;
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43015e = j.j;
        d.a.i0.a.h0.g.g gVar = this.f44542g;
        boolean z = true;
        eVar.f43017g = (gVar == null || gVar.k() <= 1) ? false : false ? "1" : "0";
        eVar.f43012b = str;
        d.a.i0.a.j2.d.a(eVar, O());
        d.a.i0.a.j2.d.c(eVar);
    }

    @Override // d.a.i0.a.t0.c
    public void f0() {
    }

    public final c.b f1() {
        return new d();
    }

    @Override // d.a.i0.a.t0.c
    public boolean g0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (d.a.i0.a.v0.a.b().c()) {
                d.a.i0.a.v0.a.b().f(this.f44541f, new c());
                return true;
            }
            d.a.i0.a.h0.g.g gVar = this.f44542g;
            if (gVar != null && gVar.k() == 1) {
                d.a.i0.a.v0.b bVar = new d.a.i0.a.v0.b();
                bVar.h();
                if (bVar.k()) {
                    d.a.i0.a.v0.c.c().j(this.f44541f, bVar.f(), bVar.e(), bVar, f1());
                    return true;
                }
                d.a.i0.a.m1.g.f().i();
            }
        }
        return super.g0(i2, keyEvent);
    }

    public final String g1() {
        return d.a.i0.a.f1.e.b.k1(O(), d.a.i0.a.g1.f.V().s());
    }

    @Override // d.a.i0.a.t0.c
    public void h0() {
        super.h0();
        if (d.a.i0.a.h0.u.g.N().P() != null) {
            d.a.i0.a.h0.u.g.N().P().e(this.f44541f);
        }
    }

    @Inject(force = false)
    public final f h1() {
        return new f();
    }

    public final void i1() {
        d.a.i0.a.j2.e.z();
        if (C()) {
            k1();
            b.a O = O();
            if (d1(O)) {
                if (v) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                d.a.i0.a.g1.f.V().c(O, null);
                return;
            }
            if (v) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            d.a.i0.a.g1.f.V().G(O, null);
        }
    }

    @Override // d.a.i0.a.t0.c
    public void j0() {
    }

    public final boolean j1() {
        d.a.i0.a.a2.d g2 = d.a.i0.a.a2.d.g();
        if (g2.C()) {
            b.a N = g2.r().N();
            String T = N.T();
            String U = N.U();
            if (TextUtils.isEmpty(N.T()) || TextUtils.equals(T, U)) {
                return false;
            }
            d.a.i0.a.a2.g J = r().J();
            if (J.b(N.T())) {
                return !J.c(T, Boolean.FALSE).booleanValue();
            }
            return true;
        }
        return false;
    }

    public final void k1() {
        b.a O = O();
        if (v) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (O == null) {
            if (v) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
            }
        } else if (l0.f(O.a0())) {
            d.a.i0.a.h0.u.g.A0(true);
        } else {
            SwanCoreVersion i0 = O.i0();
            ExtensionCore M = d.a.i0.a.h0.u.g.N().M();
            ExtensionCore O2 = O.O();
            boolean z = false;
            boolean z2 = i0 != null && l0.f(i0.swanCoreVersionName) && d.a.i0.a.f1.e.a.a(O.S());
            if (M != null && O2 != null && M.extensionCoreVersionCode < O2.extensionCoreVersionCode && d.a.i0.a.f1.e.a.b(O.S())) {
                z = true;
            }
            if (z2 || z) {
                if (v) {
                    Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                }
                d.a.i0.a.h0.u.g.A0(true);
            }
        }
    }

    @Override // d.a.i0.a.a2.m, d.a.i0.a.a2.h
    public int l() {
        return 0;
    }

    @Override // d.a.i0.a.t0.c
    public void l0() {
        ExecutorUtilsExt.postOnElastic(new RunnableC0812a(), "registerScreenshotEvent", 2);
    }

    public final void l1() {
        if (j1()) {
            d.a.i0.a.r1.k.i.b.e().f(new b(this), "tryUpdateAsync");
        }
    }

    @Override // d.a.i0.a.t0.c
    public void m0() {
    }

    public final String m1(String str) {
        b.a O = O();
        return (TextUtils.isEmpty(str) && O != null && W(O.H())) ? d.a.i0.a.g1.f.V().f() : str;
    }

    public final void n1() {
        b.a O = O();
        if (v) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + O.i0());
        }
        if (O.i0() == null || !O.i0().a()) {
            if (v) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            O.X0(d.a.i0.a.m2.b.g(0));
            if (v) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + O.i0());
            }
        }
    }

    @Override // d.a.i0.a.t0.c
    public void o0() {
        d.a.i0.a.r1.h.o().C(new UbcFlowEvent("frame_start_end"));
        d.a.i0.a.i2.a.d().i("frame_start_end");
    }

    @Override // d.a.i0.a.t0.c
    public void q0() {
    }

    @Override // d.a.i0.a.t0.c
    public void s0() {
    }

    @Override // d.a.i0.a.t0.c
    public void u0(int i2) {
        super.u0(i2);
        d.a.i0.a.n2.h.b.m(i2);
    }

    @Override // d.a.i0.a.t0.c
    public void v0(boolean z, boolean z2) {
        d.a.i0.a.e0.d.g("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String g1 = g1();
        JSONObject d2 = w.d(O().n("_naExtParams"));
        if (v) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + g1);
        }
        String m1 = m1(g1);
        if (z) {
            d.a.i0.a.j2.e.w();
            d.a.i0.a.m1.g.f().n(z2);
            HybridUbcFlow p = d.a.i0.a.r1.h.p("startup");
            b.a O = O();
            if (z2) {
                if (v) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + m1);
                }
                d.a.i0.a.h0.q.b.g().p(O.H(), true);
                d.a.i0.a.j2.j.c(2);
                d.a.i0.a.n2.h.b.o();
                if (!TextUtils.isEmpty(m1)) {
                    if (d2.optString("_naScene", "").equals("message")) {
                        d.a.i0.a.c2.f.p0.a.f("backtohome", "message", m1);
                    } else {
                        boolean i2 = d.a.i0.a.c2.f.p0.a.i(m1);
                        d.a.i0.a.j2.e.u(m1, O);
                        i.h(i2);
                        p.F(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                        p.B("type", "2");
                        boolean a2 = d.a.i0.a.c2.f.g0.d.b().a(d.a.i0.a.l1.b.e(m1, d.a.i0.a.g1.f.V().A()));
                        d.a.i0.a.c2.f.p0.a.f("backtohome", a2 ? "message" : "relaunch", m1);
                        if (i2 && !a2) {
                            d.a.i0.a.c2.f.p0.a.q("reLaunch");
                            d.a.i0.a.u.f.a.d().i();
                            if (d.a.i0.a.h0.n.a.a.c()) {
                                d.a.i0.a.y0.k.f.b.d("0");
                            } else {
                                d.a.i0.a.y0.k.f.b.e("2");
                            }
                        } else if (d.a.i0.a.h0.n.a.a.c()) {
                            d.a.i0.a.y0.k.f.b.d("0");
                        } else {
                            d.a.i0.a.y0.k.f.b.e("3");
                        }
                    }
                } else if (d.a.i0.a.k2.d.a()) {
                    d.a.i0.a.c2.f.p0.a.f("backtohome", "relaunch", d.a.i0.a.g1.f.V().f());
                } else {
                    d.a.i0.a.m1.g.f().o();
                    d.a.i0.a.m1.g.f().n(false);
                    i.h(false);
                    p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    p.B("type", "3");
                    if (d.a.i0.a.h0.n.a.a.c()) {
                        d.a.i0.a.y0.k.f.b.d("0");
                    } else {
                        d.a.i0.a.y0.k.f.b.e("3");
                    }
                    d.a.i0.a.j2.e.s(O);
                    d.a.i0.a.j2.e.p(O);
                }
                if (P().hasResumed()) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    p.C(ubcFlowEvent);
                    d.a.i0.a.i2.a.d().i("na_page_show");
                }
                d.a.i0.a.i2.a.d().i("frame_new_intent");
                d.a.i0.a.a2.e r = d.a.i0.a.a2.d.g().r();
                r.T().j();
                r.j().a();
                if (v) {
                    Log.d("SwanAppFrame", "hot start: hit prelink");
                    Log.d("SwanPrelink", "hot start: hit prelink");
                }
                r.F();
                if (v) {
                    d.a.i0.a.h0.q.b.g().o();
                }
                d.a.i0.a.j2.k.A();
            } else {
                p.F(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            l1();
        }
    }
}
