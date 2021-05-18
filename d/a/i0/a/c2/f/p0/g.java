package d.a.i0.a.c2.f.p0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.a1.e;
import d.a.i0.a.h0.m.o.a;
import d.a.i0.a.v2.o0;
import d.a.i0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41009a = d.a.i0.a.k.f43025a;

    /* loaded from: classes3.dex */
    public static class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f41010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f41011b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f41012c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41013d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41015f;

        public a(boolean z, d.a.i0.a.a2.e eVar, d dVar, String str, String str2, String str3) {
            this.f41010a = z;
            this.f41011b = eVar;
            this.f41012c = dVar;
            this.f41013d = str;
            this.f41014e = str2;
            this.f41015f = str3;
        }

        @Override // d.a.i0.a.h0.m.o.a.b
        public void a() {
            g.h(this.f41010a, this.f41011b.f40575f, "pkg_retry_fail", String.valueOf(2113));
            this.f41012c.b(2113);
        }

        @Override // d.a.i0.a.h0.m.o.a.b
        public void b(d.a.i0.a.q2.a aVar) {
            boolean n = g.n(this.f41011b.f40575f, aVar);
            if (g.f41009a) {
                Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + n + ",isRetry:" + this.f41010a + ",pmsErrorCode:" + aVar);
            }
            if (n) {
                g.i(this.f41011b.f40575f, aVar);
                d.a.i0.a.f1.d.b.a.b().a(this.f41011b.f40575f);
                g.j(this.f41011b, this.f41014e, this.f41013d, this.f41012c, this.f41015f, true);
                return;
            }
            d.a.i0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.i0.a.h.swanapp_tip_package_unavailable).F();
            g.h(this.f41010a, this.f41011b.f40575f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
            this.f41012c.b(2113);
        }

        @Override // d.a.i0.a.h0.m.o.a.b
        public void onSuccess() {
            g.h(this.f41010a, this.f41011b.f40575f, "pkg_retry_success", "");
            this.f41012c.a(this.f41013d);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.i0.a.h0.m.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41016a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f41017b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f41018c;

        public b(String str, d dVar, String str2) {
            this.f41016a = str;
            this.f41017b = dVar;
            this.f41018c = str2;
        }

        @Override // d.a.i0.a.h0.m.b
        public void a() {
            d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
            if (i2 != null) {
                i2.y0(this.f41016a, true);
            }
            this.f41017b.a(this.f41018c);
        }

        @Override // d.a.i0.a.h0.m.b
        public void b(int i2, d.a.i0.a.q2.a aVar) {
            this.f41017b.b(i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.a.i0.a.h0.m.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f41020b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f41021c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f41022d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41024f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41025g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41026h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41027i;

        public c(String str, boolean z, String str2, d dVar, String str3, String str4, String str5, String str6, String str7) {
            this.f41019a = str;
            this.f41020b = z;
            this.f41021c = str2;
            this.f41022d = dVar;
            this.f41023e = str3;
            this.f41024f = str4;
            this.f41025g = str5;
            this.f41026h = str6;
            this.f41027i = str7;
        }

        @Override // d.a.i0.a.h0.m.b
        public void a() {
            d.a.i0.a.a2.d.g().r().y0(this.f41019a, true);
            g.h(this.f41020b, this.f41021c, "sub_pkg_retry_success", "");
            this.f41022d.a(this.f41023e);
        }

        @Override // d.a.i0.a.h0.m.b
        public void b(int i2, d.a.i0.a.q2.a aVar) {
            boolean n = g.n(this.f41021c, aVar);
            if (g.f41009a) {
                Log.d("PagesRoute", "isNeedGetPkgRetry:" + n + ",isRetry:" + this.f41020b + ",pmsErrorCode:" + aVar);
            }
            if (n) {
                g.i(this.f41024f, aVar);
                d.a.i0.a.f1.d.b.a.b().a(this.f41021c);
                g.m(this.f41024f, this.f41025g, this.f41026h, this.f41019a, this.f41027i, this.f41023e, this.f41022d, true);
                return;
            }
            g.h(this.f41020b, this.f41021c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
            this.f41022d.b(i2);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void b(int i2);
    }

    /* loaded from: classes3.dex */
    public static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        public final d f41028a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f41029b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41030e;

            public a(String str) {
                this.f41030e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f41028a.a(this.f41030e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f41032e;

            public b(int i2) {
                this.f41032e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f41029b) {
                    d.a.i0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.i0.a.h.swanapp_tip_package_unavailable).F();
                }
                e.this.f41028a.b(this.f41032e);
            }
        }

        public e(@NonNull d dVar, boolean z) {
            this.f41028a = dVar;
            this.f41029b = z;
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void a(String str) {
            q0.b0(new a(str));
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void b(int i2) {
            q0.b0(new b(i2));
        }
    }

    public static void g(d.a.i0.a.a2.e eVar, d.a.i0.a.l1.b bVar, String str, d dVar, String str2) {
        if (eVar != null) {
            eVar.B().e(eVar.getAppId());
        }
        if (dVar == null) {
            return;
        }
        if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f43183e) && !TextUtils.isEmpty(bVar.f43186h)) {
            String str3 = bVar.f43186h;
            String R = eVar.R(bVar.f43183e);
            boolean h0 = eVar.h0(str3);
            if (!d.a.i0.a.e0.f.e.e.d() && !d.a.i0.a.u1.a.a.G() && !d.a.i0.a.u1.a.a.C()) {
                if (d.a.i0.a.t1.b.a.e(bVar.f43183e)) {
                    dVar.a(str);
                    return;
                }
                if (h0) {
                    if (d.a.i0.a.a1.e.A(eVar.f40575f, eVar.Z())) {
                        dVar.a(str);
                        return;
                    } else if (eVar.e0()) {
                        j(eVar, str3, str, dVar, str2, false);
                        return;
                    }
                }
                if (TextUtils.isEmpty(R)) {
                    dVar.b(2111);
                    return;
                } else if (eVar.j0(R)) {
                    dVar.a(str);
                    return;
                } else if (eVar.l0(R) && eVar.k0(R)) {
                    dVar.a(str);
                    eVar.y0(R, true);
                    return;
                } else {
                    String G = eVar.G(R);
                    if (TextUtils.isEmpty(G)) {
                        dVar.b(2112);
                        return;
                    }
                    boolean g0 = eVar.g0(str3);
                    if (!d.a.i0.a.a1.e.A(eVar.f40575f, eVar.Z()) && !g0) {
                        j(eVar, str3, str, dVar, str2, false);
                        return;
                    }
                    HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                    q.C(new UbcFlowEvent("na_start_sub_package_download"));
                    q.A("sub_state", "1");
                    l(eVar.f40575f, eVar.Z(), "3", R, G, str, new e(dVar, true));
                    return;
                }
            } else if (!h0 && TextUtils.isEmpty(R)) {
                dVar.b(2111);
                return;
            } else {
                dVar.a(str);
                return;
            }
        }
        dVar.b(2110);
    }

    public static void h(boolean z, String str, String str2, String str3) {
        if (z) {
            d.a.i0.a.f1.d.b.a.b().g(str);
            d.a.i0.a.j2.k.G(str2, str3);
        }
    }

    public static void i(String str, d.a.i0.a.q2.a aVar) {
        if ((aVar == null ? 0L : aVar.g()) == 2205) {
            d.a.i0.a.n0.f.c().d().u(d.a.i0.a.v2.z0.a.a(str), true, 12);
        }
    }

    public static void j(d.a.i0.a.a2.e eVar, String str, String str2, d dVar, String str3, boolean z) {
        if (dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow q = d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.C(new UbcFlowEvent("na_start_sub_package_download"));
        q.A("sub_state", "1");
        d.a.i0.n.i.m.c cVar = new d.a.i0.n.i.m.c(eVar.f40575f, d.a.i0.a.a2.d.g().l());
        cVar.o(q0.o(eVar.Z()));
        cVar.r(str);
        d.a.i0.n.b.b(cVar, new d.a.i0.a.h0.m.o.a(eVar.f40575f, new a(z, eVar, dVar, str2, str, str3)));
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        if (dVar == null) {
            return;
        }
        d.a.i0.n.i.m.f fVar = new d.a.i0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.i0.n.b.f(fVar, new d.a.i0.a.h0.m.q.a(str, str2, new b(str4, dVar, str6)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        m(str, str2, str3, str4, str5, str6, dVar, false);
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, d dVar, boolean z) {
        if (dVar == null) {
            return;
        }
        String e2 = d.a.i0.a.f1.d.b.a.b().e(str, str4);
        d.a.i0.n.i.m.f fVar = new d.a.i0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.i0.n.b.f(fVar, new d.a.i0.a.h0.m.q.a(str, str2, new c(str4, z, e2, dVar, str6, str, str2, str3, str5)));
    }

    public static boolean n(String str, d.a.i0.a.q2.a aVar) {
        long g2 = aVar == null ? 0L : aVar.g();
        return SwanAppNetworkUtils.i(d.a.i0.a.c1.a.b()) && d.a.i0.a.f1.d.b.a.b().f(str) && (g2 == 2101 || g2 == 2205);
    }

    public static boolean o(d.a.i0.a.f1.e.b bVar, e.g gVar) {
        if (gVar == null) {
            return false;
        }
        return p(bVar, gVar.f40518b);
    }

    public static boolean p(d.a.i0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !d.a.i0.a.e0.f.e.e.d() && !d.a.i0.a.u1.a.a.C()) {
            String f2 = o0.f(bVar.e0());
            if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                f2 = f2.substring(1);
            }
            if (swanAppConfigData != null && swanAppConfigData.f11345b != null) {
                String c2 = j.c(f2, swanAppConfigData);
                if (swanAppConfigData.f11345b.c(c2)) {
                    return false;
                }
                String str = swanAppConfigData.f11346c.f11381c.get(c2);
                if (!TextUtils.isEmpty(str)) {
                    if (d.a.i0.n.g.a.h().m(bVar.H(), bVar.u1(), str)) {
                        return !new File(e.C0550e.i(bVar.H(), bVar.u1()), str).exists();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
