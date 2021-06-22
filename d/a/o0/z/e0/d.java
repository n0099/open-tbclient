package d.a.o0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.n0.r.q.m0;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo implements p, m0 {

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f67307e;

    /* renamed from: f  reason: collision with root package name */
    public String f67308f;

    /* renamed from: g  reason: collision with root package name */
    public int f67309g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67310h;

    public d(AdvertAppInfo advertAppInfo) {
        this.f67308f = "";
        this.f67309g = 0;
        this.f67310h = false;
        this.f67307e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // d.a.o0.z.e0.p
    public void a(boolean z) {
    }

    public AdvertAppInfo c() {
        return this.f67307e;
    }

    @Override // d.a.n0.r.q.m0
    public boolean d() {
        return this.f67310h;
    }

    @Override // d.a.n0.r.q.m0
    public int f() {
        return this.position;
    }

    @Override // d.a.o0.z.e0.p
    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.f67307e;
        return d.a.c.e.m.b.d(advertAppInfo != null ? advertAppInfo.P3 : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        AdvertAppInfo advertAppInfo = this.f67307e;
        if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.d4) {
            return AdvertAppInfo.f4;
        }
        AdvertAppInfo advertAppInfo2 = this.f67307e;
        if (advertAppInfo2 == null || (iLegoAdvert = advertAppInfo2.R3) == null) {
            return null;
        }
        BdUniqueId bdUniqueId = AdvertAppInfo.g4;
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        if (goodsStyle != 2) {
            if (goodsStyle != 6) {
                if (goodsStyle != 7) {
                    if (goodsStyle != 8) {
                        switch (goodsStyle) {
                            case 12:
                                return AdvertAppInfo.l4;
                            case 13:
                                return AdvertAppInfo.k4;
                            case 14:
                                break;
                            default:
                                return bdUniqueId;
                        }
                    }
                }
                return AdvertAppInfo.j4;
            }
            return AdvertAppInfo.i4;
        }
        return AdvertAppInfo.h4;
    }

    @Override // d.a.o0.z.e0.p
    public boolean j() {
        return false;
    }

    @Override // d.a.n0.r.q.m0
    public AdvertAppInfo m() {
        return this.f67307e;
    }

    @Override // d.a.o0.z.e0.p
    public void r(boolean z) {
    }

    @Override // d.a.n0.r.q.m0
    public void setPosition(int i2) {
        this.position = i2;
        this.f67307e.position = i2;
        this.f67310h = true;
    }

    public d() {
        this.f67308f = "";
        this.f67309g = 0;
        this.f67310h = false;
        this.f67307e = null;
        this.position = -1;
    }
}
