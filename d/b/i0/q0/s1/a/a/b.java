package d.b.i0.q0.s1.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60190f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f60191e;

    public a2 g() {
        return this.f60191e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f60190f;
    }

    public void j(a2 a2Var) {
        this.f60191e = a2Var;
    }
}
