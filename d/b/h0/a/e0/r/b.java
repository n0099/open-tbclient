package d.b.h0.a.e0.r;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.i2.b0;
import d.b.h0.a.i2.i0;
import d.b.h0.a.j1.i;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.k.p0.c;
import d.b.h0.a.t1.k.p0.j;
import d.b.h0.a.u0.d;
import d.b.h0.a.z0.f;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44980b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f44981a;

    /* renamed from: d.b.h0.a.e0.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0713b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44982a = new b();
    }

    public static b c() {
        return C0713b.f44982a;
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (f44980b) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        d.b.h0.a.e0.s.a.e().i(swanAppConfigData);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0102 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0179 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0189 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0196 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e6 A[Catch: all -> 0x027e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0014, B:10:0x001a, B:12:0x0034, B:14:0x003c, B:16:0x0064, B:18:0x0087, B:23:0x0095, B:25:0x00a3, B:26:0x00a9, B:28:0x00af, B:30:0x00bb, B:31:0x00bd, B:33:0x00c1, B:34:0x00ca, B:36:0x0102, B:37:0x010e, B:39:0x0125, B:41:0x012d, B:43:0x0155, B:45:0x0179, B:46:0x017f, B:48:0x0189, B:49:0x0192, B:51:0x0196, B:52:0x019f, B:54:0x01e6, B:55:0x0277, B:42:0x0132, B:15:0x0041), top: B:61:0x0001 }] */
    /* JADX WARN: Type inference failed for: r9v20, types: [d.b.h0.a.p.d.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d.b.h0.a.e0.o.a aVar, @NonNull d.b.h0.a.p.d.b bVar, @NonNull d.b.h0.a.y0.e.b bVar2, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.g gVar) {
        boolean z;
        Bundle O;
        d.b.h0.a.e0.w.b bVar3;
        if (f44980b) {
            Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
            Log.d("SwanPrelink", "start dispatch launch event");
        }
        if (this.f44981a) {
            return;
        }
        String d2 = c.d(f.V(), bVar2, swanAppConfigData);
        String g2 = swanAppConfigData.g(d2);
        d.b.h0.a.e0.w.a aVar2 = new d.b.h0.a.e0.w.a();
        aVar2.f45030a = swanAppConfigData.l;
        swanAppConfigData.l = null;
        if (gVar != null && !TextUtils.isEmpty(gVar.f47321a)) {
            aVar2.f45031b = gVar.f47321a;
        } else {
            aVar2.f45031b = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
        }
        aVar2.f45032c = bVar.c();
        aVar2.f45033d = d2;
        aVar2.f45035f = String.valueOf(d.b.h0.a.c0.a.a());
        aVar2.f45036g = d.b.h0.a.e0.w.a.b(e.y(), d2);
        aVar2.i = g2;
        if (!f44980b && !f.V().O()) {
            z = false;
            aVar2.f45037h = z;
            aVar2.j = bVar.w();
            if (d.b.h0.a.m1.a.a.C()) {
                aVar2.k = d.b.h0.a.c0.d.b.b();
            }
            O = bVar2.O();
            if (O != null) {
                String string = O.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    aVar2.f45034e = string;
                }
            }
            if (f44980b) {
                Log.d("AppLaunchMessenger", aVar2.toString());
            }
            i.n().A(new UbcFlowEvent("master_dispatch_start"));
            d.b.h0.a.y1.a.d().i("master_dispatch_start");
            aVar.j(aVar2);
            d.b.h0.a.e0.w.d.L().A0(d.b.h0.a.e0.w.a.a(aVar2));
            d.b.h0.a.e0.w.d.L().L0(aVar2.j);
            if (d.b.h0.a.m1.a.a.B(bVar2.d0())) {
                d.b.h0.a.c0.d.d.d.d();
                d.b.h0.a.c0.d.d.d.g().h("appready");
            }
            d.b.h0.a.r1.n.c k = f.V().k(j.b(i0.d(d2)));
            bVar3 = new d.b.h0.a.e0.w.b();
            if (gVar == null && !TextUtils.isEmpty(gVar.f47321a)) {
                bVar3.f45038a = gVar.f47321a;
            } else {
                bVar3.f45038a = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
            }
            bVar3.f45039b = d2;
            bVar3.f45041d = k.f46498g;
            bVar3.f45040c = g2;
            bVar3.k = aVar2.f45036g;
            bVar3.f45042e = String.valueOf(bVar2.i0());
            bVar3.f45044g = z;
            bVar3.i = bVar.w();
            if (d.b.h0.a.m1.a.a.C()) {
                bVar3.j = d.b.h0.a.c0.d.b.d();
            }
            if (d.b.h0.a.m1.a.a.B(bVar2.d0())) {
                d.b.h0.a.c0.d.d.d.g().h("pageready");
            }
            if (f44980b) {
                Log.d("AppLaunchMessenger", bVar3.toString());
            }
            i.n().A(new UbcFlowEvent("slave_dispatch_start"));
            d.b.h0.a.y1.a.d().i("slave_dispatch_start");
            bVar.x(bVar3);
            b0.d();
            bVar.F().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
            bVar.s(d2);
            d.b.h0.a.e0.w.d.L().B0(bVar.c(), d.b.h0.a.e0.w.b.a(bVar3));
            d.b.h0.a.z1.e.B(bVar.c(), bVar3.f45039b);
            if (f44980b) {
                Log.d("AppLaunchMessenger", "app path: " + aVar2.f45031b);
                Log.d("AppLaunchMessenger", "webviewId: " + bVar.c());
                Log.d("AppLaunchMessenger", "pageUrl: " + d2);
                Log.d("AppLaunchMessenger", "pagePath: " + bVar3.f45039b);
                Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar3.f45041d);
                Log.d("AppLaunchMessenger", "sConsole:" + bVar3.f45042e);
            }
            a(swanAppConfigData);
            this.f44981a = true;
        }
        z = true;
        aVar2.f45037h = z;
        aVar2.j = bVar.w();
        if (d.b.h0.a.m1.a.a.C()) {
        }
        O = bVar2.O();
        if (O != null) {
        }
        if (f44980b) {
        }
        i.n().A(new UbcFlowEvent("master_dispatch_start"));
        d.b.h0.a.y1.a.d().i("master_dispatch_start");
        aVar.j(aVar2);
        d.b.h0.a.e0.w.d.L().A0(d.b.h0.a.e0.w.a.a(aVar2));
        d.b.h0.a.e0.w.d.L().L0(aVar2.j);
        if (d.b.h0.a.m1.a.a.B(bVar2.d0())) {
        }
        d.b.h0.a.r1.n.c k2 = f.V().k(j.b(i0.d(d2)));
        bVar3 = new d.b.h0.a.e0.w.b();
        if (gVar == null) {
        }
        bVar3.f45038a = d.e.h(bVar2.G(), bVar2.n1()).getPath() + File.separator;
        bVar3.f45039b = d2;
        bVar3.f45041d = k2.f46498g;
        bVar3.f45040c = g2;
        bVar3.k = aVar2.f45036g;
        bVar3.f45042e = String.valueOf(bVar2.i0());
        bVar3.f45044g = z;
        bVar3.i = bVar.w();
        if (d.b.h0.a.m1.a.a.C()) {
        }
        if (d.b.h0.a.m1.a.a.B(bVar2.d0())) {
        }
        if (f44980b) {
        }
        i.n().A(new UbcFlowEvent("slave_dispatch_start"));
        d.b.h0.a.y1.a.d().i("slave_dispatch_start");
        bVar.x(bVar3);
        b0.d();
        bVar.F().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d2);
        bVar.s(d2);
        d.b.h0.a.e0.w.d.L().B0(bVar.c(), d.b.h0.a.e0.w.b.a(bVar3));
        d.b.h0.a.z1.e.B(bVar.c(), bVar3.f45039b);
        if (f44980b) {
        }
        a(swanAppConfigData);
        this.f44981a = true;
    }

    public synchronized void d() {
        this.f44981a = false;
    }

    public b() {
        this.f44981a = false;
    }
}
