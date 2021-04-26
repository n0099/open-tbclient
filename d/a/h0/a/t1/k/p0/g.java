package d.a.h0.a.t1.k.p0;

import android.text.TextUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.e0.p.o.a;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.u0.d;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public static class a implements d.a.h0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44621a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f44622b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44623c;

        /* renamed from: d.a.h0.a.t1.k.p0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0814a implements Runnable {
            public RunnableC0814a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f44622b.a(aVar.f44623c);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44625e;

            public b(int i2) {
                this.f44625e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f44622b.b(this.f44625e);
            }
        }

        public a(String str, d dVar, String str2) {
            this.f44621a = str;
            this.f44622b = dVar;
            this.f44623c = str2;
        }

        @Override // d.a.h0.a.e0.p.b
        public void a(int i2) {
            k0.X(new b(i2));
        }

        @Override // d.a.h0.a.e0.p.b
        public void b() {
            d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
            if (h2 != null) {
                h2.s0(this.f44621a, true);
            }
            k0.X(new RunnableC0814a());
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f44627a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44628b;

        public b(d dVar, String str) {
            this.f44627a = dVar;
            this.f44628b = str;
        }

        @Override // d.a.h0.a.e0.p.o.a.b
        public void a() {
            this.f44627a.b(2113);
        }

        @Override // d.a.h0.a.e0.p.o.a.b
        public void onError() {
            this.f44627a.b(2113);
        }

        @Override // d.a.h0.a.e0.p.o.a.b
        public void onSuccess() {
            this.f44627a.a(this.f44628b);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.a.h0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44629a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f44630b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44631c;

        public c(String str, d dVar, String str2) {
            this.f44629a = str;
            this.f44630b = dVar;
            this.f44631c = str2;
        }

        @Override // d.a.h0.a.e0.p.b
        public void a(int i2) {
            this.f44630b.b(i2);
        }

        @Override // d.a.h0.a.e0.p.b
        public void b() {
            d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
            if (h2 != null) {
                h2.s0(this.f44629a, true);
            }
            this.f44630b.a(this.f44631c);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void b(int i2);
    }

    public static void a(d.a.h0.a.r1.e eVar, d.a.h0.a.e1.b bVar, String str, d dVar, String str2) {
        if (dVar == null) {
            return;
        }
        if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f42392a) && !TextUtils.isEmpty(bVar.f42395d)) {
            String str3 = bVar.f42395d;
            String P = eVar.P(bVar.f42392a);
            boolean d0 = eVar.d0(str3);
            if (!d.a.h0.a.c0.d.d.e.d() && !d.a.h0.a.m1.a.a.C()) {
                if (d.a.h0.a.l1.b.a.d(bVar.f42392a)) {
                    dVar.a(str);
                    return;
                }
                if (d0) {
                    if (d.a.h0.a.u0.d.p(eVar.f43823f, eVar.W())) {
                        dVar.a(str);
                        return;
                    } else if (eVar.a0()) {
                        b(eVar, str3, str, dVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(P)) {
                    dVar.b(2111);
                    return;
                } else if (eVar.f0(P)) {
                    dVar.a(str);
                    return;
                } else if (eVar.h0(P) && eVar.g0(P)) {
                    dVar.a(str);
                    eVar.s0(P, true);
                    return;
                } else {
                    String E = eVar.E(P);
                    if (TextUtils.isEmpty(E)) {
                        dVar.b(2112);
                        return;
                    }
                    boolean c0 = eVar.c0(str3);
                    if (!d.a.h0.a.u0.d.p(eVar.f43823f, eVar.W()) && !c0) {
                        b(eVar, str3, str, dVar, str2);
                        return;
                    }
                    d.a.h0.l.l.k.f fVar = new d.a.h0.l.l.k.f(eVar.f43823f, eVar.W(), E, 0);
                    d.a.h0.a.e0.p.q.a aVar = new d.a.h0.a.e0.p.q.a(eVar.f43823f, eVar.W(), new a(P, dVar, str));
                    HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                    p.A(new UbcFlowEvent("na_start_sub_package_download"));
                    p.y("sub_state", "1");
                    d.a.h0.l.c.d(fVar, aVar);
                    return;
                }
            } else if (!d0 && TextUtils.isEmpty(P)) {
                dVar.b(2111);
                return;
            } else {
                dVar.a(str);
                return;
            }
        }
        dVar.b(2110);
    }

    public static void b(d.a.h0.a.r1.e eVar, String str, String str2, d dVar, String str3) {
        if (dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        p.A(new UbcFlowEvent("na_start_sub_package_download"));
        p.y("sub_state", "1");
        d.a.h0.l.l.k.c cVar = new d.a.h0.l.l.k.c(eVar.f43823f, d.a.h0.a.r1.d.e().j());
        cVar.n(k0.o(eVar.W()));
        cVar.q(str);
        d.a.h0.l.c.a(cVar, new d.a.h0.a.e0.p.o.a(eVar.f43823f, new b(dVar, str2)));
    }

    public static void c(String str, String str2, String str3, String str4, String str5, d dVar) {
        if (dVar == null) {
            return;
        }
        d.a.h0.l.c.d(new d.a.h0.l.l.k.f(str, str2, str4, 0), new d.a.h0.a.e0.p.q.a(str, str2, new c(str3, dVar, str5)));
    }

    public static boolean d(d.a.h0.a.y0.e.b bVar, d.g gVar) {
        if (gVar == null) {
            return false;
        }
        return e(bVar, gVar.f44733b);
    }

    public static boolean e(d.a.h0.a.y0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        SwanAppConfigData.a aVar;
        if (bVar != null && !TextUtils.isEmpty(bVar.b0()) && !d.a.h0.a.c0.d.d.e.d()) {
            String d2 = i0.d(bVar.b0());
            if (!TextUtils.isEmpty(d2) && d2.startsWith(File.separator)) {
                d2 = d2.substring(1);
            }
            if (swanAppConfigData == null || (aVar = swanAppConfigData.f12152a) == null || aVar.c(d2)) {
                return false;
            }
            String str = swanAppConfigData.f12153b.f12175c.get(d2);
            if (!TextUtils.isEmpty(str)) {
                if (d.a.h0.l.i.a.h().m(bVar.G(), bVar.n1(), str)) {
                    return !new File(d.e.h(bVar.G(), bVar.n1()), str).exists();
                }
                return true;
            }
        }
        return false;
    }
}
