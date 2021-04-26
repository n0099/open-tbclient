package d.a.h0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.e0.v.b;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.v;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z0.f f44633b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44634c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44635d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44636e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44637f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44638g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44639h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.c f44640i;
        public final /* synthetic */ d.a.h0.a.e0.l.f j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.h0.a.z0.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, String str2, d.a.h0.a.e1.b bVar, String str3, b.c cVar, d.a.h0.a.e0.l.f fVar2, Context context) {
            this.f44632a = str;
            this.f44633b = fVar;
            this.f44634c = unitedSchemeEntity;
            this.f44635d = callbackHandler;
            this.f44636e = eVar;
            this.f44637f = str2;
            this.f44638g = bVar;
            this.f44639h = str3;
            this.f44640i = cVar;
            this.j = fVar2;
            this.k = context;
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.a.h0.a.j1.j.d(this.f44632a);
            d.a.h0.a.c0.c.g("relaunch", "check pages success");
            this.f44633b.q();
            d.a.h0.a.t1.k.p0.a.k(this.f44634c, this.f44635d, this.f44636e, this.f44637f, this.f44638g.f42392a, null, this.f44639h);
            h.this.p(this.f44640i, this.f44638g, this.j, this.f44632a);
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void b(int i2) {
            d.a.h0.a.c0.c.b("relaunch", "check pages failed");
            this.f44633b.q();
            if (a0.f44398b) {
                Context context = this.k;
                d.a.h0.a.q1.b.f.d.f(context, this.k.getString(d.a.h0.a.h.aiapps_open_pages_failed) + i2).C();
            }
            d.a.h0.a.t1.k.p0.a.i(this.f44634c, this.f44635d, this.f44639h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f44641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44643c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44644d;

        public b(h hVar, b.c cVar, String str, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar) {
            this.f44641a = cVar;
            this.f44642b = str;
            this.f44643c = bVar;
            this.f44644d = fVar;
        }

        @Override // d.a.h0.a.e0.v.b.d
        public void onReady() {
            if (a0.f44398b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
            }
            d.a.h0.a.j1.j.e(this.f44641a, this.f44642b);
            d.a.h0.a.t1.k.p0.a.d(this.f44641a.f42331a, this.f44643c, this.f44642b);
            h.o(this.f44644d, this.f44643c, this.f44642b);
            if (a0.f44398b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public h(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/reLaunch");
    }

    public static void o(d.a.h0.a.e0.l.f fVar, d.a.h0.a.e1.b bVar, String str) {
        d.a.h0.a.t.c.i.d.s(fVar, bVar, str);
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.e0.l.f fVar;
        if (a0.f44398b) {
            Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.h0.a.j1.j.b(uuid);
        String n = d.a.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.a.h0.a.c0.c.b("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        d.a.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.a.h0.a.c0.c.b("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(n, V.A());
        if (!k0.d(V.u(), c2, true)) {
            d.a.h0.a.c0.c.b("relaunch", "page params error : path=" + c2.f42392a + " ; routePath=" + c2.f42395d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String m = d.a.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(m) && c2 != null && !TextUtils.isEmpty(c2.f42395d) && d.a.h0.a.r1.e.h() != null) {
            d.a.h0.a.r1.e.h().r0(m, c2.f42395d);
        }
        String m2 = d.a.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m2)) {
            fVar = W;
        } else {
            HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = W;
            ubcFlowEvent.h(Long.valueOf(m2).longValue());
            p.A(ubcFlowEvent);
        }
        b.c e2 = d.a.h0.a.e0.v.b.e(V.getActivity(), d.a.h0.a.e0.v.a.a());
        String c3 = e2.f42331a.c();
        if (a0.f44398b) {
            Log.d("ReLaunchAction", "webview idx: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.h0.a.t1.k.g0.a.c().a(c2)) {
            d.a.h0.a.t1.k.g0.a.c().h("reLaunch", c2);
            d.a.h0.a.c0.c.b("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.w();
            g.a(eVar, c2, c3, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, c3, c2, optString, e2, fVar, context), uuid);
            return true;
        }
    }

    public final void p(b.c cVar, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f42332b;
        HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f44398b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.h0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (a0.f44398b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
        }
    }
}
