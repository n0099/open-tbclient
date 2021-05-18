package d.a.i0.a.c2.f.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.a1.e;
import d.a.i0.a.e0.h.a;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.v2.q0;
import d.a.i0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40976a = d.a.i0.a.k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40977b;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.e0.h.a f40978e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.l.a f40979f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f40980g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f40981h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e.g f40982i;

        public a(d.a.i0.a.e0.h.a aVar, d.a.i0.a.h0.l.a aVar2, d.a.i0.a.p.e.b bVar, d.a.i0.a.f1.e.b bVar2, e.g gVar) {
            this.f40978e = aVar;
            this.f40979f = aVar2;
            this.f40980g = bVar;
            this.f40981h = bVar2;
            this.f40982i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f40978e.i();
            d.a.i0.a.e0.h.a.g(0);
            c.a(this.f40979f, this.f40980g, this.f40981h, this.f40982i);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.l.a f40983a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f40984b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f40985c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f40986d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z1.b.b.h f40987e;

        public b(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b bVar, d.a.i0.a.f1.e.b bVar2, e.g gVar, d.a.i0.a.z1.b.b.h hVar) {
            this.f40983a = aVar;
            this.f40984b = bVar;
            this.f40985c = bVar2;
            this.f40986d = gVar;
            this.f40987e = hVar;
        }

        @Override // d.a.i0.a.e0.h.a.b
        public void onConnected() {
            c.a(this.f40983a, this.f40984b, this.f40985c, this.f40986d);
            this.f40987e.dismiss();
        }
    }

    public static void a(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b bVar, d.a.i0.a.f1.e.b bVar2, e.g gVar) {
        HybridUbcFlow o = d.a.i0.a.r1.h.o();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
        ubcFlowEvent.a(true);
        o.C(ubcFlowEvent);
        d.a.i0.a.g1.f V = d.a.i0.a.g1.f.V();
        SwanAppConfigData swanAppConfigData = gVar.f40518b;
        if (swanAppConfigData == null) {
            if (f40976a) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String c2 = c(V, bVar2, swanAppConfigData);
        String g2 = gVar.f40518b.g(c2);
        SwanAppActivity activity = V.getActivity();
        if (activity != null && !activity.isFinishing()) {
            d.a.i0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f40518b, gVar, false);
            aVar.e(activity);
            bVar.e(activity);
            d.a.i0.a.h0.g.g W = V.W();
            if (W == null) {
                return;
            }
            d.a.i0.a.l1.b e2 = d.a.i0.a.l1.b.e(c2, V.A());
            d.a.i0.a.h0.t.a.m(q0.a(e2.f43185g, e2.f43183e, e2.f43184f), bVar);
            d(W, c2);
            d.a.i0.a.j2.k.A();
            d.a.i0.a.m1.f.e(bVar.b());
            if (!TextUtils.isEmpty(g2)) {
                d.a.i0.a.r1.h.l(g2);
            }
            d.a.i0.a.j2.k.B(true, bVar2.T());
            d.a.i0.a.w2.e loadingView = activity.getLoadingView();
            if (f40976a) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
            }
            if (loadingView != null) {
                loadingView.H(1);
            }
            d.a.i0.a.a2.d g3 = d.a.i0.a.a2.d.g();
            if (g3.C() && TextUtils.equals(g3.getAppId(), bVar2.H())) {
                g3.r().f(true);
            }
            d.a.i0.a.h0.i.i.h(true);
        } else if (f40976a) {
            Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
        }
    }

    public static String b() {
        return f40977b;
    }

    public static String c(d.a.i0.a.g1.f fVar, d.a.i0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        String a2 = fVar.a();
        if (TextUtils.isEmpty(a2)) {
            if (bVar.n0()) {
                a2 = swanAppConfigData.f(bVar.h0());
            } else {
                a2 = fVar.f();
            }
        }
        f40977b = a2;
        return a2;
    }

    public static void d(d.a.i0.a.h0.g.g gVar, String str) {
        if (gVar == null) {
            return;
        }
        d.a.i0.a.h0.g.f.G3(null);
        d.a.i0.a.g1.f V = d.a.i0.a.g1.f.V();
        g.b i2 = gVar.i("init");
        int i3 = d.a.i0.a.h0.g.g.f41904i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", d.a.i0.a.l1.b.e(str, V.A()), true).a();
    }

    public static void e(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b bVar, d.a.i0.a.f1.e.b bVar2, e.g gVar) {
        if (!d.a.i0.a.u1.a.a.G() && d.a.i0.a.e0.h.a.e() != 2) {
            if (d.a.i0.a.u1.a.a.C()) {
                d.a.i0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                return;
            } else {
                a(aVar, bVar, bVar2, gVar);
                return;
            }
        }
        d.a.i0.a.e0.d.g("FirstPageAction", "in adb/wireless debug mode");
        WebView.setWebContentsDebuggingEnabled(true);
        d.a.i0.a.e0.h.a aVar2 = new d.a.i0.a.e0.h.a(d.a.i0.a.c1.a.b());
        h.a aVar3 = new h.a(d.a.i0.a.a2.d.g().x());
        aVar3.U(d.a.i0.a.h.aiapps_debug_start_inspect);
        aVar3.v(d.a.i0.a.h.aiapps_debug_inspect_waiting);
        aVar3.n(new d.a.i0.a.w2.h.a());
        aVar3.m(false);
        aVar3.O(d.a.i0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
        d.a.i0.a.z1.b.b.h X = aVar3.X();
        HybridUbcFlow o = d.a.i0.a.r1.h.o();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
        ubcFlowEvent.a(true);
        o.C(ubcFlowEvent);
        aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
        aVar2.h();
    }
}
