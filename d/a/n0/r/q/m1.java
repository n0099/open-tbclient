package d.a.n0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.RecommendForumData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m1 extends a2 {
    public static final BdUniqueId K3 = BdUniqueId.gen();
    public ArrayList<RecommendForumData> J3 = new ArrayList<>();

    public ArrayList<RecommendForumData> D4() {
        return this.J3;
    }

    @Override // d.a.n0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return K3;
    }
}
