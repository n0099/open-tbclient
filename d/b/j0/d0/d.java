package d.b.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f54090f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.q0.u1.c.b f54091e;

    public d.b.j0.q0.u1.c.b g() {
        return this.f54091e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f54090f;
    }

    public void j(d.b.j0.q0.u1.c.b bVar) {
        this.f54091e = bVar;
    }
}
