package d.a.h0.a.t1.k.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.c0.f.a;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.u0.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44589a = d.a.h0.a.k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44590b;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.c0.f.a f44591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.o.a f44592f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.p.d.b f44593g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f44594h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.g f44595i;

        public a(d.a.h0.a.c0.f.a aVar, d.a.h0.a.e0.o.a aVar2, d.a.h0.a.p.d.b bVar, d.a.h0.a.y0.e.b bVar2, d.g gVar) {
            this.f44591e = aVar;
            this.f44592f = aVar2;
            this.f44593g = bVar;
            this.f44594h = bVar2;
            this.f44595i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f44591e.i();
            d.a.h0.a.c0.f.a.g(0);
            c.b(this.f44592f, this.f44593g, this.f44594h, this.f44595i);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.o.a f44596a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.p.d.b f44597b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f44598c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f44599d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.q1.b.b.g f44600e;

        public b(d.a.h0.a.e0.o.a aVar, d.a.h0.a.p.d.b bVar, d.a.h0.a.y0.e.b bVar2, d.g gVar, d.a.h0.a.q1.b.b.g gVar2) {
            this.f44596a = aVar;
            this.f44597b = bVar;
            this.f44598c = bVar2;
            this.f44599d = gVar;
            this.f44600e = gVar2;
        }

        @Override // d.a.h0.a.c0.f.a.b
        public void onConnected() {
            c.b(this.f44596a, this.f44597b, this.f44598c, this.f44599d);
            this.f44600e.dismiss();
        }
    }

    public static void b(d.a.h0.a.e0.o.a aVar, d.a.h0.a.p.d.b bVar, d.a.h0.a.y0.e.b bVar2, d.g gVar) {
        HybridUbcFlow n = d.a.h0.a.j1.i.n();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
        ubcFlowEvent.a(true);
        n.A(ubcFlowEvent);
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        SwanAppConfigData swanAppConfigData = gVar.f44733b;
        if (swanAppConfigData == null) {
            if (f44589a) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String d2 = d(V, bVar2, swanAppConfigData);
        String g2 = gVar.f44733b.g(d2);
        SwanAppActivity activity = V.getActivity();
        if (activity != null && !activity.isFinishing()) {
            d.a.h0.a.e0.r.b.c().b(aVar, bVar, bVar2, gVar.f44733b, gVar);
            aVar.e(activity);
            bVar.e(activity);
            d.a.h0.a.e0.l.f W = V.W();
            if (W == null) {
                return;
            }
            d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(d2, V.A());
            d.a.h0.a.e0.v.b.i(k0.c(c2.f42394c, c2.f42392a, c2.f42393b), bVar);
            e(W, d2);
            d.a.h0.a.z1.h.y();
            d.a.h0.a.f1.e.e(bVar.c());
            if (!TextUtils.isEmpty(g2)) {
                d.a.h0.a.j1.i.k(g2);
            }
            d.a.h0.a.z1.h.z(true, bVar2.S());
            d.a.h0.a.j2.d loadingView = activity.getLoadingView();
            if (f44589a) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
            }
            if (loadingView != null) {
                loadingView.B(1);
            }
            d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
            if (e2.z() && TextUtils.equals(e2.getAppId(), bVar2.G())) {
                e2.p().e(true);
            }
            d.a.h0.a.e0.f.l(false);
        } else if (f44589a) {
            Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
        }
    }

    public static String c() {
        return f44590b;
    }

    public static String d(d.a.h0.a.z0.f fVar, d.a.h0.a.y0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        String c2 = fVar.c();
        if (TextUtils.isEmpty(c2)) {
            if (bVar.k0()) {
                c2 = swanAppConfigData.f(bVar.e0());
            } else {
                c2 = fVar.h();
            }
        }
        f44590b = c2;
        return c2;
    }

    public static void e(d.a.h0.a.e0.l.f fVar, String str) {
        if (fVar == null) {
            return;
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        f.b i2 = fVar.i("init");
        int i3 = d.a.h0.a.e0.l.f.f42033i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", d.a.h0.a.e1.b.c(str, V.A()), true).a();
    }

    public static void f(d.a.h0.a.e0.o.a aVar, d.a.h0.a.p.d.b bVar, d.a.h0.a.y0.e.b bVar2, d.g gVar) {
        if (!d.a.h0.a.m1.a.a.C() && d.a.h0.a.c0.f.a.e() != 2) {
            b(aVar, bVar, bVar2, gVar);
            return;
        }
        d.a.h0.a.c0.c.g("FirstPageAction", "in adb/wireless debug mode");
        WebView.setWebContentsDebuggingEnabled(true);
        d.a.h0.a.c0.f.a aVar2 = new d.a.h0.a.c0.f.a(d.a.h0.a.w0.a.c());
        g.a aVar3 = new g.a(d.a.h0.a.r1.d.e().v());
        aVar3.U(d.a.h0.a.h.aiapps_debug_start_inspect);
        aVar3.w(d.a.h0.a.h.aiapps_debug_inspect_waiting);
        aVar3.n(new d.a.h0.a.j2.g.a());
        aVar3.m(false);
        aVar3.O(d.a.h0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
        d.a.h0.a.q1.b.b.g X = aVar3.X();
        HybridUbcFlow n = d.a.h0.a.j1.i.n();
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
        ubcFlowEvent.a(true);
        n.A(ubcFlowEvent);
        aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
        aVar2.h();
    }
}
