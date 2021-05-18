package d.a.k0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.j0.r.q.m0;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo implements p, m0 {

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f63184e;

    /* renamed from: f  reason: collision with root package name */
    public String f63185f;

    /* renamed from: g  reason: collision with root package name */
    public int f63186g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63187h;

    public d(AdvertAppInfo advertAppInfo) {
        this.f63185f = "";
        this.f63186g = 0;
        this.f63187h = false;
        this.f63184e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // d.a.k0.x.e0.p
    public void a(boolean z) {
    }

    @Override // d.a.j0.r.q.m0
    public boolean b() {
        return this.f63187h;
    }

    @Override // d.a.j0.r.q.m0
    public int d() {
        return this.position;
    }

    @Override // d.a.k0.x.e0.p
    public boolean g() {
        return false;
    }

    @Override // d.a.k0.x.e0.p
    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.f63184e;
        return d.a.c.e.m.b.d(advertAppInfo != null ? advertAppInfo.L3 : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        AdvertAppInfo advertAppInfo = this.f63184e;
        if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.Z3) {
            return AdvertAppInfo.b4;
        }
        AdvertAppInfo advertAppInfo2 = this.f63184e;
        if (advertAppInfo2 == null || (iLegoAdvert = advertAppInfo2.N3) == null) {
            return null;
        }
        BdUniqueId bdUniqueId = AdvertAppInfo.c4;
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        if (goodsStyle != 2) {
            if (goodsStyle != 6) {
                if (goodsStyle != 7) {
                    if (goodsStyle != 8) {
                        switch (goodsStyle) {
                            case 12:
                                return AdvertAppInfo.h4;
                            case 13:
                                return AdvertAppInfo.g4;
                            case 14:
                                break;
                            default:
                                return bdUniqueId;
                        }
                    }
                }
                return AdvertAppInfo.f4;
            }
            return AdvertAppInfo.e4;
        }
        return AdvertAppInfo.d4;
    }

    public AdvertAppInfo h() {
        return this.f63184e;
    }

    @Override // d.a.j0.r.q.m0
    public AdvertAppInfo j() {
        return this.f63184e;
    }

    @Override // d.a.k0.x.e0.p
    public void n(boolean z) {
    }

    @Override // d.a.j0.r.q.m0
    public void setPosition(int i2) {
        this.position = i2;
        this.f63184e.position = i2;
        this.f63187h = true;
    }

    public d() {
        this.f63185f = "";
        this.f63186g = 0;
        this.f63187h = false;
        this.f63184e = null;
        this.position = -1;
    }
}
