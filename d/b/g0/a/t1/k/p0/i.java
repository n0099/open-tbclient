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
/* loaded from: classes2.dex */
public class i extends a0 {

    /* loaded from: classes2.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z0.f f46520b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46521c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46522d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46524f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46525g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46526h;
        public final /* synthetic */ b.c i;
        public final /* synthetic */ d.b.g0.a.e0.l.f j;
        public final /* synthetic */ Context k;

        public a(String str, d.b.g0.a.z0.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, String str2, d.b.g0.a.e1.b bVar, String str3, b.c cVar, d.b.g0.a.e0.l.f fVar2, Context context) {
            this.f46519a = str;
            this.f46520b = fVar;
            this.f46521c = unitedSchemeEntity;
            this.f46522d = callbackHandler;
            this.f46523e = eVar;
            this.f46524f = str2;
            this.f46525g = bVar;
            this.f46526h = str3;
            this.i = cVar;
            this.j = fVar2;
            this.k = context;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.j1.j.d(this.f46519a);
            d.b.g0.a.c0.c.g("redirect", "check pages success");
            this.f46520b.C();
            d.b.g0.a.t1.k.p0.a.k(this.f46521c, this.f46522d, this.f46523e, this.f46524f, this.f46525g.f44362a, null, this.f46526h);
            i.this.n(this.i, this.f46525g, this.j, this.f46519a);
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.g0.a.c0.c.b("redirect", "check pages failed");
            this.f46520b.C();
            if (a0.f46288b) {
                Context context = this.k;
                d.b.g0.a.q1.b.f.d.f(context, this.k.getString(d.b.g0.a.h.aiapps_open_pages_failed) + i).C();
            }
            d.b.g0.a.t1.k.p0.a.i(this.f46521c, this.f46522d, this.f46526h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46527a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46528b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46529c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46530d;

        public b(i iVar, b.c cVar, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46527a = cVar;
            this.f46528b = str;
            this.f46529c = bVar;
            this.f46530d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (a0.f46288b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
            }
            d.b.g0.a.j1.j.e(this.f46527a, this.f46528b);
            d.b.g0.a.t1.k.p0.a.d(this.f46527a.f44304a, this.f46529c, this.f46528b);
            d.b.g0.a.t.c.i.c.s(this.f46530d, this.f46529c, this.f46528b, false);
            if (a0.f46288b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public i(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/redirectTo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.e0.l.f fVar;
        if (a0.f46288b) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.b.g0.a.j1.j.b(uuid);
        String n = d.b.g0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.g0.a.c0.c.b("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(n, V.h());
        if (!k0.d(V.I(), c2, false)) {
            d.b.g0.a.c0.c.b("redirect", "page params error : path=" + c2.f44362a + " ; routePath=" + c2.f44365d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && c2 != null && !TextUtils.isEmpty(c2.f44365d) && d.b.g0.a.r1.e.y() != null) {
            d.b.g0.a.r1.e.y().r0(str, c2.f44365d);
        }
        String m = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m)) {
            fVar = W;
        } else {
            HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = W;
            ubcFlowEvent.h(Long.valueOf(m).longValue());
            p.A(ubcFlowEvent);
        }
        if (a0.f46288b) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        b.c d2 = d.b.g0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f44304a.c();
        if (a0.f46288b) {
            Log.d("redirectTo", "webview id: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.b.g0.a.t1.k.g0.a.c().a(c2)) {
            d.b.g0.a.t1.k.g0.a.c().h("redirectTo", c2);
            d.b.g0.a.c0.c.b("redirectTo", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.M();
            g.a(eVar, c2, c3, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, c3, c2, optString, d2, fVar, context), uuid);
            return true;
        }
    }

    public final void n(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44305b;
        HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f46288b) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (a0.f46288b) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }
}
