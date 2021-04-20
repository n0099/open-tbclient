package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.RecommendForumData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m1 extends a2 {
    public static final BdUniqueId F3 = BdUniqueId.gen();
    public ArrayList<RecommendForumData> E3 = new ArrayList<>();

    @Override // d.b.h0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return F3;
    }

    public ArrayList<RecommendForumData> z4() {
        return this.E3;
    }
}
