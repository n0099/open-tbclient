package d.b.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f54086f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f54087e;

    public a2 g() {
        return this.f54087e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f54086f;
    }

    public void j(a2 a2Var) {
        this.f54087e = a2Var;
    }
}
