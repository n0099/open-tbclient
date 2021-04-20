package d.b.g0.a.t1.k.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.c0.f.a;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.u0.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46858a = d.b.g0.a.k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static String f46859b;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.c0.f.a f46860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.o.a f46861f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.p.d.b f46862g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f46863h;
        public final /* synthetic */ d.g i;

        public a(d.b.g0.a.c0.f.a aVar, d.b.g0.a.e0.o.a aVar2, d.b.g0.a.p.d.b bVar, d.b.g0.a.y0.e.b bVar2, d.g gVar) {
            this.f46860e = aVar;
            this.f46861f = aVar2;
            this.f46862g = bVar;
            this.f46863h = bVar2;
            this.i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f46860e.i();
            d.b.g0.a.c0.f.a.g(0);
            c.b(this.f46861f, this.f46862g, this.f46863h, this.i);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.o.a f46864a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.p.d.b f46865b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f46866c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f46867d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.q1.b.b.g f46868e;

        public b(d.b.g0.a.e0.o.a aVar, d.b.g0.a.p.d.b bVar, d.b.g0.a.y0.e.b bVar2, d.g gVar, d.b.g0.a.q1.b.b.g gVar2) {
            this.f46864a = aVar;
            this.f46865b = bVar;
            this.f46866c = bVar2;
            this.f46867d = gVar;
            this.f46868e = gVar2;
        }

        @Override // d.b.g0.a.c0.f.a.b
        public void onConnected() {
            c.b(this.f46864a, this.f46865b, this.f46866c, this.f46867d);
            this.f46868e.dismiss();
        }
    }

    public static void b(d.b.g0.a.e0.o.a aVar, d.b.g0.a.p.d.b bVar, d.b.g0.a.y0.e.b bVar2, d.g gVar) {
        HybridUbcFlow n = d.b.g0.a.j1.i.n();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
        ubcFlowEvent.a(true);
        n.A(ubcFlowEvent);
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        SwanAppConfigData swanAppConfigData = gVar.f46993b;
        if (swanAppConfigData == null) {
            if (f46858a) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String d2 = d(V, bVar2, swanAppConfigData);
        String g2 = gVar.f46993b.g(d2);
        SwanAppActivity activity = V.getActivity();
        if (activity != null && !activity.isFinishing()) {
            d.b.g0.a.e0.r.b.c().b(aVar, bVar, bVar2, gVar.f46993b, gVar);
            aVar.d(activity);
            bVar.d(activity);
            d.b.g0.a.e0.l.f W = V.W();
            if (W == null) {
                return;
            }
            d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(d2, V.h());
            d.b.g0.a.e0.v.b.i(k0.c(c2.f44756c, c2.f44754a, c2.f44755b), bVar);
            e(W, d2);
            d.b.g0.a.z1.h.y();
            d.b.g0.a.f1.e.e(bVar.c());
            if (!TextUtils.isEmpty(g2)) {
                d.b.g0.a.j1.i.k(g2);
            }
            d.b.g0.a.z1.h.z(true, bVar2.S());
            d.b.g0.a.j2.d loadingView = activity.getLoadingView();
            if (f46858a) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
            }
            if (loadingView != null) {
                loadingView.B(1);
            }
            d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
            if (e2.x() && TextUtils.equals(e2.getAppId(), bVar2.G())) {
                e2.s().e(true);
            }
            d.b.g0.a.e0.f.l(false);
        } else if (f46858a) {
            Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
        }
    }

    public static String c() {
        return f46859b;
    }

    public static String d(d.b.g0.a.z0.f fVar, d.b.g0.a.y0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        String d2 = fVar.d();
        if (TextUtils.isEmpty(d2)) {
            if (bVar.k0()) {
                d2 = swanAppConfigData.f(bVar.e0());
            } else {
                d2 = fVar.l();
            }
        }
        f46859b = d2;
        return d2;
    }

    public static void e(d.b.g0.a.e0.l.f fVar, String str) {
        if (fVar == null) {
            return;
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        f.b i = fVar.i("init");
        int i2 = d.b.g0.a.e0.l.f.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", d.b.g0.a.e1.b.c(str, V.h()), true).a();
    }

    public static void f(d.b.g0.a.e0.o.a aVar, d.b.g0.a.p.d.b bVar, d.b.g0.a.y0.e.b bVar2, d.g gVar) {
        if (!d.b.g0.a.m1.a.a.C() && d.b.g0.a.c0.f.a.e() != 2) {
            b(aVar, bVar, bVar2, gVar);
            return;
        }
        d.b.g0.a.c0.c.g("FirstPageAction", "in adb/wireless debug mode");
        WebView.setWebContentsDebuggingEnabled(true);
        d.b.g0.a.c0.f.a aVar2 = new d.b.g0.a.c0.f.a(d.b.g0.a.w0.a.c());
        g.a aVar3 = new g.a(d.b.g0.a.r1.d.e().n());
        aVar3.U(d.b.g0.a.h.aiapps_debug_start_inspect);
        aVar3.w(d.b.g0.a.h.aiapps_debug_inspect_waiting);
        aVar3.n(new d.b.g0.a.j2.g.a());
        aVar3.m(false);
        aVar3.O(d.b.g0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
        d.b.g0.a.q1.b.b.g X = aVar3.X();
        HybridUbcFlow n = d.b.g0.a.j1.i.n();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
        ubcFlowEvent.a(true);
        n.A(ubcFlowEvent);
        aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
        aVar2.h();
    }
}
