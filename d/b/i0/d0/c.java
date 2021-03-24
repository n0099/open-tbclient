package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import d.b.b.j.e.n;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f53627f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardCompetition f53628e;

    public FeatureCardCompetition a() {
        return this.f53628e;
    }

    public void e(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition == null) {
            return;
        }
        this.f53628e = featureCardCompetition;
        String str = featureCardCompetition.title;
        Integer num = featureCardCompetition.floor;
        Integer num2 = featureCardCompetition.type;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53627f;
    }
}
