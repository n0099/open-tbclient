package com.kwad.sdk.core.response.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int A(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) ? adInfo.adBaseInfo.ecpm : invokeL.intValue;
    }

    public static String B(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) ? adInfo.adConversionInfo.h5Url : (String) invokeL.objValue;
    }

    public static String C(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) ? adInfo.adConversionInfo.deeplinkUrl : (String) invokeL.objValue;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature D(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    return materialFeature;
                }
            }
            com.kwad.sdk.core.d.a.d("AdInfoHelper", "getImageMaterialFeature in null");
            return new AdInfo.AdMaterialInfo.MaterialFeature();
        }
        return (AdInfo.AdMaterialInfo.MaterialFeature) invokeL.objValue;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature E(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, adInfo)) == null) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    return materialFeature;
                }
            }
            com.kwad.sdk.core.d.a.d("AdInfoHelper", "getVideoMaterialFeature in null");
            return new AdInfo.AdMaterialInfo.MaterialFeature();
        }
        return (AdInfo.AdMaterialInfo.MaterialFeature) invokeL.objValue;
    }

    public static long F(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, adInfo)) == null) ? ah(adInfo).likeCount : invokeL.longValue;
    }

    public static long G(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, adInfo)) == null) ? ah(adInfo).commentCount : invokeL.longValue;
    }

    public static String H(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adInfo)) == null) ? adInfo.adPreloadInfo.preloadId : (String) invokeL.objValue;
    }

    @NonNull
    public static List<String> I(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adInfo)) == null) {
            ArrayList arrayList = new ArrayList();
            int L = L(adInfo);
            if (L == 2 || L == 3) {
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

    public static boolean J(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adInfo)) == null) ? L(adInfo) == 1 : invokeL.booleanValue;
    }

    public static boolean K(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adInfo)) == null) ? D(adInfo).featureType == 2 : invokeL.booleanValue;
    }

    public static int L(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adInfo)) == null) {
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
    public static List<Integer> M(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adInfo)) == null) {
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

    public static boolean N(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adInfo)) == null) ? adInfo.adBaseInfo.mABParams.videoBlackAreaClick != 0 : invokeL.booleanValue;
    }

    public static boolean O(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adInfo)) == null) ? adInfo.adBaseInfo.mABParams.videoBlackAreaNewStyle != 0 : invokeL.booleanValue;
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adInfo)) == null) ? (adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || ag.a(adInfo.adConversionInfo.h5Url)) ? false : true : invokeL.booleanValue;
    }

    @NonNull
    public static int[] Q(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adInfo)) == null) {
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

    public static int R(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adInfo)) == null) {
            int[] Q = Q(adInfo);
            if (Q.length >= 3 && Q[0] > 0) {
                return Q[0];
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static int S(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adInfo)) == null) {
            int[] Q = Q(adInfo);
            if (Q.length < 3) {
                return 6;
            }
            return (Q[1] > 0 ? Q[1] : 3) + R(adInfo);
        }
        return invokeL.intValue;
    }

    public static int T(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adInfo)) == null) {
            int[] Q = Q(adInfo);
            if (Q.length < 3) {
                return 9;
            }
            return (Q[2] > 0 ? Q[2] : 3) + S(adInfo);
        }
        return invokeL.intValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c U(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String f2;
        int i2;
        int j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adInfo)) == null) {
            String c2 = c(adInfo);
            int d2 = d(adInfo);
            int e2 = e(adInfo);
            if (ag.a(c2) || ag.b(c2) || d2 == 0 || e2 == 0) {
                f2 = f(adInfo);
                i2 = i(adInfo);
                j = j(adInfo);
                z = true;
            } else {
                f2 = c2;
                i2 = d2;
                j = e2;
                z = false;
            }
            com.kwad.sdk.core.d.a.a("AdInfoHelper", "frameUrl=" + f2 + " useCover=" + z + " isAd=true");
            return new com.kwad.sdk.core.response.model.c(f2, i2, j, true, z);
        }
        return (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c V(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String c2;
        int d2;
        int e2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adInfo)) == null) {
            String f2 = f(adInfo);
            int i2 = i(adInfo);
            int j = j(adInfo);
            if (ag.a(f2) || i2 == 0 || j == 0) {
                c2 = c(adInfo);
                d2 = d(adInfo);
                e2 = e(adInfo);
                z = false;
            } else {
                c2 = f2;
                d2 = i2;
                e2 = j;
                z = true;
            }
            return new com.kwad.sdk.core.response.model.c(c2, d2, e2, true, z);
        }
        return (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    public static com.kwad.sdk.core.response.model.c W(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        String c2;
        int d2;
        int e2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, adInfo)) == null) {
            String h2 = h(adInfo);
            if (ag.a(h2)) {
                h2 = f(adInfo);
            }
            int i2 = i(adInfo);
            int j = j(adInfo);
            if (ag.a(h2) || i2 == 0 || j == 0) {
                c2 = c(adInfo);
                d2 = d(adInfo);
                e2 = e(adInfo);
                z = false;
            } else {
                c2 = h2;
                d2 = i2;
                e2 = j;
                z = true;
            }
            return new com.kwad.sdk.core.response.model.c(c2, d2, e2, true, z);
        }
        return (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    public static String X(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, adInfo)) == null) {
            String str = adInfo.adBaseInfo.adActionBarColor;
            return (ag.a(str) || !str.matches("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6}|[0-9a-fA-F]{3})$")) ? "#FFE4A704" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String Y(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, adInfo)) == null) {
            String str = adInfo.downloadSafeInfo.webPageTipbarText;
            return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
        }
        return (String) invokeL.objValue;
    }

    public static AdInfo.DownloadSafeInfo Z(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, adInfo)) == null) ? adInfo.downloadSafeInfo : (AdInfo.DownloadSafeInfo) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? CommonUtils.DIALOG_POS_TEXT : (String) invokeV.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65563, null, f2)) == null) ? String.format("%.1fM", Float.valueOf((f2 / 1000.0f) / 1000.0f)) : (String) invokeF.objValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) {
            return "下载中  " + i2 + "%";
        }
        return (String) invokeI.objValue;
    }

    public static String a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, adInfo)) == null) ? E(adInfo).materialUrl : (String) invokeL.objValue;
    }

    public static String a(@NonNull AdInfo adInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, adInfo, i2)) == null) {
            return "下载中..." + i2 + "%  (" + a(((float) adInfo.totalBytes) * (i2 / 100.0f)) + "/" + a((float) adInfo.totalBytes) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeLI.objValue;
    }

    public static String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, adTemplate)) == null) ? (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2) ? "立即安装" : "安装获取奖励" : (String) invokeL.objValue;
    }

    public static boolean aa(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, adInfo)) == null) ? adInfo.downloadSafeInfo.webPageTipbarSwitch : invokeL.booleanValue;
    }

    public static int ab(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, adInfo)) == null) {
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
        return invokeL.intValue;
    }

    @Nullable
    public static String ac(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.corporationName;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String ad(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.downloadSafeInfo.permissionInfo;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String ae(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.downloadSafeInfo.appPrivacyUrl;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String af(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.appVersion;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long ag(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, adInfo)) == null) {
            if (adInfo != null) {
                return adInfo.adBaseInfo.packageSize;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature ah(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, adInfo)) == null) {
            List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
            AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
            return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
        }
        return (AdInfo.AdMaterialInfo.MaterialFeature) invokeL.objValue;
    }

    public static int b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, adInfo)) == null) ? E(adInfo).videoDuration : invokeL.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? "立即打开" : (String) invokeV.objValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65578, null, i2)) == null) {
            return "下载中..." + i2 + "%";
        }
        return (String) invokeI.objValue;
    }

    public static String b(@NonNull AdInfo adInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, adInfo, i2)) == null) {
            return "继续下载 " + i2 + "%  (" + a(((float) adInfo.totalBytes) * (i2 / 100.0f)) + "/" + a((float) adInfo.totalBytes) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeLI.objValue;
    }

    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65580, null, i2)) == null) {
            return "继续下载 " + i2 + "%";
        }
        return (String) invokeI.objValue;
    }

    public static String c(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, null, adInfo)) == null) ? E(adInfo).firstFrame : (String) invokeL.objValue;
    }

    public static int d(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, null, adInfo)) == null) ? E(adInfo).videoWidth : invokeL.intValue;
    }

    public static int e(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65583, null, adInfo)) == null) ? E(adInfo).videoHeight : invokeL.intValue;
    }

    public static String f(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, null, adInfo)) == null) ? E(adInfo).coverUrl : (String) invokeL.objValue;
    }

    public static String g(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65585, null, adInfo)) == null) ? E(adInfo).blurBackgroundUrl : (String) invokeL.objValue;
    }

    public static String h(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, adInfo)) == null) ? E(adInfo).webpCoverUrl : (String) invokeL.objValue;
    }

    public static int i(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, adInfo)) == null) ? E(adInfo).width : invokeL.intValue;
    }

    public static int j(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65588, null, adInfo)) == null) ? E(adInfo).height : invokeL.intValue;
    }

    public static long k(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65589, null, adInfo)) == null) ? E(adInfo).photoId : invokeL.longValue;
    }

    public static boolean l(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, adInfo)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_SKIP_FIVE_SECOND");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : adInfo.adBaseInfo.enableSkipAd == 1;
        }
        return invokeL.booleanValue;
    }

    public static long m(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65591, null, adInfo)) == null) ? adInfo.adBaseInfo.skipSecond * 1000 : invokeL.longValue;
    }

    public static String n(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, adInfo)) == null) ? adInfo.adBaseInfo.adDescription : (String) invokeL.objValue;
    }

    public static String o(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65593, null, adInfo)) == null) ? adInfo.adBaseInfo.appIconUrl : (String) invokeL.objValue;
    }

    public static String p(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65594, null, adInfo)) == null) ? adInfo.advertiserInfo.authorIconGuide : (String) invokeL.objValue;
    }

    public static String q(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65595, null, adInfo)) == null) ? adInfo.adBaseInfo.appName : (String) invokeL.objValue;
    }

    public static String r(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65596, null, adInfo)) == null) ? adInfo.adBaseInfo.productName : (String) invokeL.objValue;
    }

    public static String s(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65597, null, adInfo)) == null) ? adInfo.adBaseInfo.appPackageName : (String) invokeL.objValue;
    }

    public static String t(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65598, null, adInfo)) == null) ? adInfo.adBaseInfo.appDownloadCountDesc : (String) invokeL.objValue;
    }

    public static float u(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, adInfo)) == null) {
            int i2 = adInfo.adBaseInfo.appScore;
            if (i2 <= 0) {
                return 0.0f;
            }
            return i2 / 10.0f;
        }
        return invokeL.floatValue;
    }

    public static String v(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65600, null, adInfo)) == null) ? ag.a(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription : (String) invokeL.objValue;
    }

    public static String w(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, adInfo)) == null) {
            String str = adInfo.adBaseInfo.adActionDescription;
            if (TextUtils.isEmpty(str)) {
                return y(adInfo) ? "立即下载" : "查看详情";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String x(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, adInfo)) == null) {
            String str = adInfo.adBaseInfo.adActionDescription;
            if (TextUtils.isEmpty(str)) {
                return y(adInfo) ? "点我试玩" : "查看详情";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean y(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65603, null, adInfo)) == null) ? z(adInfo) == 1 : invokeL.booleanValue;
    }

    public static int z(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, adInfo)) == null) {
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
}
