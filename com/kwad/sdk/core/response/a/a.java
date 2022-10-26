package com.kwad.sdk.core.response.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a {
    public static String A(AdInfo adInfo) {
        return au(adInfo).materialUrl;
    }

    public static int B(AdInfo adInfo) {
        return au(adInfo).videoDuration;
    }

    public static long C(AdInfo adInfo) {
        return B(adInfo) * 1000;
    }

    public static String D(AdInfo adInfo) {
        int aD = aD(adInfo);
        if (aD != 1) {
            if (aD != 2 && aD != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.firstFrame)) {
                    return materialFeature.firstFrame;
                }
            }
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature2.featureType == 1 && !TextUtils.isEmpty(materialFeature2.firstFrame)) {
                return materialFeature2.firstFrame;
            }
        }
        return "";
    }

    public static boolean E(AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int F(AdInfo adInfo) {
        return au(adInfo).videoWidth;
    }

    public static int G(AdInfo adInfo) {
        return au(adInfo).videoHeight;
    }

    public static boolean H(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        return smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl);
    }

    public static boolean I(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature au = au(adInfo);
        return au.videoWidth <= au.videoHeight;
    }

    public static String J(AdInfo adInfo) {
        int aD = aD(adInfo);
        String str = "";
        if (aD == 1) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 1) {
                    str = materialFeature.coverUrl;
                    if (TextUtils.isEmpty(str)) {
                        str = materialFeature.firstFrame;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        break;
                    }
                }
            }
        } else if (aD == 2 || aD == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature2.featureType == 2) {
                    str = materialFeature2.coverUrl;
                    if (TextUtils.isEmpty(str)) {
                        str = materialFeature2.materialUrl;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        break;
                    }
                }
            }
        }
        return str;
    }

    @Deprecated
    public static String K(AdInfo adInfo) {
        int aD = aD(adInfo);
        if (aD != 1) {
            if (aD != 2 && aD != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2) {
                    if (!TextUtils.isEmpty(materialFeature.materialUrl)) {
                        return materialFeature.materialUrl;
                    }
                    if (!TextUtils.isEmpty(materialFeature.coverUrl)) {
                        return materialFeature.coverUrl;
                    }
                }
            }
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature2.featureType == 1 && !TextUtils.isEmpty(materialFeature2.coverUrl)) {
                return materialFeature2.coverUrl;
            }
        }
        return "";
    }

    public static String L(AdInfo adInfo) {
        int aD = aD(adInfo);
        if (aD != 1) {
            if (aD != 2 && aD != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return ax(adInfo).blurBackgroundUrl;
    }

    public static int M(AdInfo adInfo) {
        return au(adInfo).width;
    }

    public static int N(AdInfo adInfo) {
        return au(adInfo).height;
    }

    public static long O(AdInfo adInfo) {
        return au(adInfo).photoId;
    }

    public static String P(AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long Q(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int R(AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long S(AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long T(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    public static int U(AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.e.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean V(AdInfo adInfo) {
        return U(adInfo) != 0;
    }

    public static long W(AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.e.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long X(AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.e.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static long Y(AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.e.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean Z(AdInfo adInfo) {
        return !am(adInfo) && aa(adInfo);
    }

    public static List aA(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int aD = aD(adInfo);
        if (aD == 2 || aD == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static boolean aB(AdInfo adInfo) {
        return aD(adInfo) == 1;
    }

    public static boolean aC(AdInfo adInfo) {
        return at(adInfo).featureType == 2;
    }

    public static int aD(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return i != 5 ? 0 : 3;
            }
        }
        return i2;
    }

    public static boolean aE(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static List aF(AdInfo adInfo) {
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
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public static boolean aG(AdInfo adInfo) {
        return adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle == 1;
    }

    public static int[] aH(AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    public static int aI(AdInfo adInfo) {
        int[] aH = aH(adInfo);
        if (aH[0] > 0) {
            return aH[0];
        }
        return 3;
    }

    public static int aJ(AdInfo adInfo) {
        int[] aH = aH(adInfo);
        return (aH[1] > 0 ? aH[1] : 3) + aI(adInfo);
    }

    public static String aJ(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2 || bK(d.bQ(adTemplate))) {
            if (adTemplate == null) {
                return "立即安装";
            }
            AdInfo bQ = d.bQ(adTemplate);
            return TextUtils.isEmpty(bQ.adBaseInfo.installAppLabel) ? "立即安装" : bQ.adBaseInfo.installAppLabel;
        }
        return "安装获取奖励";
    }

    public static int aK(AdInfo adInfo) {
        int[] aH = aH(adInfo);
        return (aH[2] > 0 ? aH[2] : 3) + aJ(adInfo);
    }

    public static boolean aK(AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo bA = b.bA(adTemplate);
        return (bA != null && !bA.isEmpty()) && bQ.adBaseInfo.campaignType == 13 && bQ.ocpcActionType == 2;
    }

    public static com.kwad.sdk.core.response.model.b aL(AdInfo adInfo) {
        String str;
        int M;
        int N;
        boolean z;
        String D = D(adInfo);
        int F = F(adInfo);
        int G = G(adInfo);
        if (ax.dT(D) || ax.dU(D) || F == 0 || G == 0) {
            String K = K(adInfo);
            str = K;
            M = M(adInfo);
            N = N(adInfo);
            z = true;
        } else {
            str = D;
            M = F;
            N = G;
            z = false;
        }
        com.kwad.sdk.core.e.b.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, M, N, true, z);
    }

    public static String aM(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean aN(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean aO(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int aP(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    public static boolean aQ(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int aR(AdInfo adInfo) {
        if (adInfo != null) {
            int i = adInfo.status;
            if (i == 0) {
                return 1;
            }
            if (1 == i || 2 == i || 3 == i || 4 == i) {
                return 2;
            }
            return 8 == i ? 3 : 0;
        }
        return 0;
    }

    public static String aS(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    public static String aT(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    public static String aU(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    public static String aV(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Deprecated
    public static String aW(int i) {
        return h(i, "下载中  %s%%");
    }

    public static String aW(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long aX(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static String aX(int i) {
        return "继续下载 " + i + "%";
    }

    public static boolean aY(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            boolean z = (str == null || adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(str.trim())) ? false : true;
            if (aZ(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean aZ(AdInfo adInfo) {
        return ag.zL() ? bb(adInfo) : ba(adInfo);
    }

    public static boolean aa(AdInfo adInfo) {
        return (adInfo.adRewardInfo.showLandingPage != 1 || ac(adInfo) || bQ(adInfo)) ? false : true;
    }

    public static boolean ab(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.showLandingPage == 1;
    }

    public static boolean ac(AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    public static String ad(AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String ae(AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String af(AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String ag(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String ah(AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float ai(AdInfo adInfo) {
        int i = adInfo.adBaseInfo.appScore;
        if (i <= 0) {
            return 0.0f;
        }
        return i / 10.0f;
    }

    public static float aj(AdInfo adInfo) {
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
        return f < 45.0f ? 4.5f : 5.0f;
    }

    public static String ak(AdInfo adInfo) {
        return ax.dT(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String al(AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return am(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean am(AdInfo adInfo) {
        return ap(adInfo) == 1;
    }

    public static boolean an(AdInfo adInfo) {
        return adInfo.adBaseInfo.adAttributeType == 1;
    }

    public static boolean ao(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && am(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int ap(AdInfo adInfo) {
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

    public static int aq(AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String ar(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        return aa.R(dVar == null ? null : dVar.getContext(), adInfo.adConversionInfo.h5Url);
    }

    public static int as(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature at(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.b.e("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature au(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.b.e("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean av(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature au = aB(adInfo) ? au(adInfo) : at(adInfo);
        return au.height > au.width;
    }

    public static float aw(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature au = aB(adInfo) ? au(adInfo) : at(adInfo);
        if (au == null || au.width == 0) {
            return -1.0f;
        }
        com.kwad.sdk.core.e.b.d("AdInfoHelper", "getMaterialRatio: height: " + au.height + ", width: " + au.width);
        return au.height / au.width;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature ax(AdInfo adInfo) {
        List list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? (AdInfo.AdMaterialInfo.MaterialFeature) list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean ay(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature au = au(adInfo);
        return au.height > au.width;
    }

    public static String az(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    public static boolean bA(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean bB(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String bC(AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    public static boolean bD(AdInfo adInfo) {
        return adInfo.ocpcActionType == 72 && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean bE(AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    public static boolean bF(AdInfo adInfo) {
        if (adInfo.adBaseInfo.industryFirstLevelId != 1022) {
            return false;
        }
        int i = adInfo.ocpcActionType;
        return i == 192 || i == 53;
    }

    public static String bG(AdInfo adInfo) {
        int i = adInfo.advertiserInfo.fansCount;
        if (i < 200 || i >= 10000) {
            if (i >= 10000) {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                return decimalFormat.format(i / 10000.0d) + "w";
            }
            return null;
        }
        return String.valueOf(i);
    }

    public static String bH(AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String bI(AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    public static boolean bJ(AdInfo adInfo) {
        if (bF(adInfo)) {
            return false;
        }
        int i = adInfo.ocpcActionType;
        return (i == 395 || i == 192) && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean bK(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        return adBaseInfo.itemType == 1 && adBaseInfo.campaignType == 14;
    }

    public static boolean bL(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        return adBaseInfo.itemType == 2 && adBaseInfo.campaignType == 14;
    }

    public static String bM(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        return aa.R(dVar == null ? null : dVar.getContext(), adInfo.adConversionInfo.deeplinkUrl);
    }

    public static AdProductInfo bN(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String bO(AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean bP(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardReflowSwitch;
    }

    public static boolean bQ(AdInfo adInfo) {
        if (am(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean bR(AdInfo adInfo) {
        return bQ(adInfo) && T(adInfo) < C(adInfo);
    }

    public static boolean ba(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 2;
    }

    public static boolean bb(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 1;
    }

    public static String bc(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    public static String bd(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    public static String be(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    public static boolean bf(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bg(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bh(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean bi(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i = adFeedInfo.videoAutoPlayType;
        return i == 1 || i == 0;
    }

    public static boolean bj(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean bk(AdInfo adInfo) {
        return (TextUtils.isEmpty(ar(adInfo)) || am(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true;
    }

    public static String bl(AdInfo adInfo) {
        String ae = am(adInfo) ? ae(adInfo) : af(adInfo);
        if (TextUtils.isEmpty(ae)) {
            ae = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(ae) ? "可爱的广告君" : ae;
    }

    public static String bm(AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String bn(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !am(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static String bo(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static int bp(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int bq(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int br(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String bs(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean bt(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int bu(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static int bv(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int bw(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean bx(AdInfo adInfo) {
        int i = adInfo.adSplashInfo.skipType;
        return i == 2 || i == 3;
    }

    public static boolean by(AdInfo adInfo) {
        if (bz(adInfo)) {
            int i = adInfo.adSplashInfo.skipType;
            return i == 0 || i == 2;
        }
        return false;
    }

    public static boolean bz(AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean c(AdInfo adInfo, boolean z) {
        return ((z && am(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || ax.dT(ar(adInfo))) ? false : true;
    }

    public static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (d.cd(adTemplate) || adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle == 0) {
            return false;
        }
        return ag.zL() ? !I(adInfo) : I(adInfo);
    }

    public static SpannableString e(AdInfo adInfo, int i) {
        String format;
        int indexOf;
        String bG = bG(adInfo);
        if (bG == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", bG)).indexOf(bG)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf, bG.length() + indexOf, 18);
        return spannableString;
    }

    public static String h(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    public static String uU() {
        return "继续下载";
    }

    public static long z(AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }
}
