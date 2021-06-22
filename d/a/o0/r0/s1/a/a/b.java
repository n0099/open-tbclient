package d.a.o0.r0.s1.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f63415f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f63416e;

    public a2 c() {
        return this.f63416e;
    }

    public void g(a2 a2Var) {
        this.f63416e = a2Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f63415f;
    }
}
