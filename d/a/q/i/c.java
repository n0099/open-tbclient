package d.a.q.i;

import com.baidu.helios.ids.gaid.GaidProvider;
import d.a.q.h.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements b.a {
    @Override // d.a.q.h.b.a
    public List<d.a.q.h.a> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.q.h.c.a());
        arrayList.add(new d.a.q.h.f.a());
        arrayList.add(new GaidProvider());
        arrayList.add(new d.a.q.h.g.a());
        arrayList.add(new d.a.q.h.e.a());
        return arrayList;
    }
}
