package d.a.n0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56457f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r0.u1.c.b f56458e;

    public d.a.n0.r0.u1.c.b c() {
        return this.f56458e;
    }

    public void g(d.a.n0.r0.u1.c.b bVar) {
        this.f56458e = bVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56457f;
    }
}
