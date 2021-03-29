package d.b.i0.f2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseCardInfo implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f54797f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<c> f54798e;

    public List<c> g() {
        return this.f54798e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f54797f;
    }

    public void j(List<c> list) {
        this.f54798e = list;
    }
}
