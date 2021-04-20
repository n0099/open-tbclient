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
    public static final int f46869d = d.b.g0.a.w0.a.N().D();

    /* renamed from: c  reason: collision with root package name */
    public Context f46870c;

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46872b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z0.f f46873c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46874d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46876f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46877g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46878h;
        public final /* synthetic */ String i;
        public final /* synthetic */ b.c j;
        public final /* synthetic */ Context k;

        public a(String str, d.b.g0.a.r1.e eVar, d.b.g0.a.z0.f fVar, d.b.g0.a.e0.l.f fVar2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.b.g0.a.e1.b bVar, String str3, b.c cVar, Context context) {
            this.f46871a = str;
            this.f46872b = eVar;
            this.f46873c = fVar;
            this.f46874d = fVar2;
            this.f46875e = unitedSchemeEntity;
            this.f46876f = callbackHandler;
            this.f46877g = str2;
            this.f46878h = bVar;
            this.i = str3;
            this.j = cVar;
            this.k = context;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.j1.j.d(this.f46871a);
            d.b.g0.a.c0.c.g("navigateTo", "check pages success");
            d.b.g0.a.z1.h.z(true, this.f46872b.L().S());
            this.f46873c.C();
            d.b.g0.a.t1.k.p0.a.k(this.f46875e, this.f46876f, this.f46872b, this.f46877g, this.f46878h.f44754a, d.b.g0.a.t1.k.p0.a.f(this.f46874d), this.i);
            e.this.p(this.j, this.f46878h, this.f46874d, this.f46871a);
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.g0.a.c0.c.b("navigateTo", "check pages failed");
            d.b.g0.a.z1.h.z(false, this.f46872b.L().S());
            this.f46873c.C();
            if (a0.f46680b) {
                Context context = this.k;
                d.b.g0.a.q1.b.f.d.f(context, this.k.getString(d.b.g0.a.h.aiapps_open_pages_failed) + i).C();
            }
            d.b.g0.a.t1.k.p0.a.i(this.f46875e, this.f46876f, this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46879a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46880b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46881c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46882d;

        public b(b.c cVar, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46879a = cVar;
            this.f46880b = str;
            this.f46881c = bVar;
            this.f46882d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (a0.f46680b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.b.g0.a.j1.j.e(this.f46879a, this.f46880b);
            e.this.o(this.f46879a.f44696a, this.f46881c, this.f46882d, this.f46880b);
            if (a0.f46680b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f46680b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f46869d);
        }
    }

    public e(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/navigateTo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        String str;
        if (a0.f46680b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f46870c = context;
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
            d.b.g0.a.c0.c.b("navigateTo", "page params error : path=" + c2.f44754a + " ; routePath=" + c2.f44757d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String m = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(m) && c2 != null && !TextUtils.isEmpty(c2.f44757d) && d.b.g0.a.r1.e.y() != null) {
            d.b.g0.a.r1.e.y().r0(m, c2.f44757d);
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
        if (a0.f46680b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        b.c d2 = d.b.g0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f44696a.c();
        if (a0.f46680b) {
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
        if (fVar.k() < f46869d) {
            f.b i = fVar.i("navigateTo");
            i.n(d.b.g0.a.e0.l.f.f44405g, d.b.g0.a.e0.l.f.i);
            i.k("normal", bVar2).b();
            d.b.g0.a.i2.f.c(fVar, this.f46870c);
            d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            d.b.g0.a.j1.j.c(0, str);
            d.b.g0.a.j1.j.a(str);
            return;
        }
        d.b.g0.a.t.c.i.c.s(fVar, bVar2, str, true);
    }

    public final void p(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44697b;
        HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f46680b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new b(cVar, str, bVar, fVar));
        if (a0.f46680b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
