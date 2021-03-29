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
/* loaded from: classes2.dex */
public class e extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f46477d = d.b.g0.a.w0.a.N().D();

    /* renamed from: c  reason: collision with root package name */
    public Context f46478c;

    /* loaded from: classes2.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46479a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46480b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z0.f f46481c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46482d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46485g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46486h;
        public final /* synthetic */ String i;
        public final /* synthetic */ b.c j;
        public final /* synthetic */ Context k;

        public a(String str, d.b.g0.a.r1.e eVar, d.b.g0.a.z0.f fVar, d.b.g0.a.e0.l.f fVar2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.b.g0.a.e1.b bVar, String str3, b.c cVar, Context context) {
            this.f46479a = str;
            this.f46480b = eVar;
            this.f46481c = fVar;
            this.f46482d = fVar2;
            this.f46483e = unitedSchemeEntity;
            this.f46484f = callbackHandler;
            this.f46485g = str2;
            this.f46486h = bVar;
            this.i = str3;
            this.j = cVar;
            this.k = context;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.j1.j.d(this.f46479a);
            d.b.g0.a.c0.c.g("navigateTo", "check pages success");
            d.b.g0.a.z1.h.z(true, this.f46480b.L().S());
            this.f46481c.C();
            d.b.g0.a.t1.k.p0.a.k(this.f46483e, this.f46484f, this.f46480b, this.f46485g, this.f46486h.f44362a, d.b.g0.a.t1.k.p0.a.f(this.f46482d), this.i);
            e.this.p(this.j, this.f46486h, this.f46482d, this.f46479a);
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.g0.a.c0.c.b("navigateTo", "check pages failed");
            d.b.g0.a.z1.h.z(false, this.f46480b.L().S());
            this.f46481c.C();
            if (a0.f46288b) {
                Context context = this.k;
                d.b.g0.a.q1.b.f.d.f(context, this.k.getString(d.b.g0.a.h.aiapps_open_pages_failed) + i).C();
            }
            d.b.g0.a.t1.k.p0.a.i(this.f46483e, this.f46484f, this.i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46487a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46488b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46489c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46490d;

        public b(b.c cVar, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46487a = cVar;
            this.f46488b = str;
            this.f46489c = bVar;
            this.f46490d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (a0.f46288b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.b.g0.a.j1.j.e(this.f46487a, this.f46488b);
            e.this.o(this.f46487a.f44304a, this.f46489c, this.f46490d, this.f46488b);
            if (a0.f46288b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f46288b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f46477d);
        }
    }

    public e(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/navigateTo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        String str;
        if (a0.f46288b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f46478c = context;
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
            d.b.g0.a.c0.c.b("navigateTo", "page params error : path=" + c2.f44362a + " ; routePath=" + c2.f44365d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String m = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(m) && c2 != null && !TextUtils.isEmpty(c2.f44365d) && d.b.g0.a.r1.e.y() != null) {
            d.b.g0.a.r1.e.y().r0(m, c2.f44365d);
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
        if (a0.f46288b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        b.c d2 = d.b.g0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f44304a.c();
        if (a0.f46288b) {
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
        if (fVar.k() < f46477d) {
            f.b i = fVar.i("navigateTo");
            i.n(d.b.g0.a.e0.l.f.f44013g, d.b.g0.a.e0.l.f.i);
            i.k("normal", bVar2).b();
            d.b.g0.a.i2.f.c(fVar, this.f46478c);
            d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            d.b.g0.a.j1.j.c(0, str);
            d.b.g0.a.j1.j.a(str);
            return;
        }
        d.b.g0.a.t.c.i.c.s(fVar, bVar2, str, true);
    }

    public final void p(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44305b;
        HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f46288b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new b(cVar, str, bVar, fVar));
        if (a0.f46288b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
