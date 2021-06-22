package d.a.o0.b1.b.b;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.n0.r.q.a2;
import d.a.o0.b1.j.h.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<a2> f55066a = new ArrayList();

    public c a(int i2, boolean z, d.a.o0.b1.b.a.a aVar) {
        c cVar = new c();
        cVar.f55716c = aVar.e();
        cVar.f55718e = aVar.a();
        cVar.f55719f = aVar.b();
        ArrayList<a2> d2 = aVar.d();
        if (z) {
            if (!ListUtils.isEmpty(d2)) {
                this.f55066a.clear();
                this.f55066a.addAll(d2);
                cVar.f55717d = 1;
            }
        } else if (!ListUtils.isEmpty(d2)) {
            this.f55066a.addAll(d2);
            cVar.f55717d = i2 + 1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f55066a);
        d.a.o0.b1.j.a.c(true, arrayList, aVar.c());
        cVar.f55714a = d.a.o0.b1.j.a.a(arrayList);
        return cVar;
    }

    public List<a2> b() {
        return this.f55066a;
    }

    public boolean c() {
        List<a2> list = this.f55066a;
        if (list == null) {
            return false;
        }
        return !ListUtils.isEmpty(list);
    }
}
