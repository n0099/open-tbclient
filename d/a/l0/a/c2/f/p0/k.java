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
import d.a.l0.a.h0.g.g;
import d.a.l0.a.h0.t.a;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.g1.f f44911b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f44912c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f44913d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44915f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44916g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44917h;

        /* renamed from: d.a.l0.a.c2.f.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0644a implements a.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.d f44919a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f44920b;

            public C0644a(a.d dVar, JSONObject jSONObject) {
                this.f44919a = dVar;
                this.f44920b = jSONObject;
            }

            @Override // d.a.l0.a.h0.t.a.e
            public void onReady() {
                d.a.l0.a.r1.i.e(this.f44919a, a.this.f44910a);
                d.a.l0.a.p.e.b bVar = this.f44919a.f46256a;
                a aVar = a.this;
                d.a.l0.a.c2.f.p0.a.e(bVar, aVar.f44913d, aVar.f44910a);
                d.a.l0.a.r1.i.c(5, a.this.f44910a);
                a aVar2 = a.this;
                k.this.l(aVar2.f44912c, aVar2.f44913d, aVar2.f44910a);
                a aVar3 = a.this;
                UnitedSchemeUtility.callCallback(aVar3.f44914e, aVar3.f44915f, UnitedSchemeUtility.wrapCallbackParams(this.f44920b, 0));
            }
        }

        public a(String str, d.a.l0.a.g1.f fVar, d.a.l0.a.h0.g.g gVar, d.a.l0.a.l1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            this.f44910a = str;
            this.f44911b = fVar;
            this.f44912c = gVar;
            this.f44913d = bVar;
            this.f44914e = callbackHandler;
            this.f44915f = unitedSchemeEntity;
            this.f44916g = context;
            this.f44917h = str2;
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.l0.a.r1.i.d(this.f44910a);
            this.f44911b.o();
            d.a.l0.a.h0.g.f l = this.f44912c.l();
            if (l != null && !TextUtils.isEmpty(l.j3(this.f44913d.f47036h))) {
                JSONObject c2 = d.a.l0.a.c2.f.p0.a.c(l.j3(this.f44913d.f47036h));
                d.a.l0.a.r1.i.c(4, this.f44910a);
                k.this.l(this.f44912c, this.f44913d, this.f44910a);
                UnitedSchemeUtility.callCallback(this.f44914e, this.f44915f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                return;
            }
            a.d f2 = d.a.l0.a.h0.t.a.f(this.f44911b.getActivity());
            JSONObject c3 = d.a.l0.a.c2.f.p0.a.c(f2.f46256a.b());
            HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f44910a);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", f2.f46257b ? "1" : "0");
            d.a.l0.a.h0.t.a.n(f2, new C0644a(f2, c3));
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void b(int i2) {
            this.f44911b.o();
            if (a0.f44625b) {
                Context context = this.f44916g;
                d.a.l0.a.z1.b.f.e.g(context, this.f44916g.getString(d.a.l0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            if (TextUtils.isEmpty(this.f44917h)) {
                return;
            }
            d.a.l0.a.c2.f.p0.a.j(this.f44915f, this.f44914e, this.f44917h);
        }
    }

    public k(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/switchTab");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.l0.a.r1.i.b(uuid);
        String o = d.a.l0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.l0.a.e0.d.b("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        d.a.l0.a.g1.f V = d.a.l0.a.g1.f.V();
        d.a.l0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.l0.a.e0.d.b("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.l0.a.l1.b e2 = d.a.l0.a.l1.b.e(o, V.A());
        d.a.l0.a.j2.h.f(e2.f47033e, "4");
        if (!q0.c(V.s(), e2)) {
            d.a.l0.a.e0.d.b("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.l0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(n)) {
            HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(n).longValue());
            q.C(ubcFlowEvent);
        }
        V.u();
        g.g(eVar, e2, "", new a(uuid, V, W, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
        d.a.l0.a.e0.d.g("switchTab", "create and load page");
        return true;
    }

    public final void l(d.a.l0.a.h0.g.g gVar, d.a.l0.a.l1.b bVar, String str) {
        d.a.l0.a.h0.g.f.G3(q0.n());
        g.b i2 = gVar.i("switchTab");
        i2.n(0, 0);
        i2.i();
        i2.p(bVar).b();
        d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        d.a.l0.a.r1.i.a(str, bVar);
    }
}
