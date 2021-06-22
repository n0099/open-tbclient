package d.a.m0.a.h0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.m0.a.a1.e;
import d.a.m0.a.c2.f.p0.c;
import d.a.m0.a.c2.f.p0.j;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.k;
import d.a.m0.a.r1.h;
import d.a.m0.a.u.e.j.d;
import d.a.m0.a.v2.d0;
import d.a.m0.a.v2.o0;
import java.io.File;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46298b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f46299a;

    /* renamed from: d.a.m0.a.h0.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0754b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f46300a = new b();
    }

    public static b c() {
        return C0754b.f46300a;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (f46298b) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        d.g(swanAppConfigData);
        d.a.m0.a.h0.q.b.g().p(d.a.m0.a.a2.d.g().getAppId(), false);
        d.a.m0.a.l2.b.l().t();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7 A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d9 A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0120 A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a2 A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01aa A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c3 A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0211 A[Catch: all -> 0x02ac, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001b, B:10:0x0021, B:15:0x002b, B:16:0x002e, B:18:0x0047, B:20:0x004f, B:22:0x0077, B:24:0x0099, B:29:0x00a7, B:31:0x00bb, B:32:0x00c1, B:34:0x00c7, B:36:0x00d3, B:37:0x00d5, B:39:0x00d9, B:40:0x00e2, B:42:0x0120, B:45:0x0138, B:47:0x014f, B:49:0x0157, B:51:0x017f, B:53:0x01a2, B:55:0x01aa, B:58:0x01bf, B:60:0x01c3, B:61:0x01cc, B:63:0x0211, B:64:0x02a1, B:57:0x01b6, B:50:0x015c, B:44:0x012f, B:21:0x0054), top: B:70:0x0009 }] */
    /* JADX WARN: Type inference failed for: r3v13, types: [d.a.m0.a.p.e.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d.a.m0.a.h0.l.a aVar, @NonNull d.a.m0.a.p.e.b bVar, @NonNull d.a.m0.a.f1.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable e.g gVar, boolean z) {
        boolean z2;
        boolean G;
        Bundle P;
        boolean E;
        d.a.m0.a.h0.u.d dVar;
        if (f46298b) {
            Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
            Log.d("SwanPrelink", "start dispatch launch event");
        }
        if (this.f46299a) {
            if (z) {
                d.a.m0.a.h0.u.b.c(14);
            }
            return;
        }
        if (z) {
            d.a.m0.a.h0.u.b.c(1);
        }
        String c2 = c.c(f.V(), bVar2, swanAppConfigData);
        String g2 = swanAppConfigData.g(c2);
        d.a.m0.a.h0.u.a aVar2 = new d.a.m0.a.h0.u.a();
        aVar2.f46385a = swanAppConfigData.m;
        if (gVar != null && !TextUtils.isEmpty(gVar.f44475a)) {
            aVar2.f46386b = gVar.f44475a;
        } else {
            aVar2.f46386b = e.C0620e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
        }
        aVar2.f46387c = bVar.b();
        aVar2.f46388d = c2;
        aVar2.f46390f = String.valueOf(d.a.m0.a.e0.a.a());
        aVar2.f46391g = d.a.m0.a.h0.u.a.c(d.a.m0.a.a2.e.i(), c2);
        aVar2.f46393i = g2;
        if (!f46298b && !f.V().O()) {
            z2 = false;
            aVar2.f46392h = z2;
            aVar2.j = bVar.L();
            aVar2.l = d.a.m0.a.h0.u.e.b();
            G = d.a.m0.a.u1.a.a.G();
            if (G) {
                aVar2.k = d.a.m0.a.e0.f.b.b();
            }
            P = bVar2.P();
            if (P != null) {
                String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    aVar2.f46389e = string;
                }
            }
            if (f46298b) {
                Log.d("AppLaunchMessenger", aVar2.toString());
            }
            h.o().C(new UbcFlowEvent("master_dispatch_start"));
            d.a.m0.a.i2.a.d().i("master_dispatch_start");
            aVar.D(aVar2);
            g.N().H0(d.a.m0.a.h0.u.a.b(aVar2));
            g.N().S0(aVar2.j);
            E = d.a.m0.a.u1.a.a.E(bVar2.g0());
            boolean o0 = bVar2.o0();
            if (!E) {
                d.a.m0.a.e0.f.e.d.d();
                d.a.m0.a.e0.f.e.d.g().h("appready");
            } else if (o0) {
                d.a.m0.a.e0.f.d.d.e().f("appready");
            }
            d.a.m0.a.a2.n.g e2 = f.V().e(j.b(o0.f(c2)));
            dVar = new d.a.m0.a.h0.u.d();
            if (gVar == null && !TextUtils.isEmpty(gVar.f44475a)) {
                dVar.f46396a = gVar.f44475a;
            } else {
                dVar.f46396a = e.C0620e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
            }
            dVar.f46397b = c2;
            dVar.f46399d = e2.f44582g;
            dVar.f46398c = g2;
            dVar.k = aVar2.f46391g;
            dVar.f46400e = String.valueOf(bVar2.l0());
            dVar.f46402g = z2;
            dVar.f46404i = bVar.L();
            dVar.m = true;
            if (G) {
                dVar.j = d.a.m0.a.e0.f.b.d();
            }
            if (!E) {
                d.a.m0.a.e0.f.e.d.g().h("pageready");
            } else if (o0) {
                d.a.m0.a.e0.f.d.d.e().f("pageready");
            }
            if (f46298b) {
                Log.d("AppLaunchMessenger", dVar.toString());
            }
            h.o().C(new UbcFlowEvent("slave_dispatch_start"));
            d.a.m0.a.i2.a.d().i("slave_dispatch_start");
            bVar.M(dVar);
            d0.d();
            bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
            bVar.S(c2);
            g.N().I0(bVar.b(), d.a.m0.a.h0.u.d.a(dVar));
            d.a.m0.a.j2.e.F(bVar.b(), dVar.f46397b);
            if (f46298b) {
                Log.d("AppLaunchMessenger", "app path: " + aVar2.f46386b);
                Log.d("AppLaunchMessenger", "webviewId: " + bVar.b());
                Log.d("AppLaunchMessenger", "pageUrl: " + c2);
                Log.d("AppLaunchMessenger", "pagePath: " + dVar.f46397b);
                Log.d("AppLaunchMessenger", "onReachBottomDistance: " + dVar.f46399d);
                Log.d("AppLaunchMessenger", "sConsole:" + dVar.f46400e);
            }
            a(swanAppConfigData);
            this.f46299a = true;
            e();
        }
        z2 = true;
        aVar2.f46392h = z2;
        aVar2.j = bVar.L();
        aVar2.l = d.a.m0.a.h0.u.e.b();
        G = d.a.m0.a.u1.a.a.G();
        if (G) {
        }
        P = bVar2.P();
        if (P != null) {
        }
        if (f46298b) {
        }
        h.o().C(new UbcFlowEvent("master_dispatch_start"));
        d.a.m0.a.i2.a.d().i("master_dispatch_start");
        aVar.D(aVar2);
        g.N().H0(d.a.m0.a.h0.u.a.b(aVar2));
        g.N().S0(aVar2.j);
        E = d.a.m0.a.u1.a.a.E(bVar2.g0());
        boolean o02 = bVar2.o0();
        if (!E) {
        }
        d.a.m0.a.a2.n.g e22 = f.V().e(j.b(o0.f(c2)));
        dVar = new d.a.m0.a.h0.u.d();
        if (gVar == null) {
        }
        dVar.f46396a = e.C0620e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
        dVar.f46397b = c2;
        dVar.f46399d = e22.f44582g;
        dVar.f46398c = g2;
        dVar.k = aVar2.f46391g;
        dVar.f46400e = String.valueOf(bVar2.l0());
        dVar.f46402g = z2;
        dVar.f46404i = bVar.L();
        dVar.m = true;
        if (G) {
        }
        if (!E) {
        }
        if (f46298b) {
        }
        h.o().C(new UbcFlowEvent("slave_dispatch_start"));
        d.a.m0.a.i2.a.d().i("slave_dispatch_start");
        bVar.M(dVar);
        d0.d();
        bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
        bVar.S(c2);
        g.N().I0(bVar.b(), d.a.m0.a.h0.u.d.a(dVar));
        d.a.m0.a.j2.e.F(bVar.b(), dVar.f46397b);
        if (f46298b) {
        }
        a(swanAppConfigData);
        this.f46299a = true;
        e();
    }

    public synchronized void d() {
        this.f46299a = false;
    }

    public final void e() {
        d.a.m0.a.h0.l.a P;
        int a2 = d.a.m0.a.r1.l.b.a();
        if (a2 == 0 || (P = g.N().P()) == null) {
            return;
        }
        if (a2 < 0) {
            P.r(a2);
        } else if (a2 == 1) {
            P.r(-4);
        } else {
            P.r(-2);
        }
    }

    public b() {
        this.f46299a = false;
    }
}
