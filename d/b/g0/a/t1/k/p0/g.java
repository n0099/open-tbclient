package d.b.g0.a.t1.k.p0;

import android.text.TextUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.e0.p.o.a;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.u0.d;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public static class a implements d.b.g0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46495a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f46496b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46497c;

        /* renamed from: d.b.g0.a.t1.k.p0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0842a implements Runnable {
            public RunnableC0842a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f46496b.a(aVar.f46497c);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f46499e;

            public b(int i) {
                this.f46499e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f46496b.b(this.f46499e);
            }
        }

        public a(String str, d dVar, String str2) {
            this.f46495a = str;
            this.f46496b = dVar;
            this.f46497c = str2;
        }

        @Override // d.b.g0.a.e0.p.b
        public void a(int i) {
            k0.X(new b(i));
        }

        @Override // d.b.g0.a.e0.p.b
        public void b() {
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y != null) {
                y.s0(this.f46495a, true);
            }
            k0.X(new RunnableC0842a());
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46501a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46502b;

        public b(d dVar, String str) {
            this.f46501a = dVar;
            this.f46502b = str;
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void a() {
            this.f46501a.b(2113);
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void onError() {
            this.f46501a.b(2113);
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void onSuccess() {
            this.f46501a.a(this.f46502b);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.b.g0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46503a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f46504b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46505c;

        public c(String str, d dVar, String str2) {
            this.f46503a = str;
            this.f46504b = dVar;
            this.f46505c = str2;
        }

        @Override // d.b.g0.a.e0.p.b
        public void a(int i) {
            this.f46504b.b(i);
        }

        @Override // d.b.g0.a.e0.p.b
        public void b() {
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y != null) {
                y.s0(this.f46503a, true);
            }
            this.f46504b.a(this.f46505c);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void b(int i);
    }

    public static void a(d.b.g0.a.r1.e eVar, d.b.g0.a.e1.b bVar, String str, d dVar, String str2) {
        if (dVar == null) {
            return;
        }
        if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f44361a) && !TextUtils.isEmpty(bVar.f44364d)) {
            String str3 = bVar.f44364d;
            String P = eVar.P(bVar.f44361a);
            boolean d0 = eVar.d0(str3);
            if (!d.b.g0.a.c0.d.d.e.d() && !d.b.g0.a.m1.a.a.C()) {
                if (d.b.g0.a.l1.b.a.d(bVar.f44361a)) {
                    dVar.a(str);
                    return;
                }
                if (d0) {
                    if (d.b.g0.a.u0.d.p(eVar.f45739f, eVar.W())) {
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
                    if (!d.b.g0.a.u0.d.p(eVar.f45739f, eVar.W()) && !c0) {
                        b(eVar, str3, str, dVar, str2);
                        return;
                    }
                    d.b.g0.l.l.k.f fVar = new d.b.g0.l.l.k.f(eVar.f45739f, eVar.W(), E, 0);
                    d.b.g0.a.e0.p.q.a aVar = new d.b.g0.a.e0.p.q.a(eVar.f45739f, eVar.W(), new a(P, dVar, str));
                    HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                    p.A(new UbcFlowEvent("na_start_sub_package_download"));
                    p.y("sub_state", "1");
                    d.b.g0.l.c.d(fVar, aVar);
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

    public static void b(d.b.g0.a.r1.e eVar, String str, String str2, d dVar, String str3) {
        if (dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        p.A(new UbcFlowEvent("na_start_sub_package_download"));
        p.y("sub_state", "1");
        d.b.g0.l.l.k.c cVar = new d.b.g0.l.l.k.c(eVar.f45739f, d.b.g0.a.r1.d.e().h());
        cVar.n(k0.o(eVar.W()));
        cVar.q(str);
        d.b.g0.l.c.a(cVar, new d.b.g0.a.e0.p.o.a(eVar.f45739f, new b(dVar, str2)));
    }

    public static void c(String str, String str2, String str3, String str4, String str5, d dVar) {
        if (dVar == null) {
            return;
        }
        d.b.g0.l.c.d(new d.b.g0.l.l.k.f(str, str2, str4, 0), new d.b.g0.a.e0.p.q.a(str, str2, new c(str3, dVar, str5)));
    }

    public static boolean d(d.b.g0.a.y0.e.b bVar, d.g gVar) {
        if (gVar == null) {
            return false;
        }
        return e(bVar, gVar.f46600b);
    }

    public static boolean e(d.b.g0.a.y0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        SwanAppConfigData.a aVar;
        if (bVar != null && !TextUtils.isEmpty(bVar.b0()) && !d.b.g0.a.c0.d.d.e.d()) {
            String d2 = i0.d(bVar.b0());
            if (!TextUtils.isEmpty(d2) && d2.startsWith(File.separator)) {
                d2 = d2.substring(1);
            }
            if (swanAppConfigData == null || (aVar = swanAppConfigData.f12612a) == null || aVar.c(d2)) {
                return false;
            }
            String str = swanAppConfigData.f12613b.f12634c.get(d2);
            if (!TextUtils.isEmpty(str)) {
                if (d.b.g0.l.i.a.h().m(bVar.G(), bVar.n1(), str)) {
                    return !new File(d.e.h(bVar.G(), bVar.n1()), str).exists();
                }
                return true;
            }
        }
        return false;
    }
}
