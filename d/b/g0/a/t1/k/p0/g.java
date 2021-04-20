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
        public final /* synthetic */ String f46888a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f46889b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46890c;

        /* renamed from: d.b.g0.a.t1.k.p0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0855a implements Runnable {
            public RunnableC0855a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f46889b.a(aVar.f46890c);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f46892e;

            public b(int i) {
                this.f46892e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f46889b.b(this.f46892e);
            }
        }

        public a(String str, d dVar, String str2) {
            this.f46888a = str;
            this.f46889b = dVar;
            this.f46890c = str2;
        }

        @Override // d.b.g0.a.e0.p.b
        public void a(int i) {
            k0.X(new b(i));
        }

        @Override // d.b.g0.a.e0.p.b
        public void b() {
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y != null) {
                y.s0(this.f46888a, true);
            }
            k0.X(new RunnableC0855a());
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46894a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46895b;

        public b(d dVar, String str) {
            this.f46894a = dVar;
            this.f46895b = str;
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void a() {
            this.f46894a.b(2113);
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void onError() {
            this.f46894a.b(2113);
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void onSuccess() {
            this.f46894a.a(this.f46895b);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.b.g0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46896a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f46897b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46898c;

        public c(String str, d dVar, String str2) {
            this.f46896a = str;
            this.f46897b = dVar;
            this.f46898c = str2;
        }

        @Override // d.b.g0.a.e0.p.b
        public void a(int i) {
            this.f46897b.b(i);
        }

        @Override // d.b.g0.a.e0.p.b
        public void b() {
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y != null) {
                y.s0(this.f46896a, true);
            }
            this.f46897b.a(this.f46898c);
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
        if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f44754a) && !TextUtils.isEmpty(bVar.f44757d)) {
            String str3 = bVar.f44757d;
            String P = eVar.P(bVar.f44754a);
            boolean d0 = eVar.d0(str3);
            if (!d.b.g0.a.c0.d.d.e.d() && !d.b.g0.a.m1.a.a.C()) {
                if (d.b.g0.a.l1.b.a.d(bVar.f44754a)) {
                    dVar.a(str);
                    return;
                }
                if (d0) {
                    if (d.b.g0.a.u0.d.p(eVar.f46132f, eVar.W())) {
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
                    if (!d.b.g0.a.u0.d.p(eVar.f46132f, eVar.W()) && !c0) {
                        b(eVar, str3, str, dVar, str2);
                        return;
                    }
                    d.b.g0.l.l.k.f fVar = new d.b.g0.l.l.k.f(eVar.f46132f, eVar.W(), E, 0);
                    d.b.g0.a.e0.p.q.a aVar = new d.b.g0.a.e0.p.q.a(eVar.f46132f, eVar.W(), new a(P, dVar, str));
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
        d.b.g0.l.l.k.c cVar = new d.b.g0.l.l.k.c(eVar.f46132f, d.b.g0.a.r1.d.e().h());
        cVar.n(k0.o(eVar.W()));
        cVar.q(str);
        d.b.g0.l.c.a(cVar, new d.b.g0.a.e0.p.o.a(eVar.f46132f, new b(dVar, str2)));
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
        return e(bVar, gVar.f46993b);
    }

    public static boolean e(d.b.g0.a.y0.e.b bVar, SwanAppConfigData swanAppConfigData) {
        SwanAppConfigData.a aVar;
        if (bVar != null && !TextUtils.isEmpty(bVar.b0()) && !d.b.g0.a.c0.d.d.e.d()) {
            String d2 = i0.d(bVar.b0());
            if (!TextUtils.isEmpty(d2) && d2.startsWith(File.separator)) {
                d2 = d2.substring(1);
            }
            if (swanAppConfigData == null || (aVar = swanAppConfigData.f12274a) == null || aVar.c(d2)) {
                return false;
            }
            String str = swanAppConfigData.f12275b.f12296c.get(d2);
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
