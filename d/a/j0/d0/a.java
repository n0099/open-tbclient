package d.a.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f51858f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f51859e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51858f;
    }

    public a2 h() {
        return this.f51859e;
    }

    public void l(a2 a2Var) {
        this.f51859e = a2Var;
    }
}
