package d.b.g0.a.t.c.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.v.b;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.i;
import d.b.g0.a.j1.j;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.k.p0.g;
import d.b.g0.a.z0.f;
import d.b.g0.a.z1.h;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public static final int f46504d = d.b.g0.a.w0.a.N().D();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46506f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46507g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46508h;
        public final /* synthetic */ d.b.g0.a.e0.l.f i;

        /* renamed from: d.b.g0.a.t.c.i.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0831a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f46509a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f46510b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f46511c;

            public C0831a(e eVar, String str, b.c cVar) {
                this.f46509a = eVar;
                this.f46510b = str;
                this.f46511c = cVar;
            }

            @Override // d.b.g0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f46508h);
                d.b.g0.a.c0.c.g("Api-NavigateTo", "check pages success");
                h.z(true, this.f46509a.L().S());
                a.this.f46505e.C();
                List<String> f2 = d.b.g0.a.t1.k.p0.a.f(a.this.i);
                a aVar = a.this;
                d.b.g0.a.t1.k.p0.a.l(b.this, this.f46509a, this.f46510b, aVar.f46507g.f44754a, f2, aVar.f46506f);
                a aVar2 = a.this;
                b.this.v(this.f46511c, aVar2.f46507g, aVar2.i, aVar2.f46508h);
            }

            @Override // d.b.g0.a.t1.k.p0.g.d
            public void b(int i) {
                d.b.g0.a.c0.c.b("Api-NavigateTo", "check pages failed");
                h.z(false, this.f46509a.L().S());
                a.this.f46505e.C();
                if (d.b.g0.a.t.b.d.f46321c) {
                    Context h2 = b.this.h();
                    d.b.g0.a.q1.b.f.d.f(h2, h2.getString(d.b.g0.a.h.aiapps_open_pages_failed) + i).C();
                }
                a aVar = a.this;
                d.b.g0.a.t1.k.p0.a.j(b.this, aVar.f46506f);
            }
        }

        public a(f fVar, String str, d.b.g0.a.e1.b bVar, String str2, d.b.g0.a.e0.l.f fVar2) {
            this.f46505e = fVar;
            this.f46506f = str;
            this.f46507g = bVar;
            this.f46508h = str2;
            this.i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f46505e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c d2 = d.b.g0.a.e0.v.b.d(activity);
                String c2 = d2.f44696a.c();
                if (d.b.g0.a.t.b.d.f46321c) {
                    Log.d("Api-NavigateTo", "slave webView id: " + c2);
                }
                e y = e.y();
                if (y == null) {
                    if (!d.b.g0.a.t.b.d.f46321c) {
                        b.this.c(this.f46506f, new d.b.g0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f46505e.M();
                g.a(y, this.f46507g, c2, new C0831a(y, c2, d2), this.f46508h);
            } else if (!d.b.g0.a.t.b.d.f46321c) {
                b.this.c(this.f46506f, new d.b.g0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* renamed from: d.b.g0.a.t.c.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0832b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46513a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46514b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46515c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46516d;

        public C0832b(b.c cVar, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46513a = cVar;
            this.f46514b = str;
            this.f46515c = bVar;
            this.f46516d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f46513a, this.f46514b);
            b.this.t(this.f46513a.f44696a, this.f46515c, this.f46516d, this.f46514b);
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + f46504d);
        }
    }

    public b(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void t(d.b.g0.a.p.d.b bVar, d.b.g0.a.e1.b bVar2, d.b.g0.a.e0.l.f fVar, String str) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.b.g0.a.t1.k.p0.a.d(bVar, bVar2, str);
        if (fVar.k() < f46504d) {
            f.b i = fVar.i("navigateTo");
            i.n(d.b.g0.a.e0.l.f.f44405g, d.b.g0.a.e0.l.f.i);
            i.k("normal", bVar2).b();
            d.b.g0.a.i2.f.c(fVar, h());
            i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            j.c(0, str);
            j.a(str);
            return;
        }
        c.s(fVar, bVar2, str, true);
    }

    public d.b.g0.a.t.e.b u(String str) {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-NavigateTo", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f46321c) {
                d.b.g0.a.c0.c.b("Api-NavigateTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.b.g0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.b.g0.a.c0.c.b("Api-NavigateTo", "url is null");
            return new d.b.g0.a.t.e.b(202, "url is null");
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("Api-NavigateTo", "manager is null");
            return new d.b.g0.a.t.e.b(1001, "manager is null");
        }
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(o, V.h());
        if (!k0.d(V.I(), c2, false)) {
            String str2 = "page params error : path=" + c2.f44754a + " ; routePath=" + c2.f44757d;
            d.b.g0.a.c0.c.b("Api-NavigateTo", str2);
            return new d.b.g0.a.t.e.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && c2 != null && !TextUtils.isEmpty(c2.f44757d) && e.y() != null) {
            e.y().r0(optString, c2.f44757d);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(optString2).longValue());
            p.A(ubcFlowEvent);
        }
        String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            d.b.g0.a.c0.c.b("Api-NavigateTo", "cb is null");
            return new d.b.g0.a.t.e.b(202, "cb is null");
        } else if (d.b.g0.a.t1.k.g0.a.c().a(c2)) {
            d.b.g0.a.t1.k.g0.a.c().h("navigateTo", c2);
            d.b.g0.a.c0.c.b("Api-NavigateTo", "access to this page is prohibited");
            return new d.b.g0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.b.g0.a.t.e.b(0);
        }
    }

    public final void v(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44697b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new C0832b(cVar, str, bVar, fVar));
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
        }
    }
}
