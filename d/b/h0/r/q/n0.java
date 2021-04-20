package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class n0 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f51256h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f51257e;

    /* renamed from: f  reason: collision with root package name */
    public String f51258f;

    /* renamed from: g  reason: collision with root package name */
    public ICardInfo f51259g;

    public ICardInfo g() {
        return this.f51259g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f51256h;
    }

    public boolean isValid() {
        return this.f51257e;
    }

    public void j() {
        ICardInfo i = d.b.i0.j1.o.b.i(this.f51258f);
        this.f51259g = i;
        this.f51257e = i != null;
    }

    public void n(String str) {
        this.f51258f = str;
    }
}
