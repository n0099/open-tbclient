package d.a.o0.r0;

import com.baidu.adp.BdUniqueId;
import d.a.n0.r.q.q1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class y extends d.a.o0.z.e0.a {

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.o0.c1.b.c> f63654e = new ArrayList();

    public void c(a1 a1Var) {
        this.f63654e.add(a1Var);
    }

    public List<d.a.o0.c1.b.c> getDataList() {
        return this.f63654e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return q1.L3;
    }
}
