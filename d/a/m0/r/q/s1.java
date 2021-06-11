package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes3.dex */
public class s1 extends a {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f53796i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53797e;

    /* renamed from: f  reason: collision with root package name */
    public int f53798f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53800h = true;

    /* renamed from: g  reason: collision with root package name */
    public List<MetaData> f53799g = new ArrayList();

    public void A(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.f53800h ? 10 : list.size());
            for (int i2 = 0; i2 < min; i2++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f53799g.add(metaData);
            }
        }
    }

    @Override // d.a.m0.r.q.a
    public v0 c() {
        return new v0();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f53796i;
    }

    @Override // d.a.m0.r.q.a
    public a2 i() {
        return null;
    }

    public List<MetaData> z() {
        return this.f53799g;
    }
}
