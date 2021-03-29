package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class o1 extends w {

    /* renamed from: h  reason: collision with root package name */
    public String f50854h;
    public int i;
    public String j;
    public ArrayList<n1> k;

    static {
        BdUniqueId.gen();
    }

    public o1() {
        A(9);
        this.k = new ArrayList<>();
    }

    public ArrayList<n1> B() {
        return this.k;
    }

    public void C(List<RecommendForumInfo> list) {
        Long l;
        Integer num;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            RecommendForumInfo recommendForumInfo = list.get(i);
            n1 n1Var = new n1();
            if (recommendForumInfo != null && (l = recommendForumInfo.forum_id) != null && l.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && (num = recommendForumInfo.is_like) != null && num.intValue() != 1) {
                n1Var.I(recommendForumInfo);
                arrayList.add(n1Var);
            }
        }
        this.k.clear();
        this.k.addAll(ListUtils.trimToSize(arrayList, 15));
    }

    @Override // d.b.h0.r.q.w, d.b.h0.r.q.a
    public v0 g() {
        return new v0();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return w.f50913f;
    }

    @Override // d.b.h0.r.q.w, d.b.h0.r.q.a
    public a2 n() {
        return null;
    }
}
