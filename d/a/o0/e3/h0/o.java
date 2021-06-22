package d.a.o0.e3.h0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.App;
/* loaded from: classes5.dex */
public class o extends PostData {
    public AdvertAppInfo C0;
    public String E0;
    public String F0;
    public String G0;
    public long H0;
    public int I0;
    public boolean J0;
    public int K0;
    public boolean D0 = false;
    public boolean L0 = false;

    public String C0() {
        AdvertAppInfo advertAppInfo = this.C0;
        return advertAppInfo == null ? "" : advertAppInfo.Q3;
    }

    public String D0() {
        AdvertAppInfo advertAppInfo = this.C0;
        return advertAppInfo == null ? "" : advertAppInfo.J3;
    }

    public String E0() {
        return this.D0 ? "PB_BANNER" : this.J0 ? "VIDEO_PB" : "PB";
    }

    public AdvertAppInfo.ILegoAdvert F0() {
        AdvertAppInfo advertAppInfo = this.C0;
        if (advertAppInfo == null) {
            return null;
        }
        return advertAppInfo.R3;
    }

    public boolean G0() {
        AdvertAppInfo advertAppInfo = this.C0;
        return advertAppInfo != null && advertAppInfo.I4() == 0;
    }

    public void H0(App app) {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        this.C0 = advertAppInfo;
        advertAppInfo.K4(app);
        this.C0.T3 = E0();
    }

    public AdvertAppInfo getAdvertAppInfo() {
        return this.C0;
    }

    public int getPosition() {
        AdvertAppInfo advertAppInfo = this.C0;
        if (advertAppInfo == null) {
            return 0;
        }
        return d.a.c.e.m.b.d(advertAppInfo.P3, 0);
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (!d.a.n0.r.k.c().g() && (advertAppInfo = this.C0) != null && (iLegoAdvert = advertAppInfo.R3) != null && !iLegoAdvert.isNoPicAd()) {
            return AdvertAppInfo.e4;
        }
        if (d.a.n0.b.d.B() && this.D0) {
            return AdvertAppInfo.e4;
        }
        AdvertAppInfo advertAppInfo2 = this.C0;
        if (advertAppInfo2 != null && advertAppInfo2.R3 != null) {
            int i2 = advertAppInfo2.L3;
            if (i2 != 1001 && i2 != -1001) {
                if (F0() != null) {
                    return AdvertAppInfo.g4;
                }
                return null;
            }
            return AdvertAppInfo.e4;
        }
        return AdvertAppInfo.e4;
    }
}
