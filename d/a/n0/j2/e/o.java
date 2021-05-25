package d.a.n0.j2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GiftInfo;
/* loaded from: classes5.dex */
public class o extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f56437g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56438e;

    /* renamed from: f  reason: collision with root package name */
    public long f56439f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f56437g;
    }

    public void h(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.f56438e = giftInfo.icon;
        this.f56439f = giftInfo.num.intValue();
    }
}
