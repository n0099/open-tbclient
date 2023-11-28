package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static Random ayP = new Random();

    public static int a(boolean z, @NonNull AdInfo adInfo) {
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate;
        if (z) {
            baseMatrixTemplate = adInfo.adMatrixInfo.adDataV2.neoTKInfo;
        } else {
            baseMatrixTemplate = adInfo.adMatrixInfo.adDataV2.fullScreenInfo;
        }
        return baseMatrixTemplate.renderType;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate k(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : cb(adTemplate).styles.templateList) {
            if (bg.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    public static AdMatrixInfo.TemplateData l(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : cb(adTemplate).adDataV2.templateDataList) {
            if (bg.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    public static long m(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l = l(adTemplate, str);
        if (l != null) {
            return l.templateDelayTime;
        }
        return 0L;
    }

    public static boolean n(@NonNull AdTemplate adTemplate, String str) {
        String str2;
        AdMatrixInfo.TemplateData l = l(adTemplate, str);
        if (l != null) {
            str2 = l.data;
        } else {
            str2 = "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject("autoCallAppInfo");
            if (optJSONObject == null) {
                return false;
            }
            if (TextUtils.isEmpty(optJSONObject.optString("adTitle"))) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String cA(@NonNull AdTemplate adTemplate) {
        if (cB(adTemplate)) {
            return cz(adTemplate);
        }
        return a.aS(e.dP(adTemplate));
    }

    public static boolean cB(@NonNull AdTemplate adTemplate) {
        if (!adTemplate.mIsForceJumpLandingPage && !a.bY(adTemplate) && dg(e.dP(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdMatrixInfo.FeedInfo cC(@NonNull AdTemplate adTemplate) {
        if (cD(adTemplate)) {
            return cb(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return cb(adTemplate).adDataV2.feedInfo;
    }

    public static boolean cD(@NonNull AdTemplate adTemplate) {
        if (a.cJ(e.dP(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdMatrixInfo.FeedInfo cE(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String cF(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cC(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static AdMatrixInfo.FeedTKInfo cG(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.feedTKCardInfo;
    }

    @Nullable
    public static String cH(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cE(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    @Nullable
    public static boolean cI(@NonNull AdTemplate adTemplate) {
        if (cC(adTemplate).interactionInfo.interactiveStyle == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public static boolean cJ(@NonNull AdTemplate adTemplate) {
        return cC(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int cK(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cC(adTemplate).interactionInfo;
        if (adInteractionInfo != null && (shakeInfo = adInteractionInfo.shakeInfo) != null) {
            return shakeInfo.acceleration;
        }
        return 0;
    }

    public static double cL(@NonNull AdTemplate adTemplate) {
        return e.dP(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean cM(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cF(adTemplate))) {
            return true;
        }
        return false;
    }

    public static boolean cN(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cG(adTemplate).templateId)) {
            return true;
        }
        return false;
    }

    public static String cO(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo cG = cG(adTemplate);
        if (TextUtils.isEmpty(cG.templateId)) {
            return "ksad-feed-card";
        }
        return cG.templateId;
    }

    public static boolean cP(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cH(adTemplate))) {
            return true;
        }
        return false;
    }

    public static float cQ(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = e.dP(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean cR(@NonNull AdTemplate adTemplate) {
        try {
            if (e.dP(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static float cS(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = e.dP(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static AdMatrixInfo.RotateInfo cT(@NonNull AdTemplate adTemplate) {
        try {
            return e.dP(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @NonNull
    public static AdMatrixInfo.BaseMatrixTemplate cU(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    public static String cV(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cU(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static boolean cW(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cV(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdMatrixInfo.BaseMatrixTemplate cX(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String cY(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cX(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static boolean cZ(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cY(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdMatrixInfo cb(@NonNull AdTemplate adTemplate) {
        if (e.dH(adTemplate)) {
            return e.dP(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cc(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).styles.templateList;
    }

    @NonNull
    public static AdMatrixInfo.AdDataV2 cd(@NonNull AdTemplate adTemplate) {
        return e.dP(adTemplate).adMatrixInfo.adDataV2;
    }

    public static boolean cf(@NonNull AdTemplate adTemplate) {
        return n(adTemplate, cg(adTemplate).templateId);
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo cg(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String ch(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cb(adTemplate).adDataV2.splashActionBarInfo.templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    @NonNull
    public static AdMatrixInfo.ActionBarInfoNew ci(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.actionBarInfo;
    }

    public static long ck(@NonNull AdTemplate adTemplate) {
        return ci(adTemplate).maxTimeOut;
    }

    public static boolean cl(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cj(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdMatrixInfo.AggregationCardInfo cm(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    public static String cn(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cm(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static long co(@NonNull AdTemplate adTemplate) {
        return m(adTemplate, cm(adTemplate).templateId);
    }

    public static long cp(@NonNull AdTemplate adTemplate) {
        return cm(adTemplate).changeTime * 1000;
    }

    public static int cq(@NonNull AdTemplate adTemplate) {
        return cm(adTemplate).maxTimesPerDay;
    }

    public static long cr(@NonNull AdTemplate adTemplate) {
        return cm(adTemplate).intervalTime;
    }

    public static boolean cs(@NonNull AdTemplate adTemplate) {
        AdInfo dP = e.dP(adTemplate);
        if (!a.aF(dP) && a.at(dP)) {
            return true;
        }
        return false;
    }

    public static boolean ct(@NonNull AdTemplate adTemplate) {
        if (TextUtils.isEmpty(cn(adTemplate)) || co(adTemplate) <= 0) {
            return false;
        }
        return ai.isOrientationPortrait();
    }

    @NonNull
    public static AdMatrixInfo.BaseMatrixTemplate cu(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String cv(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cu(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    @NonNull
    public static AdMatrixInfo.EndCardInfo cw(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    public static String cx(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cw(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static boolean cy(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cx(adTemplate))) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String cz(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, e.dP(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static boolean dA(@NonNull AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 4) {
                if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 9) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dB(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 4) {
            return false;
        }
        return true;
    }

    public static boolean dC(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled) {
            return false;
        }
        return true;
    }

    public static long dD(@NonNull AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j <= 0) {
                return 1500L;
            }
            return j;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean dE(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled) {
            return false;
        }
        return true;
    }

    public static float dF(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static float dG(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static String dH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String dI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String dJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String dK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts dL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts dM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean dN(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean dO(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1) {
            return true;
        }
        return false;
    }

    public static boolean dP(@NonNull AdInfo adInfo) {
        if (a.bH(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) {
            return false;
        }
        return true;
    }

    public static int dQ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String dR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static boolean dS(@NonNull AdInfo adInfo) {
        if (a.bd(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static boolean dT(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).bP(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo da(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo db(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dc(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static long dd(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int de(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static boolean df(@NonNull AdInfo adInfo) {
        if (dg(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dg(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId)) {
            return true;
        }
        return false;
    }

    @Nullable
    public static AdMatrixInfo.PreLandingPageTKInfo dh(@NonNull AdTemplate adTemplate) {
        return e.dP(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static long di(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static long dj(@NonNull AdTemplate adTemplate) {
        long j = cd(adTemplate).installedActivateInfo.showTime;
        if (j <= 0) {
            return 0L;
        }
        return j;
    }

    public static String dk(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static String dl(AdTemplate adTemplate) {
        return cd(adTemplate).neoTKInfo.templateId;
    }

    public static String dm(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    public static String dn(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    /* renamed from: do  reason: not valid java name */
    public static String m182do(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    public static int dp(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return 1;
        }
    }

    public static String dq(AdTemplate adTemplate) {
        return cd(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String dr(AdTemplate adTemplate) {
        return cd(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static int ds(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int dt(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static String du(AdTemplate adTemplate) {
        return cd(adTemplate).activityTKInfo.templateId;
    }

    public static String dv(AdTemplate adTemplate) {
        return cd(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String dw(AdTemplate adTemplate) {
        return cd(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String dx(AdTemplate adTemplate) {
        return cd(adTemplate).pushTKInfo.templateId;
    }

    public static String dy(AdTemplate adTemplate) {
        return cd(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String dz(AdTemplate adTemplate) {
        return cd(adTemplate).feedTKCardInfo.templateId;
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.recommendAggregateSwitch && !a.cO(adInfo) && !a.bH(adInfo)) {
            return true;
        }
        return false;
    }

    public static FeedSlideConf ce(@NonNull AdTemplate adTemplate) {
        String str;
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData l = l(adTemplate, cC(adTemplate).templateId);
        if (l != null) {
            str = l.data;
        } else {
            str = "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("angle")) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Nullable
    public static String cj(@NonNull AdTemplate adTemplate) {
        boolean z;
        AdInfo dP = e.dP(adTemplate);
        int dJ = e.dJ(adTemplate);
        if (dJ != 3 && dJ != 2) {
            z = false;
        } else {
            z = true;
        }
        if (a.cJ(dP)) {
            return "";
        }
        if (z && a.ca(adTemplate)) {
            AdMatrixInfo.MatrixTemplate k = k(adTemplate, da(adTemplate).templateId);
            if (k == null) {
                return "";
            }
            return k.templateUrl;
        }
        AdMatrixInfo.MatrixTemplate k2 = k(adTemplate, ci(adTemplate).templateId);
        if (k2 == null) {
            return "";
        }
        return k2.templateUrl;
    }

    public static boolean df(AdTemplate adTemplate) {
        boolean z;
        AdInfo dP = e.dP(adTemplate);
        if (g(dP) || e.eb(adTemplate)) {
            return false;
        }
        if (ci(adTemplate).cardType == 4) {
            z = true;
        } else {
            z = false;
        }
        if (z || e.dP(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType > 0 || dP.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle != 2) {
            return false;
        }
        return true;
    }

    public static boolean dg(AdTemplate adTemplate) {
        boolean z;
        AdInfo dP = e.dP(adTemplate);
        if (g(dP) || e.eb(adTemplate)) {
            return false;
        }
        if (ci(adTemplate).cardType == 4) {
            z = true;
        } else {
            z = false;
        }
        if (z || e.dP(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || dP.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) {
            return false;
        }
        return true;
    }

    public static boolean db(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static boolean dc(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dd(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static boolean de(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static String dh(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static boolean di(@NonNull AdTemplate adTemplate) {
        return cd(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static String dj(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dk(AdTemplate adTemplate) {
        return cd(adTemplate).topFloorTKInfo.templateId;
    }

    public static boolean dl(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2) {
            return true;
        }
        return false;
    }

    public static String dm(AdTemplate adTemplate) {
        return cd(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String dn(AdTemplate adTemplate) {
        return cd(adTemplate).videoImageTKInfo.templateId;
    }

    /* renamed from: do  reason: not valid java name */
    public static String m183do(AdTemplate adTemplate) {
        return cd(adTemplate).fullScreenInfo.templateId;
    }

    public static String dp(AdTemplate adTemplate) {
        return cd(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static boolean dq(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        if (adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4) {
            return true;
        }
        return false;
    }

    public static boolean dr(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2) {
            return true;
        }
        return false;
    }

    public static String ds(AdTemplate adTemplate) {
        return cd(adTemplate).interstitialCardInfo.templateId;
    }

    public static String dt(AdTemplate adTemplate) {
        return cd(adTemplate).confirmTKInfo.templateId;
    }

    public static boolean du(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2) {
            return true;
        }
        return false;
    }

    public static boolean dv(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1) {
            return true;
        }
        return false;
    }

    public static boolean dw(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1) {
            return true;
        }
        return false;
    }

    public static boolean dx(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3) {
            return true;
        }
        return false;
    }

    public static boolean dy(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10) {
            return true;
        }
        return false;
    }

    public static boolean dz(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3) {
            return true;
        }
        return false;
    }
}
