package d.a.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i0.r.q.m0;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo implements p, m0 {

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f62460e;

    /* renamed from: f  reason: collision with root package name */
    public String f62461f;

    /* renamed from: g  reason: collision with root package name */
    public int f62462g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62463h;

    public d(AdvertAppInfo advertAppInfo) {
        this.f62461f = "";
        this.f62462g = 0;
        this.f62463h = false;
        this.f62460e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // d.a.j0.x.e0.p
    public void a(boolean z) {
    }

    @Override // d.a.i0.r.q.m0
    public boolean b() {
        return this.f62463h;
    }

    @Override // d.a.i0.r.q.m0
    public int d() {
        return this.position;
    }

    @Override // d.a.j0.x.e0.p
    public boolean g() {
        return false;
    }

    @Override // d.a.j0.x.e0.p
    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.f62460e;
        return d.a.c.e.m.b.d(advertAppInfo != null ? advertAppInfo.K3 : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        AdvertAppInfo advertAppInfo = this.f62460e;
        if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.h4) {
            return AdvertAppInfo.j4;
        }
        AdvertAppInfo advertAppInfo2 = this.f62460e;
        if (advertAppInfo2 == null || (iLegoAdvert = advertAppInfo2.W3) == null) {
            return null;
        }
        BdUniqueId bdUniqueId = AdvertAppInfo.k4;
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        if (goodsStyle != 2) {
            if (goodsStyle != 6) {
                if (goodsStyle != 7) {
                    if (goodsStyle != 8) {
                        switch (goodsStyle) {
                            case 12:
                                return AdvertAppInfo.s4;
                            case 13:
                                return AdvertAppInfo.r4;
                            case 14:
                                break;
                            default:
                                return bdUniqueId;
                        }
                    }
                }
                return AdvertAppInfo.q4;
            }
            return AdvertAppInfo.p4;
        }
        return AdvertAppInfo.o4;
    }

    public AdvertAppInfo h() {
        return this.f62460e;
    }

    @Override // d.a.i0.r.q.m0
    public AdvertAppInfo j() {
        return this.f62460e;
    }

    @Override // d.a.j0.x.e0.p
    public void n(boolean z) {
    }

    @Override // d.a.i0.r.q.m0
    public void setPosition(int i2) {
        this.position = i2;
        this.f62460e.position = i2;
        this.f62463h = true;
    }

    public d() {
        this.f62461f = "";
        this.f62462g = 0;
        this.f62463h = false;
        this.f62460e = null;
        this.position = -1;
    }
}
