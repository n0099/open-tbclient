package d.b.j0.t.e.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f62669f = BdUniqueId.gen();

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f62670g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f62671e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f62671e;
        if (a2Var != null && a2Var.q1() != null && this.f62671e.q1().live_type == 1) {
            return f62670g;
        }
        return f62669f;
    }
}
