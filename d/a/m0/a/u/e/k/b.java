package d.a.m0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.a2.e;
import d.a.m0.a.c2.f.p0.g;
import d.a.m0.a.g1.f;
import d.a.m0.a.h;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.h0.t.a;
import d.a.m0.a.j2.k;
import d.a.m0.a.r1.i;
import d.a.m0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.m0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static final int f48861d = d.a.m0.a.c1.a.Z().s();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48863f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f48864g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48865h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f48866i;

        /* renamed from: d.a.m0.a.u.e.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0915a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f48867a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48868b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f48869c;

            public C0915a(e eVar, String str, a.d dVar) {
                this.f48867a = eVar;
                this.f48868b = str;
                this.f48869c = dVar;
            }

            @Override // d.a.m0.a.c2.f.p0.g.d
            public void a(String str) {
                i.d(a.this.f48865h);
                d.a.m0.a.e0.d.g("Api-NavigateTo", "check pages success");
                k.B(true, this.f48867a.N().T());
                a.this.f48862e.o();
                List<String> g2 = d.a.m0.a.c2.f.p0.a.g(a.this.f48866i);
                a aVar = a.this;
                d.a.m0.a.c2.f.p0.a.m(b.this, this.f48867a, this.f48868b, aVar.f48864g.f47141e, g2, aVar.f48863f);
                a aVar2 = a.this;
                b.this.w(this.f48869c, aVar2.f48864g, aVar2.f48866i, aVar2.f48865h);
            }

            @Override // d.a.m0.a.c2.f.p0.g.d
            public void b(int i2) {
                d.a.m0.a.e0.d.b("Api-NavigateTo", "check pages failed");
                k.B(false, this.f48867a.N().T());
                a.this.f48862e.o();
                if (d.a.m0.a.u.c.d.f48594c) {
                    Context i3 = b.this.i();
                    d.a.m0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                }
                a aVar = a.this;
                d.a.m0.a.c2.f.p0.a.k(b.this, aVar.f48863f);
            }
        }

        public a(f fVar, String str, d.a.m0.a.l1.b bVar, String str2, d.a.m0.a.h0.g.g gVar) {
            this.f48862e = fVar;
            this.f48863f = str;
            this.f48864g = bVar;
            this.f48865h = str2;
            this.f48866i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f48862e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                a.d f2 = d.a.m0.a.h0.t.a.f(activity);
                String b2 = f2.f46364a.b();
                if (d.a.m0.a.u.c.d.f48594c) {
                    Log.d("Api-NavigateTo", "slave webView id: " + b2);
                }
                e i2 = e.i();
                if (i2 == null) {
                    if (!d.a.m0.a.u.c.d.f48594c) {
                        b.this.d(this.f48863f, new d.a.m0.a.u.h.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f48862e.u();
                d.a.m0.a.c2.f.p0.g.g(i2, this.f48864g, b2, new C0915a(i2, b2, f2), this.f48865h);
            } else if (!d.a.m0.a.u.c.d.f48594c) {
                b.this.d(this.f48863f, new d.a.m0.a.u.h.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* renamed from: d.a.m0.a.u.e.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0916b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f48871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48872b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.l1.b f48873c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.g f48874d;

        public C0916b(a.d dVar, String str, d.a.m0.a.l1.b bVar, d.a.m0.a.h0.g.g gVar) {
            this.f48871a = dVar;
            this.f48872b = str;
            this.f48873c = bVar;
            this.f48874d = gVar;
        }

        @Override // d.a.m0.a.h0.t.a.e
        public void onReady() {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
            }
            i.e(this.f48871a, this.f48872b);
            b.this.u(this.f48871a.f46364a, this.f48873c, this.f48874d, this.f48872b);
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + f48861d);
        }
    }

    public b(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void u(d.a.m0.a.p.e.b bVar, d.a.m0.a.l1.b bVar2, d.a.m0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.a.m0.a.c2.f.p0.a.e(bVar, bVar2, str);
        i.c(0, str);
        if (gVar.k() < f48861d) {
            d.a.m0.a.h0.g.f.G3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.m0.a.h0.g.g.f45860g, d.a.m0.a.h0.g.g.f45862i);
            i2.k("normal", bVar2).b();
            d.a.m0.a.v2.g.c(gVar, i());
            d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar2);
            return;
        }
        c.u(gVar, bVar2, str, true);
    }

    public d.a.m0.a.u.h.b v(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-NavigateTo", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-NavigateTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String p = d.a.m0.a.c2.f.p0.a.p(jSONObject);
        if (TextUtils.isEmpty(p)) {
            d.a.m0.a.e0.d.b("Api-NavigateTo", "url is null");
            return new d.a.m0.a.u.h.b(202, "url is null");
        }
        f V = f.V();
        d.a.m0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.m0.a.e0.d.b("Api-NavigateTo", "manager is null");
            return new d.a.m0.a.u.h.b(1001, "manager is null");
        }
        d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(p, V.A());
        d.a.m0.a.j2.h.f(e2.f47141e, "0");
        if (!q0.b(V.s(), e2, false)) {
            String str2 = "page params error : path=" + e2.f47141e + " ; routePath=" + e2.f47144h;
            d.a.m0.a.e0.d.b("Api-NavigateTo", str2);
            return new d.a.m0.a.u.h.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && e2 != null && !TextUtils.isEmpty(e2.f47144h) && e.i() != null) {
            e.i().x0(optString, e2.f47144h);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(optString2).longValue());
            q.C(ubcFlowEvent);
        }
        String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            d.a.m0.a.e0.d.b("Api-NavigateTo", "cb is null");
            return new d.a.m0.a.u.h.b(202, "cb is null");
        } else if (d.a.m0.a.c2.f.g0.d.b().a(e2)) {
            d.a.m0.a.c2.f.g0.d.b().i("navigateTo", e2);
            d.a.m0.a.e0.d.b("Api-NavigateTo", "access to this page is prohibited");
            return new d.a.m0.a.u.h.b(1003, "access to this page is prohibited");
        } else {
            q0.X(new a(V, optString3, e2, uuid, W));
            return new d.a.m0.a.u.h.b(0);
        }
    }

    public final void w(a.d dVar, d.a.m0.a.l1.b bVar, d.a.m0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f46365b;
        HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.m0.a.h0.t.a.n(dVar, new C0916b(dVar, str, bVar, gVar));
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
        }
    }
}
