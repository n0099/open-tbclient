package d.a.c.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f43053e;

    /* renamed from: f  reason: collision with root package name */
    public n f43054f;

    public n c() {
        return this.f43054f;
    }

    public void g(n nVar) {
        this.f43054f = nVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return this.f43053e;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.f43053e = bdUniqueId;
    }
}
