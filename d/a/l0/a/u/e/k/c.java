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
        public final /* synthetic */ f f45094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45095f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f45096g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45097h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f45098i;

        /* renamed from: d.a.l0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0858a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f45099a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f45100b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f45101c;

            public C0858a(e eVar, String str, a.d dVar) {
                this.f45099a = eVar;
                this.f45100b = str;
                this.f45101c = dVar;
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void a(String str) {
                i.d(a.this.f45097h);
                d.a.l0.a.e0.d.g("Api-RedirectTo", "check pages success");
                a.this.f45094e.o();
                a aVar = a.this;
                d.a.l0.a.c2.f.p0.a.m(c.this, this.f45099a, this.f45100b, aVar.f45096g.f43357e, null, aVar.f45095f);
                a aVar2 = a.this;
                c.this.v(this.f45101c, aVar2.f45096g, aVar2.f45098i, aVar2.f45097h);
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void b(int i2) {
                d.a.l0.a.e0.d.b("Api-RedirectTo", "check pages failed");
                a.this.f45094e.o();
                if (d.a.l0.a.u.c.d.f44812c) {
                    Context i3 = c.this.i();
                    d.a.l0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                }
                a aVar = a.this;
                d.a.l0.a.c2.f.p0.a.k(c.this, aVar.f45095f);
            }
        }

        public a(f fVar, String str, d.a.l0.a.l1.b bVar, String str2, d.a.l0.a.h0.g.g gVar) {
            this.f45094e = fVar;
            this.f45095f = str;
            this.f45096g = bVar;
            this.f45097h = str2;
            this.f45098i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.a.u.c.d.f44812c) {
                Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f45094e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                a.d f2 = d.a.l0.a.h0.t.a.f(activity);
                String b2 = f2.f42580a.b();
                if (d.a.l0.a.u.c.d.f44812c) {
                    Log.d("Api-RedirectTo", "webview id: " + b2);
                }
                e i2 = e.i();
                if (i2 == null) {
                    if (!d.a.l0.a.u.c.d.f44812c) {
                        c.this.d(this.f45095f, new d.a.l0.a.u.h.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f45094e.u();
                d.a.l0.a.c2.f.p0.g.g(i2, this.f45096g, b2, new C0858a(i2, b2, f2), this.f45097h);
            } else if (!d.a.l0.a.u.c.d.f44812c) {
                c.this.d(this.f45095f, new d.a.l0.a.u.h.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f45103a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45104b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f45105c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f45106d;

        public b(c cVar, a.d dVar, String str, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar) {
            this.f45103a = dVar;
            this.f45104b = str;
            this.f45105c = bVar;
            this.f45106d = gVar;
        }

        @Override // d.a.l0.a.h0.t.a.e
        public void onReady() {
            if (d.a.l0.a.u.c.d.f44812c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
            }
            i.e(this.f45103a, this.f45104b);
            d.a.l0.a.c2.f.p0.a.e(this.f45103a.f42580a, this.f45105c, this.f45104b);
            c.u(this.f45106d, this.f45105c, this.f45104b, false);
            if (d.a.l0.a.u.c.d.f44812c) {
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
        boolean z = dVar != null && dVar.f42581b;
        HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.l0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
        }
    }

    public d.a.l0.a.u.h.b w(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-RedirectTo", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.l0.a.u.c.d.f44812c) {
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
        d.a.l0.a.j2.h.f(e2.f43357e, "2");
        if (!q0.b(V.s(), e2, false)) {
            String str2 = "page params error : path=" + e2.f43357e + " ; routePath=" + e2.f43360h;
            d.a.l0.a.e0.d.b("Api-RedirectTo", str2);
            return new d.a.l0.a.u.h.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && e2 != null && !TextUtils.isEmpty(e2.f43360h) && e.i() != null) {
            e.i().x0(optString, e2.f43360h);
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
