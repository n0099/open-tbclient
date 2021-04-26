package d.a.j0.i2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GiftInfo;
/* loaded from: classes4.dex */
public class o extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55546g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f55547e;

    /* renamed from: f  reason: collision with root package name */
    public long f55548f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f55546g;
    }

    public void h(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.f55547e = giftInfo.icon;
        this.f55548f = giftInfo.num.intValue();
    }
}
