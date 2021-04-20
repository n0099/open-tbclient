package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import d.b.c.j.e.n;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f53667f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardCompetition f53668e;

    public FeatureCardCompetition a() {
        return this.f53668e;
    }

    public void e(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition == null) {
            return;
        }
        this.f53668e = featureCardCompetition;
        String str = featureCardCompetition.title;
        Integer num = featureCardCompetition.floor;
        Integer num2 = featureCardCompetition.type;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53667f;
    }
}
