package d.a.i0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.c2.f.p0.g;
import d.a.i0.a.h0.t.a;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41034a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.g1.f f41035b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41036c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41037d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f41038e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41039f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.l1.b f41040g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41041h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f41042i;
        public final /* synthetic */ d.a.i0.a.h0.g.g j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.i0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, String str2, d.a.i0.a.l1.b bVar, String str3, a.d dVar, d.a.i0.a.h0.g.g gVar, Context context) {
            this.f41034a = str;
            this.f41035b = fVar;
            this.f41036c = unitedSchemeEntity;
            this.f41037d = callbackHandler;
            this.f41038e = eVar;
            this.f41039f = str2;
            this.f41040g = bVar;
            this.f41041h = str3;
            this.f41042i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.i0.a.r1.i.d(this.f41034a);
            d.a.i0.a.e0.d.g("relaunch", "check pages success");
            this.f41035b.o();
            d.a.i0.a.c2.f.p0.a.l(this.f41036c, this.f41037d, this.f41038e, this.f41039f, this.f41040g.f43183e, null, this.f41041h);
            h.this.p(this.f41042i, this.f41040g, this.j, this.f41034a);
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.i0.a.e0.d.b("relaunch", "check pages failed");
            this.f41035b.o();
            if (a0.f40775b) {
                Context context = this.k;
                d.a.i0.a.z1.b.f.e.g(context, this.k.getString(d.a.i0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            d.a.i0.a.c2.f.p0.a.j(this.f41036c, this.f41037d, this.f41041h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f41043a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41044b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.l1.b f41045c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.g f41046d;

        public b(h hVar, a.d dVar, String str, d.a.i0.a.l1.b bVar, d.a.i0.a.h0.g.g gVar) {
            this.f41043a = dVar;
            this.f41044b = str;
            this.f41045c = bVar;
            this.f41046d = gVar;
        }

        @Override // d.a.i0.a.h0.t.a.e
        public void onReady() {
            if (a0.f40775b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
            }
            d.a.i0.a.r1.i.e(this.f41043a, this.f41044b);
            d.a.i0.a.c2.f.p0.a.e(this.f41043a.f42406a, this.f41045c, this.f41044b);
            h.o(this.f41046d, this.f41045c, this.f41044b);
            if (a0.f40775b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public h(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/reLaunch");
    }

    public static void o(d.a.i0.a.h0.g.g gVar, d.a.i0.a.l1.b bVar, String str) {
        d.a.i0.a.u.e.k.d.t(gVar, bVar, str);
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.h0.g.g gVar;
        if (a0.f40775b) {
            Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.i0.a.r1.i.b(uuid);
        String o = d.a.i0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.i0.a.e0.d.b("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.i0.a.g1.f V = d.a.i0.a.g1.f.V();
        d.a.i0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.i0.a.e0.d.b("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.i0.a.l1.b e2 = d.a.i0.a.l1.b.e(o, V.A());
        d.a.i0.a.j2.h.f(e2.f43183e, "3");
        if (!q0.b(V.s(), e2, true)) {
            d.a.i0.a.e0.d.b("relaunch", "page params error : path=" + e2.f43183e + " ; routePath=" + e2.f43186h);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.i0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(n) && e2 != null && !TextUtils.isEmpty(e2.f43186h) && d.a.i0.a.a2.e.i() != null) {
            d.a.i0.a.a2.e.i().x0(n, e2.f43186h);
        }
        String n2 = d.a.i0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(n2)) {
            gVar = W;
        } else {
            HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            gVar = W;
            ubcFlowEvent.h(Long.valueOf(n2).longValue());
            q.C(ubcFlowEvent);
        }
        a.d g2 = d.a.i0.a.h0.t.a.g(V.getActivity(), true);
        String b2 = g2.f42406a.b();
        if (a0.f40775b) {
            Log.d("ReLaunchAction", "webview idx: " + b2);
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.b("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.i0.a.c2.f.g0.d.b().a(e2)) {
            d.a.i0.a.c2.f.g0.d.b().i("reLaunch", e2);
            d.a.i0.a.e0.d.b("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.u();
            g.g(eVar, e2, b2, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, b2, e2, optString, g2, gVar, context), uuid);
            return true;
        }
    }

    public final void p(a.d dVar, d.a.i0.a.l1.b bVar, d.a.i0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f42407b;
        HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (a0.f40775b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.i0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
        if (a0.f40775b) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
        }
    }
}
