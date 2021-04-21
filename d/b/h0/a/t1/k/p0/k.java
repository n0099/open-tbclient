package d.b.h0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.e0.v.b;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.v;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.t1.k.p0.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47252a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.z0.f f47253b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.f f47254c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f47255d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47258g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47259h;

        /* renamed from: d.b.h0.a.t1.k.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0876a implements b.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.c f47260a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f47261b;

            public C0876a(b.c cVar, JSONObject jSONObject) {
                this.f47260a = cVar;
                this.f47261b = jSONObject;
            }

            @Override // d.b.h0.a.e0.v.b.d
            public void onReady() {
                d.b.h0.a.j1.j.e(this.f47260a, a.this.f47252a);
                d.b.h0.a.p.d.b bVar = this.f47260a.f45025a;
                a aVar = a.this;
                d.b.h0.a.t1.k.p0.a.d(bVar, aVar.f47255d, aVar.f47252a);
                d.b.h0.a.j1.j.c(5, a.this.f47252a);
                a aVar2 = a.this;
                k.this.l(aVar2.f47254c, aVar2.f47255d, aVar2.f47252a);
                a aVar3 = a.this;
                UnitedSchemeUtility.callCallback(aVar3.f47256e, aVar3.f47257f, UnitedSchemeUtility.wrapCallbackParams(this.f47261b, 0));
            }
        }

        public a(String str, d.b.h0.a.z0.f fVar, d.b.h0.a.e0.l.f fVar2, d.b.h0.a.e1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            this.f47252a = str;
            this.f47253b = fVar;
            this.f47254c = fVar2;
            this.f47255d = bVar;
            this.f47256e = callbackHandler;
            this.f47257f = unitedSchemeEntity;
            this.f47258g = context;
            this.f47259h = str2;
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.h0.a.j1.j.d(this.f47252a);
            this.f47253b.C();
            d.b.h0.a.e0.l.e l = this.f47254c.l();
            if (l != null && !TextUtils.isEmpty(l.a3(this.f47255d.f45086d))) {
                JSONObject b2 = d.b.h0.a.t1.k.p0.a.b(l.a3(this.f47255d.f45086d));
                d.b.h0.a.j1.j.c(4, this.f47252a);
                k.this.l(this.f47254c, this.f47255d, this.f47252a);
                UnitedSchemeUtility.callCallback(this.f47256e, this.f47257f, UnitedSchemeUtility.wrapCallbackParams(b2, 0));
                return;
            }
            b.c d2 = d.b.h0.a.e0.v.b.d(this.f47253b.getActivity());
            JSONObject b3 = d.b.h0.a.t1.k.p0.a.b(d2.f45025a.c());
            HybridUbcFlow p = d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f47252a);
            p.A(new UbcFlowEvent("na_pre_load_slave_check"));
            p.y("preload", d2.f45026b ? "1" : "0");
            d.b.h0.a.e0.v.b.j(d2, new C0876a(d2, b3));
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void b(int i) {
            this.f47253b.C();
            if (a0.f47009b) {
                Context context = this.f47258g;
                d.b.h0.a.q1.b.f.d.f(context, this.f47258g.getString(d.b.h0.a.h.aiapps_open_pages_failed) + i).C();
            }
            if (TextUtils.isEmpty(this.f47259h)) {
                return;
            }
            d.b.h0.a.t1.k.p0.a.i(this.f47257f, this.f47256e, this.f47259h);
        }
    }

    public k(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/switchTab");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.b.h0.a.j1.j.b(uuid);
        String n = d.b.h0.a.t1.k.p0.a.n(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(n)) {
            d.b.h0.a.c0.c.b("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        d.b.h0.a.z0.f V = d.b.h0.a.z0.f.V();
        d.b.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.h0.a.c0.c.b("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(n, V.h());
        if (!k0.e(V.I(), c2)) {
            d.b.h0.a.c0.c.b("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String m = d.b.h0.a.t1.k.p0.a.m(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(m)) {
            HybridUbcFlow p = d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(m).longValue());
            p.A(ubcFlowEvent);
        }
        V.M();
        g.a(eVar, c2, "", new a(uuid, V, W, c2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
        d.b.h0.a.c0.c.g("switchTab", "create and load page");
        return true;
    }

    public final void l(d.b.h0.a.e0.l.f fVar, d.b.h0.a.e1.b bVar, String str) {
        f.b i = fVar.i("switchTab");
        i.n(0, 0);
        i.i();
        i.p(bVar).b();
        d.b.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
        d.b.h0.a.j1.j.a(str);
    }
}
