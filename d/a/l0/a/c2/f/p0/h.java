package d.a.l0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.c2.f.p0.g;
import d.a.l0.a.h0.t.a;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.g1.f f41209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41210c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41211d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f41212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41213f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f41214g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41215h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f41216i;
        public final /* synthetic */ d.a.l0.a.h0.g.g j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.l0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, String str2, d.a.l0.a.l1.b bVar, String str3, a.d dVar, d.a.l0.a.h0.g.g gVar, Context context) {
            this.f41208a = str;
            this.f41209b = fVar;
            this.f41210c = unitedSchemeEntity;
            this.f41211d = callbackHandler;
            this.f41212e = eVar;
            this.f41213f = str2;
            this.f41214g = bVar;
            this.f41215h = str3;
            this.f41216i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.l0.a.r1.i.d(this.f41208a);
            d.a.l0.a.e0.d.g("relaunch", "check pages success");
            this.f41209b.o();
            d.a.l0.a.c2.f.p0.a.l(this.f41210c, this.f41211d, this.f41212e, this.f41213f, this.f41214g.f43357e, null, this.f41215h);
            h.this.p(this.f41216i, this.f41214g, this.j, this.f41208a);
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.l0.a.e0.d.b("relaunch", "check pages failed");
            this.f41209b.o();
            if (a0.f40949b) {
                Context context = this.k;
                d.a.l0.a.z1.b.f.e.g(context, this.k.getString(d.a.l0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            d.a.l0.a.c2.f.p0.a.j(this.f41210c, this.f41211d, this.f41215h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f41217a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41218b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f41219c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f41220d;

        public b(h hVar, a.d dVar, String str, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar) {
            this.f41217a = dVar;
            this.f41218b = str;
            this.f41219c = bVar;
            this.f41220d = gVar;
        }

        @Override // d.a.l0.a.h0.t.a.e
        public void onReady() {
            if (a0.f40949b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
            }
            d.a.l0.a.r1.i.e(this.f41217a, this.f41218b);
            d.a.l0.a.c2.f.p0.a.e(this.f41217a.f42580a, this.f41219c, this.f41218b);
            h.o(this.f41220d, this.f41219c, this.f41218b);
            if (a0.f40949b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public h(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/reLaunch");
    }

    public static void o(d.a.l0.a.h0.g.g gVar, d.a.l0.a.l1.b bVar, String str) {
        d.a.l0.a.u.e.k.d.t(gVar, bVar, str);
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.h0.g.g gVar;
        if (a0.f40949b) {
            Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.l0.a.r1.i.b(uuid);
        String o = d.a.l0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.l0.a.e0.d.b("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.l0.a.g1.f V = d.a.l0.a.g1.f.V();
        d.a.l0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.l0.a.e0.d.b("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.l0.a.l1.b e2 = d.a.l0.a.l1.b.e(o, V.A());
        d.a.l0.a.j2.h.f(e2.f43357e, "3");
        if (!q0.b(V.s(), e2, true)) {
            d.a.l0.a.e0.d.b("relaunch", "page params error : path=" + e2.f43357e + " ; routePath=" + e2.f43360h);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.l0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(n) && e2 != null && !TextUtils.isEmpty(e2.f43360h) && d.a.l0.a.a2.e.i() != null) {
            d.a.l0.a.a2.e.i().x0(n, e2.f43360h);
        }
        String n2 = d.a.l0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(n2)) {
            gVar = W;
        } else {
            HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            gVar = W;
            ubcFlowEvent.h(Long.valueOf(n2).longValue());
            q.C(ubcFlowEvent);
        }
        a.d g2 = d.a.l0.a.h0.t.a.g(V.getActivity(), true);
        String b2 = g2.f42580a.b();
        if (a0.f40949b) {
            Log.d("ReLaunchAction", "webview idx: " + b2);
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.l0.a.c2.f.g0.d.b().a(e2)) {
            d.a.l0.a.c2.f.g0.d.b().i("reLaunch", e2);
            d.a.l0.a.e0.d.b("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.u();
            g.g(eVar, e2, b2, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, b2, e2, optString, g2, gVar, context), uuid);
            return true;
        }
    }

    public final void p(a.d dVar, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f42581b;
        HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (a0.f40949b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.l0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
        if (a0.f40949b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
        }
    }
}
