package d.a.l0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
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
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f41162d = d.a.l0.a.c1.a.Z().s();

    /* renamed from: c  reason: collision with root package name */
    public Context f41163c;

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f41165b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.g1.f f41166c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f41167d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41168e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41169f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41170g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f41171h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41172i;
        public final /* synthetic */ a.d j;
        public final /* synthetic */ Context k;

        public a(String str, d.a.l0.a.a2.e eVar, d.a.l0.a.g1.f fVar, d.a.l0.a.h0.g.g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, d.a.l0.a.l1.b bVar, String str3, a.d dVar, Context context) {
            this.f41164a = str;
            this.f41165b = eVar;
            this.f41166c = fVar;
            this.f41167d = gVar;
            this.f41168e = unitedSchemeEntity;
            this.f41169f = callbackHandler;
            this.f41170g = str2;
            this.f41171h = bVar;
            this.f41172i = str3;
            this.j = dVar;
            this.k = context;
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.l0.a.r1.i.d(this.f41164a);
            d.a.l0.a.e0.d.g("navigateTo", "check pages success");
            d.a.l0.a.j2.k.B(true, this.f41165b.N().T());
            this.f41166c.o();
            d.a.l0.a.c2.f.p0.a.l(this.f41168e, this.f41169f, this.f41165b, this.f41170g, this.f41171h.f43357e, d.a.l0.a.c2.f.p0.a.g(this.f41167d), this.f41172i);
            e.this.p(this.j, this.f41171h, this.f41167d, this.f41164a);
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.l0.a.e0.d.b("navigateTo", "check pages failed");
            d.a.l0.a.j2.k.B(false, this.f41165b.N().T());
            this.f41166c.o();
            if (a0.f40949b) {
                Context context = this.k;
                d.a.l0.a.z1.b.f.e.g(context, this.k.getString(d.a.l0.a.h.aiapps_open_pages_failed) + i2).F();
            }
            d.a.l0.a.c2.f.p0.a.j(this.f41168e, this.f41169f, this.f41172i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f41173a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41174b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f41175c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f41176d;

        public b(a.d dVar, String str, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar) {
            this.f41173a = dVar;
            this.f41174b = str;
            this.f41175c = bVar;
            this.f41176d = gVar;
        }

        @Override // d.a.l0.a.h0.t.a.e
        public void onReady() {
            if (a0.f40949b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
            }
            d.a.l0.a.r1.i.e(this.f41173a, this.f41174b);
            e.this.o(this.f41173a.f42580a, this.f41175c, this.f41176d, this.f41174b);
            if (a0.f40949b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (a0.f40949b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + f41162d);
        }
    }

    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateTo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.g1.f fVar;
        if (a0.f40949b) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.f41163c = context;
        String uuid = UUID.randomUUID().toString();
        d.a.l0.a.r1.i.b(uuid);
        String o = d.a.l0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(o)) {
            d.a.l0.a.e0.d.b("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.l0.a.g1.f V = d.a.l0.a.g1.f.V();
        d.a.l0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.l0.a.e0.d.b("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.l0.a.l1.b e2 = d.a.l0.a.l1.b.e(o, V.A());
        d.a.l0.a.j2.h.f(e2.f43357e, "0");
        if (!q0.b(V.s(), e2, false)) {
            d.a.l0.a.e0.d.b("navigateTo", "page params error : path=" + e2.f43357e + " ; routePath=" + e2.f43360h);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String n = d.a.l0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(n) && e2 != null && !TextUtils.isEmpty(e2.f43360h) && d.a.l0.a.a2.e.i() != null) {
            d.a.l0.a.a2.e.i().x0(n, e2.f43360h);
        }
        String n2 = d.a.l0.a.c2.f.p0.a.n(unitedSchemeEntity, "params", "startTime");
        if (TextUtils.isEmpty(n2)) {
            fVar = V;
        } else {
            HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            fVar = V;
            ubcFlowEvent.h(Long.valueOf(n2).longValue());
            q.C(ubcFlowEvent);
        }
        if (a0.f40949b) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        a.d f2 = d.a.l0.a.h0.t.a.f(fVar.getActivity());
        String b2 = f2.f42580a.b();
        if (a0.f40949b) {
            Log.d("NavigateToAction", "slave webView id: " + b2);
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (d.a.l0.a.c2.f.g0.d.b().a(e2)) {
            d.a.l0.a.c2.f.g0.d.b().i("navigateTo", e2);
            d.a.l0.a.e0.d.b("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            fVar.u();
            g.g(eVar, e2, b2, new a(uuid, eVar, fVar, W, unitedSchemeEntity, callbackHandler, b2, e2, optString, f2, context), uuid);
            return true;
        }
    }

    public final void o(d.a.l0.a.p.e.b bVar, d.a.l0.a.l1.b bVar2, d.a.l0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.a.l0.a.c2.f.p0.a.e(bVar, bVar2, str);
        d.a.l0.a.r1.i.c(0, str);
        if (gVar.k() < f41162d) {
            d.a.l0.a.h0.g.f.G3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.l0.a.h0.g.g.f42076g, d.a.l0.a.h0.g.g.f42078i);
            i2.k("normal", bVar2).b();
            d.a.l0.a.v2.g.c(gVar, this.f41163c);
            d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.l0.a.r1.i.a(str, bVar2);
            return;
        }
        d.a.l0.a.u.e.k.c.u(gVar, bVar2, str, true);
    }

    public final void p(a.d dVar, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f42581b;
        HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (a0.f40949b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.l0.a.h0.t.a.n(dVar, new b(dVar, str, bVar, gVar));
        if (a0.f40949b) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }
}
