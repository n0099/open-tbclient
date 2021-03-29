package d.b.g0.a.e0.p;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class e extends f {
    public static final boolean G = d.b.g0.a.k.f45051a;

    public e(String str) {
        super(str);
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void C(d.b.g0.l.k.a aVar) {
        super.C(aVar);
        if (G) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        F0("checkForUpdate", false);
        k0(aVar.f48914a);
        if (d.b.g0.a.e0.p.p.a.m(aVar)) {
            d.b.g0.a.e0.p.p.a.c(this.r);
        }
    }

    @Override // d.b.g0.l.h.g
    public void F() {
        super.F();
        if (this.q != null) {
            s0();
            F0("checkForUpdate", false);
            d.b.g0.a.e0.p.p.a.c(this.r);
        }
    }

    public final void F0(String str, boolean z) {
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        h.f(str, this.r, z);
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void G(d.b.g0.l.r.f fVar) {
        super.G(fVar);
        if (fVar == null || !fVar.d()) {
            return;
        }
        F0("checkForUpdate", true);
    }

    @Override // d.b.g0.l.h.g
    public void H(String str, int i) {
        super.H(str, i);
        d.b.g0.l.l.c a2 = d.b.g0.l.l.c.a(str);
        if (a2 == null) {
            return;
        }
        boolean b2 = d.b.g0.l.r.e.b(a2.c());
        d.b.g0.a.c0.c.g("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b2);
        if (b2) {
            d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
            d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(129);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    @Override // d.b.g0.a.e0.p.j
    public int K() {
        return 3;
    }

    @Override // d.b.g0.a.e0.p.f
    public PMSDownloadType i0() {
        return PMSDownloadType.ASYNC;
    }

    @Override // d.b.g0.a.e0.p.f
    public void t0() {
        super.t0();
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.b.g0.a.f2.a D0 = D0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (D0 == null) {
            if (G) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            F0("updateReady", true);
            y0("main_async_download", "0");
            d.b.g0.a.e0.p.p.a.c(this.r);
        } else if (G) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // d.b.g0.a.e0.p.f
    public void u0(Throwable th) {
        F0("updateFailed", false);
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
