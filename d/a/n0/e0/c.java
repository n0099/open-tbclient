package d.a.n0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import d.a.c.k.e.n;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f56455f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardCompetition f56456e;

    public FeatureCardCompetition b() {
        return this.f56456e;
    }

    public void c(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition == null) {
            return;
        }
        this.f56456e = featureCardCompetition;
        String str = featureCardCompetition.title;
        Integer num = featureCardCompetition.floor;
        Integer num2 = featureCardCompetition.type;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56455f;
    }
}
