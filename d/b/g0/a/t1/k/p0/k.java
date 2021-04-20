package d.b.g0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.v.b;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.v;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46923a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z0.f f46924b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46925c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46926d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46927e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46928f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46929g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46930h;

        /* renamed from: d.b.g0.a.t1.k.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0856a implements b.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.c f46931a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f46932b;

            public C0856a(b.c cVar, JSONObject jSONObject) {
                this.f46931a = cVar;
                this.f46932b = jSONObject;
            }

            @Override // d.b.g0.a.e0.v.b.d
            public void onReady() {
                d.b.g0.a.j1.j.e(this.f46931a, a.this.f46923a);
                d.b.g0.a.p.d.b bVar = this.f46931a.f44696a;
                a aVar = a.this;
                d.b.g0.a.t1.k.p0.a.d(bVar, aVar.f46926d, aVar.f46923a);
                d.b.g0.a.j1.j.c(5, a.this.f46923a);
                a aVar2 = a.this;
                k.this.l(aVar2.f46925c, aVar2.f46926d, aVar2.f46923a);
                a aVar3 = a.this;
                UnitedSchemeUtility.callCallback(aVar3.f46927e, aVar3.f46928f, UnitedSchemeUtility.wrapCallbackParams(this.f46932b, 0));
            }
        }

        public a(String str, d.b.g0.a.z0.f fVar, d.b.g0.a.e0.l.f fVar2, d.b.g0.a.e1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            this.f46923a = str;
            this.f46924b = fVar;
            this.f46925c = fVar2;
            this.f46926d = bVar;
            this.f46927e = callbackHandler;
            this.f46928f = unitedSchemeEntity;
            this.f46929g = context;
            this.f46930h = str2;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.j1.j.d(this.f46923a);
            this.f46924b.C();
            d.b.g0.a.e0.l.e l = this.f46925c.l();
            if (l != null && !TextUtils.isEmpty(l.a3(this.f46926d.f44757d))) {
                JSONObject b2 = d.b.g0.a.t1.k.p0.a.b(l.a3(this.f46926d.f44757d));
                d.b.g0.a.j1.j.c(4, this.f46923a);
                k.this.l(this.f46925c, this.f46926d, this.f46923a);
                UnitedSchemeUtility.callCallback(this.f46927e, this.f46928f, UnitedSchemeUtility.wrapCallbackParams(b2, 0));
                return;
            }
            b.c d2 = d.b.g0.a.e0.v.b.d(this.f46924b.getActivity());
            JSONObject b3 = d.b.g0.a.t1.k.p0.a.b(d2.f44696a.c());
            HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f46923a);
            p.A(new UbcFlowEvent("na_pre_load_slave_check"));
            p.y("preload", d2.f44697b ? "1" : "0");
            d.b.g0.a.e0.v.b.j(d2, new C0856a(d2, b3));
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            this.f46924b.C();
            if (a0.f46680b) {
                Context context = this.f46929g;
                d.b.g0.a.q1.b.f.d.f(context, this.f46929g.getString(d.b.g0.a.h.aiapps_open_pages_failed) + i).C();
            }
            if (TextUtils.isEmpty(this.f46930h)) {
                return;
            }
            d.b.g0.a.t1.k.p0.a.i(this.f46928f, this.f46927e, this.f46930h);
        }
    }

    public k(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/switchTab");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46680b) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.b.g0.a.j1.j.b(uuid);
        String n = d.b.g0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.g0.a.c0.c.b("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(n, V.h());
        if (!k0.e(V.I(), c2)) {
            d.b.g0.a.c0.c.b("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String m = d.b.g0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(m)) {
            HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(m).longValue());
            p.A(ubcFlowEvent);
        }
        V.M();
        g.a(eVar, c2, "", new a(uuid, V, W, c2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
        d.b.g0.a.c0.c.g("switchTab", "create and load page");
        return true;
    }

    public final void l(d.b.g0.a.e0.l.f fVar, d.b.g0.a.e1.b bVar, String str) {
        f.b i = fVar.i("switchTab");
        i.n(0, 0);
        i.i();
        i.p(bVar).b();
        d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
        d.b.g0.a.j1.j.a(str);
    }
}
