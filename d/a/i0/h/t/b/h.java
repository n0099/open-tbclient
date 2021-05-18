package d.a.i0.h.t.b;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import d.a.i0.a.c2.f.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Singleton
@Service
/* loaded from: classes3.dex */
public class h implements d.a.i0.a.p.b.a.b {
    @Override // d.a.i0.a.p.b.a.b
    public List<a0> a(d.a.i0.a.c2.e eVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.i0.h.m.b.c(eVar));
        arrayList.add(new d.a.i0.h.m.b.d(eVar));
        return arrayList;
    }

    @Override // d.a.i0.a.p.b.a.b
    public List<a0> b(d.a.i0.a.c2.e eVar) {
        return Arrays.asList(new d.a.i0.h.p.a.a(eVar), new d.a.i0.h.f.e(eVar), new d.a.i0.h.h.a(eVar), new d.a.i0.h.m.b.a(eVar));
    }

    @Override // d.a.i0.a.p.b.a.b
    public List<a0> c(d.a.i0.a.c2.e eVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.i0.h.e0.a.a.c(eVar));
        arrayList.add(new d.a.i0.h.e0.a.a.b(eVar));
        return arrayList;
    }
}
