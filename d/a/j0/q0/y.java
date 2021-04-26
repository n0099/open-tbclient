package d.a.j0.q0;

import com.baidu.adp.BdUniqueId;
import d.a.i0.r.q.q1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class y extends d.a.j0.x.e0.a {

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.j0.b1.b.c> f58955e = new ArrayList();

    public List<d.a.j0.b1.b.c> getDataList() {
        return this.f58955e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return q1.G3;
    }

    public void h(a1 a1Var) {
        this.f58955e.add(a1Var);
    }
}
