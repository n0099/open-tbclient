package d.a.m0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.c2.f.p0.g;
import d.a.m0.a.h0.t.a;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.g1.f f45006b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45007c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45008d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f45009e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45010f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f45011g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45012h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a.d f45013i;
        public final /* synthetic */ d.a.m0.a.h0.g.g j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.m0.a.g1.f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, String str2, d.a.m0.a.l1.b bVar, String str3, a.d dVar, d.a.m0.a.h0.g.g gVar, Context context) {
            this.f45005a = str;
            this.f45006b = fVar;
            this.f45007c = unitedSchemeEntity;
            this.f45008d = callbackHandler;
            this.f45009e = eVar;
            this.f45010f = str2;
            this.f45011g = bVar;
            this.f45012h = str3;
            this.f45013i = dVar;
            this.j = gVar;
            this.k = context;
        }

        @Override // d.a.m0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.m0.a.r1.i.d(this.f45005a);
            d.a.m0.a.e0.d.g("redirect", "check pages success");
            this.f45006b.o();
            d.a.m0.a.c2.f.p0.a.l(this.f45007c, this.f45008d, this.f45009e, this.f45010f, this.f45011g.f47141e, null, this.f45012h);
            i.this.n(this.f45013i, this.f45011g, this.j, this.f45005a);
        }

        @Override // d.a.m0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.m0.a.e0.d.b("redirect", "check pages failed");
            this.f45006b.o();
            if (a0.f44733b) {
                Context context = this.k;
                d.a.m0.a.z1.b.f.e.g(context, this.k.getString(d.a.m0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            d.a.m0.a.c2.f.p0.a.j(this.f45007c, this.f45008d, this.f45012h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f45014a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45015b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f45016c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.g f45017d;

        public b(i iVar, a.d dVar, String str, d.a.m0.a.l1.b bVar, d.a.m0.a.h0.g.g gVar) {
            this.f45014a = dVar;
            this.f45015b = str;
            this.f45016c = bVar;
            this.f45017d = gVar;
        }

        @Override // d.a.m0.a.h0.t.a.e
        public void onReady() {
            if (a0.f44733b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
            }
            d.a.m0.a.r1.i.e(this.f45014a, this.f45015b);
            d.a.m0.a.c2.f.p0.a.e(this.f45014a.f46364a, this.f45016c, this.f45015b);
            d.a.m0.a.u.e.k.c.u(this.f45017d, this.f45016c, this.f45015b, false);
            if (a0.f44733b) {
                Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public i(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/redirectTo");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.h0.g.g gVar;
        if (a0.f44733b) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.m0.a.r1.i.b(uuid);
        String o = d.a.m0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.m0.a.e0.d.b("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.m0.a.g1.f V = d.a.m0.a.g1.f.V();
        d.a.m0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.m0.a.e0.d.b("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(o, V.A());
        d.a.m0.a.j2.h.f(e2.f47141e, "2");
        if (!q0.b(V.s(), e2, false)) {
            d.a.m0.a.e0.d.b("redirect", "page params error : path=" + e2.f47141e + " ; routePath=" + e2.f47144h);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && e2 != null && !TextUtils.isEmpty(e2.f47144h) && d.a.m0.a.a2.e.i() != null) {
            d.a.m0.a.a2.e.i().x0(str, e2.f47144h);
        }
        String n = d.a.m0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(n)) {
            gVar = W;
        } else {
            HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            gVar = W;
            ubcFlowEvent.h(Long.valueOf(n).longValue());
            q.C(ubcFlowEvent);
        }
        if (a0.f44733b) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        a.d f2 = d.a.m0.a.h0.t.a.f(V.getActivity());
        String b2 = f2.f46364a.b();
        if (a0.f44733b) {
            Log.d("redirectTo", "webview id: " + b2);
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.m0.a.c2.f.g0.d.b().a(e2)) {
            d.a.m0.a.c2.f.g0.d.b().i("redirectTo", e2);
            d.a.m0.a.e0.d.b("redirectTo", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            V.u();
            g.g(eVar, e2, b2, new a(uuid, V, unitedSchemeEntity, callbackHandler, eVar, b2, e2, optString, f2, gVar, context), uuid);
            return true;
        }
    }

    public final void n(a.d dVar, d.a.m0.a.l1.b bVar, d.a.m0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f46365b;
        HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (a0.f44733b) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.m0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
        if (a0.f44733b) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }
}
