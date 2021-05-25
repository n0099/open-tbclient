package d.a.n0.b1.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.s1;
import d.a.m0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes4.dex */
public class a extends s1 {
    public static final Integer l = 6;
    public boolean j;
    public List<MetaData> k = new ArrayList();

    public static boolean C(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(l);
    }

    @Override // d.a.m0.r.q.s1
    public void A(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i2 = 0; i2 < min; i2++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.k.add(metaData);
            }
        }
    }

    public boolean B() {
        return this.j;
    }

    public void D(boolean z) {
        this.j = z;
    }

    @Override // d.a.m0.r.q.s1, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return s1.f50120i;
    }

    @Override // d.a.m0.r.q.s1, d.a.m0.r.q.a
    public v0 h() {
        return new v0();
    }

    @Override // d.a.m0.r.q.s1, d.a.m0.r.q.a
    public a2 m() {
        return null;
    }

    @Override // d.a.m0.r.q.s1
    public List<MetaData> z() {
        return this.k;
    }
}
