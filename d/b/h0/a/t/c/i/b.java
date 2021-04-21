package d.b.h0.a.t.c.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.e0.v.b;
import d.b.h0.a.i2.k0;
import d.b.h0.a.j1.i;
import d.b.h0.a.j1.j;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.k.p0.g;
import d.b.h0.a.z0.f;
import d.b.h0.a.z1.h;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public static final int f46833d = d.b.h0.a.w0.a.N().D();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46834e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46835f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f46836g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46837h;
        public final /* synthetic */ d.b.h0.a.e0.l.f i;

        /* renamed from: d.b.h0.a.t.c.i.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0851a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f46838a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f46839b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f46840c;

            public C0851a(e eVar, String str, b.c cVar) {
                this.f46838a = eVar;
                this.f46839b = str;
                this.f46840c = cVar;
            }

            @Override // d.b.h0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f46837h);
                d.b.h0.a.c0.c.g("Api-NavigateTo", "check pages success");
                h.z(true, this.f46838a.L().S());
                a.this.f46834e.C();
                List<String> f2 = d.b.h0.a.t1.k.p0.a.f(a.this.i);
                a aVar = a.this;
                d.b.h0.a.t1.k.p0.a.l(b.this, this.f46838a, this.f46839b, aVar.f46836g.f45083a, f2, aVar.f46835f);
                a aVar2 = a.this;
                b.this.v(this.f46840c, aVar2.f46836g, aVar2.i, aVar2.f46837h);
            }

            @Override // d.b.h0.a.t1.k.p0.g.d
            public void b(int i) {
                d.b.h0.a.c0.c.b("Api-NavigateTo", "check pages failed");
                h.z(false, this.f46838a.L().S());
                a.this.f46834e.C();
                if (d.b.h0.a.t.b.d.f46650c) {
                    Context h2 = b.this.h();
                    d.b.h0.a.q1.b.f.d.f(h2, h2.getString(d.b.h0.a.h.aiapps_open_pages_failed) + i).C();
                }
                a aVar = a.this;
                d.b.h0.a.t1.k.p0.a.j(b.this, aVar.f46835f);
            }
        }

        public a(f fVar, String str, d.b.h0.a.e1.b bVar, String str2, d.b.h0.a.e0.l.f fVar2) {
            this.f46834e = fVar;
            this.f46835f = str;
            this.f46836g = bVar;
            this.f46837h = str2;
            this.i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f46834e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c d2 = d.b.h0.a.e0.v.b.d(activity);
                String c2 = d2.f45025a.c();
                if (d.b.h0.a.t.b.d.f46650c) {
                    Log.d("Api-NavigateTo", "slave webView id: " + c2);
                }
                e y = e.y();
                if (y == null) {
                    if (!d.b.h0.a.t.b.d.f46650c) {
                        b.this.c(this.f46835f, new d.b.h0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f46834e.M();
                g.a(y, this.f46836g, c2, new C0851a(y, c2, d2), this.f46837h);
            } else if (!d.b.h0.a.t.b.d.f46650c) {
                b.this.c(this.f46835f, new d.b.h0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* renamed from: d.b.h0.a.t.c.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0852b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f46844c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.f f46845d;

        public C0852b(b.c cVar, String str, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar) {
            this.f46842a = cVar;
            this.f46843b = str;
            this.f46844c = bVar;
            this.f46845d = fVar;
        }

        @Override // d.b.h0.a.e0.v.b.d
        public void onReady() {
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f46842a, this.f46843b);
            b.this.t(this.f46842a.f45025a, this.f46844c, this.f46845d, this.f46843b);
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + f46833d);
        }
    }

    public b(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void t(d.b.h0.a.p.d.b bVar, d.b.h0.a.e1.b bVar2, d.b.h0.a.e0.l.f fVar, String str) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.b.h0.a.t1.k.p0.a.d(bVar, bVar2, str);
        if (fVar.k() < f46833d) {
            f.b i = fVar.i("navigateTo");
            i.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
            i.k("normal", bVar2).b();
            d.b.h0.a.i2.f.c(fVar, h());
            i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            j.c(0, str);
            j.a(str);
            return;
        }
        c.s(fVar, bVar2, str, true);
    }

    public d.b.h0.a.t.e.b u(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-NavigateTo", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-NavigateTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.b.h0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.b.h0.a.c0.c.b("Api-NavigateTo", "url is null");
            return new d.b.h0.a.t.e.b(202, "url is null");
        }
        d.b.h0.a.z0.f V = d.b.h0.a.z0.f.V();
        d.b.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.h0.a.c0.c.b("Api-NavigateTo", "manager is null");
            return new d.b.h0.a.t.e.b(1001, "manager is null");
        }
        d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(o, V.h());
        if (!k0.d(V.I(), c2, false)) {
            String str2 = "page params error : path=" + c2.f45083a + " ; routePath=" + c2.f45086d;
            d.b.h0.a.c0.c.b("Api-NavigateTo", str2);
            return new d.b.h0.a.t.e.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && c2 != null && !TextUtils.isEmpty(c2.f45086d) && e.y() != null) {
            e.y().r0(optString, c2.f45086d);
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
            d.b.h0.a.c0.c.b("Api-NavigateTo", "cb is null");
            return new d.b.h0.a.t.e.b(202, "cb is null");
        } else if (d.b.h0.a.t1.k.g0.a.c().a(c2)) {
            d.b.h0.a.t1.k.g0.a.c().h("navigateTo", c2);
            d.b.h0.a.c0.c.b("Api-NavigateTo", "access to this page is prohibited");
            return new d.b.h0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.b.h0.a.t.e.b(0);
        }
    }

    public final void v(b.c cVar, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f45026b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.h0.a.e0.v.b.j(cVar, new C0852b(cVar, str, bVar, fVar));
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
        }
    }
}
