package d.a.n0.b1.j.j;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.r.q.a2;
import d.a.n0.b1.j.h.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<a2> f55597a = new ArrayList();

    public c a(boolean z, d.a.n0.b1.j.h.a aVar) {
        c cVar = new c();
        cVar.f55591c = aVar.i();
        cVar.f55593e = aVar.a();
        cVar.f55594f = aVar.c();
        ArrayList<a2> h2 = aVar.h();
        if (z) {
            if (!ListUtils.isEmpty(h2)) {
                this.f55597a.clear();
                this.f55597a.addAll(h2);
            }
        } else if (!ListUtils.isEmpty(h2)) {
            this.f55597a.addAll(h2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f55597a);
        d.a.n0.b1.j.a.c(true, arrayList, aVar.e());
        d.a.n0.b1.j.a.c(true, arrayList, aVar.f());
        d.a.n0.b1.j.a.c(true, arrayList, aVar.d());
        d.a.n0.b1.j.a.c(true, arrayList, aVar.g());
        cVar.f55589a = d.a.n0.b1.j.a.a(arrayList);
        return cVar;
    }

    public List<a2> b() {
        return this.f55597a;
    }

    public boolean c() {
        List<a2> list = this.f55597a;
        if (list == null) {
            return false;
        }
        return !ListUtils.isEmpty(list);
    }
}
