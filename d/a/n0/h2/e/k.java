package d.a.n0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseCardInfo implements d.a.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f55571f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<c> f55572e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f55571f;
    }

    public List<c> h() {
        return this.f55572e;
    }

    public void l(List<c> list) {
        this.f55572e = list;
    }
}
