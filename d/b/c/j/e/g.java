package d.b.c.j.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f43132e;

    /* renamed from: f  reason: collision with root package name */
    public n f43133f;

    public n g() {
        return this.f43133f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return this.f43132e;
    }

    public void j(n nVar) {
        this.f43133f = nVar;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.f43132e = bdUniqueId;
    }
}
