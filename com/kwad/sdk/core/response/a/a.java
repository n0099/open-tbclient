package com.kwad.sdk.core.response.a;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String A(@Nullable AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            if (adInfo == null) {
                return "立即下载";
            }
            String str = adInfo.adBaseInfo.adActionDescription;
            if (TextUtils.isEmpty(str)) {
                return B(adInfo) ? "立即下载" : "查看详情";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean B(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) ? E(adInfo) == 1 : invokeL.booleanValue;
    }

    public static boolean C(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) ? adInfo.adBaseInfo.adAttributeType == 1 : invokeL.booleanValue;
    }

    public static boolean D(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) ? adInfo.downloadSafeInfo.complianceInfo != null && B(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1 : invokeL.booleanValue;
    }

    public static int E(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adInfo)) == null) {
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

    public static int F(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adInfo)) == null) ? adInfo.adBaseInfo.ecpm : invokeL.intValue;
    }

    public static String G(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adInfo)) == null) ? z.a(adInfo.adConversionInfo.h5Url) : (String) invokeL.objValue;
    }

    public static int H(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adInfo)) == null) ? adInfo.adConversionInfo.h5Type : invokeL.intValue;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature I(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adInfo)) == null) {
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
    public static AdInfo.AdMaterialInfo.MaterialFeature J(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adInfo)) == null) {
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

    public static boolean K(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adInfo)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature J = P(adInfo) ? J(adInfo) : I(adInfo);
            return J.height > J.width;
        }
        return invokeL.booleanValue;
    }

    public static float L(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adInfo)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature J = P(adInfo) ? J(adInfo) : I(adInfo);
            if (J == null || J.width == 0) {
                return -1.0f;
            }
            com.kwad.sdk.core.d.a.a("AdInfoHelper", "getMaterialRatio: height: " + J.height + ", width: " + J.width);
            return J.height / J.width;
        }
        return invokeL.floatValue;
    }

    public static boolean M(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adInfo)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature J = J(adInfo);
            return J.height > J.width;
        }
        return invokeL.booleanValue;
    }

    public static String N(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adInfo)) == null) ? adInfo.adPreloadInfo.preloadId : (String) invokeL.objValue;
    }

    @NonNull
    public static List<String> O(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adInfo)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adInfo)) == null) ? R(adInfo) == 1 : invokeL.booleanValue;
    }

    public static boolean Q(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adInfo)) == null) ? I(adInfo).featureType == 2 : invokeL.booleanValue;
    }

    public static int R(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adInfo)) == null) {
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
    public static List<Integer> S(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adInfo)) == null) {
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

    public static boolean T(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adInfo)) == null) {
            if (adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle == 0) {
                return false;
            }
            boolean a = af.a();
            boolean g2 = g(adInfo);
            return a ? !g2 : g2;
        }
        return invokeL.booleanValue;
    }

    public static boolean U(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adInfo)) == null) ? adInfo.adStyleInfo2.playDetailInfo.detailWebCardInfo.style == 1 : invokeL.booleanValue;
    }

    public static boolean V(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adInfo)) == null) {
            return ((com.kwad.sdk.core.config.b.aa() && B(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || at.a(G(adInfo))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static int[] W(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, adInfo)) == null) {
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

    public static int X(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, adInfo)) == null) {
            int[] W = W(adInfo);
            if (W.length >= 3 && W[0] > 0) {
                return W[0];
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static int Y(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, adInfo)) == null) {
            int[] W = W(adInfo);
            if (W.length < 3) {
                return 6;
            }
            return (W[1] > 0 ? W[1] : 3) + X(adInfo);
        }
        return invokeL.intValue;
    }

    public static int Z(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, adInfo)) == null) {
            int[] W = W(adInfo);
            if (W.length < 3) {
                return 9;
            }
            return (W[2] > 0 ? W[2] : 3) + Y(adInfo);
        }
        return invokeL.intValue;
    }

    @Nullable
    public static SpannableString a(AdInfo adInfo, @ColorInt int i2) {
        InterceptResult invokeLI;
        String format;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65562, null, adInfo, i2)) == null) {
            String aB = aB(adInfo);
            if (aB == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", aB)).indexOf(aB)) < 0) {
                return null;
            }
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new ForegroundColorSpan(i2), indexOf, aB.length() + indexOf, 18);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? "继续下载" : (String) invokeV.objValue;
    }

    @Deprecated
    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) ? a(i2, "下载中  %s%%") : (String) invokeI.objValue;
    }

    public static String a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65565, null, i2, str)) == null) {
            if (str == null) {
                str = "下载中  %s%%";
            }
            return String.format(str, Integer.valueOf(i2));
        }
        return (String) invokeIL.objValue;
    }

    public static String a(Context context, @NonNull AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, context, adInfo)) == null) {
            File f2 = com.kwad.sdk.core.config.b.f(context);
            if (f2.exists()) {
                return Uri.fromFile(f2).toString();
            }
            String d2 = com.kwad.sdk.core.config.b.d();
            return !at.a(d2) ? d2 : adInfo.downloadSafeInfo.windowPopUrl;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, adInfo)) == null) ? J(adInfo).materialUrl : (String) invokeL.objValue;
    }

    public static String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, adTemplate)) == null) {
            if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2) {
                if (adTemplate == null) {
                    return "立即安装";
                }
                AdInfo j2 = d.j(adTemplate);
                return TextUtils.isEmpty(j2.adBaseInfo.installAppLabel) ? "立即安装" : j2.adBaseInfo.installAppLabel;
            }
            return "安装获取奖励";
        }
        return (String) invokeL.objValue;
    }

    public static boolean aA(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, adInfo)) == null) ? adInfo.advertiserInfo.followed : invokeL.booleanValue;
    }

    @Nullable
    public static String aB(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, adInfo)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String aC(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, adInfo)) == null) ? adInfo.advertiserInfo.brief : (String) invokeL.objValue;
    }

    public static String aD(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, null, adInfo)) == null) ? adInfo.advertiserInfo.userName : (String) invokeL.objValue;
    }

    public static String aE(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, adInfo)) == null) ? adInfo.advertiserInfo.portraitUrl : (String) invokeL.objValue;
    }

    public static boolean aF(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, adInfo)) == null) ? adInfo.ocpcActionType == 395 && adInfo.adBaseInfo.campaignType == 13 : invokeL.booleanValue;
    }

    public static boolean aG(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, adInfo)) == null) ? aH(adInfo) || aI(adInfo) : invokeL.booleanValue;
    }

    public static boolean aH(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, adInfo)) == null) {
            return az(adInfo) && com.kwad.sdk.core.config.b.aH() != 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean aI(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, null, adInfo)) == null) ? aF(adInfo) && com.kwad.sdk.core.config.b.aI() : invokeL.booleanValue;
    }

    public static String aJ(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, adInfo)) == null) ? z.a(adInfo.adConversionInfo.deeplinkUrl) : (String) invokeL.objValue;
    }

    public static AdProductInfo aK(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, null, adInfo)) == null) ? adInfo.adProductInfo : (AdProductInfo) invokeL.objValue;
    }

    public static String aL(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65580, null, adInfo)) == null) ? adInfo.adConversionInfo.marketUrl : (String) invokeL.objValue;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aM(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, adInfo)) == null) {
            List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
            AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
            return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
        }
        return (AdInfo.AdMaterialInfo.MaterialFeature) invokeL.objValue;
    }

    public static boolean aN(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
                return false;
            }
            int i2 = playableStyleInfo.playableOrientation;
            return i2 == 0 || i2 == 2;
        }
        return invokeL.booleanValue;
    }

    public static boolean aO(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
                return false;
            }
            int i2 = playableStyleInfo.playableOrientation;
            return i2 == 0 || i2 == 1;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c aa(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String h2;
        int j2;
        int k2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, adInfo)) == null) {
            String c2 = c(adInfo);
            int e2 = e(adInfo);
            int f2 = f(adInfo);
            if (at.a(c2) || at.b(c2) || e2 == 0 || f2 == 0) {
                h2 = h(adInfo);
                j2 = j(adInfo);
                k2 = k(adInfo);
                z = true;
            } else {
                h2 = c2;
                j2 = e2;
                k2 = f2;
                z = false;
            }
            com.kwad.sdk.core.d.a.a("AdInfoHelper", "frameUrl=" + h2 + " useCover=" + z + " isAd=true");
            return new com.kwad.sdk.core.response.model.c(h2, j2, k2, true, z);
        }
        return (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    public static String ab(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, adInfo)) == null) {
            String str = adInfo.downloadSafeInfo.webPageTipbarText;
            return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
        }
        return (String) invokeL.objValue;
    }

    public static AdInfo.DownloadSafeInfo ac(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, adInfo)) == null) ? adInfo.downloadSafeInfo : (AdInfo.DownloadSafeInfo) invokeL.objValue;
    }

    public static boolean ad(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, adInfo)) == null) ? adInfo.downloadSafeInfo.secWindowPopSwitch : invokeL.booleanValue;
    }

    public static boolean ae(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65588, null, adInfo)) == null) ? adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch : invokeL.booleanValue;
    }

    public static boolean af(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65589, null, adInfo)) == null) ? adInfo.downloadSafeInfo.webPageTipbarSwitch : invokeL.booleanValue;
    }

    public static int ag(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, adInfo)) == null) {
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
    public static String ah(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.corporationName;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String ai(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.downloadSafeInfo.permissionInfo;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String aj(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.downloadSafeInfo.appPermissionInfoUrl;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String ak(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.downloadSafeInfo.appPrivacyUrl;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String al(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.appVersion;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long am(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.packageSize;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static boolean an(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
                return false;
            }
            String str = adConversionInfo.playableUrl;
            return ao(adInfo) && (str != null && adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(str.trim()));
        }
        return invokeL.booleanValue;
    }

    public static boolean ao(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65598, null, adInfo)) == null) ? af.a() ? aO(adInfo) : aN(adInfo) : invokeL.booleanValue;
    }

    @Nullable
    public static String ap(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
                return null;
            }
            return adConversionInfo.playableUrl;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String aq(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
                return null;
            }
            return adConversionInfo.callbackUrl;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String ar(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdConversionInfo adConversionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, adInfo)) == null) {
            if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
                return null;
            }
            return adConversionInfo.callbackUrlInfo;
        }
        return (String) invokeL.objValue;
    }

    public static boolean as(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65602, null, adInfo)) == null) ? (TextUtils.isEmpty(G(adInfo)) || B(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true : invokeL.booleanValue;
    }

    @NonNull
    public static String at(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, adInfo)) == null) {
            String t = B(adInfo) ? t(adInfo) : u(adInfo);
            if (TextUtils.isEmpty(t)) {
                t = adInfo.advertiserInfo.rawUserName;
            }
            return TextUtils.isEmpty(t) ? "可爱的广告君" : t;
        }
        return (String) invokeL.objValue;
    }

    public static String au(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, adInfo)) == null) {
            String str = adInfo.adBaseInfo.appIconUrl;
            return TextUtils.isEmpty(str) ? adInfo.advertiserInfo.portraitUrl : str;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static String av(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65605, null, adInfo)) == null) ? (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips : (String) invokeL.objValue;
    }

    public static boolean aw(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdSplashInfo adSplashInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65606, null, adInfo)) == null) ? (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true : invokeL.booleanValue;
    }

    public static boolean ax(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, adInfo)) == null) {
            if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
                return false;
            }
            return downloadSafeInfo.downloadPauseEnable;
        }
        return invokeL.booleanValue;
    }

    public static String ay(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65608, null, adInfo)) == null) ? adInfo.adBaseInfo.sdkExtraData : (String) invokeL.objValue;
    }

    public static boolean az(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65609, null, adInfo)) == null) ? adInfo.ocpcActionType == 72 && adInfo.adBaseInfo.campaignType == 13 : invokeL.booleanValue;
    }

    public static int b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65610, null, adInfo)) == null) ? J(adInfo).videoDuration : invokeL.intValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65611, null, i2)) == null) {
            return "继续下载 " + i2 + "%";
        }
        return (String) invokeI.objValue;
    }

    public static String c(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, adInfo)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static boolean d(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65613, null, adInfo)) == null) ? adInfo.adConversionInfo.supportThirdDownload == 1 : invokeL.booleanValue;
    }

    public static int e(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65614, null, adInfo)) == null) ? J(adInfo).videoWidth : invokeL.intValue;
    }

    public static int f(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, adInfo)) == null) ? J(adInfo).videoHeight : invokeL.intValue;
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, adInfo)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature J = J(adInfo);
            return J.videoWidth <= J.videoHeight;
        }
        return invokeL.booleanValue;
    }

    public static String h(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, null, adInfo)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String i(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65618, null, adInfo)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static int j(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65619, null, adInfo)) == null) ? J(adInfo).width : invokeL.intValue;
    }

    public static int k(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65620, null, adInfo)) == null) ? J(adInfo).height : invokeL.intValue;
    }

    public static long l(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, adInfo)) == null) ? J(adInfo).photoId : invokeL.longValue;
    }

    public static String m(@Nullable AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65622, null, adInfo)) == null) ? (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel : (String) invokeL.objValue;
    }

    public static long n(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65623, null, adInfo)) == null) ? adInfo.adRewardInfo.rewardTime : invokeL.longValue;
    }

    public static long o(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65624, null, adInfo)) == null) ? adInfo.adRewardInfo.skipShowTime * 1000 : invokeL.longValue;
    }

    public static long p(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65625, null, adInfo)) == null) ? adInfo.adRewardInfo.rewardTime * 1000 : invokeL.longValue;
    }

    public static boolean q(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65626, null, adInfo)) == null) ? !B(adInfo) && r(adInfo) : invokeL.booleanValue;
    }

    public static boolean r(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65627, null, adInfo)) == null) ? adInfo.adRewardInfo.showLandingPage == 1 : invokeL.booleanValue;
    }

    public static String s(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65628, null, adInfo)) == null) ? adInfo.adBaseInfo.adDescription : (String) invokeL.objValue;
    }

    public static String t(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65629, null, adInfo)) == null) ? adInfo.adBaseInfo.appName : (String) invokeL.objValue;
    }

    public static String u(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65630, null, adInfo)) == null) ? adInfo.adBaseInfo.productName : (String) invokeL.objValue;
    }

    public static String v(AdInfo adInfo) {
        InterceptResult invokeL;
        AdInfo.AdBaseInfo adBaseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, null, adInfo)) == null) {
            if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
                return null;
            }
            return adBaseInfo.appPackageName;
        }
        return (String) invokeL.objValue;
    }

    public static String w(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65632, null, adInfo)) == null) ? adInfo.adBaseInfo.appDownloadCountDesc : (String) invokeL.objValue;
    }

    public static float x(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, adInfo)) == null) {
            int i2 = adInfo.adBaseInfo.appScore;
            if (i2 <= 0) {
                return 0.0f;
            }
            return i2 / 10.0f;
        }
        return invokeL.floatValue;
    }

    public static float y(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65634, null, adInfo)) == null) {
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
        return invokeL.floatValue;
    }

    public static String z(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65635, null, adInfo)) == null) ? at.a(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription : (String) invokeL.objValue;
    }
}
