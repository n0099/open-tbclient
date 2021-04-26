package d.a.j0.g2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class k extends BaseCardInfo implements d.a.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f54590f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<c> f54591e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f54590f;
    }

    public List<c> h() {
        return this.f54591e;
    }

    public void l(List<c> list) {
        this.f54591e = list;
    }
}
