package d.b.p.i;

import com.baidu.helios.ids.gaid.GaidProvider;
import d.b.p.h.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements b.a {
    @Override // d.b.p.h.b.a
    public List<d.b.p.h.a> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.b.p.h.c.a());
        arrayList.add(new d.b.p.h.f.a());
        arrayList.add(new GaidProvider());
        arrayList.add(new d.b.p.h.g.a());
        arrayList.add(new d.b.p.h.e.a());
        return arrayList;
    }
}
