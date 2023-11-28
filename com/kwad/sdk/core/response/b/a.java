package com.kwad.sdk.core.response.b;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.cj;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.y;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static String DX() {
        return "继续下载";
    }

    public static String G(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    public static long J(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String K(@NonNull AdInfo adInfo) {
        return aV(adInfo).materialUrl;
    }

    public static int L(@NonNull AdInfo adInfo) {
        if (be(adInfo) == 2) {
            return aU(adInfo).videoDuration;
        }
        return aV(adInfo).videoDuration;
    }

    public static long M(@NonNull AdInfo adInfo) {
        int i;
        if (be(adInfo) == 2) {
            i = aU(adInfo).videoDuration;
        } else {
            i = aV(adInfo).videoDuration;
        }
        return i * 1000;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature N(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (ah.L(list)) {
            return list.get(0);
        }
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        if (adInfo.adConversionInfo.supportThirdDownload == 1) {
            return true;
        }
        return false;
    }

    public static int Q(@NonNull AdInfo adInfo) {
        return aV(adInfo).videoWidth;
    }

    public static int R(@NonNull AdInfo adInfo) {
        return aV(adInfo).videoHeight;
    }

    public static boolean S(@NonNull AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        if (smallAppJumpInfo != null && !TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId)) {
            return false;
        }
        return true;
    }

    public static boolean T(@NonNull AdInfo adInfo) {
        if (adInfo.adConversionInfo.webUriSourceType == 2) {
            return true;
        }
        return false;
    }

    public static boolean U(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    public static boolean V(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    public static boolean W(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        if (aV.videoWidth <= aV.videoHeight) {
            return true;
        }
        return false;
    }

    public static int Z(@NonNull AdInfo adInfo) {
        return aV(adInfo).width;
    }

    public static float aA(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.appScore;
        if (i <= 0) {
            return 0.0f;
        }
        return i / 10.0f;
    }

    public static boolean aB(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float aC(@NonNull AdInfo adInfo) {
        float f = adInfo.adBaseInfo.appScore;
        if (f < 30.0f) {
            return 3.0f;
        }
        if (f < 35.0f) {
            return 3.5f;
        }
        if (f < 40.0f) {
            return 4.0f;
        }
        if (f < 45.0f) {
            return 4.5f;
        }
        return 5.0f;
    }

    public static String aD(AdInfo adInfo) {
        if (bg.isNullString(adInfo.adBaseInfo.adSourceDescription)) {
            return "广告";
        }
        return adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aE(@Nullable AdInfo adInfo) {
        String str = "立即下载";
        if (adInfo == null) {
            return "立即下载";
        }
        String str2 = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str2)) {
            if (!aF(adInfo)) {
                str = "查看详情";
            }
            return str;
        }
        return str2;
    }

    public static boolean aF(@NonNull AdInfo adInfo) {
        if (aQ(adInfo) == 1) {
            return true;
        }
        return false;
    }

    public static boolean aG(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static int aH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aO(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static boolean aP(@NonNull AdInfo adInfo) {
        if (adInfo.downloadSafeInfo.complianceInfo == null || !aF(adInfo) || adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch != 1) {
            return false;
        }
        return true;
    }

    public static int aQ(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static int aR(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aS(@NonNull AdInfo adInfo) {
        Context context;
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            context = null;
        } else {
            context = fVar.getContext();
        }
        if (TextUtils.isEmpty(adInfo.adConversionInfo.h5Url)) {
            return "";
        }
        return ac.c(context, adInfo.adConversionInfo.h5Url, aB(adInfo));
    }

    public static int aT(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aU(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aV(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean aW(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aU;
        if (bc(adInfo)) {
            aU = aV(adInfo);
        } else {
            aU = aU(adInfo);
        }
        if (aU.height > aU.width) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aX(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (list.size() > 0) {
            materialFeature = list.get(0);
        } else {
            materialFeature = null;
        }
        if (materialFeature == null) {
            return new AdInfo.AdMaterialInfo.MaterialFeature();
        }
        return materialFeature;
    }

    public static boolean aY(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        if (aV.height > aV.width) {
            return true;
        }
        return false;
    }

    public static String aZ(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    public static int aa(@NonNull AdInfo adInfo) {
        return aV(adInfo).height;
    }

    public static long ab(@NonNull AdInfo adInfo) {
        return aV(adInfo).photoId;
    }

    public static String ac(@Nullable AdInfo adInfo) {
        if (adInfo != null && !TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) {
            return adInfo.adBaseInfo.openAppLabel;
        }
        return "立即打开";
    }

    public static long ad(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int ae(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long af(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long ag(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    public static int ah(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean ai(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int aj(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean ak(@NonNull AdInfo adInfo) {
        if (ah(adInfo) != 0) {
            return true;
        }
        return false;
    }

    public static long al(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long am(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int an(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean ao(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ap(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean aq(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long ar(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean as(@NonNull AdInfo adInfo) {
        if (!aF(adInfo) && at(adInfo)) {
            return true;
        }
        return false;
    }

    public static boolean at(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            if ((!aO(adInfo) || aN(adInfo) != 1) && !cO(adInfo)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static String au(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String av(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String aw(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    public static String ax(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String ay(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo != null && (adBaseInfo = adInfo.adBaseInfo) != null) {
            return adBaseInfo.appPackageName;
        }
        return null;
    }

    public static String az(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    @Nullable
    public static String bA(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String bB(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bC(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    @Nullable
    public static String bD(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bE(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String bF(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bG(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bH(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        boolean z;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            if (str != null && adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(str.trim())) {
                z = true;
            } else {
                z = false;
            }
            if (bK(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static long bI(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.h5DeeplinkLimitedTimeMs;
        }
        return 0L;
    }

    public static long bJ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.playableDeeplinkLimitedTimeMs;
        }
        return 0L;
    }

    public static boolean bK(AdInfo adInfo) {
        if (ai.isOrientationPortrait()) {
            return bM(adInfo);
        }
        return bL(adInfo);
    }

    public static boolean bL(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        if (i != 0 && i != 2) {
            return false;
        }
        return true;
    }

    public static boolean bM(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        if (i != 0 && i != 1) {
            return false;
        }
        return true;
    }

    @Nullable
    public static String bN(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.playableUrl;
        }
        return null;
    }

    @Nullable
    public static String bO(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.callbackUrl;
        }
        return null;
    }

    @Nullable
    public static String bP(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.callbackUrlInfo;
        }
        return null;
    }

    @Nullable
    public static String bQ(AdInfo adInfo) {
        String str;
        if (adInfo != null && (str = adInfo.serverExt) != null) {
            return str;
        }
        return null;
    }

    public static boolean bR(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bS(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bT(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) {
            return false;
        }
        return true;
    }

    public static boolean bU(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i = adFeedInfo.videoAutoPlayType;
        if (i != 1 && i != 0) {
            return false;
        }
        return true;
    }

    public static boolean bV(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) {
            return false;
        }
        return true;
    }

    public static boolean bW(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 3) {
            return false;
        }
        return true;
    }

    public static boolean bX(AdInfo adInfo) {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if ((hVar != null && hVar.yF()) || TextUtils.isEmpty(aS(adInfo)) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) {
            return false;
        }
        return true;
    }

    @NonNull
    public static String bY(@NonNull AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        if (TextUtils.isEmpty(str)) {
            return "浏览页面";
        }
        return str;
    }

    public static int bZ(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }

    @NonNull
    public static String bb(@NonNull AdInfo adInfo) {
        if (bc(adInfo)) {
            return K(adInfo);
        }
        List<String> ba = ba(adInfo);
        if (ba.size() > 0) {
            return ba.get(0);
        }
        return "";
    }

    public static boolean bc(@NonNull AdInfo adInfo) {
        if (be(adInfo) == 1) {
            return true;
        }
        return false;
    }

    public static boolean bd(@NonNull AdInfo adInfo) {
        if (aU(adInfo).featureType == 2) {
            return true;
        }
        return false;
    }

    public static int be(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 5) {
                    if (i == 8) {
                        return 8;
                    }
                    return 0;
                }
                return 3;
            }
        }
        return i2;
    }

    public static int bf(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static String bg(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean bh(AdInfo adInfo) {
        if (adInfo.adMaterialInfo.materialType == 1) {
            return true;
        }
        return false;
    }

    public static boolean bi(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bj(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bk(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    public static boolean bl(AdInfo adInfo) {
        if (new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() == 0) {
            return false;
        }
        return true;
    }

    public static int bo(@NonNull AdInfo adInfo) {
        int[] bn = bn(adInfo);
        if (bn[0] > 0) {
            return bn[0];
        }
        return 3;
    }

    public static int bp(@NonNull AdInfo adInfo) {
        int i;
        int[] bn = bn(adInfo);
        if (bn[1] > 0) {
            i = bn[1];
        } else {
            i = 3;
        }
        return i + bo(adInfo);
    }

    public static int bq(@NonNull AdInfo adInfo) {
        int i;
        int[] bn = bn(adInfo);
        if (bn[2] > 0) {
            i = bn[2];
        } else {
            i = 3;
        }
        return i + bp(adInfo);
    }

    public static String bs(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "您访问的网站由第三方提供";
    }

    public static boolean bt(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bu(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bv(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    public static boolean bw(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bx(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i = adInfo.status;
        if (i == 0) {
            return 1;
        }
        if (1 == i || 2 == i || 3 == i || 4 == i) {
            return 2;
        }
        if (8 != i) {
            return 0;
        }
        return 3;
    }

    public static int by(AdInfo adInfo) {
        return adInfo.status;
    }

    @Nullable
    public static String bz(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    public static String cA(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean cB(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.innerAdType == 3) {
            return true;
        }
        return false;
    }

    public static boolean cC(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    public static boolean cD(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.innerAdType == 1) {
            return true;
        }
        return false;
    }

    public static String cF(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cG(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    public static boolean cH(@NonNull AdInfo adInfo) {
        int i = adInfo.adStyleConfInfo.innerAdType;
        if (i != 4 && i != 5) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean cI(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.innerAdType == 7) {
            return true;
        }
        return false;
    }

    public static boolean cJ(@NonNull AdInfo adInfo) {
        if (adInfo.adBaseInfo.universeLiveType == 1 && cg(adInfo) != 0) {
            return true;
        }
        return false;
    }

    public static String cK(@NonNull AdInfo adInfo) {
        Context context;
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            context = null;
        } else {
            context = fVar.getContext();
        }
        return ac.c(context, adInfo.adConversionInfo.deeplinkUrl, aB(adInfo));
    }

    public static String cL(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    public static AdProductInfo cM(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cN(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean cO(@NonNull AdInfo adInfo) {
        if (aF(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cP(@NonNull AdInfo adInfo) {
        if (cO(adInfo) && ag(adInfo) < M(adInfo)) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static String cQ(int i) {
        return q(i, "下载中  %s%%");
    }

    public static String cR(int i) {
        return "继续下载 " + i + "%";
    }

    public static int cS(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static boolean cT(@NonNull AdInfo adInfo) {
        if (cJ(adInfo) && !TextUtils.isEmpty(b.dR(adInfo)) && !cU(adInfo)) {
            return true;
        }
        return false;
    }

    public static boolean cU(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long cV(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean cW(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean cX(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static int ca(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    public static int cb(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    @NonNull
    public static String cc(@NonNull AdInfo adInfo) {
        String ax;
        if (aF(adInfo)) {
            ax = av(adInfo);
        } else {
            ax = ax(adInfo);
        }
        if (TextUtils.isEmpty(ax)) {
            ax = adInfo.advertiserInfo.rawUserName;
        }
        if (TextUtils.isEmpty(ax)) {
            return "可爱的广告君";
        }
        return ax;
    }

    @NonNull
    public static String cd(@NonNull AdInfo adInfo) {
        String aw = aw(adInfo);
        if (TextUtils.isEmpty(aw)) {
            return "可爱的广告君";
        }
        return aw;
    }

    @NonNull
    public static String ce(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String cf(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        if (TextUtils.isEmpty(str) || !aF(adInfo)) {
            return adInfo.advertiserInfo.portraitUrl;
        }
        return str;
    }

    public static long cg(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    @NonNull
    public static String ch(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        if (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) {
            return "跳过";
        }
        return adInfo.adSplashInfo.skipTips;
    }

    public static AdInfo.CutRuleInfo ci(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int cj(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean ck(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int cl(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int cm(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int cn(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String co(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean cp(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int cq(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static int cr(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int cs(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean ct(@NonNull AdInfo adInfo) {
        int i = adInfo.adSplashInfo.skipType;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    public static boolean cu(@Nullable AdInfo adInfo) {
        if (!cv(adInfo)) {
            return false;
        }
        int i = adInfo.adSplashInfo.skipType;
        if (i != 0 && i != 2) {
            return false;
        }
        return true;
    }

    public static boolean cv(@Nullable AdInfo adInfo) {
        if (adInfo.adSplashInfo.skipSecond >= 0) {
            return true;
        }
        return false;
    }

    public static boolean cw(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        if (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) {
            return false;
        }
        return true;
    }

    public static boolean cx(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    public static int cy(@NonNull AdInfo adInfo) {
        double d = adInfo.adSplashInfo.impressionLimitSize;
        return ((int) ((d <= 0.0d || d > 1.0d) ? 0.699999988079071d : 0.699999988079071d)) * 100;
    }

    public static boolean cz(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo != null && (downloadSafeInfo = adInfo.downloadSafeInfo) != null) {
            return downloadSafeInfo.downloadPauseEnable;
        }
        return false;
    }

    public static String da(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        if (!TextUtils.isEmpty(aV.coverUrl)) {
            return aV.coverUrl;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String O(@NonNull AdInfo adInfo) {
        int be = be(adInfo);
        if (be != 1) {
            if (be != 2 && be != 3) {
                if (be != 8) {
                    return "";
                }
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                    if (materialFeature.featureType == 3 && !TextUtils.isEmpty(materialFeature.firstFrame)) {
                        return materialFeature.firstFrame;
                    }
                }
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature2.featureType == 2 && !TextUtils.isEmpty(materialFeature2.firstFrame)) {
                    return materialFeature2.firstFrame;
                }
            }
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature3 : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature3.featureType == 1 && !TextUtils.isEmpty(materialFeature3.firstFrame)) {
                return materialFeature3.firstFrame;
            }
        }
        while (r6.hasNext()) {
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String X(@NonNull AdInfo adInfo) {
        int be = be(adInfo);
        if (be != 1) {
            if (be != 2 && be != 3) {
                if (be != 8) {
                    return "";
                }
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                    if (materialFeature.featureType == 3 && !TextUtils.isEmpty(materialFeature.coverUrl)) {
                        return materialFeature.coverUrl;
                    }
                }
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature2.featureType == 2) {
                    if (!TextUtils.isEmpty(materialFeature2.materialUrl)) {
                        return materialFeature2.materialUrl;
                    }
                    if (!TextUtils.isEmpty(materialFeature2.coverUrl)) {
                        return materialFeature2.coverUrl;
                    }
                }
            }
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature3 : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature3.featureType == 1 && !TextUtils.isEmpty(materialFeature3.coverUrl)) {
                return materialFeature3.coverUrl;
            }
        }
        while (r6.hasNext()) {
        }
        return "";
    }

    public static String Y(@NonNull AdInfo adInfo) {
        int be = be(adInfo);
        if (be != 1) {
            if (be != 2 && be != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aX(adInfo).blurBackgroundUrl;
    }

    public static String bX(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2 && !cI(e.dP(adTemplate)) && !cJ(e.dP(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return "立即安装";
        }
        AdInfo dP = e.dP(adTemplate);
        if (TextUtils.isEmpty(dP.adBaseInfo.installAppLabel)) {
            return "立即安装";
        }
        return dP.adBaseInfo.installAppLabel;
    }

    @NonNull
    public static List<String> ba(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int be = be(adInfo);
        if (be != 2 && be != 3) {
            return arrayList;
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    @Nullable
    public static List<Integer> bm(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt > 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    @Nullable
    public static String cE(@NonNull AdInfo adInfo) {
        int i = adInfo.advertiserInfo.fansCount;
        if (i >= 200 && i < 10000) {
            return String.valueOf(i);
        }
        if (i >= 10000) {
            DecimalFormat decimalFormat = new DecimalFormat(cj.d);
            return decimalFormat.format(i / 10000.0d) + "w";
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if ((java.lang.System.currentTimeMillis() - r2) > (r6 * 1000)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean cR(@NonNull AdInfo adInfo) {
        boolean z = false;
        if (!adInfo.adStyleConfInfo.adPushSwitch) {
            return false;
        }
        long Kk = y.Kk();
        if (Kk > 0) {
            long j = adInfo.adStyleConfInfo.adPushIntervalTime;
            if (j <= 0) {
                j = 900;
            }
        }
        z = true;
        com.kwad.sdk.core.e.c.d("AdInfoHelper", "isPushAdEnable intervalEnable: " + z);
        return z;
    }

    public static List<String> cZ(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int be = be(adInfo);
        if (be == 2 || be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static SpannableString b(AdInfo adInfo, @ColorInt int i) {
        String format;
        int indexOf;
        String cE = cE(adInfo);
        if (cE != null && (indexOf = (format = String.format("已有%s粉丝关注了TA", cE)).indexOf(cE)) >= 0) {
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new ForegroundColorSpan(i), indexOf, cE.length() + indexOf, 18);
            return spannableString;
        }
        return null;
    }

    public static String q(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    public static boolean b(@NonNull AdInfo adInfo, boolean z) {
        boolean z2;
        if (z && aF(adInfo)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && adInfo.adBaseInfo.mABParams.showVideoAtH5 != 0 && !bg.isNullString(aS(adInfo))) {
            return true;
        }
        return false;
    }

    public static boolean bY(AdTemplate adTemplate) {
        return e.dP(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    public static String bZ(AdTemplate adTemplate) {
        return e.dP(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    public static boolean cQ(@NonNull AdInfo adInfo) {
        if (TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            com.kwad.sdk.core.e.c.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean ca(@NonNull AdTemplate adTemplate) {
        boolean z;
        AdInfo dP = e.dP(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo da = b.da(adTemplate);
        if (da != null && !da.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z && dP.adStyleConfInfo.innerAdType == 2) {
            return true;
        }
        return false;
    }

    @NonNull
    public static int[] bn(@NonNull AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b br(@NonNull AdInfo adInfo) {
        String str;
        int Z;
        int aa;
        boolean z;
        String O = O(adInfo);
        int Q = Q(adInfo);
        int R = R(adInfo);
        if (!bg.isNullString(O) && !bg.gi(O) && Q != 0 && R != 0) {
            str = O;
            Z = Q;
            aa = R;
            z = false;
        } else {
            String X = X(adInfo);
            str = X;
            Z = Z(adInfo);
            aa = aa(adInfo);
            z = true;
        }
        com.kwad.sdk.core.e.c.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, Z, aa, true, z);
    }

    public static KSAdInfoData cY(AdInfo adInfo) {
        return KSAdInfoData.obtain().setAdDescription(au(adInfo)).setProductName(ax(adInfo)).setAdSource(aD(adInfo)).setVideoUrl(cf(adInfo)).setMaterialType(be(adInfo)).setAppIconUrl(cf(adInfo)).setAppName(av(adInfo)).setImageList(cZ(adInfo)).setVideoCoverImageUrl(da(adInfo)).setInteractionType(aQ(adInfo));
    }
}
