package d.b.b.j.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f42395e;

    /* renamed from: f  reason: collision with root package name */
    public n f42396f;

    public n g() {
        return this.f42396f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return this.f42395e;
    }

    public void j(n nVar) {
        this.f42396f = nVar;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.f42395e = bdUniqueId;
    }
}
