package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.m0;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo implements p, m0 {

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f62200e;

    /* renamed from: f  reason: collision with root package name */
    public String f62201f;

    /* renamed from: g  reason: collision with root package name */
    public int f62202g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62203h;

    public d(AdvertAppInfo advertAppInfo) {
        this.f62201f = "";
        this.f62202g = 0;
        this.f62203h = false;
        this.f62200e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // d.b.i0.x.e0.p
    public void b(boolean z) {
    }

    @Override // d.b.h0.r.q.m0
    public boolean c() {
        return this.f62203h;
    }

    @Override // d.b.h0.r.q.m0
    public AdvertAppInfo d() {
        return this.f62200e;
    }

    public AdvertAppInfo g() {
        return this.f62200e;
    }

    @Override // d.b.i0.x.e0.p
    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.f62200e;
        return d.b.b.e.m.b.d(advertAppInfo != null ? advertAppInfo.K3 : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        AdvertAppInfo advertAppInfo = this.f62200e;
        if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.h4) {
            return AdvertAppInfo.j4;
        }
        AdvertAppInfo advertAppInfo2 = this.f62200e;
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

    @Override // d.b.i0.x.e0.p
    public void h(boolean z) {
    }

    @Override // d.b.h0.r.q.m0
    public int i() {
        return this.position;
    }

    @Override // d.b.i0.x.e0.p
    public boolean m() {
        return false;
    }

    @Override // d.b.h0.r.q.m0
    public void setPosition(int i) {
        this.position = i;
        this.f62200e.position = i;
        this.f62203h = true;
    }

    public d() {
        this.f62201f = "";
        this.f62202g = 0;
        this.f62203h = false;
        this.f62200e = null;
        this.position = -1;
    }
}
