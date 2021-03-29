package d.b.i0.i0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55646g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public b f55647e;

    /* renamed from: f  reason: collision with root package name */
    public b f55648f;

    public void g(b bVar) {
        this.f55647e = bVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f55646g;
    }

    public void j(b bVar) {
        this.f55648f = bVar;
    }
}
