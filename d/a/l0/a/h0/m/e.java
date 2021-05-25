package d.a.l0.a.h0.m;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class e extends f {
    public static final boolean F = d.a.l0.a.k.f43199a;

    public e(String str) {
        super(str);
    }

    @Override // d.a.l0.a.h0.m.f, d.a.l0.n.f.g
    public void B(d.a.l0.n.h.a aVar) {
        super.B(aVar);
        if (F) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        E0("checkForUpdate", false);
        j0(aVar.f48002a);
        if (d.a.l0.a.h0.m.p.a.m(aVar)) {
            d.a.l0.a.h0.m.p.a.c(this.r);
        }
    }

    @Override // d.a.l0.n.f.g
    public void E() {
        super.E();
        if (this.q != null) {
            r0();
            E0("checkForUpdate", false);
            d.a.l0.a.h0.m.p.a.c(this.r);
        }
    }

    public final void E0(String str, boolean z) {
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        h.f(str, this.r, z);
    }

    @Override // d.a.l0.a.h0.m.f, d.a.l0.n.f.g
    public void F(d.a.l0.n.o.f fVar) {
        super.F(fVar);
        if (fVar == null || !fVar.d()) {
            return;
        }
        E0("checkForUpdate", true);
    }

    @Override // d.a.l0.n.f.g
    public void G(String str, int i2) {
        super.G(str, i2);
        d.a.l0.n.i.c a2 = d.a.l0.n.i.c.a(str);
        if (a2 == null) {
            return;
        }
        boolean b2 = d.a.l0.n.o.e.b(a2.c());
        d.a.l0.a.e0.d.g("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i2);
        if (b2) {
            d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
            d.a.l0.a.v1.c.c cVar = new d.a.l0.a.v1.c.c(129);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    @Override // d.a.l0.a.h0.m.j
    public int J() {
        return 3;
    }

    @Override // d.a.l0.a.h0.m.f
    public PMSDownloadType h0() {
        return PMSDownloadType.ASYNC;
    }

    @Override // d.a.l0.a.h0.m.f
    public void s0() {
        super.s0();
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.a.l0.a.q2.a C0 = C0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (C0 == null) {
            if (F) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            E0("updateReady", true);
            x0("main_async_download", "0");
            d.a.l0.a.h0.m.p.a.c(this.r);
        } else if (F) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // d.a.l0.a.h0.m.f
    public void t0(Throwable th) {
        E0("updateFailed", false);
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (F) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage());
            }
        } else if (F) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 未知错误：" + th.getMessage());
        }
    }
}
