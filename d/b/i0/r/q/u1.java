package d.b.i0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GeneralResource;
/* loaded from: classes3.dex */
public class u1 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f51636h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51637e;

    /* renamed from: f  reason: collision with root package name */
    public String f51638f;

    /* renamed from: g  reason: collision with root package name */
    public int f51639g;

    public void g(GeneralResource generalResource) {
        if (generalResource != null) {
            this.f51637e = generalResource.res_image;
            this.f51638f = generalResource.res_link;
            this.f51639g = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f51636h;
    }
}
