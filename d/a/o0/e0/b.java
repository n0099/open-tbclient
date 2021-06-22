package d.a.o0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56578f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f56579e;

    public a2 c() {
        return this.f56579e;
    }

    public void g(a2 a2Var) {
        this.f56579e = a2Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56578f;
    }
}
