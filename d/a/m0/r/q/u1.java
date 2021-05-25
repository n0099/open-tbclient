package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GeneralResource;
/* loaded from: classes3.dex */
public class u1 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f50132h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f50133e;

    /* renamed from: f  reason: collision with root package name */
    public String f50134f;

    /* renamed from: g  reason: collision with root package name */
    public int f50135g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f50132h;
    }

    public void h(GeneralResource generalResource) {
        if (generalResource != null) {
            this.f50133e = generalResource.res_image;
            this.f50134f = generalResource.res_link;
            this.f50135g = generalResource.res_floor.intValue();
        }
    }
}
