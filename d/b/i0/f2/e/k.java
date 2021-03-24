package d.b.i0.f2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseCardInfo implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f54796f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<c> f54797e;

    public List<c> g() {
        return this.f54797e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f54796f;
    }

    public void j(List<c> list) {
        this.f54797e = list;
    }
}
