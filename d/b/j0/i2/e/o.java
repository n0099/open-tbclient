package d.b.j0.i2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GiftInfo;
/* loaded from: classes3.dex */
public class o extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57591g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57592e;

    /* renamed from: f  reason: collision with root package name */
    public long f57593f;

    public void g(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.f57592e = giftInfo.icon;
        this.f57593f = giftInfo.num.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f57591g;
    }
}
