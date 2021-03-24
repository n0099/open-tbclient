package d.b.b.j.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f42394e;

    /* renamed from: f  reason: collision with root package name */
    public n f42395f;

    public n g() {
        return this.f42395f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return this.f42394e;
    }

    public void j(n nVar) {
        this.f42395f = nVar;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.f42394e = bdUniqueId;
    }
}
