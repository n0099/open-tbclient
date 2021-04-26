package d.a.h0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.v.b;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.v;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44658a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z0.f f44659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44660c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44661d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44663f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44664g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44665h;

        /* renamed from: d.a.h0.a.t1.k.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0815a implements b.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.c f44667a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f44668b;

            public C0815a(b.c cVar, JSONObject jSONObject) {
                this.f44667a = cVar;
                this.f44668b = jSONObject;
            }

            @Override // d.a.h0.a.e0.v.b.d
            public void onReady() {
                d.a.h0.a.j1.j.e(this.f44667a, a.this.f44658a);
                d.a.h0.a.p.d.b bVar = this.f44667a.f42331a;
                a aVar = a.this;
                d.a.h0.a.t1.k.p0.a.d(bVar, aVar.f44661d, aVar.f44658a);
                d.a.h0.a.j1.j.c(5, a.this.f44658a);
                a aVar2 = a.this;
                k.this.l(aVar2.f44660c, aVar2.f44661d, aVar2.f44658a);
                a aVar3 = a.this;
                UnitedSchemeUtility.callCallback(aVar3.f44662e, aVar3.f44663f, UnitedSchemeUtility.wrapCallbackParams(this.f44668b, 0));
            }
        }

        public a(String str, d.a.h0.a.z0.f fVar, d.a.h0.a.e0.l.f fVar2, d.a.h0.a.e1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            this.f44658a = str;
            this.f44659b = fVar;
            this.f44660c = fVar2;
            this.f44661d = bVar;
            this.f44662e = callbackHandler;
            this.f44663f = unitedSchemeEntity;
            this.f44664g = context;
            this.f44665h = str2;
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.a.h0.a.j1.j.d(this.f44658a);
            this.f44659b.q();
            d.a.h0.a.e0.l.e l = this.f44660c.l();
            if (l != null && !TextUtils.isEmpty(l.Z2(this.f44661d.f42395d))) {
                JSONObject b2 = d.a.h0.a.t1.k.p0.a.b(l.Z2(this.f44661d.f42395d));
                d.a.h0.a.j1.j.c(4, this.f44658a);
                k.this.l(this.f44660c, this.f44661d, this.f44658a);
                UnitedSchemeUtility.callCallback(this.f44662e, this.f44663f, UnitedSchemeUtility.wrapCallbackParams(b2, 0));
                return;
            }
            b.c d2 = d.a.h0.a.e0.v.b.d(this.f44659b.getActivity());
            JSONObject b3 = d.a.h0.a.t1.k.p0.a.b(d2.f42331a.c());
            HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f44658a);
            p.A(new UbcFlowEvent("na_pre_load_slave_check"));
            p.y("preload", d2.f42332b ? "1" : "0");
            d.a.h0.a.e0.v.b.j(d2, new C0815a(d2, b3));
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void b(int i2) {
            this.f44659b.q();
            if (a0.f44398b) {
                Context context = this.f44664g;
                d.a.h0.a.q1.b.f.d.f(context, this.f44664g.getString(d.a.h0.a.h.aiapps_open_pages_failed) + i2).C();
            }
            if (TextUtils.isEmpty(this.f44665h)) {
                return;
            }
            d.a.h0.a.t1.k.p0.a.i(this.f44663f, this.f44662e, this.f44665h);
        }
    }

    public k(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/switchTab");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.h0.a.j1.j.b(uuid);
        String n = d.a.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.a.h0.a.c0.c.b("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        d.a.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.a.h0.a.c0.c.b("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(n, V.A());
        if (!k0.e(V.u(), c2)) {
            d.a.h0.a.c0.c.b("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String m = d.a.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(m)) {
            HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(m).longValue());
            p.A(ubcFlowEvent);
        }
        V.w();
        g.a(eVar, c2, "", new a(uuid, V, W, c2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
        d.a.h0.a.c0.c.g("switchTab", "create and load page");
        return true;
    }

    public final void l(d.a.h0.a.e0.l.f fVar, d.a.h0.a.e1.b bVar, String str) {
        f.b i2 = fVar.i("switchTab");
        i2.n(0, 0);
        i2.i();
        i2.p(bVar).b();
        d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
        d.a.h0.a.j1.j.a(str);
    }
}
