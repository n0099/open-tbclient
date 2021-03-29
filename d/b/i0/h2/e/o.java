package d.b.i0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GiftInfo;
/* loaded from: classes5.dex */
public class o extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55312g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f55313e;

    /* renamed from: f  reason: collision with root package name */
    public long f55314f;

    public void g(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.f55313e = giftInfo.icon;
        this.f55314f = giftInfo.num.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f55312g;
    }
}
