package d.a.o0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseCardInfo implements d.a.c.k.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f59385f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<c> f59386e;

    public List<c> c() {
        return this.f59386e;
    }

    public void g(List<c> list) {
        this.f59386e = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f59385f;
    }
}
