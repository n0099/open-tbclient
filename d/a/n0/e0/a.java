package d.a.n0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f52762f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f52763e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52762f;
    }

    public a2 h() {
        return this.f52763e;
    }

    public void l(a2 a2Var) {
        this.f52763e = a2Var;
    }
}
