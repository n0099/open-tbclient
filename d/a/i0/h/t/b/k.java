package d.a.i0.h.t.b;

import com.baidu.pyramid.annotation.Service;
import java.net.MalformedURLException;
@Service
/* loaded from: classes3.dex */
public class k implements d.a.i0.a.p.b.a.d {
    @Override // d.a.i0.a.p.b.a.d
    public String a() {
        return d.a.i0.h.c.f.g();
    }

    @Override // d.a.i0.a.p.b.a.d
    public boolean b() {
        d.a.i0.a.h0.g.d m;
        if (d.a.i0.a.a2.e.i() == null || !d.a.i0.a.a2.e.i().m0()) {
            return false;
        }
        d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
        if (W == null || (m = W.m()) == null || !(m instanceof d.a.i0.h.n.a)) {
            return true;
        }
        return ((d.a.i0.h.n.a) m).p3();
    }

    @Override // d.a.i0.a.p.b.a.d
    public String c(String str) throws MalformedURLException {
        return d.a.i0.h.c.f.d(str);
    }
}
