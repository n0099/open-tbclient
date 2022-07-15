package com.kwad.sdk.core.response.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.y;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class a {
    public static String A(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String B(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String C(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String D(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float E(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.appScore;
        if (i <= 0) {
            return 0.0f;
        }
        return i / 10.0f;
    }

    public static float F(@NonNull AdInfo adInfo) {
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

    public static String G(AdInfo adInfo) {
        return at.a(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String H(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return I(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean I(@NonNull AdInfo adInfo) {
        return L(adInfo) == 1;
    }

    public static boolean J(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adAttributeType == 1;
    }

    public static boolean K(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && I(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int L(@NonNull AdInfo adInfo) {
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

    public static int M(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String N(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        return y.a(dVar == null ? null : dVar.a(), adInfo.adConversionInfo.h5Url);
    }

    public static int O(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature P(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.e("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature Q(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.e("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean R(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature Q = W(adInfo) ? Q(adInfo) : P(adInfo);
        return Q.height > Q.width;
    }

    public static float S(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature Q = W(adInfo) ? Q(adInfo) : P(adInfo);
        if (Q == null || Q.width == 0) {
            return -1.0f;
        }
        com.kwad.sdk.core.d.b.a("AdInfoHelper", "getMaterialRatio: height: " + Q.height + ", width: " + Q.width);
        return Q.height / Q.width;
    }

    public static boolean T(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature Q = Q(adInfo);
        return Q.height > Q.width;
    }

    public static String U(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> V(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int Y = Y(adInfo);
        if (Y == 2 || Y == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static boolean W(@NonNull AdInfo adInfo) {
        return Y(adInfo) == 1;
    }

    public static boolean X(@NonNull AdInfo adInfo) {
        return P(adInfo).featureType == 2;
    }

    public static int Y(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    @Nullable
    public static List<Integer> Z(@NonNull AdInfo adInfo) {
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
                com.kwad.sdk.core.d.b.a(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public static long a(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    @Nullable
    public static SpannableString a(AdInfo adInfo, @ColorInt int i) {
        String format;
        int indexOf;
        String aW = aW(adInfo);
        if (aW == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", aW)).indexOf(aW)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf, aW.length() + indexOf, 18);
        return spannableString;
    }

    public static String a() {
        return "继续下载";
    }

    @Deprecated
    public static String a(int i) {
        return a(i, "下载中  %s%%");
    }

    public static String a(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    public static String a(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2 || bb(d.i(adTemplate))) {
            if (adTemplate == null) {
                return "立即安装";
            }
            AdInfo i = d.i(adTemplate);
            return TextUtils.isEmpty(i.adBaseInfo.installAppLabel) ? "立即安装" : i.adBaseInfo.installAppLabel;
        }
        return "安装获取奖励";
    }

    public static boolean a(@NonNull AdInfo adInfo, boolean z) {
        return ((z && I(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || at.a(N(adInfo))) ? false : true;
    }

    public static boolean a(AdTemplate adTemplate, @NonNull AdInfo adInfo) {
        if (d.w(adTemplate) || adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle == 0) {
            return false;
        }
        return ae.a() ? !j(adInfo) : j(adInfo);
    }

    public static boolean aA(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean aB(AdInfo adInfo) {
        return (TextUtils.isEmpty(N(adInfo)) || I(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true;
    }

    @NonNull
    public static String aC(@NonNull AdInfo adInfo) {
        String A = I(adInfo) ? A(adInfo) : B(adInfo);
        if (TextUtils.isEmpty(A)) {
            A = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(A) ? "可爱的广告君" : A;
    }

    @NonNull
    public static String aD(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String aE(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !I(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    @NonNull
    public static String aF(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static int aG(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int aH(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int aI(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String aJ(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean aK(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int aL(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static int aM(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int aN(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean aO(@NonNull AdInfo adInfo) {
        int i = adInfo.adSplashInfo.skipType;
        return i == 2 || i == 3;
    }

    public static boolean aP(@Nullable AdInfo adInfo) {
        int i = adInfo.adSplashInfo.skipType;
        return i == 0 || i == 2;
    }

    public static boolean aQ(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean aR(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String aS(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    public static boolean aT(@NonNull AdInfo adInfo) {
        return adInfo.ocpcActionType == 72 && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean aU(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    public static boolean aV(@NonNull AdInfo adInfo) {
        if (adInfo.adBaseInfo.industryFirstLevelId != 1022) {
            return false;
        }
        int i = adInfo.ocpcActionType;
        return i == 192 || i == 53;
    }

    @Nullable
    public static String aW(@NonNull AdInfo adInfo) {
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

    public static String aX(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String aY(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userName;
    }

    public static String aZ(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    public static boolean aa(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle == 1;
    }

    public static int ab(@NonNull AdInfo adInfo) {
        int[] bl = bl(adInfo);
        if (bl[0] > 0) {
            return bl[0];
        }
        return 3;
    }

    public static int ac(@NonNull AdInfo adInfo) {
        int[] bl = bl(adInfo);
        return (bl[1] > 0 ? bl[1] : 3) + ab(adInfo);
    }

    public static int ad(@NonNull AdInfo adInfo) {
        int[] bl = bl(adInfo);
        return (bl[2] > 0 ? bl[2] : 3) + ac(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b ae(@NonNull AdInfo adInfo) {
        String str;
        int bg;
        int bh;
        boolean z;
        String e = e(adInfo);
        int g = g(adInfo);
        int h = h(adInfo);
        if (at.a(e) || at.b(e) || g == 0 || h == 0) {
            String k = k(adInfo);
            str = k;
            bg = bg(adInfo);
            bh = bh(adInfo);
            z = true;
        } else {
            str = e;
            bg = g;
            bh = h;
            z = false;
        }
        com.kwad.sdk.core.d.b.a("AdInfoHelper", "frameUrl=" + str + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, bg, bh, true, z);
    }

    public static String af(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean ag(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean ah(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int ai(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    public static boolean aj(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int ak(AdInfo adInfo) {
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

    @Nullable
    public static String al(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String am(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String an(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String ao(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String ap(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long aq(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean ar(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            boolean z = (str == null || adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(str.trim())) ? false : true;
            if (as(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean as(AdInfo adInfo) {
        return ae.a() ? bn(adInfo) : bm(adInfo);
    }

    @Nullable
    public static String at(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String au(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    public static String av(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    public static boolean aw(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean ax(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean ay(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean az(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i = adFeedInfo.videoAutoPlayType;
        return i == 1 || i == 0;
    }

    public static String b(int i) {
        return "继续下载 " + i + "%";
    }

    public static String b(@NonNull AdInfo adInfo) {
        return Q(adInfo).materialUrl;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        AdInfo i = d.i(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo C = b.C(adTemplate);
        return (C != null && !C.isEmpty()) && i.adBaseInfo.campaignType == 13 && i.ocpcActionType == 2;
    }

    public static boolean ba(@NonNull AdInfo adInfo) {
        if (aV(adInfo)) {
            return false;
        }
        int i = adInfo.ocpcActionType;
        return (i == 395 || i == 192) && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean bb(@NonNull AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        return adBaseInfo.itemType == 1 && adBaseInfo.campaignType == 14;
    }

    public static String bc(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        return y.a(dVar == null ? null : dVar.a(), adInfo.adConversionInfo.deeplinkUrl);
    }

    public static AdProductInfo bd(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String be(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean bf(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardReflowSwitch;
    }

    public static int bg(@NonNull AdInfo adInfo) {
        return Q(adInfo).width;
    }

    public static int bh(@NonNull AdInfo adInfo) {
        return Q(adInfo).height;
    }

    public static int bi(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean bj(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature bk(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    @NonNull
    public static int[] bl(@NonNull AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    public static boolean bm(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 2;
    }

    public static boolean bn(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 1;
    }

    public static int c(@NonNull AdInfo adInfo) {
        return Q(adInfo).videoDuration;
    }

    public static long d(@NonNull AdInfo adInfo) {
        return c(adInfo) * 1000;
    }

    public static String e(@NonNull AdInfo adInfo) {
        int Y = Y(adInfo);
        if (Y != 1) {
            if (Y != 2 && Y != 3) {
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

    public static boolean f(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int g(@NonNull AdInfo adInfo) {
        return Q(adInfo).videoWidth;
    }

    public static int h(@NonNull AdInfo adInfo) {
        return Q(adInfo).videoHeight;
    }

    public static boolean i(@NonNull AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        return smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl);
    }

    public static boolean j(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature Q = Q(adInfo);
        return Q.videoWidth <= Q.videoHeight;
    }

    public static String k(@NonNull AdInfo adInfo) {
        int Y = Y(adInfo);
        if (Y != 1) {
            if (Y != 2 && Y != 3) {
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

    public static String l(@NonNull AdInfo adInfo) {
        int Y = Y(adInfo);
        if (Y != 1) {
            if (Y != 2 && Y != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return bk(adInfo).blurBackgroundUrl;
    }

    public static long m(@NonNull AdInfo adInfo) {
        return Q(adInfo).photoId;
    }

    public static String n(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long o(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int p(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long q(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long r(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    public static boolean s(@NonNull AdInfo adInfo) {
        return bi(adInfo) != 0;
    }

    public static long t(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long u(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static long v(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean w(@NonNull AdInfo adInfo) {
        return !I(adInfo) && x(adInfo);
    }

    public static boolean x(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.showLandingPage == 1 && !bj(adInfo);
    }

    public static boolean y(@NonNull AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.showLandingPage == 1;
    }

    public static String z(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }
}
