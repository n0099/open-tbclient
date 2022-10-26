package com.kwad.sdk.core.response.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public final class b {
    public static Random adc = new Random();

    public static AdMatrixInfo aL(AdTemplate adTemplate) {
        return d.bI(adTemplate) ? d.bQ(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static AdMatrixInfo.ActionBarInfoNew aM(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.actionBarInfo;
    }

    public static String aN(AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        int bK = d.bK(adTemplate);
        boolean z = bK == 3 || bK == 2;
        if (z && a.bF(bQ)) {
            return bS(bQ);
        }
        if (z && a.aK(adTemplate)) {
            AdMatrixInfo.MatrixTemplate b = b(adTemplate, bA(adTemplate).templateId);
            return b != null ? b.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, aM(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static long aO(AdTemplate adTemplate) {
        return aM(adTemplate).maxTimeOut;
    }

    public static boolean aP(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(aN(adTemplate));
    }

    public static AdMatrixInfo.AggregationCardInfo aQ(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.aggregationCardInfo;
    }

    public static String aR(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, aQ(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static long aS(AdTemplate adTemplate) {
        return d(adTemplate, aQ(adTemplate).templateId);
    }

    public static long aT(AdTemplate adTemplate) {
        return aQ(adTemplate).changeTime * 1000;
    }

    public static int aU(AdTemplate adTemplate) {
        return aQ(adTemplate).maxTimesPerDay;
    }

    public static long aV(AdTemplate adTemplate) {
        return aQ(adTemplate).intervalTime;
    }

    public static boolean aW(AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        return !a.am(bQ) && a.aa(bQ);
    }

    public static boolean aX(AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(aR(adTemplate)) && aS(adTemplate) > 0) {
            return ag.zL();
        }
        return false;
    }

    public static AdMatrixInfo.HalfCardInfo aY(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.halfCardInfo;
    }

    public static String aZ(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, aY(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean ac(AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    public static AdMatrixInfo.MatrixTemplate b(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : aL(adTemplate).styles.templateList) {
            if (ax.V(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo bA(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static boolean bB(AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        if (cg(bQ) || d.cd(adTemplate)) {
            return false;
        }
        return !(aM(adTemplate).cardType == 4) && d.bQ(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && bQ.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    @Deprecated
    public static String bS(AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        String str = adInfo.adStyleInfo.playDetailInfo.detailWebCardInfo.cardUrl;
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).ae(str)) {
            return str;
        }
        return null;
    }

    public static AdMatrixInfo.DownloadTexts bT(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts bU(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo.downloadTexts;
    }

    public static String bV(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String bW(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static AdMatrixInfo.DownloadTexts bX(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static String bY(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean bZ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static AdMatrixInfo.EndCardInfo ba(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.endCardInfo;
    }

    public static String bb(AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        int bK = d.bK(adTemplate);
        if ((bK == 3 || bK == 2) && a.bF(bQ)) {
            return bc(adTemplate);
        }
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, ba(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    @Deprecated
    public static String bc(AdTemplate adTemplate) {
        return c.bG(adTemplate).playEndInfo.adWebCardInfo.cardUrl;
    }

    public static boolean bd(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bb(adTemplate));
    }

    public static AdMatrixInfo.InteractionInfo be(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.interactionInfo;
    }

    public static String bf(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, be(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean bg(AdTemplate adTemplate) {
        if (adTemplate.mAdScene == null || !ag.zL() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lG() || TextUtils.isEmpty(bf(adTemplate))) {
            return false;
        }
        int adStyle = adTemplate.mAdScene.getAdStyle();
        if (adStyle == 1 || adStyle == 3 || adStyle == 2) {
            AdInfo bQ = d.bQ(adTemplate);
            return a.an(bQ) && a.am(bQ);
        }
        return false;
    }

    public static AdMatrixInfo.FeedInfo bh(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.feedInfo;
    }

    public static String bi(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bh(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static float bj(AdTemplate adTemplate) {
        return (float) d.bQ(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean bk(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bi(adTemplate));
    }

    public static AdMatrixInfo.InterstitialCardInfo bl(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static float bm(AdTemplate adTemplate) {
        int i;
        try {
            i = d.bQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean bn(AdTemplate adTemplate) {
        try {
            return d.bQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return false;
        }
    }

    public static String bo(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bl(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static float bp(AdTemplate adTemplate) {
        int i;
        try {
            i = d.bQ(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static AdMatrixInfo.RotateInfo bq(AdTemplate adTemplate) {
        try {
            return d.bQ(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.ComplianceCardInfo br(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.complianceCardInfo;
    }

    public static String bs(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, br(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean bt(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bs(adTemplate));
    }

    public static AdMatrixInfo.DownloadConfirmCardInfo bu(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    public static String bv(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bu(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean bw(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bv(adTemplate));
    }

    public static boolean bx(AdTemplate adTemplate) {
        List list = adTemplate.adInfoList;
        if (list != null && list.size() != 0) {
            AdInfo adInfo = (AdInfo) adTemplate.adInfoList.get(0);
            if (!a.bQ(adInfo) && !a.aY(adInfo) && adInfo.adBaseInfo.taskType == 4) {
                return true;
            }
        }
        return false;
    }

    public static AdMatrixInfo.RewardWatchOnceInfo by(AdTemplate adTemplate) {
        return aL(adTemplate).adDataV2.rewardWatchOnceInfo;
    }

    public static String bz(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, by(adTemplate).templateId);
        if (b != null) {
            return b.templateUrl;
        }
        return null;
    }

    public static AdMatrixInfo.TemplateData c(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : aL(adTemplate).adDataV2.templateDataList) {
            if (ax.V(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    public static int ca(AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i == 0) {
                return adc.nextBoolean() ? 1 : 2;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return 1;
        }
    }

    public static boolean cb(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean cc(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean cd(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean ce(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 0;
    }

    public static boolean cf(AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static boolean cg(AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || ac(adInfo) || a.bQ(adInfo)) ? false : true;
    }

    public static float ch(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static String ci(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String cj(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts ck(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static long d(AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData c = c(adTemplate, str);
        if (c != null) {
            return c.templateDelayTime;
        }
        return 0L;
    }

    public static boolean e(Context context, AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        if (!d.cd(adTemplate) && a.aG(bQ)) {
            return ag.cB(context) ? !a.I(bQ) : a.I(bQ);
        }
        return false;
    }
}
