package d.b.g0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.v.b;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.v;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f46476d = d.b.g0.a.w0.a.N().D();

    /* renamed from: c  reason: collision with root package name */
    public Context f46477c;

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46479b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z0.f f46480c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46481d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46484g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46485h;
        public final /* synthetic */ String i;
        public final /* synthetic */ b.c j;
        public final /* synthetic */ Context k;

        public a(String str, d.b.g0.a.r1.e eVar, d.b.g0.a.z0.f fVar, d.b.g0.a.e0.l.f fVar2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.b.g0.a.e1.b bVar, String str3, b.c cVar, Context context) {
            this.f46478a = str;
            this.f46479b = eVar;
            this.f46480c = fVar;
            this.f46481d = fVar2;
            this.f46482e = unitedSchemeEntity;
            this.f46483f = callbackHandler;
            this.f46484g = str2;
            this.f46485h = bVar;
            this.i = str3;
            this.j = cVar;
            this.k = context;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.j1.j.d(this.f46478a);
            d.b.g0.a.c0.c.g("navigateTo", "check pages success");
            d.b.g0.a.z1.h.z(true, this.f46479b.L().S());
            this.f46480c.C();
            d.b.g0.a.t1.k.p0.a.k(this.f46482e, this.f46483f, this.f46479b, this.f46484g, this.f46485h.f44361a, d.b.g0.a.t1.k.p0.a.f(this.f46481d), this.i);
            e.this.p(this.j, this.f46485h, this.f46481d, this.f46478a);
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.g0.a.c0.c.b("navigateTo", "check pages failed");
            d.b.g0.a.z1.h.z(false, this.f46479b.L().S());
            this.f46480c.C();
            if (a0.f46287b) {
                Context context = this.k;
                d.b.g0.a.q1.b.f.d.f(context, this.k.getString(d.b.g0.a.h.aiapps_open_pages_failed) + i).C();
            }
            d.b.g0.a.t1.k.p0.a.i(this.f46482e, this.f46483f, this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46486a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46487b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46488c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46489d;

        public b(b.c cVar, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46486a = cVar;
            this.f46487b = str;
            this.f46488c = bVar;
            this.f46489d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (a0.f46287b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.b.g0.a.j1.j.e(this.f46486a, this.f46487b);
            e.this.o(this.f46486a.f44303a, this.f46488c, this.f46489d, this.f46487b);
            if (a0.f46287b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f46287b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f46476d);
        }
    }

    public e(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/navigateTo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        String str;
        if (a0.f46287b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f46477c = context;
        String uuid = UUID.randomUUID().toString();
        d.b.g0.a.j1.j.b(uuid);
        String n = d.b.g0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.g0.a.c0.c.b("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(n, V.h());
        if (!k0.d(V.I(), c2, false)) {
            d.b.g0.a.c0.c.b("navigateTo", "page params error : path=" + c2.f44361a + " ; routePath=" + c2.f44364d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String m = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(m) && c2 != null && !TextUtils.isEmpty(c2.f44364d) && d.b.g0.a.r1.e.y() != null) {
            d.b.g0.a.r1.e.y().r0(m, c2.f44364d);
        }
        String m2 = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m2)) {
            str = "navigateTo";
        } else {
            HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            str = "navigateTo";
            ubcFlowEvent.h(Long.valueOf(m2).longValue());
            p.A(ubcFlowEvent);
        }
        if (a0.f46287b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        b.c d2 = d.b.g0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f44303a.c();
        if (a0.f46287b) {
            Log.d("NavigateToAction", "slave webView id: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b(str, "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String str2 = str;
        if (d.b.g0.a.t1.k.g0.a.c().a(c2)) {
            d.b.g0.a.t1.k.g0.a.c().h(str2, c2);
            d.b.g0.a.c0.c.b("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        V.M();
        g.a(eVar, c2, c3, new a(uuid, eVar, V, W, unitedSchemeEntity, callbackHandler, c3, c2, optString, d2, context), uuid);
        return true;
    }

    public final void o(d.b.g0.a.p.d.b bVar, d.b.g0.a.e1.b bVar2, d.b.g0.a.e0.l.f fVar, String str) {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.b.g0.a.t1.k.p0.a.d(bVar, bVar2, str);
        if (fVar.k() < f46476d) {
            f.b i = fVar.i("navigateTo");
            i.n(d.b.g0.a.e0.l.f.f44012g, d.b.g0.a.e0.l.f.i);
            i.k("normal", bVar2).b();
            d.b.g0.a.i2.f.c(fVar, this.f46477c);
            d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            d.b.g0.a.j1.j.c(0, str);
            d.b.g0.a.j1.j.a(str);
            return;
        }
        d.b.g0.a.t.c.i.c.s(fVar, bVar2, str, true);
    }

    public final void p(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44304b;
        HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f46287b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new b(cVar, str, bVar, fVar));
        if (a0.f46287b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
