package d.b.i0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import d.b.b.j.e.n;
/* loaded from: classes4.dex */
public class f implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53634f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardGame f53635e;

    public FeatureCardGame a() {
        return this.f53635e;
    }

    public void e(FeatureCardGame featureCardGame) {
        if (featureCardGame == null) {
            return;
        }
        this.f53635e = featureCardGame;
        String str = featureCardGame.title;
        Integer num = featureCardGame.floor;
        Integer num2 = featureCardGame.type;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53634f;
    }
}
