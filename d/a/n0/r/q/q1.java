package d.a.n0.r.q;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class q1 extends a2 {
    public static final BdUniqueId L3 = BdUniqueId.gen();
    public String J3 = "";
    public ArrayList<r1> K3 = new ArrayList<>();

    @Override // d.a.n0.r.q.a2
    public String A1() {
        return this.J3;
    }

    public ArrayList<r1> D4() {
        return this.K3;
    }

    public void E4(RecommendInfo recommendInfo) {
        if (recommendInfo == null) {
            return;
        }
        this.J3 = recommendInfo.title;
        for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
            if (schoolRecomUserInfo != null) {
                r1 r1Var = new r1();
                r1Var.f(schoolRecomUserInfo);
                this.K3.add(r1Var);
            }
        }
    }

    @Override // d.a.n0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return L3;
    }
}
