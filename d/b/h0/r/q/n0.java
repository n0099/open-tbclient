package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f50848h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f50849e;

    /* renamed from: f  reason: collision with root package name */
    public String f50850f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f50851g;

    public ICardInfo g() {
        return this.f50851g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f50848h;
    }

    public boolean isValid() {
        return this.f50849e;
    }

    public void j() {
        ICardInfo i = d.b.i0.i1.o.b.i(this.f50850f);
        this.f50851g = i;
        this.f50849e = i != null;
    }

    public void n(String str) {
        this.f50850f = str;
    }
}
