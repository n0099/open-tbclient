package d.b.h0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.h0.a.e0.v.b;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.v;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47240a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.z0.f f47241b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47242c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47243d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47245f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f47246g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47247h;
        public final /* synthetic */ b.c i;
        public final /* synthetic */ d.b.h0.a.e0.l.f j;
        public final /* synthetic */ Context k;

        public a(String str, d.b.h0.a.z0.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, String str2, d.b.h0.a.e1.b bVar, String str3, b.c cVar, d.b.h0.a.e0.l.f fVar2, Context context) {
            this.f47240a = str;
            this.f47241b = fVar;
            this.f47242c = unitedSchemeEntity;
            this.f47243d = callbackHandler;
            this.f47244e = eVar;
            this.f47245f = str2;
            this.f47246g = bVar;
            this.f47247h = str3;
            this.i = cVar;
            this.j = fVar2;
            this.k = context;
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.h0.a.j1.j.d(this.f47240a);
            d.b.h0.a.c0.c.g("redirect", "check pages success");
            this.f47241b.C();
            d.b.h0.a.t1.k.p0.a.k(this.f47242c, this.f47243d, this.f47244e, this.f47245f, this.f47246g.f45083a, null, this.f47247h);
            i.this.n(this.i, this.f47246g, this.j, this.f47240a);
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.h0.a.c0.c.b("redirect", "check pages failed");
            this.f47241b.C();
            if (a0.f47009b) {
                Context context = this.k;
                d.b.h0.a.q1.b.f.d.f(context, this.k.getString(d.b.h0.a.h.aiapps_open_pages_failed) + i).C();
            }
            d.b.h0.a.t1.k.p0.a.i(this.f47242c, this.f47243d, this.f47247h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f47248a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47249b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f47250c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.f f47251d;

        public b(i iVar, b.c cVar, String str, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar) {
            this.f47248a = cVar;
            this.f47249b = str;
            this.f47250c = bVar;
            this.f47251d = fVar;
        }

        @Override // d.b.h0.a.e0.v.b.d
        public void onReady() {
            if (a0.f47009b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
            }
            d.b.h0.a.j1.j.e(this.f47248a, this.f47249b);
            d.b.h0.a.t1.k.p0.a.d(this.f47248a.f45025a, this.f47250c, this.f47249b);
            d.b.h0.a.t.c.i.c.s(this.f47251d, this.f47250c, this.f47249b, false);
            if (a0.f47009b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public i(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/redirectTo");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.e0.l.f fVar;
        if (a0.f47009b) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.b.h0.a.j1.j.b(uuid);
        String n = d.b.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.h0.a.c0.c.b("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.b.h0.a.z0.f V = d.b.h0.a.z0.f.V();
        d.b.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.h0.a.c0.c.b("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(n, V.h());
        if (!k0.d(V.I(), c2, false)) {
            d.b.h0.a.c0.c.b("redirect", "page params error : path=" + c2.f45083a + " ; routePath=" + c2.f45086d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && c2 != null && !TextUtils.isEmpty(c2.f45086d) && d.b.h0.a.r1.e.y() != null) {
            d.b.h0.a.r1.e.y().r0(str, c2.f45086d);
        }
        String m = d.b.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m)) {
            fVar = W;
        } else {
            HybridUbcFlow p = d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = W;
            ubcFlowEvent.h(Long.valueOf(m).longValue());
            p.A(ubcFlowEvent);
        }
        if (a0.f47009b) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        b.c d2 = d.b.h0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f45025a.c();
        if (a0.f47009b) {
            Log.d("redirectTo", "webview id: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.b.h0.a.t1.k.g0.a.c().a(c2)) {
            d.b.h0.a.t1.k.g0.a.c().h("redirectTo", c2);
            d.b.h0.a.c0.c.b("redirectTo", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.M();
            g.a(eVar, c2, c3, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, c3, c2, optString, d2, fVar, context), uuid);
            return true;
        }
    }

    public final void n(b.c cVar, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f45026b;
        HybridUbcFlow p = d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f47009b) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.h0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (a0.f47009b) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }
}
