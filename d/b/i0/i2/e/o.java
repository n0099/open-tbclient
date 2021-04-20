package d.b.i0.i2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GiftInfo;
/* loaded from: classes3.dex */
public class o extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57170g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57171e;

    /* renamed from: f  reason: collision with root package name */
    public long f57172f;

    public void g(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.f57171e = giftInfo.icon;
        this.f57172f = giftInfo.num.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f57170g;
    }
}
