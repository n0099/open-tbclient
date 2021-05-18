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
import d.a.i0.a.h0.g.g;
import d.a.i0.a.h0.t.a;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41060a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.g1.f f41061b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.g f41062c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.l1.b f41063d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41065f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f41066g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41067h;

        /* renamed from: d.a.i0.a.c2.f.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0577a implements a.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.d f41069a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f41070b;

            public C0577a(a.d dVar, JSONObject jSONObject) {
                this.f41069a = dVar;
                this.f41070b = jSONObject;
            }

            @Override // d.a.i0.a.h0.t.a.e
            public void onReady() {
                d.a.i0.a.r1.i.e(this.f41069a, a.this.f41060a);
                d.a.i0.a.p.e.b bVar = this.f41069a.f42406a;
                a aVar = a.this;
                d.a.i0.a.c2.f.p0.a.e(bVar, aVar.f41063d, aVar.f41060a);
                d.a.i0.a.r1.i.c(5, a.this.f41060a);
                a aVar2 = a.this;
                k.this.l(aVar2.f41062c, aVar2.f41063d, aVar2.f41060a);
                a aVar3 = a.this;
                UnitedSchemeUtility.callCallback(aVar3.f41064e, aVar3.f41065f, UnitedSchemeUtility.wrapCallbackParams(this.f41070b, 0));
            }
        }

        public a(String str, d.a.i0.a.g1.f fVar, d.a.i0.a.h0.g.g gVar, d.a.i0.a.l1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            this.f41060a = str;
            this.f41061b = fVar;
            this.f41062c = gVar;
            this.f41063d = bVar;
            this.f41064e = callbackHandler;
            this.f41065f = unitedSchemeEntity;
            this.f41066g = context;
            this.f41067h = str2;
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.i0.a.r1.i.d(this.f41060a);
            this.f41061b.o();
            d.a.i0.a.h0.g.f l = this.f41062c.l();
            if (l != null && !TextUtils.isEmpty(l.j3(this.f41063d.f43186h))) {
                JSONObject c2 = d.a.i0.a.c2.f.p0.a.c(l.j3(this.f41063d.f43186h));
                d.a.i0.a.r1.i.c(4, this.f41060a);
                k.this.l(this.f41062c, this.f41063d, this.f41060a);
                UnitedSchemeUtility.callCallback(this.f41064e, this.f41065f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                return;
            }
            a.d f2 = d.a.i0.a.h0.t.a.f(this.f41061b.getActivity());
            JSONObject c3 = d.a.i0.a.c2.f.p0.a.c(f2.f42406a.b());
            HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f41060a);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", f2.f42407b ? "1" : "0");
            d.a.i0.a.h0.t.a.n(f2, new C0577a(f2, c3));
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void b(int i2) {
            this.f41061b.o();
            if (a0.f40775b) {
                Context context = this.f41066g;
                d.a.i0.a.z1.b.f.e.g(context, this.f41066g.getString(d.a.i0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            if (TextUtils.isEmpty(this.f41067h)) {
                return;
            }
            d.a.i0.a.c2.f.p0.a.j(this.f41065f, this.f41064e, this.f41067h);
        }
    }

    public k(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/switchTab");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.i0.a.r1.i.b(uuid);
        String o = d.a.i0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.i0.a.e0.d.b("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        d.a.i0.a.g1.f V = d.a.i0.a.g1.f.V();
        d.a.i0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.i0.a.e0.d.b("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.i0.a.l1.b e2 = d.a.i0.a.l1.b.e(o, V.A());
        d.a.i0.a.j2.h.f(e2.f43183e, "4");
        if (!q0.c(V.s(), e2)) {
            d.a.i0.a.e0.d.b("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.i0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(n)) {
            HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(n).longValue());
            q.C(ubcFlowEvent);
        }
        V.u();
        g.g(eVar, e2, "", new a(uuid, V, W, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
        d.a.i0.a.e0.d.g("switchTab", "create and load page");
        return true;
    }

    public final void l(d.a.i0.a.h0.g.g gVar, d.a.i0.a.l1.b bVar, String str) {
        d.a.i0.a.h0.g.f.G3(q0.n());
        g.b i2 = gVar.i("switchTab");
        i2.n(0, 0);
        i2.i();
        i2.p(bVar).b();
        d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        d.a.i0.a.r1.i.a(str, bVar);
    }
}
