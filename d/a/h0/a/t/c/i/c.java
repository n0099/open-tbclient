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
public class c extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44232f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44233g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44234h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44235i;

        /* renamed from: d.a.h0.a.t.c.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0792a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f44236a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f44237b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f44238c;

            public C0792a(e eVar, String str, b.c cVar) {
                this.f44236a = eVar;
                this.f44237b = str;
                this.f44238c = cVar;
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f44234h);
                d.a.h0.a.c0.c.g("Api-RedirectTo", "check pages success");
                a.this.f44231e.q();
                a aVar = a.this;
                d.a.h0.a.t1.k.p0.a.l(c.this, this.f44236a, this.f44237b, aVar.f44233g.f42392a, null, aVar.f44232f);
                a aVar2 = a.this;
                c.this.t(this.f44238c, aVar2.f44233g, aVar2.f44235i, aVar2.f44234h);
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void b(int i2) {
                d.a.h0.a.c0.c.b("Api-RedirectTo", "check pages failed");
                a.this.f44231e.q();
                if (d.a.h0.a.t.b.d.f44021c) {
                    Context h2 = c.this.h();
                    d.a.h0.a.q1.b.f.d.f(h2, h2.getString(h.aiapps_open_pages_failed) + i2).C();
                }
                a aVar = a.this;
                d.a.h0.a.t1.k.p0.a.j(c.this, aVar.f44232f);
            }
        }

        public a(f fVar, String str, d.a.h0.a.e1.b bVar, String str2, d.a.h0.a.e0.l.f fVar2) {
            this.f44231e = fVar;
            this.f44232f = str;
            this.f44233g = bVar;
            this.f44234h = str2;
            this.f44235i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f44231e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c d2 = d.a.h0.a.e0.v.b.d(activity);
                String c2 = d2.f42331a.c();
                if (d.a.h0.a.t.b.d.f44021c) {
                    Log.d("Api-RedirectTo", "webview id: " + c2);
                }
                e h2 = e.h();
                if (h2 == null) {
                    if (!d.a.h0.a.t.b.d.f44021c) {
                        c.this.c(this.f44232f, new d.a.h0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f44231e.w();
                g.a(h2, this.f44233g, c2, new C0792a(h2, c2, d2), this.f44234h);
            } else if (!d.a.h0.a.t.b.d.f44021c) {
                c.this.c(this.f44232f, new d.a.h0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f44240a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44241b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e1.b f44242c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.f f44243d;

        public b(c cVar, b.c cVar2, String str, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar) {
            this.f44240a = cVar2;
            this.f44241b = str;
            this.f44242c = bVar;
            this.f44243d = fVar;
        }

        @Override // d.a.h0.a.e0.v.b.d
        public void onReady() {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f44240a, this.f44241b);
            d.a.h0.a.t1.k.p0.a.d(this.f44240a.f42331a, this.f44242c, this.f44241b);
            c.s(this.f44243d, this.f44242c, this.f44241b, false);
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public c(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void s(d.a.h0.a.e0.l.f fVar, d.a.h0.a.e1.b bVar, String str, boolean z) {
        f.b i2 = fVar.i("redirectTo");
        i2.n(0, 0);
        f.b k = i2.k("normal", bVar);
        k.m(z ? 0 : fVar.k() - 2);
        k.b();
        int i3 = z ? 8 : 2;
        i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
        j.c(i3, str);
        j.a(str);
    }

    public final void t(b.c cVar, d.a.h0.a.e1.b bVar, d.a.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f42332b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.h0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
        }
    }

    public d.a.h0.a.t.e.b u(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-RedirectTo", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-RedirectTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.a.h0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.a.h0.a.c0.c.b("Api-RedirectTo", "url is null");
            return new d.a.h0.a.t.e.b(202, "url is null");
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        d.a.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.a.h0.a.c0.c.b("Api-RedirectTo", "manager is null");
            return new d.a.h0.a.t.e.b(1001, "manager is null");
        }
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(o, V.A());
        if (!k0.d(V.u(), c2, false)) {
            String str2 = "page params error : path=" + c2.f42392a + " ; routePath=" + c2.f42395d;
            d.a.h0.a.c0.c.b("Api-RedirectTo", str2);
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
            d.a.h0.a.c0.c.b("Api-RedirectTo", "cb is null");
            return new d.a.h0.a.t.e.b(202, "cb is null");
        } else if (d.a.h0.a.t1.k.g0.a.c().a(c2)) {
            d.a.h0.a.t1.k.g0.a.c().h("redirectTo", c2);
            d.a.h0.a.c0.c.b("Api-RedirectTo", "access to this page is prohibited");
            return new d.a.h0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.a.h0.a.t.e.b(0);
        }
    }
}
