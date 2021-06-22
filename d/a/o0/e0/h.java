package d.a.o0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.k.e.n;
/* loaded from: classes4.dex */
public class h implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f56590f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardTopic f56591e;

    public FeatureCardTopic b() {
        return this.f56591e;
    }

    public void c(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic == null) {
            return;
        }
        this.f56591e = featureCardTopic;
        String str = featureCardTopic.title;
        Integer num = featureCardTopic.floor;
        Integer num2 = featureCardTopic.type;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56590f;
    }
}
