package d.b.j0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import d.b.c.j.e.n;
/* loaded from: classes4.dex */
public class f implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f54094f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardGame f54095e;

    public FeatureCardGame a() {
        return this.f54095e;
    }

    public void e(FeatureCardGame featureCardGame) {
        if (featureCardGame == null) {
            return;
        }
        this.f54095e = featureCardGame;
        String str = featureCardGame.title;
        Integer num = featureCardGame.floor;
        Integer num2 = featureCardGame.type;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f54094f;
    }
}
