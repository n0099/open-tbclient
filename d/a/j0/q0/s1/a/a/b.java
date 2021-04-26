package d.a.j0.q0.s1.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f58716f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f58717e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f58716f;
    }

    public a2 h() {
        return this.f58717e;
    }

    public void l(a2 a2Var) {
        this.f58717e = a2Var;
    }
}
