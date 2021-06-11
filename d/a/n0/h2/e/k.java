package d.a.n0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseCardInfo implements d.a.c.k.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f59260f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<c> f59261e;

    public List<c> c() {
        return this.f59261e;
    }

    public void g(List<c> list) {
        this.f59261e = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f59260f;
    }
}
