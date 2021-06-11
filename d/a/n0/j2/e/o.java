package d.a.n0.j2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GiftInfo;
/* loaded from: classes5.dex */
public class o extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60126g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60127e;

    /* renamed from: f  reason: collision with root package name */
    public long f60128f;

    public void c(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.f60127e = giftInfo.icon;
        this.f60128f = giftInfo.num.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f60126g;
    }
}
