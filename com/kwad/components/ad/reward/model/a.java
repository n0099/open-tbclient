package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public String kY;
    public String liveStartTime;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public String np;
    public List<String> oW;
    public String oX;
    public String oY;
    public String oZ;
    public String originPrice;
    public boolean pa;
    public String pb;
    public String pc = "查看详情";
    public String pd = "立即预约";
    public List<String> pe;
    @Nullable
    public AdTemplate pf;
    public int playableStyle;
    public String price;
    public String title;

    private void S(String str) {
        this.oY = str;
    }

    private void T(String str) {
        this.oZ = str;
    }

    @Nullable
    public static a a(u uVar, boolean z) {
        AdTemplate adTemplate;
        if (uVar == null || (adTemplate = uVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo bQ = d.bQ(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.a.a.bl(bQ);
        aVar.kY = com.kwad.sdk.core.response.a.a.bn(bQ);
        aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
        aVar.oW = com.kwad.sdk.core.response.a.c.bH(adTemplate);
        aVar.oX = com.kwad.sdk.core.response.a.a.al(bQ);
        aVar.playableStyle = d.f(adTemplate, z);
        aVar.pf = adTemplate;
        aVar.mApkDownloadHelper = uVar.getApkDownloadHelper();
        return aVar;
    }

    @Nullable
    public static a v(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        AdInfo bQ = d.bQ(adTemplate);
        AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(bQ);
        a aVar = new a();
        String name = bN.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.a.a.af(bQ);
        }
        aVar.kY = bN.getIcon();
        aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
        aVar.oX = com.kwad.components.ad.c.b.ai();
        aVar.price = bN.getPrice();
        aVar.originPrice = bN.getOriginPrice();
        return aVar;
    }

    @Nullable
    public static a w(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo bQ = d.bQ(adTemplate);
        AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(bQ);
        a aVar = new a();
        String name = bN.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.a.a.af(bQ);
        }
        aVar.kY = bN.getIcon();
        aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
        aVar.price = bN.getPrice();
        aVar.originPrice = bN.getOriginPrice();
        if (!bN.isCouponListEmpty() && (firstCouponList = bN.getFirstCouponList()) != null) {
            aVar.T(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.S(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    @Nullable
    public static a x(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo bA = com.kwad.sdk.core.response.a.b.bA(adTemplate);
        a aVar = new a();
        aVar.kY = bA.userHeadUrl;
        aVar.liveStartTime = bA.liveStartTime;
        aVar.title = bA.title;
        aVar.pa = bA.needShowSubscriberCount();
        aVar.pb = bA.getFormattedLiveSubscribeCount();
        aVar.pe = bA.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = bA.playEndCard;
        aVar.pc = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.pd = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.pf = adTemplate;
        return aVar;
    }

    public final String eL() {
        return this.kY;
    }

    public final String fO() {
        return this.np;
    }

    @Nullable
    public final AdTemplate gA() {
        return this.pf;
    }

    public final List<String> gB() {
        return this.oW;
    }

    public final boolean gC() {
        List<String> list = this.oW;
        return list == null || list.size() == 0;
    }

    public final int gD() {
        return this.playableStyle;
    }

    public final String gE() {
        return this.pb;
    }

    public final String gF() {
        return this.pc;
    }

    public final String gG() {
        return this.pd;
    }

    public final boolean gH() {
        return this.pa;
    }

    public final List<String> gI() {
        return this.pe;
    }

    public final String gJ() {
        return this.liveStartTime;
    }

    @Nullable
    public final com.kwad.components.core.c.a.c getApkDownloadHelper() {
        return this.mApkDownloadHelper;
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

    public final String gx() {
        return this.oX;
    }

    public final String gy() {
        return this.oZ;
    }

    public final String gz() {
        return this.oY;
    }
}
