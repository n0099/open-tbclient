package d.a.j0.r.q;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class q1 extends a2 {
    public static final BdUniqueId H3 = BdUniqueId.gen();
    public String F3 = "";
    public ArrayList<r1> G3 = new ArrayList<>();

    public ArrayList<r1> B4() {
        return this.G3;
    }

    public void C4(RecommendInfo recommendInfo) {
        if (recommendInfo == null) {
            return;
        }
        this.F3 = recommendInfo.title;
        for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
            if (schoolRecomUserInfo != null) {
                r1 r1Var = new r1();
                r1Var.f(schoolRecomUserInfo);
                this.G3.add(r1Var);
            }
        }
    }

    @Override // d.a.j0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return H3;
    }

    @Override // d.a.j0.r.q.a2
    public String y1() {
        return this.F3;
    }
}
