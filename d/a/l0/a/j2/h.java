package d.a.l0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.l0.a.f1.e.b;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43125a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f43126b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f43127c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f43128d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43129e;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f43129e = false;
    }

    public static boolean a() {
        if (f43125a) {
            Log.d("SwanAppRouteUbc", "mIsStartByApi = " + f43127c);
        }
        boolean z = f43127c;
        h(false);
        return z;
    }

    public static boolean b() {
        if (f43125a) {
            Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + f43126b);
        }
        boolean z = f43126b;
        i(false);
        return z;
    }

    public static String c() {
        return f43128d;
    }

    public static boolean d() {
        return f43126b;
    }

    public static void e(String str, String str2, d.a.l0.a.p.e.j.d dVar, String str3) {
        d.a.l0.a.a2.e Q;
        if (f43129e && (Q = d.a.l0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
            fVar.f43185a = k.m(L.G());
            fVar.f43190f = L.H();
            if (d.a.l0.a.e0.f.e.e.d()) {
                fVar.f43187c = "remote-debug";
            } else if (d.a.l0.a.u1.a.a.C()) {
                fVar.f43187c = "local-debug";
            } else {
                fVar.f43187c = L.T();
            }
            fVar.f43186b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f43189e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f44002c > 0) {
                fVar.a("valuetype", dVar.f44006g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f43125a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + fVar.f());
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        if (f43125a) {
            Log.d("SwanAppRouteUbc", "recordRouteByApi");
        }
        if (d()) {
            return;
        }
        h(true);
        f43128d = str2;
        e(str, null, null, str2);
    }

    public static void g(String str) {
        if (f43125a) {
            Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
        }
        f43128d = "6";
        e(str, null, null, f43128d);
    }

    public static synchronized void h(boolean z) {
        synchronized (h.class) {
            f43127c = z;
        }
    }

    public static synchronized void i(boolean z) {
        synchronized (h.class) {
            f43126b = z;
        }
    }
}
