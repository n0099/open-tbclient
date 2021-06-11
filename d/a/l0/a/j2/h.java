package d.a.l0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.l0.a.f1.e.b;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46801a = d.a.l0.a.k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46802b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f46803c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f46804d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46805e;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f46805e = false;
    }

    public static boolean a() {
        if (f46801a) {
            Log.d("SwanAppRouteUbc", "mIsStartByApi = " + f46803c);
        }
        boolean z = f46803c;
        h(false);
        return z;
    }

    public static boolean b() {
        if (f46801a) {
            Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + f46802b);
        }
        boolean z = f46802b;
        i(false);
        return z;
    }

    public static String c() {
        return f46804d;
    }

    public static boolean d() {
        return f46802b;
    }

    public static void e(String str, String str2, d.a.l0.a.p.e.j.d dVar, String str3) {
        d.a.l0.a.a2.e Q;
        if (f46805e && (Q = d.a.l0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
            fVar.f46861a = k.m(L.G());
            fVar.f46866f = L.H();
            if (d.a.l0.a.e0.f.e.e.d()) {
                fVar.f46863c = "remote-debug";
            } else if (d.a.l0.a.u1.a.a.C()) {
                fVar.f46863c = "local-debug";
            } else {
                fVar.f46863c = L.T();
            }
            fVar.f46862b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f46865e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f47676c > 0) {
                fVar.a("valuetype", dVar.f47680g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f46801a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + fVar.f());
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        if (f46801a) {
            Log.d("SwanAppRouteUbc", "recordRouteByApi");
        }
        if (d()) {
            return;
        }
        h(true);
        f46804d = str2;
        e(str, null, null, str2);
    }

    public static void g(String str) {
        if (f46801a) {
            Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
        }
        f46804d = "6";
        e(str, null, null, f46804d);
    }

    public static synchronized void h(boolean z) {
        synchronized (h.class) {
            f46803c = z;
        }
    }

    public static synchronized void i(boolean z) {
        synchronized (h.class) {
            f46802b = z;
        }
    }
}
