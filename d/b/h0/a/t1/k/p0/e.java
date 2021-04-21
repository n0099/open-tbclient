package d.b.h0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.e0.v.b;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.v;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f47198d = d.b.h0.a.w0.a.N().D();

    /* renamed from: c  reason: collision with root package name */
    public Context f47199c;

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47200a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47201b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.z0.f f47202c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.f f47203d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47205f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47206g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f47207h;
        public final /* synthetic */ String i;
        public final /* synthetic */ b.c j;
        public final /* synthetic */ Context k;

        public a(String str, d.b.h0.a.r1.e eVar, d.b.h0.a.z0.f fVar, d.b.h0.a.e0.l.f fVar2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.b.h0.a.e1.b bVar, String str3, b.c cVar, Context context) {
            this.f47200a = str;
            this.f47201b = eVar;
            this.f47202c = fVar;
            this.f47203d = fVar2;
            this.f47204e = unitedSchemeEntity;
            this.f47205f = callbackHandler;
            this.f47206g = str2;
            this.f47207h = bVar;
            this.i = str3;
            this.j = cVar;
            this.k = context;
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.h0.a.j1.j.d(this.f47200a);
            d.b.h0.a.c0.c.g("navigateTo", "check pages success");
            d.b.h0.a.z1.h.z(true, this.f47201b.L().S());
            this.f47202c.C();
            d.b.h0.a.t1.k.p0.a.k(this.f47204e, this.f47205f, this.f47201b, this.f47206g, this.f47207h.f45083a, d.b.h0.a.t1.k.p0.a.f(this.f47203d), this.i);
            e.this.p(this.j, this.f47207h, this.f47203d, this.f47200a);
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.h0.a.c0.c.b("navigateTo", "check pages failed");
            d.b.h0.a.z1.h.z(false, this.f47201b.L().S());
            this.f47202c.C();
            if (a0.f47009b) {
                Context context = this.k;
                d.b.h0.a.q1.b.f.d.f(context, this.k.getString(d.b.h0.a.h.aiapps_open_pages_failed) + i).C();
            }
            d.b.h0.a.t1.k.p0.a.i(this.f47204e, this.f47205f, this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f47208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f47210c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.f f47211d;

        public b(b.c cVar, String str, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar) {
            this.f47208a = cVar;
            this.f47209b = str;
            this.f47210c = bVar;
            this.f47211d = fVar;
        }

        @Override // d.b.h0.a.e0.v.b.d
        public void onReady() {
            if (a0.f47009b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.b.h0.a.j1.j.e(this.f47208a, this.f47209b);
            e.this.o(this.f47208a.f45025a, this.f47210c, this.f47211d, this.f47209b);
            if (a0.f47009b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f47009b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f47198d);
        }
    }

    public e(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/navigateTo");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        String str;
        if (a0.f47009b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f47199c = context;
        String uuid = UUID.randomUUID().toString();
        d.b.h0.a.j1.j.b(uuid);
        String n = d.b.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.h0.a.c0.c.b("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.b.h0.a.z0.f V = d.b.h0.a.z0.f.V();
        d.b.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.h0.a.c0.c.b("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(n, V.h());
        if (!k0.d(V.I(), c2, false)) {
            d.b.h0.a.c0.c.b("navigateTo", "page params error : path=" + c2.f45083a + " ; routePath=" + c2.f45086d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String m = d.b.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(m) && c2 != null && !TextUtils.isEmpty(c2.f45086d) && d.b.h0.a.r1.e.y() != null) {
            d.b.h0.a.r1.e.y().r0(m, c2.f45086d);
        }
        String m2 = d.b.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m2)) {
            str = "navigateTo";
        } else {
            HybridUbcFlow p = d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            str = "navigateTo";
            ubcFlowEvent.h(Long.valueOf(m2).longValue());
            p.A(ubcFlowEvent);
        }
        if (a0.f47009b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        b.c d2 = d.b.h0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f45025a.c();
        if (a0.f47009b) {
            Log.d("NavigateToAction", "slave webView id: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b(str, "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String str2 = str;
        if (d.b.h0.a.t1.k.g0.a.c().a(c2)) {
            d.b.h0.a.t1.k.g0.a.c().h(str2, c2);
            d.b.h0.a.c0.c.b("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        V.M();
        g.a(eVar, c2, c3, new a(uuid, eVar, V, W, unitedSchemeEntity, callbackHandler, c3, c2, optString, d2, context), uuid);
        return true;
    }

    public final void o(d.b.h0.a.p.d.b bVar, d.b.h0.a.e1.b bVar2, d.b.h0.a.e0.l.f fVar, String str) {
        SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.b.h0.a.t1.k.p0.a.d(bVar, bVar2, str);
        if (fVar.k() < f47198d) {
            f.b i = fVar.i("navigateTo");
            i.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
            i.k("normal", bVar2).b();
            d.b.h0.a.i2.f.c(fVar, this.f47199c);
            d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            d.b.h0.a.j1.j.c(0, str);
            d.b.h0.a.j1.j.a(str);
            return;
        }
        d.b.h0.a.t.c.i.c.s(fVar, bVar2, str, true);
    }

    public final void p(b.c cVar, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f45026b;
        HybridUbcFlow p = d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f47009b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.h0.a.e0.v.b.j(cVar, new b(cVar, str, bVar, fVar));
        if (a0.f47009b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
