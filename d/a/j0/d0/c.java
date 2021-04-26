package d.a.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import d.a.c.j.e.n;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f51862f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardCompetition f51863e;

    public FeatureCardCompetition c() {
        return this.f51863e;
    }

    public void e(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition == null) {
            return;
        }
        this.f51863e = featureCardCompetition;
        String str = featureCardCompetition.title;
        Integer num = featureCardCompetition.floor;
        Integer num2 = featureCardCompetition.type;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51862f;
    }
}
