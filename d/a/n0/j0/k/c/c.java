package d.a.n0.j0.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f56011g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public b f56012e;

    /* renamed from: f  reason: collision with root package name */
    public b f56013f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f56011g;
    }

    public void h(b bVar) {
        this.f56012e = bVar;
    }

    public void l(b bVar) {
        this.f56013f = bVar;
    }
}
