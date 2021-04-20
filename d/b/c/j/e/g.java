package d.b.c.j.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f42892e;

    /* renamed from: f  reason: collision with root package name */
    public n f42893f;

    public n g() {
        return this.f42893f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return this.f42892e;
    }

    public void j(n nVar) {
        this.f42893f = nVar;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.f42892e = bdUniqueId;
    }
}
