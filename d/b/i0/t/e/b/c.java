package d.b.i0.t.e.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f62248f = BdUniqueId.gen();

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f62249g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f62250e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f62250e;
        if (a2Var != null && a2Var.q1() != null && this.f62250e.q1().live_type == 1) {
            return f62249g;
        }
        return f62248f;
    }
}
