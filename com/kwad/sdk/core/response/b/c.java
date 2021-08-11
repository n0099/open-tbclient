package com.kwad.sdk.core.response.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.NewsInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.an;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) ? adTemplate.realShowType == 1 && adTemplate.photoInfo != null : invokeL.booleanValue;
    }

    public static boolean a(AdTemplate adTemplate, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, adTemplate, context)) == null) {
            if (adTemplate == null) {
                return false;
            }
            return (b.j(adTemplate) || r(adTemplate)) && !a.a(i(adTemplate), context);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) ? (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean c(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) ? adTemplate.realShowType == 5 && adTemplate.newsInfo != null : invokeL.booleanValue;
    }

    public static long d(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) ? adTemplate.posId : invokeL.longValue;
    }

    public static int e(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, adTemplate)) == null) ? adTemplate.contentType : invokeL.intValue;
    }

    public static long f(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, adTemplate)) == null) ? adTemplate.llsid : invokeL.longValue;
    }

    public static String g(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) ? adTemplate.extra : (String) invokeL.objValue;
    }

    public static String h(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adTemplate)) == null) ? adTemplate.impAdExtra : (String) invokeL.objValue;
    }

    @NonNull
    public static AdInfo i(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adTemplate)) == null) {
            AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
            if (adInfo == null) {
                com.kwad.sdk.core.d.a.e("AdTemplateHelper", "adInfo in null");
                return new AdInfo();
            }
            return adInfo;
        }
        return (AdInfo) invokeL.objValue;
    }

    @NonNull
    public static PhotoInfo j(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adTemplate)) == null) ? adTemplate.photoInfo : (PhotoInfo) invokeL.objValue;
    }

    public static NewsInfo k(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adTemplate)) == null) ? adTemplate.newsInfo : (NewsInfo) invokeL.objValue;
    }

    public static String l(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adTemplate)) == null) ? b(adTemplate) ? a.a(i(adTemplate)) : e.a(j(adTemplate)) : (String) invokeL.objValue;
    }

    public static String m(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adTemplate)) == null) ? b(adTemplate) ? a.ah(i(adTemplate)) : c(adTemplate) ? d.g(k(adTemplate)) : e.h(j(adTemplate)) : (String) invokeL.objValue;
    }

    public static int n(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adTemplate)) == null) ? b(adTemplate) ? i(adTemplate).adBaseInfo.industryFirstLevelId : j(adTemplate).baseInfo.industryFirstLevelId : invokeL.intValue;
    }

    public static long o(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adTemplate)) == null) ? a(adTemplate) ? e.d(j(adTemplate)) : b(adTemplate) ? a.i(i(adTemplate)) : c(adTemplate) ? d.a(k(adTemplate)) : adTemplate.hashCode() : invokeL.longValue;
    }

    public static int p(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adTemplate)) == null) {
            if (a(adTemplate)) {
                return e.e(j(adTemplate));
            }
            if (c(adTemplate)) {
                return d.b(k(adTemplate));
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static LiveInfo q(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adTemplate)) == null) ? adTemplate.mLiveInfo : (LiveInfo) invokeL.objValue;
    }

    public static boolean r(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adTemplate)) == null) {
            AdStyleInfo k = b.k(adTemplate);
            AdInfo i2 = i(adTemplate);
            return (k.playEndInfo.showLandingPage3 == 1) && !a.v(i2) && !(an.a(a.A(i2)) ^ true) && (an.a(a.y(i2)) ^ true);
        }
        return invokeL.booleanValue;
    }

    public static String s(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adTemplate)) == null) ? adTemplate.aggregatePageEntranceInfo.aggregatePageH5Url : (String) invokeL.objValue;
    }

    public static long t(AdTemplate adTemplate) {
        InterceptResult invokeL;
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adTemplate)) == null) {
            if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) {
                return 0L;
            }
            return sceneImpl.getAdStyle();
        }
        return invokeL.longValue;
    }
}
