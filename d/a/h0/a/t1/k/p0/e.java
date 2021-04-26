package d.a.h0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.v.b;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.v;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f44601d = d.a.h0.a.w0.a.N().r();

    /* renamed from: c  reason: collision with root package name */
    public Context f44602c;

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44603a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44604b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z0.f f44605c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44606d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44608f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44609g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44610h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44611i;
        public final /* synthetic */ b.c j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.h0.a.r1.e eVar, d.a.h0.a.z0.f fVar, d.a.h0.a.e0.l.f fVar2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.a.h0.a.e1.b bVar, String str3, b.c cVar, Context context) {
            this.f44603a = str;
            this.f44604b = eVar;
            this.f44605c = fVar;
            this.f44606d = fVar2;
            this.f44607e = unitedSchemeEntity;
            this.f44608f = callbackHandler;
            this.f44609g = str2;
            this.f44610h = bVar;
            this.f44611i = str3;
            this.j = cVar;
            this.k = context;
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.a.h0.a.j1.j.d(this.f44603a);
            d.a.h0.a.c0.c.g("navigateTo", "check pages success");
            d.a.h0.a.z1.h.z(true, this.f44604b.L().S());
            this.f44605c.q();
            d.a.h0.a.t1.k.p0.a.k(this.f44607e, this.f44608f, this.f44604b, this.f44609g, this.f44610h.f42392a, d.a.h0.a.t1.k.p0.a.f(this.f44606d), this.f44611i);
            e.this.p(this.j, this.f44610h, this.f44606d, this.f44603a);
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void b(int i2) {
            d.a.h0.a.c0.c.b("navigateTo", "check pages failed");
            d.a.h0.a.z1.h.z(false, this.f44604b.L().S());
            this.f44605c.q();
            if (a0.f44398b) {
                Context context = this.k;
                d.a.h0.a.q1.b.f.d.f(context, this.k.getString(d.a.h0.a.h.aiapps_open_pages_failed) + i2).C();
            }
            d.a.h0.a.t1.k.p0.a.i(this.f44607e, this.f44608f, this.f44611i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f44612a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44613b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44614c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44615d;

        public b(b.c cVar, String str, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar) {
            this.f44612a = cVar;
            this.f44613b = str;
            this.f44614c = bVar;
            this.f44615d = fVar;
        }

        @Override // d.a.h0.a.e0.v.b.d
        public void onReady() {
            if (a0.f44398b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.a.h0.a.j1.j.e(this.f44612a, this.f44613b);
            e.this.o(this.f44612a.f42331a, this.f44614c, this.f44615d, this.f44613b);
            if (a0.f44398b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f44398b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f44601d);
        }
    }

    public e(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/navigateTo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        String str;
        if (a0.f44398b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f44602c = context;
        String uuid = UUID.randomUUID().toString();
        d.a.h0.a.j1.j.b(uuid);
        String n = d.a.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.a.h0.a.c0.c.b("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        d.a.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.a.h0.a.c0.c.b("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(n, V.A());
        if (!k0.d(V.u(), c2, false)) {
            d.a.h0.a.c0.c.b("navigateTo", "page params error : path=" + c2.f42392a + " ; routePath=" + c2.f42395d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String m = d.a.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(m) && c2 != null && !TextUtils.isEmpty(c2.f42395d) && d.a.h0.a.r1.e.h() != null) {
            d.a.h0.a.r1.e.h().r0(m, c2.f42395d);
        }
        String m2 = d.a.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m2)) {
            str = "navigateTo";
        } else {
            HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            str = "navigateTo";
            ubcFlowEvent.h(Long.valueOf(m2).longValue());
            p.A(ubcFlowEvent);
        }
        if (a0.f44398b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        b.c d2 = d.a.h0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f42331a.c();
        if (a0.f44398b) {
            Log.d("NavigateToAction", "slave webView id: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b(str, "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String str2 = str;
        if (d.a.h0.a.t1.k.g0.a.c().a(c2)) {
            d.a.h0.a.t1.k.g0.a.c().h(str2, c2);
            d.a.h0.a.c0.c.b("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        V.w();
        g.a(eVar, c2, c3, new a(uuid, eVar, V, W, unitedSchemeEntity, callbackHandler, c3, c2, optString, d2, context), uuid);
        return true;
    }

    public final void o(d.a.h0.a.p.d.b bVar, d.a.h0.a.e1.b bVar2, d.a.h0.a.e0.l.f fVar, String str) {
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.a.h0.a.t1.k.p0.a.d(bVar, bVar2, str);
        if (fVar.k() < f44601d) {
            f.b i2 = fVar.i("navigateTo");
            i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
            i2.k("normal", bVar2).b();
            d.a.h0.a.i2.f.c(fVar, this.f44602c);
            d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            d.a.h0.a.j1.j.c(0, str);
            d.a.h0.a.j1.j.a(str);
            return;
        }
        d.a.h0.a.t.c.i.c.s(fVar, bVar2, str, true);
    }

    public final void p(b.c cVar, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f42332b;
        HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f44398b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.h0.a.e0.v.b.j(cVar, new b(cVar, str, bVar, fVar));
        if (a0.f44398b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
