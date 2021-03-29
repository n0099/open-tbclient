package d.b.g0.a.e0.p.p;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.h.a.a;
import d.b.g0.a.e0.p.f;
import d.b.g0.a.j0.c;
import d.b.g0.a.j0.e;
import d.b.g0.a.k;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b extends f {
    public static final boolean H = k.f45051a;
    public a.c G;

    public b(String str, a.c cVar) {
        super(str);
        this.G = cVar;
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void C(d.b.g0.l.k.a aVar) {
        super.C(aVar);
        if (H) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        a.c cVar = this.G;
        if (cVar != null) {
            if (aVar.f48914a == 1010) {
                cVar.b();
            } else {
                cVar.a(0);
            }
        }
        k0(aVar.f48914a);
        if (a.m(aVar)) {
            a.c(this.r);
        }
    }

    @Override // d.b.g0.l.h.g
    public void F() {
        super.F();
        if (this.q != null) {
            s0();
            a.c(this.r);
        }
    }

    @Override // d.b.g0.a.e0.p.j
    public int K() {
        return 7;
    }

    @Override // d.b.g0.a.e0.p.f
    public PMSDownloadType i0() {
        return PMSDownloadType.PRE;
    }

    @Override // d.b.g0.a.e0.p.f
    public void t0() {
        super.t0();
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.b.g0.a.f2.a D0 = D0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (D0 == null) {
            a.c(this.r);
            a.c cVar = this.G;
            if (cVar != null) {
                cVar.b();
            }
        } else {
            a.c cVar2 = this.G;
            if (cVar2 != null) {
                cVar2.a(5);
            }
        }
        y0("main_pre_download", this.t);
        HashSet hashSet = new HashSet();
        hashSet.add(this.r);
        c d2 = e.c().d();
        d.b.g0.a.j0.j.c k = d.b.g0.a.j0.j.c.k();
        k.h(7);
        d2.q(hashSet, k.j());
    }

    @Override // d.b.g0.a.e0.p.f
    public void u0(Throwable th) {
        a.c cVar = this.G;
        if (cVar != null) {
            cVar.a(0);
        }
    }
}
