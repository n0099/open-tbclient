package d.a.i0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.i0.a.a2.e;
import d.a.i0.a.c2.f.p0.g;
import d.a.i0.a.g1.f;
import d.a.i0.a.h;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.h0.t.a;
import d.a.i0.a.j2.k;
import d.a.i0.a.r1.i;
import d.a.i0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static final int f44903d = d.a.i0.a.c1.a.Z().s();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44905f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.l1.b f44906g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44907h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f44908i;

        /* renamed from: d.a.i0.a.u.e.k.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0845a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f44909a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f44910b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f44911c;

            public C0845a(e eVar, String str, a.d dVar) {
                this.f44909a = eVar;
                this.f44910b = str;
                this.f44911c = dVar;
            }

            @Override // d.a.i0.a.c2.f.p0.g.d
            public void a(String str) {
                i.d(a.this.f44907h);
                d.a.i0.a.e0.d.g("Api-NavigateTo", "check pages success");
                k.B(true, this.f44909a.N().T());
                a.this.f44904e.o();
                List<String> g2 = d.a.i0.a.c2.f.p0.a.g(a.this.f44908i);
                a aVar = a.this;
                d.a.i0.a.c2.f.p0.a.m(b.this, this.f44909a, this.f44910b, aVar.f44906g.f43183e, g2, aVar.f44905f);
                a aVar2 = a.this;
                b.this.w(this.f44911c, aVar2.f44906g, aVar2.f44908i, aVar2.f44907h);
            }

            @Override // d.a.i0.a.c2.f.p0.g.d
            public void b(int i2) {
                d.a.i0.a.e0.d.b("Api-NavigateTo", "check pages failed");
                k.B(false, this.f44909a.N().T());
                a.this.f44904e.o();
                if (d.a.i0.a.u.c.d.f44636c) {
                    Context i3 = b.this.i();
                    d.a.i0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                }
                a aVar = a.this;
                d.a.i0.a.c2.f.p0.a.k(b.this, aVar.f44905f);
            }
        }

        public a(f fVar, String str, d.a.i0.a.l1.b bVar, String str2, d.a.i0.a.h0.g.g gVar) {
            this.f44904e = fVar;
            this.f44905f = str;
            this.f44906g = bVar;
            this.f44907h = str2;
            this.f44908i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f44904e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                a.d f2 = d.a.i0.a.h0.t.a.f(activity);
                String b2 = f2.f42406a.b();
                if (d.a.i0.a.u.c.d.f44636c) {
                    Log.d("Api-NavigateTo", "slave webView id: " + b2);
                }
                e i2 = e.i();
                if (i2 == null) {
                    if (!d.a.i0.a.u.c.d.f44636c) {
                        b.this.d(this.f44905f, new d.a.i0.a.u.h.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f44904e.u();
                d.a.i0.a.c2.f.p0.g.g(i2, this.f44906g, b2, new C0845a(i2, b2, f2), this.f44907h);
            } else if (!d.a.i0.a.u.c.d.f44636c) {
                b.this.d(this.f44905f, new d.a.i0.a.u.h.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* renamed from: d.a.i0.a.u.e.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0846b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f44913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44914b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.l1.b f44915c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.g f44916d;

        public C0846b(a.d dVar, String str, d.a.i0.a.l1.b bVar, d.a.i0.a.h0.g.g gVar) {
            this.f44913a = dVar;
            this.f44914b = str;
            this.f44915c = bVar;
            this.f44916d = gVar;
        }

        @Override // d.a.i0.a.h0.t.a.e
        public void onReady() {
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
            }
            i.e(this.f44913a, this.f44914b);
            b.this.u(this.f44913a.f42406a, this.f44915c, this.f44916d, this.f44914b);
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    static {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + f44903d);
        }
    }

    public b(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void u(d.a.i0.a.p.e.b bVar, d.a.i0.a.l1.b bVar2, d.a.i0.a.h0.g.g gVar, String str) {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d.a.i0.a.c2.f.p0.a.e(bVar, bVar2, str);
        i.c(0, str);
        if (gVar.k() < f44903d) {
            d.a.i0.a.h0.g.f.G3(q0.n());
            g.b i2 = gVar.i("navigateTo");
            i2.n(d.a.i0.a.h0.g.g.f41902g, d.a.i0.a.h0.g.g.f41904i);
            i2.k("normal", bVar2).b();
            d.a.i0.a.v2.g.c(gVar, i());
            d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            i.a(str, bVar2);
            return;
        }
        c.u(gVar, bVar2, str, true);
    }

    public d.a.i0.a.u.h.b v(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-NavigateTo", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-NavigateTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String p = d.a.i0.a.c2.f.p0.a.p(jSONObject);
        if (TextUtils.isEmpty(p)) {
            d.a.i0.a.e0.d.b("Api-NavigateTo", "url is null");
            return new d.a.i0.a.u.h.b(202, "url is null");
        }
        f V = f.V();
        d.a.i0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.i0.a.e0.d.b("Api-NavigateTo", "manager is null");
            return new d.a.i0.a.u.h.b(1001, "manager is null");
        }
        d.a.i0.a.l1.b e2 = d.a.i0.a.l1.b.e(p, V.A());
        d.a.i0.a.j2.h.f(e2.f43183e, "0");
        if (!q0.b(V.s(), e2, false)) {
            String str2 = "page params error : path=" + e2.f43183e + " ; routePath=" + e2.f43186h;
            d.a.i0.a.e0.d.b("Api-NavigateTo", str2);
            return new d.a.i0.a.u.h.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && e2 != null && !TextUtils.isEmpty(e2.f43186h) && e.i() != null) {
            e.i().x0(optString, e2.f43186h);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(optString2).longValue());
            q.C(ubcFlowEvent);
        }
        String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            d.a.i0.a.e0.d.b("Api-NavigateTo", "cb is null");
            return new d.a.i0.a.u.h.b(202, "cb is null");
        } else if (d.a.i0.a.c2.f.g0.d.b().a(e2)) {
            d.a.i0.a.c2.f.g0.d.b().i("navigateTo", e2);
            d.a.i0.a.e0.d.b("Api-NavigateTo", "access to this page is prohibited");
            return new d.a.i0.a.u.h.b(1003, "access to this page is prohibited");
        } else {
            q0.X(new a(V, optString3, e2, uuid, W));
            return new d.a.i0.a.u.h.b(0);
        }
    }

    public final void w(a.d dVar, d.a.i0.a.l1.b bVar, d.a.i0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f42407b;
        HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.i0.a.h0.t.a.n(dVar, new C0846b(dVar, str, bVar, gVar));
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
        }
    }
}
