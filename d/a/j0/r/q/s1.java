package d.a.j0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes3.dex */
public class s1 extends a {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f50076i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f50077e;

    /* renamed from: f  reason: collision with root package name */
    public int f50078f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50080h = true;

    /* renamed from: g  reason: collision with root package name */
    public List<MetaData> f50079g = new ArrayList();

    public void A(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.f50080h ? 10 : list.size());
            for (int i2 = 0; i2 < min; i2++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f50079g.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f50076i;
    }

    @Override // d.a.j0.r.q.a
    public v0 h() {
        return new v0();
    }

    @Override // d.a.j0.r.q.a
    public a2 m() {
        return null;
    }

    public List<MetaData> z() {
        return this.f50079g;
    }
}
