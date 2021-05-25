package d.a.n0.r0.s1.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f59599f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f59600e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59599f;
    }

    public a2 h() {
        return this.f59600e;
    }

    public void l(a2 a2Var) {
        this.f59600e = a2Var;
    }
}
