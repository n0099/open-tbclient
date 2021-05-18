package d.a.i0.a.h0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.a1.e;
import d.a.i0.a.c2.f.p0.c;
import d.a.i0.a.c2.f.p0.j;
import d.a.i0.a.g1.f;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import d.a.i0.a.r1.h;
import d.a.i0.a.u.e.j.d;
import d.a.i0.a.v2.d0;
import d.a.i0.a.v2.o0;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42340b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42341a;

    /* renamed from: d.a.i0.a.h0.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0684b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f42342a = new b();
    }

    public static b c() {
        return C0684b.f42342a;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (f42340b) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        d.g(swanAppConfigData);
        d.a.i0.a.h0.q.b.g().p(d.a.i0.a.a2.d.g().getAppId(), false);
        d.a.i0.a.l2.b.l().t();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c8 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a3 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ab A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c4 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0214 A[Catch: all -> 0x02b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x001c, B:10:0x0022, B:15:0x002c, B:16:0x002f, B:18:0x0048, B:20:0x0050, B:22:0x0078, B:24:0x009a, B:29:0x00a8, B:31:0x00bc, B:32:0x00c2, B:34:0x00c8, B:36:0x00d4, B:37:0x00d6, B:39:0x00da, B:40:0x00e3, B:42:0x0121, B:45:0x0139, B:47:0x0150, B:49:0x0158, B:51:0x0180, B:53:0x01a3, B:55:0x01ab, B:58:0x01c0, B:60:0x01c4, B:61:0x01cd, B:63:0x0214, B:64:0x02a5, B:57:0x01b7, B:50:0x015d, B:44:0x0130, B:21:0x0055), top: B:70:0x0009 }] */
    /* JADX WARN: Type inference failed for: r3v13, types: [d.a.i0.a.p.e.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d.a.i0.a.h0.l.a aVar, @NonNull d.a.i0.a.p.e.b bVar, @NonNull d.a.i0.a.f1.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable e.g gVar, boolean z) {
        boolean z2;
        boolean G;
        Bundle P;
        boolean E;
        d.a.i0.a.h0.u.d dVar;
        if (f42340b) {
            Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
            Log.d("SwanPrelink", "start dispatch launch event");
        }
        if (this.f42341a) {
            if (z) {
                d.a.i0.a.h0.u.b.c(14);
            }
            return;
        }
        if (z) {
            d.a.i0.a.h0.u.b.c(1);
        }
        String c2 = c.c(f.V(), bVar2, swanAppConfigData);
        String g2 = swanAppConfigData.g(c2);
        d.a.i0.a.h0.u.a aVar2 = new d.a.i0.a.h0.u.a();
        aVar2.f42427a = swanAppConfigData.m;
        if (gVar != null && !TextUtils.isEmpty(gVar.f40517a)) {
            aVar2.f42428b = gVar.f40517a;
        } else {
            aVar2.f42428b = e.C0550e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
        }
        aVar2.f42429c = bVar.b();
        aVar2.f42430d = c2;
        aVar2.f42432f = String.valueOf(d.a.i0.a.e0.a.a());
        aVar2.f42433g = d.a.i0.a.h0.u.a.c(d.a.i0.a.a2.e.i(), c2);
        aVar2.f42435i = g2;
        if (!f42340b && !f.V().O()) {
            z2 = false;
            aVar2.f42434h = z2;
            aVar2.j = bVar.L();
            aVar2.l = d.a.i0.a.h0.u.e.b();
            G = d.a.i0.a.u1.a.a.G();
            if (G) {
                aVar2.k = d.a.i0.a.e0.f.b.b();
            }
            P = bVar2.P();
            if (P != null) {
                String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    aVar2.f42431e = string;
                }
            }
            if (f42340b) {
                Log.d("AppLaunchMessenger", aVar2.toString());
            }
            h.o().C(new UbcFlowEvent("master_dispatch_start"));
            d.a.i0.a.i2.a.d().i("master_dispatch_start");
            aVar.D(aVar2);
            g.N().H0(d.a.i0.a.h0.u.a.b(aVar2));
            g.N().S0(aVar2.j);
            E = d.a.i0.a.u1.a.a.E(bVar2.g0());
            boolean o0 = bVar2.o0();
            if (!E) {
                d.a.i0.a.e0.f.e.d.d();
                d.a.i0.a.e0.f.e.d.g().h("appready");
            } else if (o0) {
                d.a.i0.a.e0.f.d.d.e().f("appready");
            }
            d.a.i0.a.a2.n.g e2 = f.V().e(j.b(o0.f(c2)));
            dVar = new d.a.i0.a.h0.u.d();
            if (gVar == null && !TextUtils.isEmpty(gVar.f40517a)) {
                dVar.f42438a = gVar.f40517a;
            } else {
                dVar.f42438a = e.C0550e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
            }
            dVar.f42439b = c2;
            dVar.f42441d = e2.f40624g;
            dVar.f42440c = g2;
            dVar.k = aVar2.f42433g;
            dVar.f42442e = String.valueOf(bVar2.l0());
            dVar.f42444g = z2;
            dVar.f42446i = bVar.L();
            dVar.m = true;
            if (G) {
                dVar.j = d.a.i0.a.e0.f.b.d();
            }
            if (!E) {
                d.a.i0.a.e0.f.e.d.g().h("pageready");
            } else if (o0) {
                d.a.i0.a.e0.f.d.d.e().f("pageready");
            }
            if (f42340b) {
                Log.d("AppLaunchMessenger", dVar.toString());
            }
            h.o().C(new UbcFlowEvent("slave_dispatch_start"));
            d.a.i0.a.i2.a.d().i("slave_dispatch_start");
            bVar.M(dVar);
            d0.d();
            bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
            bVar.S(c2);
            g.N().I0(bVar.b(), d.a.i0.a.h0.u.d.a(dVar));
            d.a.i0.a.j2.e.F(bVar.b(), dVar.f42439b);
            if (f42340b) {
                Log.d("AppLaunchMessenger", "app path: " + aVar2.f42428b);
                Log.d("AppLaunchMessenger", "webviewId: " + bVar.b());
                Log.d("AppLaunchMessenger", "pageUrl: " + c2);
                Log.d("AppLaunchMessenger", "pagePath: " + dVar.f42439b);
                Log.d("AppLaunchMessenger", "onReachBottomDistance: " + dVar.f42441d);
                Log.d("AppLaunchMessenger", "sConsole:" + dVar.f42442e);
            }
            a(swanAppConfigData);
            this.f42341a = true;
            e();
        }
        z2 = true;
        aVar2.f42434h = z2;
        aVar2.j = bVar.L();
        aVar2.l = d.a.i0.a.h0.u.e.b();
        G = d.a.i0.a.u1.a.a.G();
        if (G) {
        }
        P = bVar2.P();
        if (P != null) {
        }
        if (f42340b) {
        }
        h.o().C(new UbcFlowEvent("master_dispatch_start"));
        d.a.i0.a.i2.a.d().i("master_dispatch_start");
        aVar.D(aVar2);
        g.N().H0(d.a.i0.a.h0.u.a.b(aVar2));
        g.N().S0(aVar2.j);
        E = d.a.i0.a.u1.a.a.E(bVar2.g0());
        boolean o02 = bVar2.o0();
        if (!E) {
        }
        d.a.i0.a.a2.n.g e22 = f.V().e(j.b(o0.f(c2)));
        dVar = new d.a.i0.a.h0.u.d();
        if (gVar == null) {
        }
        dVar.f42438a = e.C0550e.i(bVar2.H(), bVar2.u1()).getPath() + File.separator;
        dVar.f42439b = c2;
        dVar.f42441d = e22.f40624g;
        dVar.f42440c = g2;
        dVar.k = aVar2.f42433g;
        dVar.f42442e = String.valueOf(bVar2.l0());
        dVar.f42444g = z2;
        dVar.f42446i = bVar.L();
        dVar.m = true;
        if (G) {
        }
        if (!E) {
        }
        if (f42340b) {
        }
        h.o().C(new UbcFlowEvent("slave_dispatch_start"));
        d.a.i0.a.i2.a.d().i("slave_dispatch_start");
        bVar.M(dVar);
        d0.d();
        bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, c2);
        bVar.S(c2);
        g.N().I0(bVar.b(), d.a.i0.a.h0.u.d.a(dVar));
        d.a.i0.a.j2.e.F(bVar.b(), dVar.f42439b);
        if (f42340b) {
        }
        a(swanAppConfigData);
        this.f42341a = true;
        e();
    }

    public synchronized void d() {
        this.f42341a = false;
    }

    public final void e() {
        d.a.i0.a.h0.l.a P;
        int a2 = d.a.i0.a.r1.l.b.a();
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
        this.f42341a = false;
    }
}
