package d.a.i0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GeneralResource;
/* loaded from: classes3.dex */
public class u1 extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f49269h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f49270e;

    /* renamed from: f  reason: collision with root package name */
    public String f49271f;

    /* renamed from: g  reason: collision with root package name */
    public int f49272g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f49269h;
    }

    public void h(GeneralResource generalResource) {
        if (generalResource != null) {
            this.f49270e = generalResource.res_image;
            this.f49271f = generalResource.res_link;
            this.f49272g = generalResource.res_floor.intValue();
        }
    }
}
