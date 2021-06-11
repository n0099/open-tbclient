package d.a.c.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f42950e;

    /* renamed from: f  reason: collision with root package name */
    public n f42951f;

    public n c() {
        return this.f42951f;
    }

    public void g(n nVar) {
        this.f42951f = nVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return this.f42950e;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.f42950e = bdUniqueId;
    }
}
