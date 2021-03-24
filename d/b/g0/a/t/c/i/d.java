package d.b.g0.a.t.c.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.v.b;
import d.b.g0.a.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.i;
import d.b.g0.a.j1.j;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.k.p0.g;
import d.b.g0.a.z0.f;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46140h;
        public final /* synthetic */ d.b.g0.a.e0.l.f i;

        /* renamed from: d.b.g0.a.t.c.i.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0821a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f46141a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f46142b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f46143c;

            public C0821a(e eVar, String str, b.c cVar) {
                this.f46141a = eVar;
                this.f46142b = str;
                this.f46143c = cVar;
            }

            @Override // d.b.g0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f46140h);
                d.b.g0.a.c0.c.g("Api-ReLaunch", "check pages success");
                a.this.f46137e.C();
                a aVar = a.this;
                d.b.g0.a.t1.k.p0.a.l(d.this, this.f46141a, this.f46142b, aVar.f46139g.f44361a, null, aVar.f46138f);
                d.b.g0.a.z1.e.q(this.f46142b);
                a aVar2 = a.this;
                d.this.t(this.f46143c, aVar2.f46139g, aVar2.i, aVar2.f46140h);
            }

            @Override // d.b.g0.a.t1.k.p0.g.d
            public void b(int i) {
                d.b.g0.a.c0.c.b("Api-ReLaunch", "check pages failed");
                a.this.f46137e.C();
                if (d.b.g0.a.t.b.d.f45928c) {
                    Context h2 = d.this.h();
                    d.b.g0.a.q1.b.f.d.f(h2, h2.getString(h.aiapps_open_pages_failed) + i).C();
                }
                a aVar = a.this;
                d.b.g0.a.t1.k.p0.a.j(d.this, aVar.f46138f);
            }
        }

        public a(f fVar, String str, d.b.g0.a.e1.b bVar, String str2, d.b.g0.a.e0.l.f fVar2) {
            this.f46137e = fVar;
            this.f46138f = str;
            this.f46139g = bVar;
            this.f46140h = str2;
            this.i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity = this.f46137e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c e2 = d.b.g0.a.e0.v.b.e(activity, d.b.g0.a.e0.v.a.a());
                String c2 = e2.f44303a.c();
                if (d.b.g0.a.t.b.d.f45928c) {
                    Log.d("Api-ReLaunch", "webview idx: " + c2);
                }
                e y = e.y();
                if (y == null) {
                    if (!d.b.g0.a.t.b.d.f45928c) {
                        d.this.c(this.f46138f, new d.b.g0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f46137e.M();
                g.a(y, this.f46139g, c2, new C0821a(y, c2, e2), this.f46140h);
            } else if (!d.b.g0.a.t.b.d.f45928c) {
                d.this.c(this.f46138f, new d.b.g0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46145a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46146b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46147c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46148d;

        public b(d dVar, b.c cVar, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46145a = cVar;
            this.f46146b = str;
            this.f46147c = bVar;
            this.f46148d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (d.b.g0.a.t.b.d.f45928c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f46145a, this.f46146b);
            d.b.g0.a.t1.k.p0.a.d(this.f46145a.f44303a, this.f46147c, this.f46146b);
            d.s(this.f46148d, this.f46147c, this.f46146b);
            if (d.b.g0.a.t.b.d.f45928c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements f.a {
        @Override // d.b.g0.a.e0.l.f.a
        public void a(@NonNull Fragment fragment) {
        }

        @Override // d.b.g0.a.e0.l.f.a
        public void b(@NonNull Fragment fragment) {
            if (fragment instanceof d.b.g0.a.e0.l.e) {
                ((d.b.g0.a.e0.l.e) fragment).P0 = true;
            }
        }
    }

    public d(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void s(d.b.g0.a.e0.l.f fVar, d.b.g0.a.e1.b bVar, String str) {
        if (bVar != null) {
            d.b.g0.a.c0.c.g("Api-ReLaunch", "doReLaunch page=" + bVar.f44361a + " routePage=" + bVar.f44364d);
        }
        c cVar = new c();
        fVar.g(cVar);
        f.b i = fVar.i("reLaunch");
        i.n(0, 0);
        i.f();
        i.k("normal", bVar).b();
        fVar.p(cVar);
        i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
        j.c(3, str);
        j.a(str);
    }

    public final void t(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44304b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute end.");
        }
    }

    public d.b.g0.a.t.e.b u(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-ReLaunch", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-ReLaunch", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.b.g0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.b.g0.a.c0.c.b("Api-ReLaunch", "url is null");
            return new d.b.g0.a.t.e.b(202, "url is null");
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("Api-ReLaunch", "manager is null");
            return new d.b.g0.a.t.e.b(1001, "manager is null");
        }
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(o, V.h());
        if (!k0.d(V.I(), c2, true)) {
            String str2 = "page params error : path=" + c2.f44361a + " ; routePath=" + c2.f44364d;
            d.b.g0.a.c0.c.b("Api-ReLaunch", str2);
            return new d.b.g0.a.t.e.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && c2 != null && !TextUtils.isEmpty(c2.f44364d) && e.y() != null) {
            e.y().r0(optString, c2.f44364d);
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
            d.b.g0.a.c0.c.b("Api-ReLaunch", "cb is null");
            return new d.b.g0.a.t.e.b(202, "cb is null");
        } else if (d.b.g0.a.t1.k.g0.a.c().a(c2)) {
            d.b.g0.a.t1.k.g0.a.c().h("reLaunch", c2);
            d.b.g0.a.c0.c.b("Api-ReLaunch", "access to this page is prohibited");
            return new d.b.g0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.b.g0.a.t.e.b(0);
        }
    }
}
