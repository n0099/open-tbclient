package d.a.k0.i0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55827g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public b f55828e;

    /* renamed from: f  reason: collision with root package name */
    public b f55829f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f55827g;
    }

    public void h(b bVar) {
        this.f55828e = bVar;
    }

    public void l(b bVar) {
        this.f55829f = bVar;
    }
}
