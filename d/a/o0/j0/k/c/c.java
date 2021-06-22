package d.a.o0.j0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59825g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public b f59826e;

    /* renamed from: f  reason: collision with root package name */
    public b f59827f;

    public void c(b bVar) {
        this.f59826e = bVar;
    }

    public void g(b bVar) {
        this.f59827f = bVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f59825g;
    }
}
