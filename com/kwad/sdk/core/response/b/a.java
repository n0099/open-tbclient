package com.kwad.sdk.core.response.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.CommonUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static String A(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.deeplinkUrl;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature B(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.a.e("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature C(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.a.e("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static String D(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> E(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int H = H(adInfo);
        if (H == 2 || H == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static boolean F(@NonNull AdInfo adInfo) {
        return H(adInfo) == 1;
    }

    public static boolean G(@NonNull AdInfo adInfo) {
        return B(adInfo).featureType == 2;
    }

    public static int H(AdInfo adInfo) {
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
    public static List<Integer> I(@NonNull AdInfo adInfo) {
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

    public static boolean J(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.mABParams.videoBlackAreaClick != 0;
    }

    public static boolean K(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle != 0;
    }

    public static boolean L(@NonNull AdInfo adInfo) {
        return ((com.kwad.sdk.core.config.c.Q() && v(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || ag.a(adInfo.adConversionInfo.h5Url)) ? false : true;
    }

    @NonNull
    public static int[] M(@NonNull AdInfo adInfo) {
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

    public static int N(@NonNull AdInfo adInfo) {
        int[] M = M(adInfo);
        if (M.length >= 3 && M[0] > 0) {
            return M[0];
        }
        return 3;
    }

    public static int O(@NonNull AdInfo adInfo) {
        int[] M = M(adInfo);
        if (M.length < 3) {
            return 6;
        }
        return (M[1] > 0 ? M[1] : 3) + N(adInfo);
    }

    public static int P(@NonNull AdInfo adInfo) {
        int[] M = M(adInfo);
        if (M.length < 3) {
            return 9;
        }
        return (M[2] > 0 ? M[2] : 3) + O(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c Q(@NonNull AdInfo adInfo) {
        String str;
        int g2;
        int h2;
        boolean z;
        String c2 = c(adInfo);
        int d2 = d(adInfo);
        int e2 = e(adInfo);
        if (ag.a(c2) || ag.b(c2) || d2 == 0 || e2 == 0) {
            String f2 = f(adInfo);
            str = f2;
            g2 = g(adInfo);
            h2 = h(adInfo);
            z = true;
        } else {
            str = c2;
            g2 = d2;
            h2 = e2;
            z = false;
        }
        com.kwad.sdk.core.d.a.a("AdInfoHelper", "frameUrl=" + str + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.c(str, g2, h2, true, z);
    }

    public static String R(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static AdInfo.DownloadSafeInfo S(AdInfo adInfo) {
        return adInfo.downloadSafeInfo;
    }

    public static boolean T(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int U(AdInfo adInfo) {
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
    public static String V(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String W(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String X(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String Y(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long Z(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static String a() {
        return CommonUtils.DIALOG_POS_TEXT;
    }

    public static String a(int i2) {
        return "下载中  " + i2 + "%";
    }

    public static String a(@NonNull AdInfo adInfo) {
        return C(adInfo).materialUrl;
    }

    public static String a(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2) {
            if (adTemplate == null) {
                return "立即安装";
            }
            AdInfo g2 = c.g(adTemplate);
            return TextUtils.isEmpty(g2.adBaseInfo.installAppLabel) ? "立即安装" : g2.adBaseInfo.installAppLabel;
        }
        return "安装获取奖励";
    }

    public static boolean a(AdInfo adInfo, Context context) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || context == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return false;
        }
        String str = adConversionInfo.playableUrl;
        return b(adInfo, context) && (str != null && adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(str.trim()));
    }

    @Nullable
    public static String aa(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String ab(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    public static boolean ac(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 2;
    }

    public static boolean ad(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 1;
    }

    public static int b(@NonNull AdInfo adInfo) {
        return C(adInfo).videoDuration;
    }

    public static String b(int i2) {
        return "继续下载 " + i2 + "%";
    }

    public static boolean b(AdInfo adInfo, Context context) {
        return v.e(context) ? ad(adInfo) : ac(adInfo);
    }

    public static String c(@NonNull AdInfo adInfo) {
        return C(adInfo).firstFrame;
    }

    public static int d(@NonNull AdInfo adInfo) {
        return C(adInfo).videoWidth;
    }

    public static int e(@NonNull AdInfo adInfo) {
        return C(adInfo).videoHeight;
    }

    public static String f(@NonNull AdInfo adInfo) {
        return C(adInfo).coverUrl;
    }

    public static int g(@NonNull AdInfo adInfo) {
        return C(adInfo).width;
    }

    public static int h(@NonNull AdInfo adInfo) {
        return C(adInfo).height;
    }

    public static long i(@NonNull AdInfo adInfo) {
        return C(adInfo).photoId;
    }

    public static String j(AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static boolean k(@NonNull AdInfo adInfo) {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_SKIP_FIVE_SECOND");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : adInfo.adBaseInfo.enableSkipAd == 1;
    }

    public static long l(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.skipSecond * 1000;
    }

    public static String m(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String n(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appIconUrl;
    }

    public static String o(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String p(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String q(AdInfo adInfo) {
        return adInfo.adBaseInfo.appPackageName;
    }

    public static String r(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float s(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adBaseInfo.appScore;
        if (i2 <= 0) {
            return 0.0f;
        }
        return i2 / 10.0f;
    }

    public static String t(AdInfo adInfo) {
        return ag.a(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String u(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return v(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean v(@NonNull AdInfo adInfo) {
        return w(adInfo) == 1;
    }

    public static int w(@NonNull AdInfo adInfo) {
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

    public static int x(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String y(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Url;
    }

    public static int z(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }
}
