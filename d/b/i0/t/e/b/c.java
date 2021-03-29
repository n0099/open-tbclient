package d.b.i0.t.e.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60684f = BdUniqueId.gen();

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60685g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f60686e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f60686e;
        if (a2Var != null && a2Var.q1() != null && this.f60686e.q1().live_type == 1) {
            return f60685g;
        }
        return f60684f;
    }
}
