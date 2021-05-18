package d.a.j0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f50040h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f50041e;

    /* renamed from: f  reason: collision with root package name */
    public String f50042f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f50043g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f50040h;
    }

    public ICardInfo h() {
        return this.f50043g;
    }

    public boolean isValid() {
        return this.f50041e;
    }

    public void l() {
        ICardInfo i2 = d.a.k0.j1.o.b.i(this.f50042f);
        this.f50043g = i2;
        this.f50041e = i2 != null;
    }

    public void m(String str) {
        this.f50042f = str;
    }
}
