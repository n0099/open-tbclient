package d.a.m0.h.t.b;

import com.baidu.pyramid.annotation.Service;
import java.net.MalformedURLException;
@Service
/* loaded from: classes3.dex */
public class k implements d.a.m0.a.p.b.a.d {
    @Override // d.a.m0.a.p.b.a.d
    public String a() {
        return d.a.m0.h.c.f.g();
    }

    @Override // d.a.m0.a.p.b.a.d
    public boolean b() {
        d.a.m0.a.h0.g.d m;
        if (d.a.m0.a.a2.e.i() == null || !d.a.m0.a.a2.e.i().m0()) {
            return false;
        }
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null || (m = W.m()) == null || !(m instanceof d.a.m0.h.n.a)) {
            return true;
        }
        return ((d.a.m0.h.n.a) m).p3();
    }

    @Override // d.a.m0.a.p.b.a.d
    public String c(String str) throws MalformedURLException {
        return d.a.m0.h.c.f.d(str);
    }
}
