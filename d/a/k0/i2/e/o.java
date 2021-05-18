package d.a.k0.i2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GiftInfo;
/* loaded from: classes5.dex */
public class o extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f56253g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56254e;

    /* renamed from: f  reason: collision with root package name */
    public long f56255f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f56253g;
    }

    public void h(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.f56254e = giftInfo.icon;
        this.f56255f = giftInfo.num.intValue();
    }
}
