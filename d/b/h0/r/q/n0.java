package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f50849h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f50850e;

    /* renamed from: f  reason: collision with root package name */
    public String f50851f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f50852g;

    public ICardInfo g() {
        return this.f50852g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f50849h;
    }

    public boolean isValid() {
        return this.f50850e;
    }

    public void j() {
        ICardInfo i = d.b.i0.i1.o.b.i(this.f50851f);
        this.f50852g = i;
        this.f50850e = i != null;
    }

    public void n(String str) {
        this.f50851f = str;
    }
}
