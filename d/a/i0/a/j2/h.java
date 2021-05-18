package d.a.i0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.i0.a.f1.e.b;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42951a = d.a.i0.a.k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f42952b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f42953c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f42954d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42955e;

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f42955e = false;
    }

    public static boolean a() {
        if (f42951a) {
            Log.d("SwanAppRouteUbc", "mIsStartByApi = " + f42953c);
        }
        boolean z = f42953c;
        h(false);
        return z;
    }

    public static boolean b() {
        if (f42951a) {
            Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + f42952b);
        }
        boolean z = f42952b;
        i(false);
        return z;
    }

    public static String c() {
        return f42954d;
    }

    public static boolean d() {
        return f42952b;
    }

    public static void e(String str, String str2, d.a.i0.a.p.e.j.d dVar, String str3) {
        d.a.i0.a.a2.e Q;
        if (f42955e && (Q = d.a.i0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            d.a.i0.a.j2.p.f fVar = new d.a.i0.a.j2.p.f();
            fVar.f43011a = k.m(L.G());
            fVar.f43016f = L.H();
            if (d.a.i0.a.e0.f.e.e.d()) {
                fVar.f43013c = "remote-debug";
            } else if (d.a.i0.a.u1.a.a.C()) {
                fVar.f43013c = "local-debug";
            } else {
                fVar.f43013c = L.T();
            }
            fVar.f43012b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f43015e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f43826c > 0) {
                fVar.a("valuetype", dVar.f43830g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f42951a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + fVar.f());
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        if (f42951a) {
            Log.d("SwanAppRouteUbc", "recordRouteByApi");
        }
        if (d()) {
            return;
        }
        h(true);
        f42954d = str2;
        e(str, null, null, str2);
    }

    public static void g(String str) {
        if (f42951a) {
            Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
        }
        f42954d = "6";
        e(str, null, null, f42954d);
    }

    public static synchronized void h(boolean z) {
        synchronized (h.class) {
            f42953c = z;
        }
    }

    public static synchronized void i(boolean z) {
        synchronized (h.class) {
            f42952b = z;
        }
    }
}
