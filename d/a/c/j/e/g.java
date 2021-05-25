package d.a.c.j.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class g extends BaseCardInfo {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f39269e;

    /* renamed from: f  reason: collision with root package name */
    public n f39270f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.f39269e;
    }

    public n h() {
        return this.f39270f;
    }

    public void l(n nVar) {
        this.f39270f = nVar;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.f39269e = bdUniqueId;
    }
}
