package d.a.n0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import d.a.c.k.e.n;
/* loaded from: classes4.dex */
public class f implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56461f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardGame f56462e;

    public FeatureCardGame b() {
        return this.f56462e;
    }

    public void c(FeatureCardGame featureCardGame) {
        if (featureCardGame == null) {
            return;
        }
        this.f56462e = featureCardGame;
        String str = featureCardGame.title;
        Integer num = featureCardGame.floor;
        Integer num2 = featureCardGame.type;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56461f;
    }
}
