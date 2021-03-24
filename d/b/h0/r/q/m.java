package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class m extends BaseCardInfo implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f50844f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<l> f50845e = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f50844f;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list == null) {
            return;
        }
        for (BannerImage bannerImage : list) {
            l lVar = new l();
            lVar.f(bannerImage);
            this.f50845e.add(lVar);
        }
    }
}
