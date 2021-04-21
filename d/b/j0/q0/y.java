package d.b.j0.q0;

import com.baidu.adp.BdUniqueId;
import d.b.i0.r.q.q1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class y extends d.b.j0.x.e0.a {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.j0.b1.b.c> f60839e = new ArrayList();

    public void g(a1 a1Var) {
        this.f60839e.add(a1Var);
    }

    public List<d.b.j0.b1.b.c> getDataList() {
        return this.f60839e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return q1.G3;
    }
}
