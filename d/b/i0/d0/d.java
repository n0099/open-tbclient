package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53629f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p0.u1.c.b f53630e;

    public d.b.i0.p0.u1.c.b g() {
        return this.f53630e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53629f;
    }

    public void j(d.b.i0.p0.u1.c.b bVar) {
        this.f53630e = bVar;
    }
}
