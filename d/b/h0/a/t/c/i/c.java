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
import d.b.h0.a.h;
import d.b.h0.a.i2.k0;
import d.b.h0.a.j1.i;
import d.b.h0.a.j1.j;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.k.p0.g;
import d.b.h0.a.z0.f;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46848f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f46849g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46850h;
        public final /* synthetic */ d.b.h0.a.e0.l.f i;

        /* renamed from: d.b.h0.a.t.c.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0853a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f46851a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f46852b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b.c f46853c;

            public C0853a(e eVar, String str, b.c cVar) {
                this.f46851a = eVar;
                this.f46852b = str;
                this.f46853c = cVar;
            }

            @Override // d.b.h0.a.t1.k.p0.g.d
            public void a(String str) {
                j.d(a.this.f46850h);
                d.b.h0.a.c0.c.g("Api-RedirectTo", "check pages success");
                a.this.f46847e.C();
                a aVar = a.this;
                d.b.h0.a.t1.k.p0.a.l(c.this, this.f46851a, this.f46852b, aVar.f46849g.f45083a, null, aVar.f46848f);
                a aVar2 = a.this;
                c.this.t(this.f46853c, aVar2.f46849g, aVar2.i, aVar2.f46850h);
            }

            @Override // d.b.h0.a.t1.k.p0.g.d
            public void b(int i) {
                d.b.h0.a.c0.c.b("Api-RedirectTo", "check pages failed");
                a.this.f46847e.C();
                if (d.b.h0.a.t.b.d.f46650c) {
                    Context h2 = c.this.h();
                    d.b.h0.a.q1.b.f.d.f(h2, h2.getString(h.aiapps_open_pages_failed) + i).C();
                }
                a aVar = a.this;
                d.b.h0.a.t1.k.p0.a.j(c.this, aVar.f46848f);
            }
        }

        public a(f fVar, String str, d.b.h0.a.e1.b bVar, String str2, d.b.h0.a.e0.l.f fVar2) {
            this.f46847e = fVar;
            this.f46848f = str;
            this.f46849g = bVar;
            this.f46850h = str2;
            this.i = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
            }
            SwanAppActivity activity = this.f46847e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.c d2 = d.b.h0.a.e0.v.b.d(activity);
                String c2 = d2.f45025a.c();
                if (d.b.h0.a.t.b.d.f46650c) {
                    Log.d("Api-RedirectTo", "webview id: " + c2);
                }
                e y = e.y();
                if (y == null) {
                    if (!d.b.h0.a.t.b.d.f46650c) {
                        c.this.c(this.f46848f, new d.b.h0.a.t.e.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f46847e.M();
                g.a(y, this.f46849g, c2, new C0853a(y, c2, d2), this.f46850h);
            } else if (!d.b.h0.a.t.b.d.f46650c) {
                c.this.c(this.f46848f, new d.b.h0.a.t.e.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f46855a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46856b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e1.b f46857c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.f f46858d;

        public b(c cVar, b.c cVar2, String str, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar) {
            this.f46855a = cVar2;
            this.f46856b = str;
            this.f46857c = bVar;
            this.f46858d = fVar;
        }

        @Override // d.b.h0.a.e0.v.b.d
        public void onReady() {
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
            }
            j.e(this.f46855a, this.f46856b);
            d.b.h0.a.t1.k.p0.a.d(this.f46855a.f45025a, this.f46857c, this.f46856b);
            c.s(this.f46858d, this.f46857c, this.f46856b, false);
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    public c(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void s(d.b.h0.a.e0.l.f fVar, d.b.h0.a.e1.b bVar, String str, boolean z) {
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

    public final void t(b.c cVar, d.b.h0.a.e1.b bVar, d.b.h0.a.e0.l.f fVar, String str) {
        boolean z = cVar != null && cVar.f45026b;
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_pre_load_slave_check"));
        p.y("preload", z ? "1" : "0");
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.b.h0.a.e0.v.b.j(cVar, new b(this, cVar, str, bVar, fVar));
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
        }
    }

    public d.b.h0.a.t.e.b u(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-RedirectTo", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-RedirectTo", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String o = d.b.h0.a.t1.k.p0.a.o(jSONObject);
        if (TextUtils.isEmpty(o)) {
            d.b.h0.a.c0.c.b("Api-RedirectTo", "url is null");
            return new d.b.h0.a.t.e.b(202, "url is null");
        }
        d.b.h0.a.z0.f V = d.b.h0.a.z0.f.V();
        d.b.h0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.h0.a.c0.c.b("Api-RedirectTo", "manager is null");
            return new d.b.h0.a.t.e.b(1001, "manager is null");
        }
        d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(o, V.h());
        if (!k0.d(V.I(), c2, false)) {
            String str2 = "page params error : path=" + c2.f45083a + " ; routePath=" + c2.f45086d;
            d.b.h0.a.c0.c.b("Api-RedirectTo", str2);
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
            d.b.h0.a.c0.c.b("Api-RedirectTo", "cb is null");
            return new d.b.h0.a.t.e.b(202, "cb is null");
        } else if (d.b.h0.a.t1.k.g0.a.c().a(c2)) {
            d.b.h0.a.t1.k.g0.a.c().h("redirectTo", c2);
            d.b.h0.a.c0.c.b("Api-RedirectTo", "access to this page is prohibited");
            return new d.b.h0.a.t.e.b(1003, "access to this page is prohibited");
        } else {
            k0.T(new a(V, optString3, c2, uuid, W));
            return new d.b.h0.a.t.e.b(0);
        }
    }
}
