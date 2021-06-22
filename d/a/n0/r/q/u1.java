package d.a.n0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GeneralResource;
/* loaded from: classes3.dex */
public class u1 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f53915h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53916e;

    /* renamed from: f  reason: collision with root package name */
    public String f53917f;

    /* renamed from: g  reason: collision with root package name */
    public int f53918g;

    public void c(GeneralResource generalResource) {
        if (generalResource != null) {
            this.f53916e = generalResource.res_image;
            this.f53917f = generalResource.res_link;
            this.f53918g = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f53915h;
    }
}
