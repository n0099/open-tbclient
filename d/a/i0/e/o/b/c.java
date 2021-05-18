package d.a.i0.e.o.b;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.i0.a.h0.s.e;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.p.d.i1;
@Service
/* loaded from: classes3.dex */
public class c implements i1 {
    @Override // d.a.i0.a.p.d.i1
    public d.a.i0.n.l.b a() {
        return b.b().a();
    }

    @Override // d.a.i0.a.p.d.i1
    public void b(e eVar, d.a.i0.a.h0.s.c cVar) {
        if (cVar == null) {
            return;
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f42397a)) {
            String str = eVar.f42397a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1195918653) {
                if (hashCode == 1825003424 && str.equals("by_click")) {
                    c2 = 0;
                }
            } else if (str.equals("by_silent")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    cVar.onFail();
                    return;
                } else {
                    b.b().b(true, cVar);
                    return;
                }
            } else if (eVar.f42398b) {
                b.b().b(false, cVar);
                return;
            } else {
                b.b().b(true, cVar);
                return;
            }
        }
        cVar.onFail();
    }

    @Override // d.a.i0.a.p.d.i1
    public boolean c() {
        return d() || d.a.i0.a.n0.k.c.f43471d.w() || (d.a.i0.a.n0.k.c.f43471d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && g.N().i0());
    }

    @Override // d.a.i0.a.p.d.i1
    public boolean d() {
        return !b.b().c();
    }
}
