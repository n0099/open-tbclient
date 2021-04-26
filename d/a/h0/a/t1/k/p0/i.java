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
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z0.f f44646b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44647c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44648d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44650f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44651g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44652h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.c f44653i;
        public final /* synthetic */ d.a.h0.a.e0.l.f j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.h0.a.z0.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, String str2, d.a.h0.a.e1.b bVar, String str3, b.c cVar, d.a.h0.a.e0.l.f fVar2, Context context) {
            this.f44645a = str;
            this.f44646b = fVar;
            this.f44647c = unitedSchemeEntity;
            this.f44648d = callbackHandler;
            this.f44649e = eVar;
            this.f44650f = str2;
            this.f44651g = bVar;
            this.f44652h = str3;
            this.f44653i = cVar;
            this.j = fVar2;
            this.k = context;
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.a.h0.a.j1.j.d(this.f44645a);
            d.a.h0.a.c0.c.g("redirect", "check pages success");
            this.f44646b.q();
            d.a.h0.a.t1.k.p0.a.k(this.f44647c, this.f44648d, this.f44649e, this.f44650f, this.f44651g.f42392a, null, this.f44652h);
            i.this.n(this.f44653i, this.f44651g, this.j, this.f44645a);
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void b(int i2) {
            d.a.h0.a.c0.c.b("redirect", "check pages failed");
            this.f44646b.q();
            if (a0.f44398b) {
                Context context = this.k;
                d.a.h0.a.q1.b.f.d.f(context, this.k.getString(d.a.h0.a.h.aiapps_open_pages_failed) + i2).C();
            }
            d.a.h0.a.t1.k.p0.a.i(this.f44647c, this.f44648d, this.f44652h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f44654a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44655b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44656c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44657d;

        public b(i iVar, b.c cVar, String str, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar) {
            this.f44654a = cVar;
            this.f44655b = str;
            this.f44656c = bVar;
            this.f44657d = fVar;
        }

        @Override // d.a.h0.a.e0.v.b.d
        public void onReady() {
            if (a0.f44398b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
            }
            d.a.h0.a.j1.j.e(this.f44654a, this.f44655b);
            d.a.h0.a.t1.k.p0.a.d(this.f44654a.f42331a, this.f44656c, this.f44655b);
            d.a.h0.a.t.c.i.c.s(this.f44657d, this.f44656c, this.f44655b, false);
            if (a0.f44398b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public i(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/redirectTo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.e0.l.f fVar;
        if (a0.f44398b) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.h0.a.j1.j.b(uuid);
        String n = d.a.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.a.h0.a.c0.c.b("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        d.a.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.a.h0.a.c0.c.b("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(n, V.A());
        if (!k0.d(V.u(), c2, false)) {
            d.a.h0.a.c0.c.b("redirect", "page params error : path=" + c2.f42392a + " ; routePath=" + c2.f42395d);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && c2 != null && !TextUtils.isEmpty(c2.f42395d) && d.a.h0.a.r1.e.h() != null) {
            d.a.h0.a.r1.e.h().r0(str, c2.f42395d);
        }
        String m = d.a.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(m)) {
            fVar = W;
        } else {
            HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = W;
            ubcFlowEvent.h(Long.valueOf(m).longValue());
            p.A(ubcFlowEvent);
        }
        if (a0.f44398b) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        b.c d2 = d.a.h0.a.e0.v.b.d(V.getActivity());
        String c3 = d2.f42331a.c();
        if (a0.f44398b) {
            Log.d("redirectTo", "webview id: " + c3);
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.h0.a.t1.k.g0.a.c().a(c2)) {
            d.a.h0.a.t1.k.g0.a.c().h("redirectTo", c2);
            d.a.h0.a.c0.c.b("redirectTo", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.w();
            g.a(eVar, c2, c3, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, c3, c2, optString, d2, fVar, context), uuid);
            return true;
        }
    }

    public final void n(b.c cVar, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f42332b;
        HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (a0.f44398b) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.h0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (a0.f44398b) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }
}
