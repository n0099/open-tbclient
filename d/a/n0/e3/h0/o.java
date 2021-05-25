package d.a.n0.e3.h0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.App;
/* loaded from: classes5.dex */
public class o extends PostData {
    public String A0;
    public String B0;
    public long C0;
    public int D0;
    public boolean E0;
    public int K0;
    public AdvertAppInfo x0;
    public String z0;
    public boolean y0 = false;
    public boolean L0 = false;

    public String C0() {
        AdvertAppInfo advertAppInfo = this.x0;
        return advertAppInfo == null ? "" : advertAppInfo.N3;
    }

    public String D0() {
        AdvertAppInfo advertAppInfo = this.x0;
        return advertAppInfo == null ? "" : advertAppInfo.G3;
    }

    public String E0() {
        return this.y0 ? "PB_BANNER" : this.E0 ? "VIDEO_PB" : "PB";
    }

    public AdvertAppInfo.ILegoAdvert F0() {
        AdvertAppInfo advertAppInfo = this.x0;
        if (advertAppInfo == null) {
            return null;
        }
        return advertAppInfo.O3;
    }

    public boolean G0() {
        AdvertAppInfo advertAppInfo = this.x0;
        return advertAppInfo != null && advertAppInfo.H4() == 0;
    }

    public void H0(App app) {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        this.x0 = advertAppInfo;
        advertAppInfo.J4(app);
        this.x0.Q3 = E0();
    }

    public AdvertAppInfo getAdvertAppInfo() {
        return this.x0;
    }

    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.x0;
        if (advertAppInfo == null) {
            return 0;
        }
        return d.a.c.e.m.b.d(advertAppInfo.M3, 0);
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.j.e.n
    public BdUniqueId getType() {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (!d.a.m0.r.k.c().g() && (advertAppInfo = this.x0) != null && (iLegoAdvert = advertAppInfo.O3) != null && !iLegoAdvert.isNoPicAd()) {
            return AdvertAppInfo.b4;
        }
        if (d.a.m0.b.d.B() && this.y0) {
            return AdvertAppInfo.b4;
        }
        AdvertAppInfo advertAppInfo2 = this.x0;
        if (advertAppInfo2 != null && advertAppInfo2.O3 != null) {
            int i2 = advertAppInfo2.I3;
            if (i2 != 1001 && i2 != -1001) {
                if (F0() != null) {
                    return AdvertAppInfo.d4;
                }
                return null;
            }
            return AdvertAppInfo.b4;
        }
        return AdvertAppInfo.b4;
    }
}
