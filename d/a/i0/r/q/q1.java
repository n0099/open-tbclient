package d.a.i0.r.q;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class q1 extends a2 {
    public static final BdUniqueId G3 = BdUniqueId.gen();
    public String E3 = "";
    public ArrayList<r1> F3 = new ArrayList<>();

    public void A4(RecommendInfo recommendInfo) {
        if (recommendInfo == null) {
            return;
        }
        this.E3 = recommendInfo.title;
        for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
            if (schoolRecomUserInfo != null) {
                r1 r1Var = new r1();
                r1Var.f(schoolRecomUserInfo);
                this.F3.add(r1Var);
            }
        }
    }

    @Override // d.a.i0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return G3;
    }

    @Override // d.a.i0.r.q.a2
    public String x1() {
        return this.E3;
    }

    public ArrayList<r1> z4() {
        return this.F3;
    }
}
