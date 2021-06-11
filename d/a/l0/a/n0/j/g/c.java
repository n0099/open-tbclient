package d.a.l0.a.n0.j.g;

import androidx.annotation.NonNull;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends a {
    public c(@NonNull d.a.l0.a.n0.j.f.a aVar) {
        super(aVar);
    }

    @Override // d.a.l0.a.n0.j.g.a
    public void e() {
        d();
        d.a.l0.t.d.L(d.a.l0.a.k2.b.w());
        d.a.l0.a.t1.e.a.a();
        d.a.l0.t.d.K(d.a.l0.a.h0.o.h.d.a.a().b());
        d.a.l0.t.d.L(d.a.l0.a.b2.a.c.e());
        Map<String, PMSAppInfo> t = d.a.l0.n.g.a.h().t();
        d.a.l0.a.n0.d d2 = d.a.l0.a.n0.f.c().d();
        ArrayList arrayList = new ArrayList(t.keySet());
        d.a.l0.a.n0.l.c l = d.a.l0.a.n0.l.c.l();
        l.i(15);
        d2.g(arrayList, true, false, l.k());
    }
}
