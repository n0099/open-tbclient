package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class q1 extends a2 {
    public static final BdUniqueId I3 = BdUniqueId.gen();
    public String G3 = "";
    public ArrayList<r1> H3 = new ArrayList<>();

    public ArrayList<r1> C4() {
        return this.H3;
    }

    public void D4(RecommendInfo recommendInfo) {
        if (recommendInfo == null) {
            return;
        }
        this.G3 = recommendInfo.title;
        for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
            if (schoolRecomUserInfo != null) {
                r1 r1Var = new r1();
                r1Var.f(schoolRecomUserInfo);
                this.H3.add(r1Var);
            }
        }
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return I3;
    }

    @Override // d.a.m0.r.q.a2
    public String z1() {
        return this.G3;
    }
}
