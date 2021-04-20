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
/* loaded from: classes2.dex */
public class c extends d.b.g0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46519f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46520g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46521h;
        public final /* synthetic */ d.b.g0.a.e0.l.f i;

        /* renamed from: d.b.g0.a.t.c.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0833a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f46522a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f46523b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f46524c;

            public C0833a(e eVar, String str, b.c cVar) {
                this.f46522a = eVar;
                this.f46523b = str;
                this.f46524c = cVar;
            }

            @Override // d.b.g0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f46521h);
                d.b.g0.a.c0.c.g("Api-RedirectTo", "check pages success");
                a.this.f46518e.C();
                a aVar = a.this;
                d.b.g0.a.t1.k.p0.a.l(c.this, this.f46522a, this.f46523b, aVar.f46520g.f44754a, null, aVar.f46519f);
                a aVar2 = a.this;
                c.this.t(this.f46524c, aVar2.f46520g, aVar2.i, aVar2.f46521h);
            }

            @Override // d.b.g0.a.t1.k.p0.g.d
            public void b(int i) {
                d.b.g0.a.c0.c.b("Api-RedirectTo", "check pages failed");
                a.this.f46518e.C();
                if (d.b.g0.a.t.b.d.f46321c) {
                    Context h2 = c.this.h();
                    d.b.g0.a.q1.b.f.d.f(h2, h2.getString(h.aiapps_open_pages_failed) + i).C();
                }
                a aVar = a.this;
                d.b.g0.a.t1.k.p0.a.j(c.this, aVar.f46519f);
            }
        }

        public a(f fVar, String str, d.b.g0.a.e1.b bVar, String str2, d.b.g0.a.e0.l.f fVar2) {
            this.f46518e = fVar;
            this.f46519f = str;
            this.f46520g = bVar;
            this.f46521h = str2;
            this.i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f46518e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c d2 = d.b.g0.a.e0.v.b.d(activity);
                String c2 = d2.f44696a.c();
                if (d.b.g0.a.t.b.d.f46321c) {
                    Log.d("Api-RedirectTo", "webview id: " + c2);
                }
                e y = e.y();
                if (y == null) {
                    if (!d.b.g0.a.t.b.d.f46321c) {
                        c.this.c(this.f46519f, new d.b.g0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f46518e.M();
                g.a(y, this.f46520g, c2, new C0833a(y, c2, d2), this.f46521h);
            } else if (!d.b.g0.a.t.b.d.f46321c) {
                c.this.c(this.f46519f, new d.b.g0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46526a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46527b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e1.b f46528c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.f f46529d;

        public b(c cVar, b.c cVar2, String str, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar) {
            this.f46526a = cVar2;
            this.f46527b = str;
            this.f46528c = bVar;
            this.f46529d = fVar;
        }

        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f46526a, this.f46527b);
            d.b.g0.a.t1.k.p0.a.d(this.f46526a.f44696a, this.f46528c, this.f46527b);
            c.s(this.f46529d, this.f46528c, this.f46527b, false);
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public c(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void s(d.b.g0.a.e0.l.f fVar, d.b.g0.a.e1.b bVar, String str, boolean z) {
        f.b i = fVar.i("redirectTo");
        i.n(0, 0);
        f.b k = i.k("normal", bVar);
        k.m(z ? 0 : fVar.k() - 2);
        k.b();
        int i2 = z ? 8 : 2;
        i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
        j.c(i2, str);
        j.a(str);
    }

    public final void t(b.c cVar, d.b.g0.a.e1.b bVar, d.b.g0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f44697b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.g0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
        }
    }

    public d.b.g0.a.t.e.b u(String str) {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-RedirectTo", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f46321c) {
                d.b.g0.a.c0.c.b("Api-RedirectTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.b.g0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.b.g0.a.c0.c.b("Api-RedirectTo", "url is null");
            return new d.b.g0.a.t.e.b(202, "url is null");
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("Api-RedirectTo", "manager is null");
            return new d.b.g0.a.t.e.b(1001, "manager is null");
        }
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(o, V.h());
        if (!k0.d(V.I(), c2, false)) {
            String str2 = "page params error : path=" + c2.f44754a + " ; routePath=" + c2.f44757d;
            d.b.g0.a.c0.c.b("Api-RedirectTo", str2);
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
            d.b.g0.a.c0.c.b("Api-RedirectTo", "cb is null");
            return new d.b.g0.a.t.e.b(202, "cb is null");
        } else if (d.b.g0.a.t1.k.g0.a.c().a(c2)) {
            d.b.g0.a.t1.k.g0.a.c().h("redirectTo", c2);
            d.b.g0.a.c0.c.b("Api-RedirectTo", "access to this page is prohibited");
            return new d.b.g0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.b.g0.a.t.e.b(0);
        }
    }
}
