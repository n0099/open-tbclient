package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f50084h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f50085e;

    /* renamed from: f  reason: collision with root package name */
    public String f50086f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f50087g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f50084h;
    }

    public ICardInfo h() {
        return this.f50087g;
    }

    public boolean isValid() {
        return this.f50085e;
    }

    public void l() {
        ICardInfo i2 = d.a.n0.k1.o.b.i(this.f50086f);
        this.f50087g = i2;
        this.f50085e = i2 != null;
    }

    public void m(String str) {
        this.f50086f = str;
    }
}
