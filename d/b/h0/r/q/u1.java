package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GeneralResource;
/* loaded from: classes3.dex */
public class u1 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f51300h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51301e;

    /* renamed from: f  reason: collision with root package name */
    public String f51302f;

    /* renamed from: g  reason: collision with root package name */
    public int f51303g;

    public void g(GeneralResource generalResource) {
        if (generalResource != null) {
            this.f51301e = generalResource.res_image;
            this.f51302f = generalResource.res_link;
            this.f51303g = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f51300h;
    }
}
