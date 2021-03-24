package d.b.g0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.v.b;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.v;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46506a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z0.f f46507b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46508c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46509d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46511f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46512g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46513h;
        public final /* synthetic */ b.c i;
        public final /* synthetic */ d.b.g0.a.e0.l.f j;
        public final /* synthetic */ Context k;

        public a(String str, d.b.g0.a.z0.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, String str2, d.b.g0.a.e1.b bVar, String str3, b.c cVar, d.b.g0.a.e0.l.f fVar2, Context context) {
            this.f46506a = str;
            this.f46507b = fVar;
            this.f46508c = unitedSchemeEntity;
            this.f46509d = callbackHandler;
            this.f46510e = eVar;
            this.f46511f = str2;
            this.f46512g = bVar;
            this.f46513h = str3;
            this.i = cVar;
            this.j = fVar2;
            this.k = context;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.j1.j.d(this.f46506a);
            d.b.g0.a.c0.c.g("relaunch", "check pages success");
            this.f46507b.C();
            d.b.g0.a.t1.k.p0.a.k(this.f46508c, this.f46509d, this.f46510e, this.f46511f, this.f46512g.f44361a, null, this.f46513h);
            h.this.p(this.i, this.f46512g, this.j, this.f46506a);
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.g0.a.c0.c.b("relaunch", "check pages failed");
            this.f46507b.C();
            if (a0.f46287b) {
                Context context = this.k;
                d.b.g0.a.q1.b.f.d.f(context, this.k.getString(d.b.g0.a.h.aiapps_open_pages_failed) + i).C();
            }
            d.b.g0.a.t1.k.p0.a.i(this.f46508c, this.f46509d, this.f46513h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46515b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46516c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46517d;

        public b(h hVar, b.c cVar, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46514a = cVar;
            this.f46515b = str;
            this.f46516c = bVar;
            this.f46517d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (a0.f46287b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
            }
            d.b.g0.a.j1.j.e(this.f46514a, this.f46515b);
            d.b.g0.a.t1.k.p0.a.d(this.f46514a.f44303a, this.f46516c, this.f46515b);
            h.o(this.f46517d, this.f46516c, this.f46515b);
            if (a0.f46287b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public h(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/reLaunch");
    }

    public static void o(d.b.g0.a.e0.l.f fVar, d.b.g0.a.e1.b bVar, String str) {
        d.b.g0.a.t.c.i.d.s(fVar, bVar, str);
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.e0.l.f fVar;
        if (a0.f46287b) {
            Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.b.g0.a.j1.j.b(uuid);
        String n = d.b.g0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.g0.a.c0.c.b("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(n, V.h());
        if (!k0.d(V.I(), c2, true)) {
            d.b.g0.a.c0.c.b("relaunch", "page params error : path=" + c2.f44361a + " ; routePath=" + c2.f44364d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String m = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(m) && c2 != null && !TextUtils.isEmpty(c2.f44364d) && d.b.g0.a.r1.e.y() != null) {
            d.b.g0.a.r1.e.y().r0(m, c2.f44364d);
        }
        String m2 = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m2)) {
            fVar = W;
        } else {
            HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = W;
            ubcFlowEvent.h(Long.valueOf(m2).longValue());
            p.A(ubcFlowEvent);
        }
        b.c e2 = d.b.g0.a.e0.v.b.e(V.getActivity(), d.b.g0.a.e0.v.a.a());
        String c3 = e2.f44303a.c();
        if (a0.f46287b) {
            Log.d("ReLaunchAction", "webview idx: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.b.g0.a.t1.k.g0.a.c().a(c2)) {
            d.b.g0.a.t1.k.g0.a.c().h("reLaunch", c2);
            d.b.g0.a.c0.c.b("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.M();
            g.a(eVar, c2, c3, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, c3, c2, optString, e2, fVar, context), uuid);
            return true;
        }
    }

    public final void p(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44304b;
        HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f46287b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (a0.f46287b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
        }
    }
}
