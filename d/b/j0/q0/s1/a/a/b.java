package d.b.j0.q0.s1.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60611f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f60612e;

    public a2 g() {
        return this.f60612e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f60611f;
    }

    public void j(a2 a2Var) {
        this.f60612e = a2Var;
    }
}
