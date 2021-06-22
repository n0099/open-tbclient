package d.a.m0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.c2.f.p0.g;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.h0.t.a;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f44946d = d.a.m0.a.c1.a.Z().s();

    /* renamed from: c  reason: collision with root package name */
    public Context f44947c;

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f44949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.g1.f f44950c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.g f44951d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44953f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44954g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f44955h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44956i;
        public final /* synthetic */ a.d j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.m0.a.a2.e eVar, d.a.m0.a.g1.f fVar, d.a.m0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.a.m0.a.l1.b bVar, String str3, a.d dVar, Context context) {
            this.f44948a = str;
            this.f44949b = eVar;
            this.f44950c = fVar;
            this.f44951d = gVar;
            this.f44952e = unitedSchemeEntity;
            this.f44953f = callbackHandler;
            this.f44954g = str2;
            this.f44955h = bVar;
            this.f44956i = str3;
            this.j = dVar;
            this.k = context;
        }

        @Override // d.a.m0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.m0.a.r1.i.d(this.f44948a);
            d.a.m0.a.e0.d.g("navigateTo", "check pages success");
            d.a.m0.a.j2.k.B(true, this.f44949b.N().T());
            this.f44950c.o();
            d.a.m0.a.c2.f.p0.a.l(this.f44952e, this.f44953f, this.f44949b, this.f44954g, this.f44955h.f47141e, d.a.m0.a.c2.f.p0.a.g(this.f44951d), this.f44956i);
            e.this.p(this.j, this.f44955h, this.f44951d, this.f44948a);
        }

        @Override // d.a.m0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.m0.a.e0.d.b("navigateTo", "check pages failed");
            d.a.m0.a.j2.k.B(false, this.f44949b.N().T());
            this.f44950c.o();
            if (a0.f44733b) {
                Context context = this.k;
                d.a.m0.a.z1.b.f.e.g(context, this.k.getString(d.a.m0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            d.a.m0.a.c2.f.p0.a.j(this.f44952e, this.f44953f, this.f44956i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f44957a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44958b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f44959c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.g f44960d;

        public b(a.d dVar, String str, d.a.m0.a.l1.b bVar, d.a.m0.a.h0.g.g gVar) {
            this.f44957a = dVar;
            this.f44958b = str;
            this.f44959c = bVar;
            this.f44960d = gVar;
        }

        @Override // d.a.m0.a.h0.t.a.e
        public void onReady() {
            if (a0.f44733b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.a.m0.a.r1.i.e(this.f44957a, this.f44958b);
            e.this.o(this.f44957a.f46364a, this.f44959c, this.f44960d, this.f44958b);
            if (a0.f44733b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f44733b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f44946d);
        }
    }

    public e(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateTo");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.g1.f fVar;
        if (a0.f44733b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f44947c = context;
        String uuid = UUID.randomUUID().toString();
        d.a.m0.a.r1.i.b(uuid);
        String o = d.a.m0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.m0.a.e0.d.b("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.m0.a.g1.f V = d.a.m0.a.g1.f.V();
        d.a.m0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.m0.a.e0.d.b("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(o, V.A());
        d.a.m0.a.j2.h.f(e2.f47141e, "0");
        if (!q0.b(V.s(), e2, false)) {
            d.a.m0.a.e0.d.b("navigateTo", "page params error : path=" + e2.f47141e + " ; routePath=" + e2.f47144h);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.m0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(n) && e2 != null && !TextUtils.isEmpty(e2.f47144h) && d.a.m0.a.a2.e.i() != null) {
            d.a.m0.a.a2.e.i().x0(n, e2.f47144h);
        }
        String n2 = d.a.m0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(n2)) {
            fVar = V;
        } else {
            HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = V;
            ubcFlowEvent.h(Long.valueOf(n2).longValue());
            q.C(ubcFlowEvent);
        }
        if (a0.f44733b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        a.d f2 = d.a.m0.a.h0.t.a.f(fVar.getActivity());
        String b2 = f2.f46364a.b();
        if (a0.f44733b) {
            Log.d("NavigateToAction", "slave webView id: " + b2);
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.m0.a.c2.f.g0.d.b().a(e2)) {
            d.a.m0.a.c2.f.g0.d.b().i("navigateTo", e2);
            d.a.m0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            fVar.u();
            g.g(eVar, e2, b2, new a(uuid, eVar, fVar, W, unitedSchemeEntity, callbackHandler, b2, e2, optString, f2, context), uuid);
            return true;
        }
    }

    public final void o(d.a.m0.a.p.e.b bVar, d.a.m0.a.l1.b bVar2, d.a.m0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.a.m0.a.c2.f.p0.a.e(bVar, bVar2, str);
        d.a.m0.a.r1.i.c(0, str);
        if (gVar.k() < f44946d) {
            d.a.m0.a.h0.g.f.G3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.m0.a.h0.g.g.f45860g, d.a.m0.a.h0.g.g.f45862i);
            i2.k("normal", bVar2).b();
            d.a.m0.a.v2.g.c(gVar, this.f44947c);
            d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.m0.a.r1.i.a(str, bVar2);
            return;
        }
        d.a.m0.a.u.e.k.c.u(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, d.a.m0.a.l1.b bVar, d.a.m0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f46365b;
        HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (a0.f44733b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.m0.a.h0.t.a.n(dVar, new b(dVar, str, bVar, gVar));
        if (a0.f44733b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
