package d.a.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f51866f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardHot f51867e;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51866f;
    }

    public FeatureCardHot h() {
        return this.f51867e;
    }

    public void l(FeatureCardHot featureCardHot) {
        this.f51867e = featureCardHot;
    }
}
