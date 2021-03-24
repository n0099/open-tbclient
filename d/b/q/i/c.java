package d.b.q.i;

import com.baidu.helios.ids.gaid.GaidProvider;
import d.b.q.h.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements b.a {
    @Override // d.b.q.h.b.a
    public List<d.b.q.h.a> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.b.q.h.c.a());
        arrayList.add(new d.b.q.h.f.a());
        arrayList.add(new GaidProvider());
        arrayList.add(new d.b.q.h.g.a());
        arrayList.add(new d.b.q.h.e.a());
        return arrayList;
    }
}
