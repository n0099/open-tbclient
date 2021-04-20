package d.b.i0.i0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f56769g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public b f56770e;

    /* renamed from: f  reason: collision with root package name */
    public b f56771f;

    public void g(b bVar) {
        this.f56770e = bVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f56769g;
    }

    public void j(b bVar) {
        this.f56771f = bVar;
    }
}
