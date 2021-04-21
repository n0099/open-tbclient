package d.b.h0.a.e0.p;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class e extends f {
    public static final boolean G = d.b.h0.a.k.f45772a;

    public e(String str) {
        super(str);
    }

    @Override // d.b.h0.a.e0.p.f, d.b.h0.l.h.g
    public void B(d.b.h0.l.k.a aVar) {
        super.B(aVar);
        if (G) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        E0("checkForUpdate", false);
        j0(aVar.f49635a);
        if (d.b.h0.a.e0.p.p.a.m(aVar)) {
            d.b.h0.a.e0.p.p.a.c(this.r);
        }
    }

    @Override // d.b.h0.l.h.g
    public void E() {
        super.E();
        if (this.q != null) {
            r0();
            E0("checkForUpdate", false);
            d.b.h0.a.e0.p.p.a.c(this.r);
        }
    }

    public final void E0(String str, boolean z) {
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        h.f(str, this.r, z);
    }

    @Override // d.b.h0.a.e0.p.f, d.b.h0.l.h.g
    public void F(d.b.h0.l.r.f fVar) {
        super.F(fVar);
        if (fVar == null || !fVar.d()) {
            return;
        }
        E0("checkForUpdate", true);
    }

    @Override // d.b.h0.l.h.g
    public void G(String str, int i) {
        super.G(str, i);
        d.b.h0.l.l.c a2 = d.b.h0.l.l.c.a(str);
        if (a2 == null) {
            return;
        }
        boolean b2 = d.b.h0.l.r.e.b(a2.c());
        d.b.h0.a.c0.c.g("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b2);
        if (b2) {
            d.b.h0.a.n1.c.a e2 = d.b.h0.a.n1.c.a.e();
            d.b.h0.a.n1.c.c cVar = new d.b.h0.a.n1.c.c(129);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    @Override // d.b.h0.a.e0.p.j
    public int J() {
        return 3;
    }

    @Override // d.b.h0.a.e0.p.f
    public PMSDownloadType h0() {
        return PMSDownloadType.ASYNC;
    }

    @Override // d.b.h0.a.e0.p.f
    public void s0() {
        super.s0();
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.b.h0.a.f2.a C0 = C0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (C0 == null) {
            if (G) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            E0("updateReady", true);
            x0("main_async_download", "0");
            d.b.h0.a.e0.p.p.a.c(this.r);
        } else if (G) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // d.b.h0.a.e0.p.f
    public void t0(Throwable th) {
        E0("updateFailed", false);
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (G) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage());
            }
        } else if (G) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 未知错误：" + th.getMessage());
        }
    }
}
