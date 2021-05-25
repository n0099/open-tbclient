package d.a.n0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import d.a.c.j.e.n;
/* loaded from: classes4.dex */
public class f implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f52772f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardGame f52773e;

    public FeatureCardGame c() {
        return this.f52773e;
    }

    public void e(FeatureCardGame featureCardGame) {
        if (featureCardGame == null) {
            return;
        }
        this.f52773e = featureCardGame;
        String str = featureCardGame.title;
        Integer num = featureCardGame.floor;
        Integer num2 = featureCardGame.type;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52772f;
    }
}
