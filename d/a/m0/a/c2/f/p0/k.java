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
import d.a.m0.a.h0.g.g;
import d.a.m0.a.h0.t.a;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45018a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.g1.f f45019b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.g f45020c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f45021d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45023f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45024g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45025h;

        /* renamed from: d.a.m0.a.c2.f.p0.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0647a implements a.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.d f45027a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f45028b;

            public C0647a(a.d dVar, JSONObject jSONObject) {
                this.f45027a = dVar;
                this.f45028b = jSONObject;
            }

            @Override // d.a.m0.a.h0.t.a.e
            public void onReady() {
                d.a.m0.a.r1.i.e(this.f45027a, a.this.f45018a);
                d.a.m0.a.p.e.b bVar = this.f45027a.f46364a;
                a aVar = a.this;
                d.a.m0.a.c2.f.p0.a.e(bVar, aVar.f45021d, aVar.f45018a);
                d.a.m0.a.r1.i.c(5, a.this.f45018a);
                a aVar2 = a.this;
                k.this.l(aVar2.f45020c, aVar2.f45021d, aVar2.f45018a);
                a aVar3 = a.this;
                UnitedSchemeUtility.callCallback(aVar3.f45022e, aVar3.f45023f, UnitedSchemeUtility.wrapCallbackParams(this.f45028b, 0));
            }
        }

        public a(String str, d.a.m0.a.g1.f fVar, d.a.m0.a.h0.g.g gVar, d.a.m0.a.l1.b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            this.f45018a = str;
            this.f45019b = fVar;
            this.f45020c = gVar;
            this.f45021d = bVar;
            this.f45022e = callbackHandler;
            this.f45023f = unitedSchemeEntity;
            this.f45024g = context;
            this.f45025h = str2;
        }

        @Override // d.a.m0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.m0.a.r1.i.d(this.f45018a);
            this.f45019b.o();
            d.a.m0.a.h0.g.f l = this.f45020c.l();
            if (l != null && !TextUtils.isEmpty(l.j3(this.f45021d.f47144h))) {
                JSONObject c2 = d.a.m0.a.c2.f.p0.a.c(l.j3(this.f45021d.f47144h));
                d.a.m0.a.r1.i.c(4, this.f45018a);
                k.this.l(this.f45020c, this.f45021d, this.f45018a);
                UnitedSchemeUtility.callCallback(this.f45022e, this.f45023f, UnitedSchemeUtility.wrapCallbackParams(c2, 0));
                return;
            }
            a.d f2 = d.a.m0.a.h0.t.a.f(this.f45019b.getActivity());
            JSONObject c3 = d.a.m0.a.c2.f.p0.a.c(f2.f46364a.b());
            HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.f45018a);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", f2.f46365b ? "1" : "0");
            d.a.m0.a.h0.t.a.n(f2, new C0647a(f2, c3));
        }

        @Override // d.a.m0.a.c2.f.p0.g.d
        public void b(int i2) {
            this.f45019b.o();
            if (a0.f44733b) {
                Context context = this.f45024g;
                d.a.m0.a.z1.b.f.e.g(context, this.f45024g.getString(d.a.m0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            if (TextUtils.isEmpty(this.f45025h)) {
                return;
            }
            d.a.m0.a.c2.f.p0.a.j(this.f45023f, this.f45022e, this.f45025h);
        }
    }

    public k(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/switchTab");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.m0.a.r1.i.b(uuid);
        String o = d.a.m0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.m0.a.e0.d.b("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        d.a.m0.a.g1.f V = d.a.m0.a.g1.f.V();
        d.a.m0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.m0.a.e0.d.b("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(o, V.A());
        d.a.m0.a.j2.h.f(e2.f47141e, "4");
        if (!q0.c(V.s(), e2)) {
            d.a.m0.a.e0.d.b("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.m0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(n)) {
            HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(n).longValue());
            q.C(ubcFlowEvent);
        }
        V.u();
        g.g(eVar, e2, "", new a(uuid, V, W, e2, callbackHandler, unitedSchemeEntity, context, optString), uuid);
        d.a.m0.a.e0.d.g("switchTab", "create and load page");
        return true;
    }

    public final void l(d.a.m0.a.h0.g.g gVar, d.a.m0.a.l1.b bVar, String str) {
        d.a.m0.a.h0.g.f.G3(q0.n());
        g.b i2 = gVar.i("switchTab");
        i2.n(0, 0);
        i2.i();
        i2.p(bVar).b();
        d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        d.a.m0.a.r1.i.a(str, bVar);
    }
}
