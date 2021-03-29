package d.b.i0.p0.s1.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f58522f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a2 f58523e;

    public a2 g() {
        return this.f58523e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f58522f;
    }

    public void j(a2 a2Var) {
        this.f58523e = a2Var;
    }
}
