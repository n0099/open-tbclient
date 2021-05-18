package d.a.k0.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import d.a.c.j.e.n;
/* loaded from: classes4.dex */
public class f implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f52567f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public FeatureCardGame f52568e;

    public FeatureCardGame c() {
        return this.f52568e;
    }

    public void e(FeatureCardGame featureCardGame) {
        if (featureCardGame == null) {
            return;
        }
        this.f52568e = featureCardGame;
        String str = featureCardGame.title;
        Integer num = featureCardGame.floor;
        Integer num2 = featureCardGame.type;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52567f;
    }
}
