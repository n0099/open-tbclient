package d.a.j0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.RecommendForumData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m1 extends a2 {
    public static final BdUniqueId G3 = BdUniqueId.gen();
    public ArrayList<RecommendForumData> F3 = new ArrayList<>();

    public ArrayList<RecommendForumData> B4() {
        return this.F3;
    }

    @Override // d.a.j0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return G3;
    }
}
