package d.b.h0.a.t1.k.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.c0.f.a;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.i2.k0;
import d.b.h0.a.q1.b.b.g;
import d.b.h0.a.u0.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47187a = d.b.h0.a.k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static String f47188b;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.c0.f.a f47189e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.o.a f47190f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.p.d.b f47191g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f47192h;
        public final /* synthetic */ d.g i;

        public a(d.b.h0.a.c0.f.a aVar, d.b.h0.a.e0.o.a aVar2, d.b.h0.a.p.d.b bVar, d.b.h0.a.y0.e.b bVar2, d.g gVar) {
            this.f47189e = aVar;
            this.f47190f = aVar2;
            this.f47191g = bVar;
            this.f47192h = bVar2;
            this.i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f47189e.i();
            d.b.h0.a.c0.f.a.g(0);
            c.b(this.f47190f, this.f47191g, this.f47192h, this.i);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.o.a f47193a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.p.d.b f47194b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f47195c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f47196d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.q1.b.b.g f47197e;

        public b(d.b.h0.a.e0.o.a aVar, d.b.h0.a.p.d.b bVar, d.b.h0.a.y0.e.b bVar2, d.g gVar, d.b.h0.a.q1.b.b.g gVar2) {
            this.f47193a = aVar;
            this.f47194b = bVar;
            this.f47195c = bVar2;
            this.f47196d = gVar;
            this.f47197e = gVar2;
        }

        @Override // d.b.h0.a.c0.f.a.b
        public void onConnected() {
            c.b(this.f47193a, this.f47194b, this.f47195c, this.f47196d);
            this.f47197e.dismiss();
        }
    }

    public static void b(d.b.h0.a.e0.o.a aVar, d.b.h0.a.p.d.b bVar, d.b.h0.a.y0.e.b bVar2, d.g gVar) {
        HybridUbcFlow n = d.b.h0.a.j1.i.n();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
        ubcFlowEvent.a(true);
        n.A(ubcFlowEvent);
        d.b.h0.a.z0.f V = d.b.h0.a.z0.f.V();
        SwanAppConfigData swanAppConfigData = gVar.f47322b;
        if (swanAppConfigData == null) {
            if (f47187a) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String d2 = d(V, bVar2, swanAppConfigData);
        String g2 = gVar.f47322b.g(d2);
        SwanAppActivity activity = V.getActivity();
        if (activity != null && !activity.isFinishing()) {
            d.b.h0.a.e0.r.b.c().b(aVar, bVar, bVar2, gVar.f47322b, gVar);
            aVar.d(activity);
            bVar.d(activity);
            d.b.h0.a.e0.l.f W = V.W();
            if (W == null) {
                return;
            }
            d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(d2, V.h());
            d.b.h0.a.e0.v.b.i(k0.c(c2.f45085c, c2.f45083a, c2.f45084b), bVar);
            e(W, d2);
            d.b.h0.a.z1.h.y();
            d.b.h0.a.f1.e.e(bVar.c());
            if (!TextUtils.isEmpty(g2)) {
                d.b.h0.a.j1.i.k(g2);
            }
            d.b.h0.a.z1.h.z(true, bVar2.S());
            d.b.h0.a.j2.d loadingView = activity.getLoadingView();
            if (f47187a) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
            }
            if (loadingView != null) {
                loadingView.B(1);
            }
            d.b.h0.a.r1.d e2 = d.b.h0.a.r1.d.e();
            if (e2.x() && TextUtils.equals(e2.getAppId(), bVar2.G())) {
                e2.s().e(true);
            }
            d.b.h0.a.e0.f.l(false);
        } else if (f47187a) {
            Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
        }
    }

    public static String c() {
        return f47188b;
    }

    public static String d(d.b.h0.a.z0.f fVar, d.b.h0.a.y0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        String d2 = fVar.d();
        if (TextUtils.isEmpty(d2)) {
            if (bVar.k0()) {
                d2 = swanAppConfigData.f(bVar.e0());
            } else {
                d2 = fVar.l();
            }
        }
        f47188b = d2;
        return d2;
    }

    public static void e(d.b.h0.a.e0.l.f fVar, String str) {
        if (fVar == null) {
            return;
        }
        d.b.h0.a.z0.f V = d.b.h0.a.z0.f.V();
        f.b i = fVar.i("init");
        int i2 = d.b.h0.a.e0.l.f.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", d.b.h0.a.e1.b.c(str, V.h()), true).a();
    }

    public static void f(d.b.h0.a.e0.o.a aVar, d.b.h0.a.p.d.b bVar, d.b.h0.a.y0.e.b bVar2, d.g gVar) {
        if (!d.b.h0.a.m1.a.a.C() && d.b.h0.a.c0.f.a.e() != 2) {
            b(aVar, bVar, bVar2, gVar);
            return;
        }
        d.b.h0.a.c0.c.g("FirstPageAction", "in adb/wireless debug mode");
        WebView.setWebContentsDebuggingEnabled(true);
        d.b.h0.a.c0.f.a aVar2 = new d.b.h0.a.c0.f.a(d.b.h0.a.w0.a.c());
        g.a aVar3 = new g.a(d.b.h0.a.r1.d.e().n());
        aVar3.U(d.b.h0.a.h.aiapps_debug_start_inspect);
        aVar3.w(d.b.h0.a.h.aiapps_debug_inspect_waiting);
        aVar3.n(new d.b.h0.a.j2.g.a());
        aVar3.m(false);
        aVar3.O(d.b.h0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
        d.b.h0.a.q1.b.b.g X = aVar3.X();
        HybridUbcFlow n = d.b.h0.a.j1.i.n();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
        ubcFlowEvent.a(true);
        n.A(ubcFlowEvent);
        aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
        aVar2.h();
    }
}
