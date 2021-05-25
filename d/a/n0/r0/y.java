package d.a.n0.r0;

import com.baidu.adp.BdUniqueId;
import d.a.m0.r.q.q1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class y extends d.a.n0.z.e0.a {

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.c1.b.c> f59838e = new ArrayList();

    public List<d.a.n0.c1.b.c> getDataList() {
        return this.f59838e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return q1.I3;
    }

    public void h(a1 a1Var) {
        this.f59838e.add(a1Var);
    }
}
