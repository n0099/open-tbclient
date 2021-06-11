package d.a.l0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.p0.g;
import d.a.l0.a.g1.f;
import d.a.l0.a.h;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.h0.t.a;
import d.a.l0.a.r1.i;
import d.a.l0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.l0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48769f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f48770g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48771h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f48772i;

        /* renamed from: d.a.l0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0914a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f48773a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48774b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f48775c;

            public C0914a(e eVar, String str, a.d dVar) {
                this.f48773a = eVar;
                this.f48774b = str;
                this.f48775c = dVar;
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void a(String str) {
                i.d(a.this.f48771h);
                d.a.l0.a.e0.d.g("Api-RedirectTo", "check pages success");
                a.this.f48768e.o();
                a aVar = a.this;
                d.a.l0.a.c2.f.p0.a.m(c.this, this.f48773a, this.f48774b, aVar.f48770g.f47033e, null, aVar.f48769f);
                a aVar2 = a.this;
                c.this.v(this.f48775c, aVar2.f48770g, aVar2.f48772i, aVar2.f48771h);
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void b(int i2) {
                d.a.l0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                a.this.f48768e.o();
                if (d.a.l0.a.u.c.d.f48486c) {
                    Context i3 = c.this.i();
                    d.a.l0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                }
                a aVar = a.this;
                d.a.l0.a.c2.f.p0.a.k(c.this, aVar.f48769f);
            }
        }

        public a(f fVar, String str, d.a.l0.a.l1.b bVar, String str2, d.a.l0.a.h0.g.g gVar) {
            this.f48768e = fVar;
            this.f48769f = str;
            this.f48770g = bVar;
            this.f48771h = str2;
            this.f48772i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.a.u.c.d.f48486c) {
                Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f48768e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                a.d f2 = d.a.l0.a.h0.t.a.f(activity);
                String b2 = f2.f46256a.b();
                if (d.a.l0.a.u.c.d.f48486c) {
                    Log.d("Api-RedirectTo", "webview id: " + b2);
                }
                e i2 = e.i();
                if (i2 == null) {
                    if (!d.a.l0.a.u.c.d.f48486c) {
                        c.this.d(this.f48769f, new d.a.l0.a.u.h.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f48768e.u();
                d.a.l0.a.c2.f.p0.g.g(i2, this.f48770g, b2, new C0914a(i2, b2, f2), this.f48771h);
            } else if (!d.a.l0.a.u.c.d.f48486c) {
                c.this.d(this.f48769f, new d.a.l0.a.u.h.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f48777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f48779c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f48780d;

        public b(c cVar, a.d dVar, String str, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar) {
            this.f48777a = dVar;
            this.f48778b = str;
            this.f48779c = bVar;
            this.f48780d = gVar;
        }

        @Override // d.a.l0.a.h0.t.a.e
        public void onReady() {
            if (d.a.l0.a.u.c.d.f48486c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
            }
            i.e(this.f48777a, this.f48778b);
            d.a.l0.a.c2.f.p0.a.e(this.f48777a.f46256a, this.f48779c, this.f48778b);
            c.u(this.f48780d, this.f48779c, this.f48778b, false);
            if (d.a.l0.a.u.c.d.f48486c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public c(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static boolean t() {
        SwanAppActivity x;
        e Q = e.Q();
        return Q == null || (x = Q.x()) == null || x.isFinishing() || x.isDestroyed();
    }

    public static void u(d.a.l0.a.h0.g.g gVar, d.a.l0.a.l1.b bVar, String str, boolean z) {
        SwanAppActivity x;
        if (t() || (x = d.a.l0.a.a2.d.g().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        i.c(z ? 8 : 2, str);
        d.a.l0.a.h0.g.f.G3(q0.n());
        g.b i2 = gVar.i("redirectTo");
        i2.n(0, 0);
        g.b k = i2.k("normal", bVar);
        k.m(z ? 0 : gVar.k() - 2);
        k.b();
        d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void v(a.d dVar, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f46257b;
        HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.l0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
        }
    }

    public d.a.l0.a.u.h.b w(String str) {
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-RedirectTo", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.l0.a.u.c.d.f48486c) {
                d.a.l0.a.e0.d.b("Api-RedirectTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String p = d.a.l0.a.c2.f.p0.a.p(jSONObject);
        if (TextUtils.isEmpty(p)) {
            d.a.l0.a.e0.d.b("Api-RedirectTo", "url is null");
            return new d.a.l0.a.u.h.b(202, "url is null");
        }
        f V = f.V();
        d.a.l0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.l0.a.e0.d.b("Api-RedirectTo", "manager is null");
            return new d.a.l0.a.u.h.b(1001, "manager is null");
        }
        d.a.l0.a.l1.b e2 = d.a.l0.a.l1.b.e(p, V.A());
        d.a.l0.a.j2.h.f(e2.f47033e, "2");
        if (!q0.b(V.s(), e2, false)) {
            String str2 = "page params error : path=" + e2.f47033e + " ; routePath=" + e2.f47036h;
            d.a.l0.a.e0.d.b("Api-RedirectTo", str2);
            return new d.a.l0.a.u.h.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && e2 != null && !TextUtils.isEmpty(e2.f47036h) && e.i() != null) {
            e.i().x0(optString, e2.f47036h);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
            ubcFlowEvent.h(Long.valueOf(optString2).longValue());
            q.C(ubcFlowEvent);
        }
        String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            d.a.l0.a.e0.d.b("Api-RedirectTo", "cb is null");
            return new d.a.l0.a.u.h.b(202, "cb is null");
        } else if (d.a.l0.a.c2.f.g0.d.b().a(e2)) {
            d.a.l0.a.c2.f.g0.d.b().i("redirectTo", e2);
            d.a.l0.a.e0.d.b("Api-RedirectTo", "access to this page is prohibited");
            return new d.a.l0.a.u.h.b(1003, "access to this page is prohibited");
        } else {
            q0.X(new a(V, optString3, e2, uuid, W));
            return new d.a.l0.a.u.h.b(0);
        }
    }
}
