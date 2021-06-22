package d.a.o0.v.e.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f65709f = BdUniqueId.gen();

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f65710g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f65711e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f65711e;
        if (a2Var != null && a2Var.s1() != null && this.f65711e.s1().live_type == 1) {
            return f65710g;
        }
        return f65709f;
    }
}
