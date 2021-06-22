package d.a.o0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56584f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardHot f56585e;

    public FeatureCardHot c() {
        return this.f56585e;
    }

    public void g(FeatureCardHot featureCardHot) {
        this.f56585e = featureCardHot;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56584f;
    }
}
