package d.a.i0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.c2.f.p0.g;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.h0.t.a;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f40988d = d.a.i0.a.c1.a.Z().s();

    /* renamed from: c  reason: collision with root package name */
    public Context f40989c;

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f40990a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f40991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.g1.f f40992c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.g f40993d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f40994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f40996g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.l1.b f40997h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f40998i;
        public final /* synthetic */ a.d j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.i0.a.a2.e eVar, d.a.i0.a.g1.f fVar, d.a.i0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.a.i0.a.l1.b bVar, String str3, a.d dVar, Context context) {
            this.f40990a = str;
            this.f40991b = eVar;
            this.f40992c = fVar;
            this.f40993d = gVar;
            this.f40994e = unitedSchemeEntity;
            this.f40995f = callbackHandler;
            this.f40996g = str2;
            this.f40997h = bVar;
            this.f40998i = str3;
            this.j = dVar;
            this.k = context;
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.i0.a.r1.i.d(this.f40990a);
            d.a.i0.a.e0.d.g("navigateTo", "check pages success");
            d.a.i0.a.j2.k.B(true, this.f40991b.N().T());
            this.f40992c.o();
            d.a.i0.a.c2.f.p0.a.l(this.f40994e, this.f40995f, this.f40991b, this.f40996g, this.f40997h.f43183e, d.a.i0.a.c2.f.p0.a.g(this.f40993d), this.f40998i);
            e.this.p(this.j, this.f40997h, this.f40993d, this.f40990a);
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.i0.a.e0.d.b("navigateTo", "check pages failed");
            d.a.i0.a.j2.k.B(false, this.f40991b.N().T());
            this.f40992c.o();
            if (a0.f40775b) {
                Context context = this.k;
                d.a.i0.a.z1.b.f.e.g(context, this.k.getString(d.a.i0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            d.a.i0.a.c2.f.p0.a.j(this.f40994e, this.f40995f, this.f40998i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f40999a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41000b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.l1.b f41001c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.g f41002d;

        public b(a.d dVar, String str, d.a.i0.a.l1.b bVar, d.a.i0.a.h0.g.g gVar) {
            this.f40999a = dVar;
            this.f41000b = str;
            this.f41001c = bVar;
            this.f41002d = gVar;
        }

        @Override // d.a.i0.a.h0.t.a.e
        public void onReady() {
            if (a0.f40775b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.a.i0.a.r1.i.e(this.f40999a, this.f41000b);
            e.this.o(this.f40999a.f42406a, this.f41001c, this.f41002d, this.f41000b);
            if (a0.f40775b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f40775b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f40988d);
        }
    }

    public e(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateTo");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.g1.f fVar;
        if (a0.f40775b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f40989c = context;
        String uuid = UUID.randomUUID().toString();
        d.a.i0.a.r1.i.b(uuid);
        String o = d.a.i0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.i0.a.e0.d.b("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.i0.a.g1.f V = d.a.i0.a.g1.f.V();
        d.a.i0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.i0.a.e0.d.b("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.i0.a.l1.b e2 = d.a.i0.a.l1.b.e(o, V.A());
        d.a.i0.a.j2.h.f(e2.f43183e, "0");
        if (!q0.b(V.s(), e2, false)) {
            d.a.i0.a.e0.d.b("navigateTo", "page params error : path=" + e2.f43183e + " ; routePath=" + e2.f43186h);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.i0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(n) && e2 != null && !TextUtils.isEmpty(e2.f43186h) && d.a.i0.a.a2.e.i() != null) {
            d.a.i0.a.a2.e.i().x0(n, e2.f43186h);
        }
        String n2 = d.a.i0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(n2)) {
            fVar = V;
        } else {
            HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = V;
            ubcFlowEvent.h(Long.valueOf(n2).longValue());
            q.C(ubcFlowEvent);
        }
        if (a0.f40775b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        a.d f2 = d.a.i0.a.h0.t.a.f(fVar.getActivity());
        String b2 = f2.f42406a.b();
        if (a0.f40775b) {
            Log.d("NavigateToAction", "slave webView id: " + b2);
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.b("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.i0.a.c2.f.g0.d.b().a(e2)) {
            d.a.i0.a.c2.f.g0.d.b().i("navigateTo", e2);
            d.a.i0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            fVar.u();
            g.g(eVar, e2, b2, new a(uuid, eVar, fVar, W, unitedSchemeEntity, callbackHandler, b2, e2, optString, f2, context), uuid);
            return true;
        }
    }

    public final void o(d.a.i0.a.p.e.b bVar, d.a.i0.a.l1.b bVar2, d.a.i0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity = d.a.i0.a.g1.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.a.i0.a.c2.f.p0.a.e(bVar, bVar2, str);
        d.a.i0.a.r1.i.c(0, str);
        if (gVar.k() < f40988d) {
            d.a.i0.a.h0.g.f.G3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.i0.a.h0.g.g.f41902g, d.a.i0.a.h0.g.g.f41904i);
            i2.k("normal", bVar2).b();
            d.a.i0.a.v2.g.c(gVar, this.f40989c);
            d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.i0.a.r1.i.a(str, bVar2);
            return;
        }
        d.a.i0.a.u.e.k.c.u(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, d.a.i0.a.l1.b bVar, d.a.i0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f42407b;
        HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (a0.f40775b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.i0.a.h0.t.a.n(dVar, new b(dVar, str, bVar, gVar));
        if (a0.f40775b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
