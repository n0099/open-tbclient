package d.a.l0.a.u.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
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
public class d extends d.a.l0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45107e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45108f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f45109g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45110h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f45111i;

        /* renamed from: d.a.l0.a.u.e.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0859a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f45112a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f45113b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.d f45114c;

            public C0859a(e eVar, String str, a.d dVar) {
                this.f45112a = eVar;
                this.f45113b = str;
                this.f45114c = dVar;
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void a(String str) {
                i.d(a.this.f45110h);
                d.a.l0.a.e0.d.g("Api-ReLaunch", "check pages success");
                a.this.f45107e.o();
                a aVar = a.this;
                d.a.l0.a.c2.f.p0.a.m(d.this, this.f45112a, this.f45113b, aVar.f45109g.f43357e, null, aVar.f45108f);
                d.a.l0.a.j2.e.t(this.f45113b);
                a aVar2 = a.this;
                d.this.u(this.f45114c, aVar2.f45109g, aVar2.f45111i, aVar2.f45110h);
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void b(int i2) {
                d.a.l0.a.e0.d.b("Api-ReLaunch", "check pages failed");
                a.this.f45107e.o();
                if (d.a.l0.a.u.c.d.f44812c) {
                    Context i3 = d.this.i();
                    d.a.l0.a.z1.b.f.e.g(i3, i3.getString(h.aiapps_open_pages_failed) + i2).F();
                }
                a aVar = a.this;
                d.a.l0.a.c2.f.p0.a.k(d.this, aVar.f45108f);
            }
        }

        public a(f fVar, String str, d.a.l0.a.l1.b bVar, String str2, d.a.l0.a.h0.g.g gVar) {
            this.f45107e = fVar;
            this.f45108f = str;
            this.f45109g = bVar;
            this.f45110h = str2;
            this.f45111i = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity = this.f45107e.getActivity();
            if (activity != null && !activity.isFinishing()) {
                a.d g2 = d.a.l0.a.h0.t.a.g(activity, true);
                String b2 = g2.f42580a.b();
                if (d.a.l0.a.u.c.d.f44812c) {
                    Log.d("Api-ReLaunch", "webview idx: " + b2);
                }
                e i2 = e.i();
                if (i2 == null) {
                    if (!d.a.l0.a.u.c.d.f44812c) {
                        d.this.d(this.f45108f, new d.a.l0.a.u.h.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                this.f45107e.u();
                d.a.l0.a.c2.f.p0.g.g(i2, this.f45109g, b2, new C0859a(i2, b2, g2), this.f45110h);
            } else if (!d.a.l0.a.u.c.d.f44812c) {
                d.this.d(this.f45108f, new d.a.l0.a.u.h.b(1001, "swan activity is null"));
            } else {
                throw new RuntimeException("swan activity is null");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f45116a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l1.b f45118c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.g.g f45119d;

        public b(d dVar, a.d dVar2, String str, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar) {
            this.f45116a = dVar2;
            this.f45117b = str;
            this.f45118c = bVar;
            this.f45119d = gVar;
        }

        @Override // d.a.l0.a.h0.t.a.e
        public void onReady() {
            if (d.a.l0.a.u.c.d.f44812c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
            }
            i.e(this.f45116a, this.f45117b);
            d.a.l0.a.c2.f.p0.a.e(this.f45116a.f42580a, this.f45118c, this.f45117b);
            d.t(this.f45119d, this.f45118c, this.f45117b);
            if (d.a.l0.a.u.c.d.f44812c) {
                Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady end.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements g.a {
        @Override // d.a.l0.a.h0.g.g.a
        public void a(@NonNull Fragment fragment) {
        }

        @Override // d.a.l0.a.h0.g.g.a
        public void b(@NonNull Fragment fragment) {
            if (fragment instanceof d.a.l0.a.h0.g.f) {
                ((d.a.l0.a.h0.g.f) fragment).P0 = true;
            }
        }
    }

    public d(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void t(d.a.l0.a.h0.g.g gVar, d.a.l0.a.l1.b bVar, String str) {
        if (bVar != null) {
            d.a.l0.a.e0.d.g("Api-ReLaunch", "doReLaunch page=" + bVar.f43357e + " routePage=" + bVar.f43360h);
        }
        SwanAppActivity x = d.a.l0.a.a2.d.g().x();
        if (x == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        c cVar = new c();
        i.c(3, str);
        d.a.l0.a.h0.g.f.G3(q0.n());
        gVar.g(cVar);
        g.b i2 = gVar.i("reLaunch");
        i2.n(0, 0);
        i2.f();
        i2.k("normal", bVar).b();
        gVar.p(cVar);
        d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
        i.a(str, bVar);
    }

    public final void u(a.d dVar, d.a.l0.a.l1.b bVar, d.a.l0.a.h0.g.g gVar, String str) {
        boolean z = dVar != null && dVar.f42581b;
        HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_pre_load_slave_check"));
        q.A("preload", z ? "1" : "0");
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        d.a.l0.a.h0.t.a.n(dVar, new b(this, dVar, str, bVar, gVar));
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute end.");
        }
    }

    public d.a.l0.a.u.h.b v(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-ReLaunch", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.l0.a.u.c.d.f44812c) {
                d.a.l0.a.e0.d.b("Api-ReLaunch", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String p = d.a.l0.a.c2.f.p0.a.p(jSONObject);
        if (TextUtils.isEmpty(p)) {
            d.a.l0.a.e0.d.b("Api-ReLaunch", "url is null");
            return new d.a.l0.a.u.h.b(202, "url is null");
        }
        f V = f.V();
        d.a.l0.a.h0.g.g W = V.W();
        if (W == null) {
            d.a.l0.a.e0.d.b("Api-ReLaunch", "manager is null");
            return new d.a.l0.a.u.h.b(1001, "manager is null");
        }
        d.a.l0.a.l1.b e2 = d.a.l0.a.l1.b.e(p, V.A());
        d.a.l0.a.j2.h.f(e2.f43357e, "3");
        if (!q0.b(V.s(), e2, true)) {
            String str2 = "page params error : path=" + e2.f43357e + " ; routePath=" + e2.f43360h;
            d.a.l0.a.e0.d.b("Api-ReLaunch", str2);
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
            d.a.l0.a.e0.d.b("Api-ReLaunch", "cb is null");
            return new d.a.l0.a.u.h.b(202, "cb is null");
        } else if (d.a.l0.a.c2.f.g0.d.b().a(e2)) {
            d.a.l0.a.c2.f.g0.d.b().i("reLaunch", e2);
            d.a.l0.a.e0.d.b("Api-ReLaunch", "access to this page is prohibited");
            return new d.a.l0.a.u.h.b(1003, "access to this page is prohibited");
        } else {
            q0.X(new a(V, optString3, e2, uuid, W));
            return new d.a.l0.a.u.h.b(0);
        }
    }
}
