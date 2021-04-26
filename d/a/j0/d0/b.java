package d.a.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f51860f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f51861e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51860f;
    }

    public a2 h() {
        return this.f51861e;
    }

    public void l(a2 a2Var) {
        this.f51861e = a2Var;
    }
}
