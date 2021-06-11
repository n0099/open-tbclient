package d.a.l0.a.c2.f.p0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a1.e;
import d.a.l0.a.h0.m.o.a;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44859a = d.a.l0.a.k.f46875a;

    /* loaded from: classes3.dex */
    public static class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44860a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f44861b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f44862c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44863d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44865f;

        public a(boolean z, d.a.l0.a.a2.e eVar, d dVar, String str, String str2, String str3) {
            this.f44860a = z;
            this.f44861b = eVar;
            this.f44862c = dVar;
            this.f44863d = str;
            this.f44864e = str2;
            this.f44865f = str3;
        }

        @Override // d.a.l0.a.h0.m.o.a.b
        public void a() {
            g.h(this.f44860a, this.f44861b.f44425f, "pkg_retry_fail", String.valueOf(2113));
            this.f44862c.b(2113);
        }

        @Override // d.a.l0.a.h0.m.o.a.b
        public void b(d.a.l0.a.q2.a aVar) {
            boolean n = g.n(this.f44861b.f44425f, aVar);
            if (g.f44859a) {
                Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + n + ",isRetry:" + this.f44860a + ",pmsErrorCode:" + aVar);
            }
            if (n) {
                g.i(this.f44861b.f44425f, aVar);
                d.a.l0.a.f1.d.b.a.b().a(this.f44861b.f44425f);
                g.j(this.f44861b, this.f44864e, this.f44863d, this.f44862c, this.f44865f, true);
                return;
            }
            d.a.l0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.l0.a.h.swanapp_tip_package_unavailable).F();
            g.h(this.f44860a, this.f44861b.f44425f, "pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
            this.f44862c.b(2113);
        }

        @Override // d.a.l0.a.h0.m.o.a.b
        public void onSuccess() {
            g.h(this.f44860a, this.f44861b.f44425f, "pkg_retry_success", "");
            this.f44862c.a(this.f44863d);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.l0.a.h0.m.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44866a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f44867b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44868c;

        public b(String str, d dVar, String str2) {
            this.f44866a = str;
            this.f44867b = dVar;
            this.f44868c = str2;
        }

        @Override // d.a.l0.a.h0.m.b
        public void a() {
            d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
            if (i2 != null) {
                i2.y0(this.f44866a, true);
            }
            this.f44867b.a(this.f44868c);
        }

        @Override // d.a.l0.a.h0.m.b
        public void b(int i2, d.a.l0.a.q2.a aVar) {
            this.f44867b.b(i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.a.l0.a.h0.m.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44869a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f44870b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44871c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f44872d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44874f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44875g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44876h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44877i;

        public c(String str, boolean z, String str2, d dVar, String str3, String str4, String str5, String str6, String str7) {
            this.f44869a = str;
            this.f44870b = z;
            this.f44871c = str2;
            this.f44872d = dVar;
            this.f44873e = str3;
            this.f44874f = str4;
            this.f44875g = str5;
            this.f44876h = str6;
            this.f44877i = str7;
        }

        @Override // d.a.l0.a.h0.m.b
        public void a() {
            d.a.l0.a.a2.d.g().r().y0(this.f44869a, true);
            g.h(this.f44870b, this.f44871c, "sub_pkg_retry_success", "");
            this.f44872d.a(this.f44873e);
        }

        @Override // d.a.l0.a.h0.m.b
        public void b(int i2, d.a.l0.a.q2.a aVar) {
            boolean n = g.n(this.f44871c, aVar);
            if (g.f44859a) {
                Log.d("PagesRoute", "isNeedGetPkgRetry:" + n + ",isRetry:" + this.f44870b + ",pmsErrorCode:" + aVar);
            }
            if (n) {
                g.i(this.f44874f, aVar);
                d.a.l0.a.f1.d.b.a.b().a(this.f44871c);
                g.m(this.f44874f, this.f44875g, this.f44876h, this.f44869a, this.f44877i, this.f44873e, this.f44872d, true);
                return;
            }
            g.h(this.f44870b, this.f44871c, "sub_pkg_retry_fail", String.valueOf(aVar == null ? 0L : aVar.a()));
            this.f44872d.b(i2);
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
        public final d f44878a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44879b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44880e;

            public a(String str) {
                this.f44880e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f44878a.a(this.f44880e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44882e;

            public b(int i2) {
                this.f44882e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f44879b) {
                    d.a.l0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.l0.a.h.swanapp_tip_package_unavailable).F();
                }
                e.this.f44878a.b(this.f44882e);
            }
        }

        public e(@NonNull d dVar, boolean z) {
            this.f44878a = dVar;
            this.f44879b = z;
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void a(String str) {
            q0.b0(new a(str));
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void b(int i2) {
            q0.b0(new b(i2));
        }
    }

    public static void g(d.a.l0.a.a2.e eVar, d.a.l0.a.l1.b bVar, String str, d dVar, String str2) {
        if (eVar != null) {
            eVar.B().e(eVar.getAppId());
        }
        if (dVar == null) {
            return;
        }
        if (eVar != null && bVar != null && !TextUtils.isEmpty(bVar.f47033e) && !TextUtils.isEmpty(bVar.f47036h)) {
            String str3 = bVar.f47036h;
            String R = eVar.R(bVar.f47033e);
            boolean h0 = eVar.h0(str3);
            if (!d.a.l0.a.e0.f.e.e.d() && !d.a.l0.a.u1.a.a.G() && !d.a.l0.a.u1.a.a.C()) {
                if (d.a.l0.a.t1.b.a.e(bVar.f47033e)) {
                    dVar.a(str);
                    return;
                }
                if (h0) {
                    if (d.a.l0.a.a1.e.A(eVar.f44425f, eVar.Z())) {
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
                    if (!d.a.l0.a.a1.e.A(eVar.f44425f, eVar.Z()) && !g0) {
                        j(eVar, str3, str, dVar, str2, false);
                        return;
                    }
                    HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2);
                    q.C(new UbcFlowEvent("na_start_sub_package_download"));
                    q.A("sub_state", "1");
                    l(eVar.f44425f, eVar.Z(), "3", R, G, str, new e(dVar, true));
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
            d.a.l0.a.f1.d.b.a.b().g(str);
            d.a.l0.a.j2.k.G(str2, str3);
        }
    }

    public static void i(String str, d.a.l0.a.q2.a aVar) {
        if ((aVar == null ? 0L : aVar.g()) == 2205) {
            d.a.l0.a.n0.f.c().d().u(d.a.l0.a.v2.z0.a.a(str), true, 12);
        }
    }

    public static void j(d.a.l0.a.a2.e eVar, String str, String str2, d dVar, String str3, boolean z) {
        if (dVar == null) {
            return;
        }
        if (eVar == null) {
            dVar.b(2111);
            return;
        }
        HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str3);
        q.C(new UbcFlowEvent("na_start_sub_package_download"));
        q.A("sub_state", "1");
        d.a.l0.n.i.m.c cVar = new d.a.l0.n.i.m.c(eVar.f44425f, d.a.l0.a.a2.d.g().l());
        cVar.o(q0.o(eVar.Z()));
        cVar.r(str);
        d.a.l0.n.b.b(cVar, new d.a.l0.a.h0.m.o.a(eVar.f44425f, new a(z, eVar, dVar, str2, str, str3)));
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        if (dVar == null) {
            return;
        }
        d.a.l0.n.i.m.f fVar = new d.a.l0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.l0.n.b.f(fVar, new d.a.l0.a.h0.m.q.a(str, str2, new b(str4, dVar, str6)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, d dVar) {
        m(str, str2, str3, str4, str5, str6, dVar, false);
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, d dVar, boolean z) {
        if (dVar == null) {
            return;
        }
        String e2 = d.a.l0.a.f1.d.b.a.b().e(str, str4);
        d.a.l0.n.i.m.f fVar = new d.a.l0.n.i.m.f(str, str2, str5, 0);
        fVar.d(str3);
        d.a.l0.n.b.f(fVar, new d.a.l0.a.h0.m.q.a(str, str2, new c(str4, z, e2, dVar, str6, str, str2, str3, str5)));
    }

    public static boolean n(String str, d.a.l0.a.q2.a aVar) {
        long g2 = aVar == null ? 0L : aVar.g();
        return SwanAppNetworkUtils.i(d.a.l0.a.c1.a.b()) && d.a.l0.a.f1.d.b.a.b().f(str) && (g2 == 2101 || g2 == 2205);
    }

    public static boolean o(d.a.l0.a.f1.e.b bVar, e.g gVar) {
        if (gVar == null) {
            return false;
        }
        return p(bVar, gVar.f44368b);
    }

    public static boolean p(d.a.l0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar != null && !TextUtils.isEmpty(bVar.e0()) && !d.a.l0.a.e0.f.e.e.d() && !d.a.l0.a.u1.a.a.C()) {
            String f2 = o0.f(bVar.e0());
            if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                f2 = f2.substring(1);
            }
            if (swanAppConfigData != null && swanAppConfigData.f11308b != null) {
                String c2 = j.c(f2, swanAppConfigData);
                if (swanAppConfigData.f11308b.c(c2)) {
                    return false;
                }
                String str = swanAppConfigData.f11309c.f11344c.get(c2);
                if (!TextUtils.isEmpty(str)) {
                    if (d.a.l0.n.g.a.h().m(bVar.H(), bVar.u1(), str)) {
                        return !new File(e.C0617e.i(bVar.H(), bVar.u1()), str).exists();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
