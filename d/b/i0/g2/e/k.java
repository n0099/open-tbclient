package d.b.i0.g2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class k extends BaseCardInfo implements d.b.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f56267f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<c> f56268e;

    public List<c> g() {
        return this.f56268e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f56267f;
    }

    public void j(List<c> list) {
        this.f56268e = list;
    }
}
