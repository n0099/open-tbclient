package d.a.i0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f49221h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f49222e;

    /* renamed from: f  reason: collision with root package name */
    public String f49223f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f49224g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f49221h;
    }

    public ICardInfo h() {
        return this.f49224g;
    }

    public boolean isValid() {
        return this.f49222e;
    }

    public void l() {
        ICardInfo i2 = d.a.j0.j1.o.b.i(this.f49223f);
        this.f49224g = i2;
        this.f49222e = i2 != null;
    }

    public void m(String str) {
        this.f49223f = str;
    }
}
