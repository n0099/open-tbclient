package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public String liveStartTime;
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public String originPrice;
    public String pZ;
    public int playableStyle;
    public String price;
    public String qa;
    public List<String> rO;
    public String rP;
    public String rQ;
    public String rR;
    public boolean rS;
    public String rT;
    public String rU = "查看详情";
    public String rV = "立即预约";
    public List<String> rW;
    @Nullable
    public AdTemplate rX;
    public String title;

    public final String gU() {
        return this.rR;
    }

    public final String gV() {
        return this.rQ;
    }

    @Nullable
    public final AdTemplate gW() {
        return this.rX;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c gX() {
        return this.mApkDownloadHelper;
    }

    public final List<String> gY() {
        return this.rO;
    }

    public final boolean gZ() {
        List<String> list = this.rO;
        if (list != null && list.size() != 0) {
            return false;
        }
        return true;
    }

    public final String gd() {
        return this.pZ;
    }

    public final String ge() {
        return this.qa;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int ha() {
        return this.playableStyle;
    }

    public final String hb() {
        return this.rT;
    }

    public final String hc() {
        return this.rV;
    }

    public final boolean hd() {
        return this.rS;
    }

    public final List<String> he() {
        return this.rW;
    }

    public final String hf() {
        return this.liveStartTime;
    }

    @Nullable
    public static a I(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo dP = e.dP(adTemplate);
        AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(dP);
        a aVar = new a();
        String name = cM.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.ax(dP);
        }
        aVar.pZ = cM.getIcon();
        aVar.qa = com.kwad.sdk.core.response.b.a.au(dP);
        aVar.price = cM.getPrice();
        aVar.originPrice = cM.getOriginPrice();
        if (!cM.isCouponListEmpty() && (firstCouponList = cM.getFirstCouponList()) != null) {
            aVar.M(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.L(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    @Nullable
    public static a J(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo da = com.kwad.sdk.core.response.b.b.da(adTemplate);
        a aVar = new a();
        aVar.pZ = da.userHeadUrl;
        aVar.liveStartTime = da.liveStartTime;
        aVar.title = da.title;
        aVar.rS = da.needShowSubscriberCount();
        aVar.rT = da.getFormattedLiveSubscribeCount();
        aVar.rW = da.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = da.playEndCard;
        aVar.rU = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.rV = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.rX = adTemplate;
        return aVar;
    }

    private void L(String str) {
        this.rQ = str;
    }

    private void M(String str) {
        this.rR = str;
    }

    @Nullable
    public static a a(r rVar, boolean z) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo dP = e.dP(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cc(dP);
        aVar.pZ = com.kwad.sdk.core.response.b.a.cf(dP);
        aVar.qa = com.kwad.sdk.core.response.b.a.au(dP);
        aVar.rO = com.kwad.sdk.core.response.b.d.dG(adTemplate);
        aVar.rP = com.kwad.sdk.core.response.b.a.aE(dP);
        aVar.playableStyle = e.j(adTemplate, z);
        aVar.rX = adTemplate;
        aVar.mApkDownloadHelper = rVar.gX();
        return aVar;
    }
}
