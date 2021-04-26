package d.a.j0.i0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55120g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public b f55121e;

    /* renamed from: f  reason: collision with root package name */
    public b f55122f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f55120g;
    }

    public void h(b bVar) {
        this.f55121e = bVar;
    }

    public void l(b bVar) {
        this.f55122f = bVar;
    }
}
