package d.a.n0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.j.e.n;
/* loaded from: classes4.dex */
public class h implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f52776f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardTopic f52777e;

    public FeatureCardTopic c() {
        return this.f52777e;
    }

    public void e(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic == null) {
            return;
        }
        this.f52777e = featureCardTopic;
        String str = featureCardTopic.title;
        Integer num = featureCardTopic.floor;
        Integer num2 = featureCardTopic.type;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52776f;
    }
}
