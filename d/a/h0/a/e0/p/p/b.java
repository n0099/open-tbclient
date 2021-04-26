package d.a.h0.a.e0.p.p;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.e0.h.a.a;
import d.a.h0.a.e0.p.f;
import d.a.h0.a.j0.c;
import d.a.h0.a.j0.e;
import d.a.h0.a.k;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b extends f {
    public static final boolean H = k.f43101a;
    public a.c G;

    public b(String str, a.c cVar) {
        super(str);
        this.G = cVar;
    }

    @Override // d.a.h0.a.e0.p.f, d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        if (H) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        a.c cVar = this.G;
        if (cVar != null) {
            if (aVar.f47144a == 1010) {
                cVar.a();
            } else {
                cVar.b(0);
            }
        }
        j0(aVar.f47144a);
        if (a.m(aVar)) {
            a.c(this.r);
        }
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        if (this.q != null) {
            r0();
            a.c(this.r);
        }
    }

    @Override // d.a.h0.a.e0.p.j
    public int J() {
        return 7;
    }

    @Override // d.a.h0.a.e0.p.f
    public PMSDownloadType h0() {
        return PMSDownloadType.PRE;
    }

    @Override // d.a.h0.a.e0.p.f
    public void s0() {
        super.s0();
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.a.h0.a.f2.a C0 = C0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (C0 == null) {
            a.c(this.r);
            a.c cVar = this.G;
            if (cVar != null) {
                cVar.a();
            }
        } else {
            a.c cVar2 = this.G;
            if (cVar2 != null) {
                cVar2.b(5);
            }
        }
        x0("main_pre_download", this.t);
        HashSet hashSet = new HashSet();
        hashSet.add(this.r);
        c d2 = e.c().d();
        d.a.h0.a.j0.j.c k = d.a.h0.a.j0.j.c.k();
        k.h(7);
        d2.q(hashSet, k.j());
    }

    @Override // d.a.h0.a.e0.p.f
    public void t0(Throwable th) {
        a.c cVar = this.G;
        if (cVar != null) {
            cVar.b(0);
        }
    }
}
