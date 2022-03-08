package com.kwad.sdk.core.response.a;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.z;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static String A(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return B(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean B(@NonNull AdInfo adInfo) {
        return E(adInfo) == 1;
    }

    public static boolean C(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adAttributeType == 1;
    }

    public static boolean D(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && B(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int E(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adBaseInfo.adOperationType;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                return 0;
            }
        }
        return i3;
    }

    public static int F(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String G(@NonNull AdInfo adInfo) {
        return z.a(adInfo.adConversionInfo.h5Url);
    }

    public static int H(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature I(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.a.e("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature J(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.a.e("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean K(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature J = P(adInfo) ? J(adInfo) : I(adInfo);
        return J.height > J.width;
    }

    public static float L(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature J = P(adInfo) ? J(adInfo) : I(adInfo);
        if (J == null || J.width == 0) {
            return -1.0f;
        }
        com.kwad.sdk.core.d.a.a("AdInfoHelper", "getMaterialRatio: height: " + J.height + ", width: " + J.width);
        return J.height / J.width;
    }

    public static boolean M(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature J = J(adInfo);
        return J.height > J.width;
    }

    public static String N(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> O(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int R = R(adInfo);
        if (R == 2 || R == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        return R(adInfo) == 1;
    }

    public static boolean Q(@NonNull AdInfo adInfo) {
        return I(adInfo).featureType == 2;
    }

    public static int R(AdInfo adInfo) {
        int i2 = adInfo.adMaterialInfo.materialType;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    return 0;
                }
            }
        }
        return i3;
    }

    @Nullable
    public static List<Integer> S(@NonNull AdInfo adInfo) {
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
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public static boolean T(@NonNull AdInfo adInfo) {
        if (adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle == 0) {
            return false;
        }
        boolean a = af.a();
        boolean g2 = g(adInfo);
        return a ? !g2 : g2;
    }

    public static boolean U(@NonNull AdInfo adInfo) {
        return adInfo.adStyleInfo2.playDetailInfo.detailWebCardInfo.style == 1;
    }

    public static boolean V(@NonNull AdInfo adInfo) {
        return ((com.kwad.sdk.core.config.b.aa() && B(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || at.a(G(adInfo))) ? false : true;
    }

    @NonNull
    public static int[] W(@NonNull AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    public static int X(@NonNull AdInfo adInfo) {
        int[] W = W(adInfo);
        if (W.length >= 3 && W[0] > 0) {
            return W[0];
        }
        return 3;
    }

    public static int Y(@NonNull AdInfo adInfo) {
        int[] W = W(adInfo);
        if (W.length < 3) {
            return 6;
        }
        return (W[1] > 0 ? W[1] : 3) + X(adInfo);
    }

    public static int Z(@NonNull AdInfo adInfo) {
        int[] W = W(adInfo);
        if (W.length < 3) {
            return 9;
        }
        return (W[2] > 0 ? W[2] : 3) + Y(adInfo);
    }

    @Nullable
    public static SpannableString a(AdInfo adInfo, @ColorInt int i2) {
        String format;
        int indexOf;
        String aB = aB(adInfo);
        if (aB == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", aB)).indexOf(aB)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i2), indexOf, aB.length() + indexOf, 18);
        return spannableString;
    }

    public static String a() {
        return "继续下载";
    }

    @Deprecated
    public static String a(int i2) {
        return a(i2, "下载中  %s%%");
    }

    public static String a(int i2, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i2));
    }

    public static String a(Context context, @NonNull AdInfo adInfo) {
        File f2 = com.kwad.sdk.core.config.b.f(context);
        if (f2.exists()) {
            return Uri.fromFile(f2).toString();
        }
        String d2 = com.kwad.sdk.core.config.b.d();
        return !at.a(d2) ? d2 : adInfo.downloadSafeInfo.windowPopUrl;
    }

    public static String a(@NonNull AdInfo adInfo) {
        return J(adInfo).materialUrl;
    }

    public static String a(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2) {
            if (adTemplate == null) {
                return "立即安装";
            }
            AdInfo j2 = d.j(adTemplate);
            return TextUtils.isEmpty(j2.adBaseInfo.installAppLabel) ? "立即安装" : j2.adBaseInfo.installAppLabel;
        }
        return "安装获取奖励";
    }

    public static boolean aA(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Nullable
    public static String aB(@NonNull AdInfo adInfo) {
        int i2 = adInfo.advertiserInfo.fansCount;
        if (i2 < 200 || i2 >= 10000) {
            if (i2 >= 10000) {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                return decimalFormat.format(i2 / 10000.0d) + "w";
            }
            return null;
        }
        return String.valueOf(i2);
    }

    public static String aC(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String aD(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userName;
    }

    public static String aE(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    public static boolean aF(@NonNull AdInfo adInfo) {
        return adInfo.ocpcActionType == 395 && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean aG(AdInfo adInfo) {
        return aH(adInfo) || aI(adInfo);
    }

    public static boolean aH(AdInfo adInfo) {
        return az(adInfo) && com.kwad.sdk.core.config.b.aH() != 0;
    }

    public static boolean aI(AdInfo adInfo) {
        return aF(adInfo) && com.kwad.sdk.core.config.b.aI();
    }

    public static String aJ(@NonNull AdInfo adInfo) {
        return z.a(adInfo.adConversionInfo.deeplinkUrl);
    }

    public static AdProductInfo aK(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String aL(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aM(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean aN(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 2;
    }

    public static boolean aO(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 1;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c aa(@NonNull AdInfo adInfo) {
        String str;
        int j2;
        int k;
        boolean z;
        String c2 = c(adInfo);
        int e2 = e(adInfo);
        int f2 = f(adInfo);
        if (at.a(c2) || at.b(c2) || e2 == 0 || f2 == 0) {
            String h2 = h(adInfo);
            str = h2;
            j2 = j(adInfo);
            k = k(adInfo);
            z = true;
        } else {
            str = c2;
            j2 = e2;
            k = f2;
            z = false;
        }
        com.kwad.sdk.core.d.a.a("AdInfoHelper", "frameUrl=" + str + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.c(str, j2, k, true, z);
    }

    public static String ab(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static AdInfo.DownloadSafeInfo ac(AdInfo adInfo) {
        return adInfo.downloadSafeInfo;
    }

    public static boolean ad(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean ae(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static boolean af(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int ag(AdInfo adInfo) {
        if (adInfo != null) {
            int i2 = adInfo.status;
            if (i2 == 0) {
                return 1;
            }
            if (1 == i2 || 2 == i2 || 3 == i2 || 4 == i2) {
                return 2;
            }
            return 8 == i2 ? 3 : 0;
        }
        return 0;
    }

    @Nullable
    public static String ah(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String ai(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String aj(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String ak(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String al(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long am(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean an(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return false;
        }
        String str = adConversionInfo.playableUrl;
        return ao(adInfo) && (str != null && adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(str.trim()));
    }

    public static boolean ao(AdInfo adInfo) {
        return af.a() ? aO(adInfo) : aN(adInfo);
    }

    @Nullable
    public static String ap(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String aq(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    public static String ar(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    public static boolean as(AdInfo adInfo) {
        return (TextUtils.isEmpty(G(adInfo)) || B(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true;
    }

    @NonNull
    public static String at(@NonNull AdInfo adInfo) {
        String t = B(adInfo) ? t(adInfo) : u(adInfo);
        if (TextUtils.isEmpty(t)) {
            t = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(t) ? "可爱的广告君" : t;
    }

    public static String au(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return TextUtils.isEmpty(str) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    @NonNull
    public static String av(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static boolean aw(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean ax(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String ay(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    public static boolean az(@NonNull AdInfo adInfo) {
        return adInfo.ocpcActionType == 72 && adInfo.adBaseInfo.campaignType == 13;
    }

    public static int b(@NonNull AdInfo adInfo) {
        return J(adInfo).videoDuration;
    }

    public static String b(int i2) {
        return "继续下载 " + i2 + "%";
    }

    public static String c(@NonNull AdInfo adInfo) {
        int R = R(adInfo);
        if (R != 1) {
            if (R != 2 && R != 3) {
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

    public static boolean d(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int e(@NonNull AdInfo adInfo) {
        return J(adInfo).videoWidth;
    }

    public static int f(@NonNull AdInfo adInfo) {
        return J(adInfo).videoHeight;
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature J = J(adInfo);
        return J.videoWidth <= J.videoHeight;
    }

    public static String h(@NonNull AdInfo adInfo) {
        int R = R(adInfo);
        if (R != 1) {
            if (R != 2 && R != 3) {
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

    public static String i(@NonNull AdInfo adInfo) {
        int R = R(adInfo);
        if (R != 1) {
            if (R != 2 && R != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aM(adInfo).blurBackgroundUrl;
    }

    public static int j(@NonNull AdInfo adInfo) {
        return J(adInfo).width;
    }

    public static int k(@NonNull AdInfo adInfo) {
        return J(adInfo).height;
    }

    public static long l(@NonNull AdInfo adInfo) {
        return J(adInfo).photoId;
    }

    public static String m(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long n(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static long o(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long p(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    public static boolean q(@NonNull AdInfo adInfo) {
        return !B(adInfo) && r(adInfo);
    }

    public static boolean r(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.showLandingPage == 1;
    }

    public static String s(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String t(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String u(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String v(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String w(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float x(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adBaseInfo.appScore;
        if (i2 <= 0) {
            return 0.0f;
        }
        return i2 / 10.0f;
    }

    public static float y(@NonNull AdInfo adInfo) {
        float f2 = adInfo.adBaseInfo.appScore;
        if (f2 < 30.0f) {
            return 3.0f;
        }
        if (f2 < 35.0f) {
            return 3.5f;
        }
        if (f2 < 40.0f) {
            return 4.0f;
        }
        return f2 < 45.0f ? 4.5f : 5.0f;
    }

    public static String z(AdInfo adInfo) {
        return at.a(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }
}
