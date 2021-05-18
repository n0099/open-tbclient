package d.a.k0.t.e.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.j0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f61581f = BdUniqueId.gen();

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61582g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f61583e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f61583e;
        if (a2Var != null && a2Var.q1() != null && this.f61583e.q1().live_type == 1) {
            return f61582g;
        }
        return f61581f;
    }
}
