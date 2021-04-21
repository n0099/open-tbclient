package d.b.j0.a1.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.s1;
import d.b.i0.r.q.v0;
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

    @Override // d.b.i0.r.q.s1
    public void A(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
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

    @Override // d.b.i0.r.q.s1, d.b.i0.r.q.a
    public v0 g() {
        return new v0();
    }

    @Override // d.b.i0.r.q.s1, com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return s1.i;
    }

    @Override // d.b.i0.r.q.s1, d.b.i0.r.q.a
    public a2 n() {
        return null;
    }

    @Override // d.b.i0.r.q.s1
    public List<MetaData> z() {
        return this.k;
    }
}
