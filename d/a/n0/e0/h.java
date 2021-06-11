package d.a.n0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.k.e.n;
/* loaded from: classes4.dex */
public class h implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f56465f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardTopic f56466e;

    public FeatureCardTopic b() {
        return this.f56466e;
    }

    public void c(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic == null) {
            return;
        }
        this.f56466e = featureCardTopic;
        String str = featureCardTopic.title;
        Integer num = featureCardTopic.floor;
        Integer num2 = featureCardTopic.type;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56465f;
    }
}
