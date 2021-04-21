package d.b.i0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f51592h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f51593e;

    /* renamed from: f  reason: collision with root package name */
    public String f51594f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f51595g;

    public ICardInfo g() {
        return this.f51595g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f51592h;
    }

    public boolean isValid() {
        return this.f51593e;
    }

    public void j() {
        ICardInfo i = d.b.j0.j1.o.b.i(this.f51594f);
        this.f51595g = i;
        this.f51593e = i != null;
    }

    public void n(String str) {
        this.f51594f = str;
    }
}
