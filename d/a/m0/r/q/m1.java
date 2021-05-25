package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.RecommendForumData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m1 extends a2 {
    public static final BdUniqueId H3 = BdUniqueId.gen();
    public ArrayList<RecommendForumData> G3 = new ArrayList<>();

    public ArrayList<RecommendForumData> C4() {
        return this.G3;
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return H3;
    }
}
