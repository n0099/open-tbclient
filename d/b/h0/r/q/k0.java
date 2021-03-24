package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class k0 extends BaseCardInfo implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f50825f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<l> f50826e = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f50825f;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list == null) {
            return;
        }
        this.f50826e.clear();
        int min = Math.min(list.size(), 10);
        for (int i = 0; i < min; i++) {
            l lVar = new l();
            lVar.f(list.get(i));
            this.f50826e.add(lVar);
        }
    }
}
