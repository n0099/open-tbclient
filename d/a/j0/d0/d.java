package d.a.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f51864f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.q0.u1.c.b f51865e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51864f;
    }

    public d.a.j0.q0.u1.c.b h() {
        return this.f51865e;
    }

    public void l(d.a.j0.q0.u1.c.b bVar) {
        this.f51865e = bVar;
    }
}
