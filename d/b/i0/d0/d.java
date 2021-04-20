package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53669f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q0.u1.c.b f53670e;

    public d.b.i0.q0.u1.c.b g() {
        return this.f53670e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53669f;
    }

    public void j(d.b.i0.q0.u1.c.b bVar) {
        this.f53670e = bVar;
    }
}
