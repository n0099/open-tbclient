package d.a.h0.a.t.c.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.v.b;
import d.a.h0.a.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.j1.i;
import d.a.h0.a.j1.j;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.k.p0.g;
import d.a.h0.a.z0.f;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44245f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44246g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44247h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44248i;

        /* renamed from: d.a.h0.a.t.c.i.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0793a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f44249a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f44250b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f44251c;

            public C0793a(e eVar, String str, b.c cVar) {
                this.f44249a = eVar;
                this.f44250b = str;
                this.f44251c = cVar;
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f44247h);
                d.a.h0.a.c0.c.g("Api-ReLaunch", "check pages success");
                a.this.f44244e.q();
                a aVar = a.this;
                d.a.h0.a.t1.k.p0.a.l(d.this, this.f44249a, this.f44250b, aVar.f44246g.f42392a, null, aVar.f44245f);
                d.a.h0.a.z1.e.q(this.f44250b);
                a aVar2 = a.this;
                d.this.t(this.f44251c, aVar2.f44246g, aVar2.f44248i, aVar2.f44247h);
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void b(int i2) {
                d.a.h0.a.c0.c.b("Api-ReLaunch", "check pages failed");
                a.this.f44244e.q();
                if (d.a.h0.a.t.b.d.f44021c) {
                    Context h2 = d.this.h();
                    d.a.h0.a.q1.b.f.d.f(h2, h2.getString(h.aiapps_open_pages_failed) + i2).C();
                }
                a aVar = a.this;
                d.a.h0.a.t1.k.p0.a.j(d.this, aVar.f44245f);
            }
        }

        public a(f fVar, String str, d.a.h0.a.e1.b bVar, String str2, d.a.h0.a.e0.l.f fVar2) {
            this.f44244e = fVar;
            this.f44245f = str;
            this.f44246g = bVar;
            this.f44247h = str2;
            this.f44248i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity = this.f44244e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c e2 = d.a.h0.a.e0.v.b.e(activity, d.a.h0.a.e0.v.a.a());
                String c2 = e2.f42331a.c();
                if (d.a.h0.a.t.b.d.f44021c) {
                    Log.d("Api-ReLaunch", "webview idx: " + c2);
                }
                e h2 = e.h();
                if (h2 == null) {
                    if (!d.a.h0.a.t.b.d.f44021c) {
                        d.this.c(this.f44245f, new d.a.h0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f44244e.w();
                g.a(h2, this.f44246g, c2, new C0793a(h2, c2, e2), this.f44247h);
            } else if (!d.a.h0.a.t.b.d.f44021c) {
                d.this.c(this.f44245f, new d.a.h0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f44253a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44254b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44255c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44256d;

        public b(d dVar, b.c cVar, String str, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar) {
            this.f44253a = cVar;
            this.f44254b = str;
            this.f44255c = bVar;
            this.f44256d = fVar;
        }

        @Override // d.a.h0.a.e0.v.b.d
        public void onReady() {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f44253a, this.f44254b);
            d.a.h0.a.t1.k.p0.a.d(this.f44253a.f42331a, this.f44255c, this.f44254b);
            d.s(this.f44256d, this.f44255c, this.f44254b);
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements f.a {
        @Override // d.a.h0.a.e0.l.f.a
        public void a(@NonNull Fragment fragment) {
        }

        @Override // d.a.h0.a.e0.l.f.a
        public void b(@NonNull Fragment fragment) {
            if (fragment instanceof d.a.h0.a.e0.l.e) {
                ((d.a.h0.a.e0.l.e) fragment).P0 = true;
            }
        }
    }

    public d(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void s(d.a.h0.a.e0.l.f fVar, d.a.h0.a.e1.b bVar, String str) {
        if (bVar != null) {
            d.a.h0.a.c0.c.g("Api-ReLaunch", "doReLaunch page=" + bVar.f42392a + " routePage=" + bVar.f42395d);
        }
        c cVar = new c();
        fVar.g(cVar);
        f.b i2 = fVar.i("reLaunch");
        i2.n(0, 0);
        i2.f();
        i2.k("normal", bVar).b();
        fVar.p(cVar);
        i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
        j.c(3, str);
        j.a(str);
    }

    public final void t(b.c cVar, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f42332b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.h0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute end.");
        }
    }

    public d.a.h0.a.t.e.b u(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-ReLaunch", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-ReLaunch", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.a.h0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.a.h0.a.c0.c.b("Api-ReLaunch", "url is null");
            return new d.a.h0.a.t.e.b(202, "url is null");
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        d.a.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.a.h0.a.c0.c.b("Api-ReLaunch", "manager is null");
            return new d.a.h0.a.t.e.b(1001, "manager is null");
        }
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(o, V.A());
        if (!k0.d(V.u(), c2, true)) {
            String str2 = "page params error : path=" + c2.f42392a + " ; routePath=" + c2.f42395d;
            d.a.h0.a.c0.c.b("Api-ReLaunch", str2);
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
            d.a.h0.a.c0.c.b("Api-ReLaunch", "cb is null");
            return new d.a.h0.a.t.e.b(202, "cb is null");
        } else if (d.a.h0.a.t1.k.g0.a.c().a(c2)) {
            d.a.h0.a.t1.k.g0.a.c().h("reLaunch", c2);
            d.a.h0.a.c0.c.b("Api-ReLaunch", "access to this page is prohibited");
            return new d.a.h0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.a.h0.a.t.e.b(0);
        }
    }
}
