package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class k0 extends BaseCardInfo implements d.a.c.k.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53737f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<l> f53738e = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f53737f;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list == null) {
            return;
        }
        this.f53738e.clear();
        int min = Math.min(list.size(), 10);
        for (int i2 = 0; i2 < min; i2++) {
            l lVar = new l();
            lVar.f(list.get(i2));
            this.f53738e.add(lVar);
        }
    }
}
