package d.a.o0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56582f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r0.u1.c.b f56583e;

    public d.a.o0.r0.u1.c.b c() {
        return this.f56583e;
    }

    public void g(d.a.o0.r0.u1.c.b bVar) {
        this.f56583e = bVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56582f;
    }
}
