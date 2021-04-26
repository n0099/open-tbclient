package d.a.j0.t.e.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60857f = BdUniqueId.gen();

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60858g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f60859e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f60859e;
        if (a2Var != null && a2Var.q1() != null && this.f60859e.q1().live_type == 1) {
            return f60858g;
        }
        return f60857f;
    }
}
