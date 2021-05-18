package d.a.k0.d3.h0;

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
        return advertAppInfo == null ? "" : advertAppInfo.M3;
    }

    public String D0() {
        AdvertAppInfo advertAppInfo = this.x0;
        return advertAppInfo == null ? "" : advertAppInfo.F3;
    }

    public String E0() {
        return this.y0 ? "PB_BANNER" : this.E0 ? "VIDEO_PB" : "PB";
    }

    public AdvertAppInfo.ILegoAdvert F0() {
        AdvertAppInfo advertAppInfo = this.x0;
        if (advertAppInfo == null) {
            return null;
        }
        return advertAppInfo.N3;
    }

    public boolean G0() {
        AdvertAppInfo advertAppInfo = this.x0;
        return advertAppInfo != null && advertAppInfo.G4() == 0;
    }

    public void H0(App app) {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        this.x0 = advertAppInfo;
        advertAppInfo.I4(app);
        this.x0.P3 = E0();
    }

    public AdvertAppInfo getAdvertAppInfo() {
        return this.x0;
    }

    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.x0;
        if (advertAppInfo == null) {
            return 0;
        }
        return d.a.c.e.m.b.d(advertAppInfo.L3, 0);
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.j.e.n
    public BdUniqueId getType() {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (!d.a.j0.r.k.c().g() && (advertAppInfo = this.x0) != null && (iLegoAdvert = advertAppInfo.N3) != null && !iLegoAdvert.isNoPicAd()) {
            return AdvertAppInfo.a4;
        }
        if (d.a.j0.b.d.B() && this.y0) {
            return AdvertAppInfo.a4;
        }
        AdvertAppInfo advertAppInfo2 = this.x0;
        if (advertAppInfo2 != null && advertAppInfo2.N3 != null) {
            int i2 = advertAppInfo2.H3;
            if (i2 != 1001 && i2 != -1001) {
                if (F0() != null) {
                    return AdvertAppInfo.c4;
                }
                return null;
            }
            return AdvertAppInfo.a4;
        }
        return AdvertAppInfo.a4;
    }
}
