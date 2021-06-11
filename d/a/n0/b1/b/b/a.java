package d.a.n0.b1.b.b;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.r.q.a2;
import d.a.n0.b1.j.h.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<a2> f54941a = new ArrayList();

    public c a(int i2, boolean z, d.a.n0.b1.b.a.a aVar) {
        c cVar = new c();
        cVar.f55591c = aVar.e();
        cVar.f55593e = aVar.a();
        cVar.f55594f = aVar.b();
        ArrayList<a2> d2 = aVar.d();
        if (z) {
            if (!ListUtils.isEmpty(d2)) {
                this.f54941a.clear();
                this.f54941a.addAll(d2);
                cVar.f55592d = 1;
            }
        } else if (!ListUtils.isEmpty(d2)) {
            this.f54941a.addAll(d2);
            cVar.f55592d = i2 + 1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f54941a);
        d.a.n0.b1.j.a.c(true, arrayList, aVar.c());
        cVar.f55589a = d.a.n0.b1.j.a.a(arrayList);
        return cVar;
    }

    public List<a2> b() {
        return this.f54941a;
    }

    public boolean c() {
        List<a2> list = this.f54941a;
        if (list == null) {
            return false;
        }
        return !ListUtils.isEmpty(list);
    }
}
