package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53624f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f53625e;

    public a2 g() {
        return this.f53625e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53624f;
    }

    public void j(a2 a2Var) {
        this.f53625e = a2Var;
    }
}
