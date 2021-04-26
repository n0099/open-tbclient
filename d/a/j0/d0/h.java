package d.a.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.j.e.n;
/* loaded from: classes4.dex */
public class h implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f51872f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardTopic f51873e;

    public FeatureCardTopic c() {
        return this.f51873e;
    }

    public void e(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic == null) {
            return;
        }
        this.f51873e = featureCardTopic;
        String str = featureCardTopic.title;
        Integer num = featureCardTopic.floor;
        Integer num2 = featureCardTopic.type;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51872f;
    }
}
