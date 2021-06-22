package d.a.n0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f53867h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f53868e;

    /* renamed from: f  reason: collision with root package name */
    public String f53869f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f53870g;

    public ICardInfo c() {
        return this.f53870g;
    }

    public void g() {
        ICardInfo i2 = d.a.o0.k1.o.b.i(this.f53869f);
        this.f53870g = i2;
        this.f53868e = i2 != null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f53867h;
    }

    public void i(String str) {
        this.f53869f = str;
    }

    public boolean isValid() {
        return this.f53868e;
    }
}
