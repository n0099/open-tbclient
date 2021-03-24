package d.b.g0.a.e0.r;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.i2.b0;
import d.b.g0.a.i2.i0;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.k.p0.c;
import d.b.g0.a.t1.k.p0.j;
import d.b.g0.a.u0.d;
import d.b.g0.a.z0.f;
import java.io.File;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44258b = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f44259a;

    /* renamed from: d.b.g0.a.e0.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0680b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44260a = new b();
    }

    public static b c() {
        return C0680b.f44260a;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (f44258b) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        d.b.g0.a.e0.s.a.e().i(swanAppConfigData);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2 A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0 A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0101 A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0178 A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0188 A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0195 A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e3 A[Catch: all -> 0x027a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0013, B:10:0x0019, B:12:0x0033, B:14:0x003b, B:16:0x0063, B:18:0x0086, B:23:0x0094, B:25:0x00a2, B:26:0x00a8, B:28:0x00ae, B:30:0x00ba, B:31:0x00bc, B:33:0x00c0, B:34:0x00c9, B:36:0x0101, B:37:0x010d, B:39:0x0124, B:41:0x012c, B:43:0x0154, B:45:0x0178, B:46:0x017e, B:48:0x0188, B:49:0x0191, B:51:0x0195, B:52:0x019e, B:54:0x01e3, B:55:0x0273, B:42:0x0131, B:15:0x0040), top: B:61:0x0001 }] */
    /* JADX WARN: Type inference failed for: r9v20, types: [d.b.g0.a.p.d.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d.b.g0.a.e0.o.a aVar, @NonNull d.b.g0.a.p.d.b bVar, @NonNull d.b.g0.a.y0.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.g gVar) {
        boolean z;
        Bundle O;
        d.b.g0.a.e0.w.b bVar3;
        if (f44258b) {
            Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
            Log.d("SwanPrelink", "start dispatch launch event");
        }
        if (this.f44259a) {
            return;
        }
        String d2 = c.d(f.V(), bVar2, swanAppConfigData);
        String g2 = swanAppConfigData.g(d2);
        d.b.g0.a.e0.w.a aVar2 = new d.b.g0.a.e0.w.a();
        aVar2.f44308a = swanAppConfigData.l;
        swanAppConfigData.l = null;
        if (gVar != null && !TextUtils.isEmpty(gVar.f46599a)) {
            aVar2.f44309b = gVar.f46599a;
        } else {
            aVar2.f44309b = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
        }
        aVar2.f44310c = bVar.c();
        aVar2.f44311d = d2;
        aVar2.f44313f = String.valueOf(d.b.g0.a.c0.a.a());
        aVar2.f44314g = d.b.g0.a.e0.w.a.b(e.y(), d2);
        aVar2.i = g2;
        if (!f44258b && !f.V().O()) {
            z = false;
            aVar2.f44315h = z;
            aVar2.j = bVar.w();
            if (d.b.g0.a.m1.a.a.C()) {
                aVar2.k = d.b.g0.a.c0.d.b.b();
            }
            O = bVar2.O();
            if (O != null) {
                String string = O.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    aVar2.f44312e = string;
                }
            }
            if (f44258b) {
                Log.d("AppLaunchMessenger", aVar2.toString());
            }
            i.n().A(new UbcFlowEvent("master_dispatch_start"));
            d.b.g0.a.y1.a.d().i("master_dispatch_start");
            aVar.j(aVar2);
            d.b.g0.a.e0.w.d.L().A0(d.b.g0.a.e0.w.a.a(aVar2));
            d.b.g0.a.e0.w.d.L().L0(aVar2.j);
            if (d.b.g0.a.m1.a.a.B(bVar2.d0())) {
                d.b.g0.a.c0.d.d.d.d();
                d.b.g0.a.c0.d.d.d.g().h("appready");
            }
            d.b.g0.a.r1.n.c k = f.V().k(j.b(i0.d(d2)));
            bVar3 = new d.b.g0.a.e0.w.b();
            if (gVar == null && !TextUtils.isEmpty(gVar.f46599a)) {
                bVar3.f44316a = gVar.f46599a;
            } else {
                bVar3.f44316a = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
            }
            bVar3.f44317b = d2;
            bVar3.f44319d = k.f45776g;
            bVar3.f44318c = g2;
            bVar3.k = aVar2.f44314g;
            bVar3.f44320e = String.valueOf(bVar2.i0());
            bVar3.f44322g = z;
            bVar3.i = bVar.w();
            if (d.b.g0.a.m1.a.a.C()) {
                bVar3.j = d.b.g0.a.c0.d.b.d();
            }
            if (d.b.g0.a.m1.a.a.B(bVar2.d0())) {
                d.b.g0.a.c0.d.d.d.g().h("pageready");
            }
            if (f44258b) {
                Log.d("AppLaunchMessenger", bVar3.toString());
            }
            i.n().A(new UbcFlowEvent("slave_dispatch_start"));
            d.b.g0.a.y1.a.d().i("slave_dispatch_start");
            bVar.x(bVar3);
            b0.d();
            bVar.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
            bVar.s(d2);
            d.b.g0.a.e0.w.d.L().B0(bVar.c(), d.b.g0.a.e0.w.b.a(bVar3));
            d.b.g0.a.z1.e.B(bVar.c(), bVar3.f44317b);
            if (f44258b) {
                Log.d("AppLaunchMessenger", "app path: " + aVar2.f44309b);
                Log.d("AppLaunchMessenger", "webviewId: " + bVar.c());
                Log.d("AppLaunchMessenger", "pageUrl: " + d2);
                Log.d("AppLaunchMessenger", "pagePath: " + bVar3.f44317b);
                Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar3.f44319d);
                Log.d("AppLaunchMessenger", "sConsole:" + bVar3.f44320e);
            }
            a(swanAppConfigData);
            this.f44259a = true;
        }
        z = true;
        aVar2.f44315h = z;
        aVar2.j = bVar.w();
        if (d.b.g0.a.m1.a.a.C()) {
        }
        O = bVar2.O();
        if (O != null) {
        }
        if (f44258b) {
        }
        i.n().A(new UbcFlowEvent("master_dispatch_start"));
        d.b.g0.a.y1.a.d().i("master_dispatch_start");
        aVar.j(aVar2);
        d.b.g0.a.e0.w.d.L().A0(d.b.g0.a.e0.w.a.a(aVar2));
        d.b.g0.a.e0.w.d.L().L0(aVar2.j);
        if (d.b.g0.a.m1.a.a.B(bVar2.d0())) {
        }
        d.b.g0.a.r1.n.c k2 = f.V().k(j.b(i0.d(d2)));
        bVar3 = new d.b.g0.a.e0.w.b();
        if (gVar == null) {
        }
        bVar3.f44316a = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
        bVar3.f44317b = d2;
        bVar3.f44319d = k2.f45776g;
        bVar3.f44318c = g2;
        bVar3.k = aVar2.f44314g;
        bVar3.f44320e = String.valueOf(bVar2.i0());
        bVar3.f44322g = z;
        bVar3.i = bVar.w();
        if (d.b.g0.a.m1.a.a.C()) {
        }
        if (d.b.g0.a.m1.a.a.B(bVar2.d0())) {
        }
        if (f44258b) {
        }
        i.n().A(new UbcFlowEvent("slave_dispatch_start"));
        d.b.g0.a.y1.a.d().i("slave_dispatch_start");
        bVar.x(bVar3);
        b0.d();
        bVar.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
        bVar.s(d2);
        d.b.g0.a.e0.w.d.L().B0(bVar.c(), d.b.g0.a.e0.w.b.a(bVar3));
        d.b.g0.a.z1.e.B(bVar.c(), bVar3.f44317b);
        if (f44258b) {
        }
        a(swanAppConfigData);
        this.f44259a = true;
    }

    public synchronized void d() {
        this.f44259a = false;
    }

    public b() {
        this.f44259a = false;
    }
}
