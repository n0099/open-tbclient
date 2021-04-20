package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends BaseCardInfo {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53671f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardHot f53672e;

    public FeatureCardHot g() {
        return this.f53672e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53671f;
    }

    public void j(FeatureCardHot featureCardHot) {
        this.f53672e = featureCardHot;
    }
}
