package d.a.h0.a.e0.r;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.i2.b0;
import d.a.h0.a.i2.i0;
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.k.p0.c;
import d.a.h0.a.t1.k.p0.j;
import d.a.h0.a.u0.d;
import d.a.h0.a.z0.f;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42285b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42286a;

    /* renamed from: d.a.h0.a.e0.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0652b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f42287a = new b();
    }

    public static b c() {
        return C0652b.f42287a;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (f42285b) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        d.a.h0.a.e0.s.a.e().i(swanAppConfigData);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0102 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0179 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0189 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0196 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e6 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Type inference failed for: r9v20, types: [d.a.h0.a.p.d.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d.a.h0.a.e0.o.a aVar, @NonNull d.a.h0.a.p.d.b bVar, @NonNull d.a.h0.a.y0.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.g gVar) {
        boolean z;
        Bundle O;
        d.a.h0.a.e0.w.b bVar3;
        if (f42285b) {
            Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
            Log.d("SwanPrelink", "start dispatch launch event");
        }
        if (this.f42286a) {
            return;
        }
        String d2 = c.d(f.V(), bVar2, swanAppConfigData);
        String g2 = swanAppConfigData.g(d2);
        d.a.h0.a.e0.w.a aVar2 = new d.a.h0.a.e0.w.a();
        aVar2.f42336a = swanAppConfigData.l;
        swanAppConfigData.l = null;
        if (gVar != null && !TextUtils.isEmpty(gVar.f44732a)) {
            aVar2.f42337b = gVar.f44732a;
        } else {
            aVar2.f42337b = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
        }
        aVar2.f42338c = bVar.c();
        aVar2.f42339d = d2;
        aVar2.f42341f = String.valueOf(d.a.h0.a.c0.a.a());
        aVar2.f42342g = d.a.h0.a.e0.w.a.b(e.h(), d2);
        aVar2.f42344i = g2;
        if (!f42285b && !f.V().O()) {
            z = false;
            aVar2.f42343h = z;
            aVar2.j = bVar.J();
            if (d.a.h0.a.m1.a.a.C()) {
                aVar2.k = d.a.h0.a.c0.d.b.b();
            }
            O = bVar2.O();
            if (O != null) {
                String string = O.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    aVar2.f42340e = string;
                }
            }
            if (f42285b) {
                Log.d("AppLaunchMessenger", aVar2.toString());
            }
            i.n().A(new UbcFlowEvent("master_dispatch_start"));
            d.a.h0.a.y1.a.d().i("master_dispatch_start");
            aVar.C(aVar2);
            d.a.h0.a.e0.w.d.L().A0(d.a.h0.a.e0.w.a.a(aVar2));
            d.a.h0.a.e0.w.d.L().L0(aVar2.j);
            if (d.a.h0.a.m1.a.a.B(bVar2.d0())) {
                d.a.h0.a.c0.d.d.d.d();
                d.a.h0.a.c0.d.d.d.g().h("appready");
            }
            d.a.h0.a.r1.n.c g3 = f.V().g(j.b(i0.d(d2)));
            bVar3 = new d.a.h0.a.e0.w.b();
            if (gVar == null && !TextUtils.isEmpty(gVar.f44732a)) {
                bVar3.f42345a = gVar.f44732a;
            } else {
                bVar3.f42345a = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
            }
            bVar3.f42346b = d2;
            bVar3.f42348d = g3.f43862g;
            bVar3.f42347c = g2;
            bVar3.k = aVar2.f42342g;
            bVar3.f42349e = String.valueOf(bVar2.i0());
            bVar3.f42351g = z;
            bVar3.f42353i = bVar.J();
            if (d.a.h0.a.m1.a.a.C()) {
                bVar3.j = d.a.h0.a.c0.d.b.d();
            }
            if (d.a.h0.a.m1.a.a.B(bVar2.d0())) {
                d.a.h0.a.c0.d.d.d.g().h("pageready");
            }
            if (f42285b) {
                Log.d("AppLaunchMessenger", bVar3.toString());
            }
            i.n().A(new UbcFlowEvent("slave_dispatch_start"));
            d.a.h0.a.y1.a.d().i("slave_dispatch_start");
            bVar.K(bVar3);
            b0.d();
            bVar.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
            bVar.n(d2);
            d.a.h0.a.e0.w.d.L().B0(bVar.c(), d.a.h0.a.e0.w.b.a(bVar3));
            d.a.h0.a.z1.e.B(bVar.c(), bVar3.f42346b);
            if (f42285b) {
                Log.d("AppLaunchMessenger", "app path: " + aVar2.f42337b);
                Log.d("AppLaunchMessenger", "webviewId: " + bVar.c());
                Log.d("AppLaunchMessenger", "pageUrl: " + d2);
                Log.d("AppLaunchMessenger", "pagePath: " + bVar3.f42346b);
                Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar3.f42348d);
                Log.d("AppLaunchMessenger", "sConsole:" + bVar3.f42349e);
            }
            a(swanAppConfigData);
            this.f42286a = true;
        }
        z = true;
        aVar2.f42343h = z;
        aVar2.j = bVar.J();
        if (d.a.h0.a.m1.a.a.C()) {
        }
        O = bVar2.O();
        if (O != null) {
        }
        if (f42285b) {
        }
        i.n().A(new UbcFlowEvent("master_dispatch_start"));
        d.a.h0.a.y1.a.d().i("master_dispatch_start");
        aVar.C(aVar2);
        d.a.h0.a.e0.w.d.L().A0(d.a.h0.a.e0.w.a.a(aVar2));
        d.a.h0.a.e0.w.d.L().L0(aVar2.j);
        if (d.a.h0.a.m1.a.a.B(bVar2.d0())) {
        }
        d.a.h0.a.r1.n.c g32 = f.V().g(j.b(i0.d(d2)));
        bVar3 = new d.a.h0.a.e0.w.b();
        if (gVar == null) {
        }
        bVar3.f42345a = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
        bVar3.f42346b = d2;
        bVar3.f42348d = g32.f43862g;
        bVar3.f42347c = g2;
        bVar3.k = aVar2.f42342g;
        bVar3.f42349e = String.valueOf(bVar2.i0());
        bVar3.f42351g = z;
        bVar3.f42353i = bVar.J();
        if (d.a.h0.a.m1.a.a.C()) {
        }
        if (d.a.h0.a.m1.a.a.B(bVar2.d0())) {
        }
        if (f42285b) {
        }
        i.n().A(new UbcFlowEvent("slave_dispatch_start"));
        d.a.h0.a.y1.a.d().i("slave_dispatch_start");
        bVar.K(bVar3);
        b0.d();
        bVar.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
        bVar.n(d2);
        d.a.h0.a.e0.w.d.L().B0(bVar.c(), d.a.h0.a.e0.w.b.a(bVar3));
        d.a.h0.a.z1.e.B(bVar.c(), bVar3.f42346b);
        if (f42285b) {
        }
        a(swanAppConfigData);
        this.f42286a = true;
    }

    public synchronized void d() {
        this.f42286a = false;
    }

    public b() {
        this.f42286a = false;
    }
}
