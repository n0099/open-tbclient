package d.a.k0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.j0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f52559f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f52560e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52559f;
    }

    public a2 h() {
        return this.f52560e;
    }

    public void l(a2 a2Var) {
        this.f52560e = a2Var;
    }
}
