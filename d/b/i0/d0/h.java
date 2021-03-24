package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.b.b.j.e.n;
/* loaded from: classes4.dex */
public class h implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f53637f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardTopic f53638e;

    public FeatureCardTopic a() {
        return this.f53638e;
    }

    public void e(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic == null) {
            return;
        }
        this.f53638e = featureCardTopic;
        String str = featureCardTopic.title;
        Integer num = featureCardTopic.floor;
        Integer num2 = featureCardTopic.type;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53637f;
    }
}
