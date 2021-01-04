package com.kwad.sdk.core.response.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static int A(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String B(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Url;
    }

    public static String C(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.deeplinkUrl;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature D(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.a.d("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature E(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.a.d("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static long F(@NonNull AdInfo adInfo) {
        return ah(adInfo).likeCount;
    }

    public static long G(@NonNull AdInfo adInfo) {
        return ah(adInfo).commentCount;
    }

    public static String H(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> I(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        switch (L(adInfo)) {
            case 2:
            case 3:
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                    if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                        arrayList.add(materialFeature.materialUrl);
                    }
                }
                return arrayList;
            default:
                return arrayList;
        }
    }

    public static boolean J(@NonNull AdInfo adInfo) {
        return L(adInfo) == 1;
    }

    public static boolean K(@NonNull AdInfo adInfo) {
        return D(adInfo).featureType == 2;
    }

    public static int L(AdInfo adInfo) {
        switch (adInfo.adMaterialInfo.materialType) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }
    }

    @Nullable
    public static List<Integer> M(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                for (String str2 : split) {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt > 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public static boolean N(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.mABParams.videoBlackAreaClick != 0;
    }

    public static boolean O(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle != 0;
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        return (adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || ag.a(adInfo.adConversionInfo.h5Url)) ? false : true;
    }

    @NonNull
    public static int[] Q(@NonNull AdInfo adInfo) {
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split.length >= 3) {
                    iArr[0] = Integer.parseInt(split[0]);
                    iArr[1] = Integer.parseInt(split[1]);
                    iArr[2] = Integer.parseInt(split[2]);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
        return iArr;
    }

    public static int R(@NonNull AdInfo adInfo) {
        int[] Q = Q(adInfo);
        if (Q.length >= 3 && Q[0] > 0) {
            return Q[0];
        }
        return 3;
    }

    public static int S(@NonNull AdInfo adInfo) {
        int[] Q = Q(adInfo);
        if (Q.length < 3) {
            return 6;
        }
        return (Q[1] > 0 ? Q[1] : 3) + R(adInfo);
    }

    public static int T(@NonNull AdInfo adInfo) {
        int[] Q = Q(adInfo);
        if (Q.length < 3) {
            return 9;
        }
        return (Q[2] > 0 ? Q[2] : 3) + S(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c U(@NonNull AdInfo adInfo) {
        boolean z;
        String c = c(adInfo);
        int d = d(adInfo);
        int e = e(adInfo);
        if (ag.a(c) || ag.b(c) || d == 0 || e == 0) {
            c = f(adInfo);
            d = i(adInfo);
            e = j(adInfo);
            z = true;
        } else {
            z = false;
        }
        com.kwad.sdk.core.d.a.a("AdInfoHelper", "frameUrl=" + c + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.c(c, d, e, true, z);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c V(@NonNull AdInfo adInfo) {
        boolean z;
        String f = f(adInfo);
        int i = i(adInfo);
        int j = j(adInfo);
        if (ag.a(f) || i == 0 || j == 0) {
            f = c(adInfo);
            i = d(adInfo);
            j = e(adInfo);
            z = false;
        } else {
            z = true;
        }
        return new com.kwad.sdk.core.response.model.c(f, i, j, true, z);
    }

    public static com.kwad.sdk.core.response.model.c W(@NonNull AdInfo adInfo) {
        String c;
        boolean z;
        String h = h(adInfo);
        if (ag.a(h)) {
            h = f(adInfo);
        }
        int i = i(adInfo);
        int j = j(adInfo);
        if (ag.a(h) || i == 0 || j == 0) {
            c = c(adInfo);
            i = d(adInfo);
            j = e(adInfo);
            z = false;
        } else {
            z = true;
            c = h;
        }
        return new com.kwad.sdk.core.response.model.c(c, i, j, true, z);
    }

    public static String X(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.adActionBarColor;
        return (ag.a(str) || !str.matches("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6}|[0-9a-fA-F]{3})$")) ? "#FFE4A704" : str;
    }

    public static String Y(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static AdInfo.DownloadSafeInfo Z(AdInfo adInfo) {
        return adInfo.downloadSafeInfo;
    }

    public static String a() {
        return "继续下载";
    }

    @SuppressLint({"DefaultLocale"})
    private static String a(float f) {
        return String.format("%.1fM", Float.valueOf((f / 1000.0f) / 1000.0f));
    }

    public static String a(int i) {
        return "下载中  " + i + "%";
    }

    public static String a(@NonNull AdInfo adInfo) {
        return E(adInfo).materialUrl;
    }

    public static String a(@NonNull AdInfo adInfo, int i) {
        return "下载中..." + i + "%  (" + a(((float) adInfo.totalBytes) * (i / 100.0f)) + "/" + a((float) adInfo.totalBytes) + ")";
    }

    public static String a(AdTemplate adTemplate) {
        return (adTemplate == null || adTemplate.mAdScene == null || adTemplate.mAdScene.getAdStyle() != 2) ? "立即安装" : "安装获取奖励";
    }

    public static boolean aa(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int ab(AdInfo adInfo) {
        if (adInfo != null) {
            DOWNLOADSTAUS downloadstaus = adInfo.status;
            if (DOWNLOADSTAUS.UNKNOWN == downloadstaus) {
                return 1;
            }
            if (DOWNLOADSTAUS.START == downloadstaus || DOWNLOADSTAUS.DOWNLOADING == downloadstaus || DOWNLOADSTAUS.PROGRESS == downloadstaus || DOWNLOADSTAUS.PAUSED == downloadstaus) {
                return 2;
            }
            return DOWNLOADSTAUS.FINISHED == downloadstaus ? 3 : 0;
        }
        return 0;
    }

    @Nullable
    public static String ac(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String ad(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String ae(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String af(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long ag(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    @NonNull
    private static AdInfo.AdMaterialInfo.MaterialFeature ah(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static int b(@NonNull AdInfo adInfo) {
        return E(adInfo).videoDuration;
    }

    public static String b() {
        return "立即打开";
    }

    public static String b(int i) {
        return "下载中..." + i + "%";
    }

    public static String b(@NonNull AdInfo adInfo, int i) {
        return "继续下载 " + i + "%  (" + a(((float) adInfo.totalBytes) * (i / 100.0f)) + "/" + a((float) adInfo.totalBytes) + ")";
    }

    public static String c(int i) {
        return "继续下载 " + i + "%";
    }

    public static String c(@NonNull AdInfo adInfo) {
        return E(adInfo).firstFrame;
    }

    public static int d(@NonNull AdInfo adInfo) {
        return E(adInfo).videoWidth;
    }

    public static int e(@NonNull AdInfo adInfo) {
        return E(adInfo).videoHeight;
    }

    public static String f(@NonNull AdInfo adInfo) {
        return E(adInfo).coverUrl;
    }

    public static String g(@NonNull AdInfo adInfo) {
        return E(adInfo).blurBackgroundUrl;
    }

    public static String h(@NonNull AdInfo adInfo) {
        return E(adInfo).webpCoverUrl;
    }

    public static int i(@NonNull AdInfo adInfo) {
        return E(adInfo).width;
    }

    public static int j(@NonNull AdInfo adInfo) {
        return E(adInfo).height;
    }

    public static long k(@NonNull AdInfo adInfo) {
        return E(adInfo).photoId;
    }

    public static boolean l(@NonNull AdInfo adInfo) {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_SKIP_FIVE_SECOND");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : adInfo.adBaseInfo.enableSkipAd == 1;
    }

    public static long m(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.skipSecond * 1000;
    }

    public static String n(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String o(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appIconUrl;
    }

    public static String p(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.authorIconGuide;
    }

    public static String q(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String r(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String s(AdInfo adInfo) {
        return adInfo.adBaseInfo.appPackageName;
    }

    public static String t(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float u(@NonNull AdInfo adInfo) {
        if (adInfo.adBaseInfo.appScore <= 0) {
            return 0.0f;
        }
        return adInfo.adBaseInfo.appScore / 10.0f;
    }

    public static String v(AdInfo adInfo) {
        return ag.a(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String w(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.adActionDescription;
        return TextUtils.isEmpty(str) ? y(adInfo) ? "立即下载" : "查看详情" : str;
    }

    public static String x(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.adActionDescription;
        return TextUtils.isEmpty(str) ? y(adInfo) ? "点我试玩" : "查看详情" : str;
    }

    public static boolean y(@NonNull AdInfo adInfo) {
        return z(adInfo) == 1;
    }

    public static int z(@NonNull AdInfo adInfo) {
        switch (adInfo.adBaseInfo.adOperationType) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }
}
