package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GeneralResource;
/* loaded from: classes3.dex */
public class u1 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f50892h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f50893e;

    /* renamed from: f  reason: collision with root package name */
    public String f50894f;

    /* renamed from: g  reason: collision with root package name */
    public int f50895g;

    public void g(GeneralResource generalResource) {
        if (generalResource != null) {
            this.f50893e = generalResource.res_image;
            this.f50894f = generalResource.res_link;
            this.f50895g = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f50892h;
    }
}
