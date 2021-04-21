package d.b.i0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes3.dex */
public class s1 extends a {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51625e;

    /* renamed from: f  reason: collision with root package name */
    public int f51626f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51628h = true;

    /* renamed from: g  reason: collision with root package name */
    public List<MetaData> f51627g = new ArrayList();

    public void A(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.f51628h ? 10 : list.size());
            for (int i2 = 0; i2 < min; i2++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f51627g.add(metaData);
            }
        }
    }

    @Override // d.b.i0.r.q.a
    public v0 g() {
        return new v0();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    @Override // d.b.i0.r.q.a
    public a2 n() {
        return null;
    }

    public List<MetaData> z() {
        return this.f51627g;
    }
}
