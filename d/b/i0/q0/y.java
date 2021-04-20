package d.b.i0.q0;

import com.baidu.adp.BdUniqueId;
import d.b.h0.r.q.q1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class y extends d.b.i0.x.e0.a {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.b1.b.c> f60418e = new ArrayList();

    public void g(a1 a1Var) {
        this.f60418e.add(a1Var);
    }

    public List<d.b.i0.b1.b.c> getDataList() {
        return this.f60418e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return q1.G3;
    }
}
