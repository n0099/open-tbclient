package d.a.j0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class m extends BaseCardInfo implements d.a.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f50036f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<l> f50037e = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f50036f;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list == null) {
            return;
        }
        for (BannerImage bannerImage : list) {
            l lVar = new l();
            lVar.f(bannerImage);
            this.f50037e.add(lVar);
        }
    }
}
