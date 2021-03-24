package d.b.i0.c3.h0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
/* loaded from: classes5.dex */
public class o extends PostData {
    public String A0;
    public String B0;
    public String C0;
    public long D0;
    public int E0;
    public boolean K0;
    public int L0;
    public AppData w0;
    public String z0;
    public boolean x0 = false;
    public boolean y0 = false;
    public boolean M0 = false;

    public String A0() {
        AppData appData = this.w0;
        return appData == null ? "" : appData.id;
    }

    public AppData B0() {
        return this.w0;
    }

    public String C0() {
        return this.x0 ? "PB_BANNER" : this.K0 ? "VIDEO_PB" : "PB";
    }

    public AdvertAppInfo.ILegoAdvert D0() {
        AppData appData = this.w0;
        if (appData == null) {
            return null;
        }
        return appData.legoCard;
    }

    public int E0() {
        AppData.AppGoods appGoods;
        AppData appData = this.w0;
        if (appData == null || (appGoods = appData.goods) == null) {
            return -1;
        }
        return appGoods.goods_style;
    }

    public boolean F0() {
        AppData appData = this.w0;
        return appData != null && appData.s();
    }

    public boolean G0() {
        AppData appData = this.w0;
        return appData != null && appData.u() == 0;
    }

    public void H0(String str) {
        this.w0 = new AppData(str);
    }

    public void I0(App app) {
        this.w0 = new AppData(app);
    }

    public AdvertAppInfo J0() {
        List<String> c2;
        List<String> list;
        List<String> list2;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        AppData appData = this.w0;
        if (appData != null) {
            advertAppInfo.e4 = appData;
            advertAppInfo.E3 = appData.id;
            advertAppInfo.F3 = appData.name;
            advertAppInfo.G3 = appData.url_type;
            advertAppInfo.H3 = appData.url;
            String str = appData.deepUrl;
            advertAppInfo.I3 = appData.apk_url;
            advertAppInfo.J3 = appData.apk_name;
            advertAppInfo.K3 = appData.pos_name.trim();
            AppData appData2 = this.w0;
            advertAppInfo.L3 = appData2.first_name;
            advertAppInfo.M3 = appData2.second_name;
            advertAppInfo.N3 = appData2.cpid;
            advertAppInfo.P3 = appData2.abtest;
            advertAppInfo.Q3 = appData2.plan_id;
            advertAppInfo.R3 = appData2.user_id;
            advertAppInfo.S3 = appData2.verify;
            advertAppInfo.O3 = appData2.price;
            advertAppInfo.T3 = appData2.ext_info;
            int i = appData2.app_time;
            advertAppInfo.W3 = appData2.legoCard;
            advertAppInfo.d4 = appData2.rawApp;
            AppData.AppGoods appGoods = appData2.goods;
            if (appGoods != null) {
                AdvertAppInfo.a aVar = advertAppInfo.U3;
                aVar.f13208g = appGoods.pop_window_text;
                aVar.f13202a = appGoods.id;
                aVar.f13207f = appGoods.thread_pic;
                aVar.f13209h = appGoods.goods_style;
                aVar.f13205d = appGoods.thread_title;
                aVar.f13206e = appGoods.thread_content;
                aVar.f13203b = appGoods.user_name;
                aVar.f13204c = appGoods.user_portrait;
                aVar.i = appGoods.button_text;
                aVar.j = appGoods.button_url;
                ArrayList<String> arrayList = appGoods.thread_pic_list;
                if (arrayList != null && (list2 = aVar.k) != null) {
                    list2.addAll(arrayList);
                }
                if (ListUtils.isEmpty(advertAppInfo.U3.k) && (c2 = AdvertAppInfo.a.c(this.w0.goods.lego_card)) != null && (list = advertAppInfo.U3.k) != null) {
                    list.addAll(c2);
                }
                AdvertAppInfo.a aVar2 = advertAppInfo.U3;
                AppData.AppGoods appGoods2 = this.w0.goods;
                aVar2.m = appGoods2.video_info;
                aVar2.n = appGoods2.tag_name;
                aVar2.o = appGoods2.ad_source;
                aVar2.p = appGoods2.tag_name_url;
                aVar2.q = appGoods2.tagRatio;
                aVar2.l = appGoods2.lego_card;
                aVar2.r = appGoods2.adCloseInfo;
            }
            advertAppInfo.c4 = C0();
        }
        return advertAppInfo;
    }

    public int getPosition() {
        AppData appData = this.w0;
        if (appData == null) {
            return 0;
        }
        return d.b.b.e.m.b.d(appData.pos_name, 0);
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.b.b.j.e.n
    public BdUniqueId getType() {
        AppData appData;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (!d.b.h0.r.k.c().g() && (appData = this.w0) != null && (iLegoAdvert = appData.legoCard) != null && !iLegoAdvert.isNoPicAd()) {
            return AdvertAppInfo.i4;
        }
        if (d.b.h0.b.d.A() && this.x0) {
            return AdvertAppInfo.i4;
        }
        if (E0() != 1001 && E0() != -1001) {
            if (D0() != null) {
                return AdvertAppInfo.k4;
            }
            return null;
        }
        return AdvertAppInfo.i4;
    }
}
