package com.kwad.sdk.core.response.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.an;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String A(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) ? adInfo.adConversionInfo.deeplinkUrl : (String) invokeL.objValue;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature B(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    return materialFeature;
                }
            }
            com.kwad.sdk.core.d.a.e("AdInfoHelper", "getImageMaterialFeature in null");
            return new AdInfo.AdMaterialInfo.MaterialFeature();
        }
        return (AdInfo.AdMaterialInfo.MaterialFeature) invokeL.objValue;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature C(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    return materialFeature;
                }
            }
            com.kwad.sdk.core.d.a.e("AdInfoHelper", "getVideoMaterialFeature in null");
            return new AdInfo.AdMaterialInfo.MaterialFeature();
        }
        return (AdInfo.AdMaterialInfo.MaterialFeature) invokeL.objValue;
    }

    public static String D(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) ? adInfo.adPreloadInfo.preloadId : (String) invokeL.objValue;
    }

    @NonNull
    public static List<String> E(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adInfo)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static boolean F(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, adInfo)) == null) ? H(adInfo) == 1 : invokeL.booleanValue;
    }

    public static boolean G(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, adInfo)) == null) ? B(adInfo).featureType == 2 : invokeL.booleanValue;
    }

    public static int H(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adInfo)) == null) {
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
        return invokeL.intValue;
    }

    @Nullable
    public static List<Integer> I(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adInfo)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static boolean J(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adInfo)) == null) ? adInfo.adBaseInfo.mABParams.videoBlackAreaClick != 0 : invokeL.booleanValue;
    }

    public static boolean K(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adInfo)) == null) ? adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle != 0 : invokeL.booleanValue;
    }

    public static boolean L(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adInfo)) == null) ? adInfo.adStyleInfo2.playDetailInfo.detailWebCardInfo.style == 1 : invokeL.booleanValue;
    }

    public static boolean M(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adInfo)) == null) ? adInfo.adStyleInfo2.playDetailInfo.detailCommonInfo.rewardFullClickSwitch == 1 : invokeL.booleanValue;
    }

    public static int N(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adInfo)) == null) ? adInfo.adStyleInfo2.playDetailInfo.detailCommonInfo.middleEndcardShowTime : invokeL.intValue;
    }

    public static boolean O(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adInfo)) == null) {
            return ((com.kwad.sdk.core.config.c.W() && v(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || an.a(adInfo.adConversionInfo.h5Url)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static int[] P(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adInfo)) == null) {
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
        return (int[]) invokeL.objValue;
    }

    public static int Q(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adInfo)) == null) {
            int[] P = P(adInfo);
            if (P.length >= 3 && P[0] > 0) {
                return P[0];
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static int R(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adInfo)) == null) {
            int[] P = P(adInfo);
            if (P.length < 3) {
                return 6;
            }
            return (P[1] > 0 ? P[1] : 3) + Q(adInfo);
        }
        return invokeL.intValue;
    }

    public static int S(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adInfo)) == null) {
            int[] P = P(adInfo);
            if (P.length < 3) {
                return 9;
            }
            return (P[2] > 0 ? P[2] : 3) + R(adInfo);
        }
        return invokeL.intValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c T(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String f2;
        int g2;
        int h2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adInfo)) == null) {
            String c2 = c(adInfo);
            int d2 = d(adInfo);
            int e2 = e(adInfo);
            if (an.a(c2) || an.b(c2) || d2 == 0 || e2 == 0) {
                f2 = f(adInfo);
                g2 = g(adInfo);
                h2 = h(adInfo);
                z = true;
            } else {
                f2 = c2;
                g2 = d2;
                h2 = e2;
                z = false;
            }
            com.kwad.sdk.core.d.a.a("AdInfoHelper", "frameUrl=" + f2 + " useCover=" + z + " isAd=true");
            return new com.kwad.sdk.core.response.model.c(f2, g2, h2, true, z);
        }
        return (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    public static String U(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adInfo)) == null) {
            String str = adInfo.downloadSafeInfo.webPageTipbarText;
            return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
        }
        return (String) invokeL.objValue;
    }

    public static AdInfo.DownloadSafeInfo V(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adInfo)) == null) ? adInfo.downloadSafeInfo : (AdInfo.DownloadSafeInfo) invokeL.objValue;
    }

    public static boolean W(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, adInfo)) == null) ? adInfo.downloadSafeInfo.webPageTipbarSwitch : invokeL.booleanValue;
    }

    public static int X(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, adInfo)) == null) {
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
        return invokeL.intValue;
    }

    @Nullable
    public static String Y(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.corporationName;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String Z(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.downloadSafeInfo.permissionInfo;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? CommonUtils.DIALOG_POS_TEXT : (String) invokeV.objValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i2)) == null) {
            return "下载中  " + i2 + "%";
        }
        return (String) invokeI.objValue;
    }

    public static String a(Context context, @NonNull AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, context, adInfo)) == null) {
            File j2 = com.kwad.sdk.core.config.c.j(context);
            if (j2.exists()) {
                return Uri.fromFile(j2).toString();
            }
            String g2 = com.kwad.sdk.core.config.c.g();
            return !an.a(g2) ? g2 : adInfo.downloadSafeInfo.windowPopUrl;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Context context, AdTemplate adTemplate, AdInfo adInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65565, null, context, adTemplate, adInfo)) == null) {
            boolean b2 = b(context, adTemplate, adInfo);
            File i2 = com.kwad.sdk.core.config.c.i(context);
            return (b2 && i2.exists()) ? Uri.fromFile(i2).toString() : b2 ? com.kwad.sdk.core.config.c.f() : adInfo.adConversionInfo.h5Url;
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, adInfo)) == null) ? C(adInfo).materialUrl : (String) invokeL.objValue;
    }

    public static String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, adTemplate)) == null) {
            if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2) {
                if (adTemplate == null) {
                    return "立即安装";
                }
                AdInfo i2 = c.i(adTemplate);
                return TextUtils.isEmpty(i2.adBaseInfo.installAppLabel) ? "立即安装" : i2.adBaseInfo.installAppLabel;
            }
            return "安装获取奖励";
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(AdInfo adInfo, Context context) {
        InterceptResult invokeLL;
        AdInfo.AdConversionInfo adConversionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, adInfo, context)) == null) {
            if (adInfo == null || context == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
                return false;
            }
            String str = adConversionInfo.playableUrl;
            return b(adInfo, context) && (str != null && adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(str.trim()));
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static String aa(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.downloadSafeInfo.appPrivacyUrl;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String ab(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.appVersion;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long ac(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.packageSize;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    @Nullable
    public static String ad(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
                return null;
            }
            return adConversionInfo.playableUrl;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String ae(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
                return null;
            }
            return adConversionInfo.callbackUrl;
        }
        return (String) invokeL.objValue;
    }

    public static boolean af(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, adInfo)) == null) ? (TextUtils.isEmpty(y(adInfo)) || v(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true : invokeL.booleanValue;
    }

    @NonNull
    public static String ag(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, adInfo)) == null) {
            String o = v(adInfo) ? o(adInfo) : p(adInfo);
            if (TextUtils.isEmpty(o)) {
                o = adInfo.advertiserInfo.rawUserName;
            }
            return TextUtils.isEmpty(o) ? "可爱的广告君" : o;
        }
        return (String) invokeL.objValue;
    }

    public static String ah(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, adInfo)) == null) {
            if (v(adInfo)) {
                String n = n(adInfo);
                if (!an.a(n)) {
                    return n;
                }
            }
            return adInfo.advertiserInfo.portraitUrl;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static String ai(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, null, adInfo)) == null) ? (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips : (String) invokeL.objValue;
    }

    public static boolean aj(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdSplashInfo adSplashInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, adInfo)) == null) ? (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true : invokeL.booleanValue;
    }

    public static boolean ak(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, adInfo)) == null) {
            if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
                return false;
            }
            return downloadSafeInfo.downloadPauseEnable;
        }
        return invokeL.booleanValue;
    }

    public static boolean al(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
                return false;
            }
            int i2 = playableStyleInfo.playableOrientation;
            return i2 == 0 || i2 == 2;
        }
        return invokeL.booleanValue;
    }

    public static boolean am(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
                return false;
            }
            int i2 = playableStyleInfo.playableOrientation;
            return i2 == 0 || i2 == 1;
        }
        return invokeL.booleanValue;
    }

    public static int b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, null, adInfo)) == null) ? C(adInfo).videoDuration : invokeL.intValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65583, null, i2)) == null) {
            return "继续下载 " + i2 + "%";
        }
        return (String) invokeI.objValue;
    }

    public static boolean b(Context context, AdTemplate adTemplate, AdInfo adInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65584, null, context, adTemplate, adInfo)) == null) {
            if (adTemplate == null || adInfo == null || adTemplate.mAdScene == null || !ab.e(context) || com.kwad.sdk.core.config.c.W()) {
                return false;
            }
            int adStyle = adTemplate.mAdScene.getAdStyle();
            return (adStyle == 1 || adStyle == 3 || adStyle == 2) && adInfo.adBaseInfo.adAttributeType == 1 && v(adInfo) && com.kwad.sdk.core.config.c.h();
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(AdInfo adInfo, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65585, null, adInfo, context)) == null) ? ab.e(context) ? am(adInfo) : al(adInfo) : invokeLL.booleanValue;
    }

    public static String c(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, adInfo)) == null) {
            int H = H(adInfo);
            if (H != 1) {
                if (H != 2 && H != 3) {
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
        return (String) invokeL.objValue;
    }

    public static int d(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, adInfo)) == null) ? C(adInfo).videoWidth : invokeL.intValue;
    }

    public static int e(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65588, null, adInfo)) == null) ? C(adInfo).videoHeight : invokeL.intValue;
    }

    public static String f(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, adInfo)) == null) {
            int H = H(adInfo);
            if (H != 1) {
                if (H != 2 && H != 3) {
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
        return (String) invokeL.objValue;
    }

    public static int g(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65590, null, adInfo)) == null) ? C(adInfo).width : invokeL.intValue;
    }

    public static int h(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65591, null, adInfo)) == null) ? C(adInfo).height : invokeL.intValue;
    }

    public static long i(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, adInfo)) == null) ? C(adInfo).photoId : invokeL.longValue;
    }

    public static String j(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65593, null, adInfo)) == null) ? (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel : (String) invokeL.objValue;
    }

    public static boolean k(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, adInfo)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_SKIP_FIVE_SECOND");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : adInfo.adBaseInfo.enableSkipAd == 1;
        }
        return invokeL.booleanValue;
    }

    public static long l(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65595, null, adInfo)) == null) ? adInfo.adBaseInfo.skipSecond * 1000 : invokeL.longValue;
    }

    public static String m(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65596, null, adInfo)) == null) ? adInfo.adBaseInfo.adDescription : (String) invokeL.objValue;
    }

    public static String n(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65597, null, adInfo)) == null) ? adInfo.adBaseInfo.appIconUrl : (String) invokeL.objValue;
    }

    public static String o(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65598, null, adInfo)) == null) ? adInfo.adBaseInfo.appName : (String) invokeL.objValue;
    }

    public static String p(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65599, null, adInfo)) == null) ? adInfo.adBaseInfo.productName : (String) invokeL.objValue;
    }

    public static String q(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdBaseInfo adBaseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, adInfo)) == null) {
            if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
                return null;
            }
            return adBaseInfo.appPackageName;
        }
        return (String) invokeL.objValue;
    }

    public static String r(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65601, null, adInfo)) == null) ? adInfo.adBaseInfo.appDownloadCountDesc : (String) invokeL.objValue;
    }

    public static float s(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, adInfo)) == null) {
            int i2 = adInfo.adBaseInfo.appScore;
            if (i2 <= 0) {
                return 0.0f;
            }
            return i2 / 10.0f;
        }
        return invokeL.floatValue;
    }

    public static String t(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65603, null, adInfo)) == null) ? an.a(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription : (String) invokeL.objValue;
    }

    public static String u(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, adInfo)) == null) {
            String str = adInfo.adBaseInfo.adActionDescription;
            if (TextUtils.isEmpty(str)) {
                return v(adInfo) ? "立即下载" : "查看详情";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean v(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65605, null, adInfo)) == null) ? w(adInfo) == 1 : invokeL.booleanValue;
    }

    public static int w(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, adInfo)) == null) {
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
        return invokeL.intValue;
    }

    public static int x(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65607, null, adInfo)) == null) ? adInfo.adBaseInfo.ecpm : invokeL.intValue;
    }

    public static String y(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65608, null, adInfo)) == null) ? adInfo.adConversionInfo.h5Url : (String) invokeL.objValue;
    }

    public static int z(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65609, null, adInfo)) == null) ? adInfo.adConversionInfo.h5Type : invokeL.intValue;
    }
}
