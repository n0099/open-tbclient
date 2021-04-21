package d.b.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i0.r.q.m0;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo implements p, m0 {

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f64197e;

    /* renamed from: f  reason: collision with root package name */
    public String f64198f;

    /* renamed from: g  reason: collision with root package name */
    public int f64199g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64200h;

    public d(AdvertAppInfo advertAppInfo) {
        this.f64198f = "";
        this.f64199g = 0;
        this.f64200h = false;
        this.f64197e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // d.b.j0.x.e0.p
    public void b(boolean z) {
    }

    @Override // d.b.i0.r.q.m0
    public boolean c() {
        return this.f64200h;
    }

    @Override // d.b.i0.r.q.m0
    public AdvertAppInfo d() {
        return this.f64197e;
    }

    public AdvertAppInfo g() {
        return this.f64197e;
    }

    @Override // d.b.j0.x.e0.p
    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.f64197e;
        return d.b.c.e.m.b.d(advertAppInfo != null ? advertAppInfo.K3 : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        AdvertAppInfo advertAppInfo = this.f64197e;
        if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.h4) {
            return AdvertAppInfo.j4;
        }
        AdvertAppInfo advertAppInfo2 = this.f64197e;
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

    @Override // d.b.j0.x.e0.p
    public void h(boolean z) {
    }

    @Override // d.b.i0.r.q.m0
    public int i() {
        return this.position;
    }

    @Override // d.b.j0.x.e0.p
    public boolean m() {
        return false;
    }

    @Override // d.b.i0.r.q.m0
    public void setPosition(int i) {
        this.position = i;
        this.f64197e.position = i;
        this.f64200h = true;
    }

    public d() {
        this.f64198f = "";
        this.f64199g = 0;
        this.f64200h = false;
        this.f64197e = null;
        this.position = -1;
    }
}
