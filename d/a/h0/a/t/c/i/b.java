package d.a.h0.a.t.c.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.v.b;
import d.a.h0.a.i2.k0;
import d.a.h0.a.j1.i;
import d.a.h0.a.j1.j;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.k.p0.g;
import d.a.h0.a.z0.f;
import d.a.h0.a.z1.h;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public static final int f44216d = d.a.h0.a.w0.a.N().r();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44217e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44218f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44219g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44220h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44221i;

        /* renamed from: d.a.h0.a.t.c.i.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0790a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f44222a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f44223b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f44224c;

            public C0790a(e eVar, String str, b.c cVar) {
                this.f44222a = eVar;
                this.f44223b = str;
                this.f44224c = cVar;
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f44220h);
                d.a.h0.a.c0.c.g("Api-NavigateTo", "check pages success");
                h.z(true, this.f44222a.L().S());
                a.this.f44217e.q();
                List<String> f2 = d.a.h0.a.t1.k.p0.a.f(a.this.f44221i);
                a aVar = a.this;
                d.a.h0.a.t1.k.p0.a.l(b.this, this.f44222a, this.f44223b, aVar.f44219g.f42392a, f2, aVar.f44218f);
                a aVar2 = a.this;
                b.this.v(this.f44224c, aVar2.f44219g, aVar2.f44221i, aVar2.f44220h);
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void b(int i2) {
                d.a.h0.a.c0.c.b("Api-NavigateTo", "check pages failed");
                h.z(false, this.f44222a.L().S());
                a.this.f44217e.q();
                if (d.a.h0.a.t.b.d.f44021c) {
                    Context h2 = b.this.h();
                    d.a.h0.a.q1.b.f.d.f(h2, h2.getString(d.a.h0.a.h.aiapps_open_pages_failed) + i2).C();
                }
                a aVar = a.this;
                d.a.h0.a.t1.k.p0.a.j(b.this, aVar.f44218f);
            }
        }

        public a(f fVar, String str, d.a.h0.a.e1.b bVar, String str2, d.a.h0.a.e0.l.f fVar2) {
            this.f44217e = fVar;
            this.f44218f = str;
            this.f44219g = bVar;
            this.f44220h = str2;
            this.f44221i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f44217e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c d2 = d.a.h0.a.e0.v.b.d(activity);
                String c2 = d2.f42331a.c();
                if (d.a.h0.a.t.b.d.f44021c) {
                    Log.d("Api-NavigateTo", "slave webView id: " + c2);
                }
                e h2 = e.h();
                if (h2 == null) {
                    if (!d.a.h0.a.t.b.d.f44021c) {
                        b.this.c(this.f44218f, new d.a.h0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f44217e.w();
                g.a(h2, this.f44219g, c2, new C0790a(h2, c2, d2), this.f44220h);
            } else if (!d.a.h0.a.t.b.d.f44021c) {
                b.this.c(this.f44218f, new d.a.h0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* renamed from: d.a.h0.a.t.c.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0791b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f44226a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44227b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44228c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44229d;

        public C0791b(b.c cVar, String str, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar) {
            this.f44226a = cVar;
            this.f44227b = str;
            this.f44228c = bVar;
            this.f44229d = fVar;
        }

        @Override // d.a.h0.a.e0.v.b.d
        public void onReady() {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f44226a, this.f44227b);
            b.this.t(this.f44226a.f42331a, this.f44228c, this.f44229d, this.f44227b);
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + f44216d);
        }
    }

    public b(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void t(d.a.h0.a.p.d.b bVar, d.a.h0.a.e1.b bVar2, d.a.h0.a.e0.l.f fVar, String str) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.a.h0.a.t1.k.p0.a.d(bVar, bVar2, str);
        if (fVar.k() < f44216d) {
            f.b i2 = fVar.i("navigateTo");
            i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
            i2.k("normal", bVar2).b();
            d.a.h0.a.i2.f.c(fVar, h());
            i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            j.c(0, str);
            j.a(str);
            return;
        }
        c.s(fVar, bVar2, str, true);
    }

    public d.a.h0.a.t.e.b u(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-NavigateTo", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-NavigateTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.a.h0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.a.h0.a.c0.c.b("Api-NavigateTo", "url is null");
            return new d.a.h0.a.t.e.b(202, "url is null");
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        d.a.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.a.h0.a.c0.c.b("Api-NavigateTo", "manager is null");
            return new d.a.h0.a.t.e.b(1001, "manager is null");
        }
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(o, V.A());
        if (!k0.d(V.u(), c2, false)) {
            String str2 = "page params error : path=" + c2.f42392a + " ; routePath=" + c2.f42395d;
            d.a.h0.a.c0.c.b("Api-NavigateTo", str2);
            return new d.a.h0.a.t.e.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && c2 != null && !TextUtils.isEmpty(c2.f42395d) && e.h() != null) {
            e.h().r0(optString, c2.f42395d);
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
            d.a.h0.a.c0.c.b("Api-NavigateTo", "cb is null");
            return new d.a.h0.a.t.e.b(202, "cb is null");
        } else if (d.a.h0.a.t1.k.g0.a.c().a(c2)) {
            d.a.h0.a.t1.k.g0.a.c().h("navigateTo", c2);
            d.a.h0.a.c0.c.b("Api-NavigateTo", "access to this page is prohibited");
            return new d.a.h0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.a.h0.a.t.e.b(0);
        }
    }

    public final void v(b.c cVar, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f42332b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.h0.a.e0.v.b.j(cVar, new C0791b(cVar, str, bVar, fVar));
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
        }
    }
}
