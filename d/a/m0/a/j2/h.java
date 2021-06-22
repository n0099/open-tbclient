package d.a.m0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.m0.a.f1.e.b;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46909a = d.a.m0.a.k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46910b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f46911c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f46912d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46913e;

    static {
        d.a.m0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f46913e = false;
    }

    public static boolean a() {
        if (f46909a) {
            Log.d("SwanAppRouteUbc", "mIsStartByApi = " + f46911c);
        }
        boolean z = f46911c;
        h(false);
        return z;
    }

    public static boolean b() {
        if (f46909a) {
            Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + f46910b);
        }
        boolean z = f46910b;
        i(false);
        return z;
    }

    public static String c() {
        return f46912d;
    }

    public static boolean d() {
        return f46910b;
    }

    public static void e(String str, String str2, d.a.m0.a.p.e.j.d dVar, String str3) {
        d.a.m0.a.a2.e Q;
        if (f46913e && (Q = d.a.m0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
            fVar.f46969a = k.m(L.G());
            fVar.f46974f = L.H();
            if (d.a.m0.a.e0.f.e.e.d()) {
                fVar.f46971c = "remote-debug";
            } else if (d.a.m0.a.u1.a.a.C()) {
                fVar.f46971c = "local-debug";
            } else {
                fVar.f46971c = L.T();
            }
            fVar.f46970b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f46973e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f47784c > 0) {
                fVar.a("valuetype", dVar.f47788g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f46909a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + fVar.f());
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        if (f46909a) {
            Log.d("SwanAppRouteUbc", "recordRouteByApi");
        }
        if (d()) {
            return;
        }
        h(true);
        f46912d = str2;
        e(str, null, null, str2);
    }

    public static void g(String str) {
        if (f46909a) {
            Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
        }
        f46912d = "6";
        e(str, null, null, f46912d);
    }

    public static synchronized void h(boolean z) {
        synchronized (h.class) {
            f46911c = z;
        }
    }

    public static synchronized void i(boolean z) {
        synchronized (h.class) {
            f46910b = z;
        }
    }
}
