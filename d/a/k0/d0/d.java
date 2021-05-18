package d.a.k0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f52563f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.q0.u1.c.b f52564e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52563f;
    }

    public d.a.k0.q0.u1.c.b h() {
        return this.f52564e;
    }

    public void l(d.a.k0.q0.u1.c.b bVar) {
        this.f52564e = bVar;
    }
}
