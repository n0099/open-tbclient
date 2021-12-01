package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.kwad.sdk.utils.at;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) ? (adTemplate.realShowType != 6 || adTemplate.mLiveInfo == null || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) ? adTemplate.realShowType == 1 && adTemplate.photoInfo != null : invokeL.booleanValue;
    }

    public static boolean c(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) ? (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean d(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) ? adTemplate.realShowType == 5 && adTemplate.newsInfo != null : invokeL.booleanValue;
    }

    public static long e(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) ? adTemplate.posId : invokeL.longValue;
    }

    public static int f(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adTemplate)) == null) ? adTemplate.contentType : invokeL.intValue;
    }

    public static long g(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adTemplate)) == null) ? adTemplate.llsid : invokeL.longValue;
    }

    public static String h(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) ? adTemplate.extra : (String) invokeL.objValue;
    }

    public static String i(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adTemplate)) == null) ? adTemplate.impAdExtra : (String) invokeL.objValue;
    }

    @NonNull
    public static AdInfo j(@NonNull AdTemplate adTemplate) {
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
    public static PhotoInfo k(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adTemplate)) == null) ? adTemplate.photoInfo : (PhotoInfo) invokeL.objValue;
    }

    public static NewsInfo l(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adTemplate)) == null) ? adTemplate.newsInfo : (NewsInfo) invokeL.objValue;
    }

    public static String m(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adTemplate)) == null) ? c(adTemplate) ? a.a(j(adTemplate)) : f.a(k(adTemplate)) : (String) invokeL.objValue;
    }

    public static String n(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adTemplate)) == null) ? b(adTemplate) ? f.d(k(adTemplate)) : a.i(j(adTemplate)) : (String) invokeL.objValue;
    }

    public static String o(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adTemplate)) == null) ? c(adTemplate) ? a.au(j(adTemplate)) : d(adTemplate) ? e.g(l(adTemplate)) : f.i(k(adTemplate)) : (String) invokeL.objValue;
    }

    public static long p(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adTemplate)) == null) ? b(adTemplate) ? f.e(k(adTemplate)) : c(adTemplate) ? a.l(j(adTemplate)) : d(adTemplate) ? e.a(l(adTemplate)) : adTemplate.hashCode() : invokeL.longValue;
    }

    public static int q(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adTemplate)) == null) {
            if (b(adTemplate)) {
                return f.f(k(adTemplate));
            }
            if (d(adTemplate)) {
                return e.b(l(adTemplate));
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static LiveInfo r(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adTemplate)) == null) ? adTemplate.mLiveInfo : (LiveInfo) invokeL.objValue;
    }

    @Deprecated
    public static boolean s(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adTemplate)) == null) {
            AdStyleInfo h2 = c.h(adTemplate);
            AdInfo j2 = j(adTemplate);
            return (h2.playEndInfo.showLandingPage3 == 1) && !a.B(j2) && !(at.a(a.aJ(j2)) ^ true) && (at.a(a.G(j2)) ^ true);
        }
        return invokeL.booleanValue;
    }

    public static int t(AdTemplate adTemplate) {
        InterceptResult invokeL;
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adTemplate)) == null) {
            if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) {
                return 0;
            }
            return sceneImpl.getAdStyle();
        }
        return invokeL.intValue;
    }

    public static boolean u(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return false;
            }
            AdInfo j2 = j(adTemplate);
            return a.B(j2) && !a.aG(j2) && w(adTemplate) == 2;
        }
        return invokeL.booleanValue;
    }

    public static boolean v(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adTemplate)) == null) ? (adTemplate == null || a.B(j(adTemplate)) || w(adTemplate) != 3) ? false : true : invokeL.booleanValue;
    }

    public static int w(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return -1;
            }
            return j(adTemplate).adBaseInfo.taskType;
        }
        return invokeL.intValue;
    }

    public static String x(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, adTemplate)) == null) ? c(adTemplate) ? a.ay(j(adTemplate)) : f.o(k(adTemplate)) : (String) invokeL.objValue;
    }

    public static long y(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, adTemplate)) == null) ? j(adTemplate).adBaseInfo.creativeId : invokeL.longValue;
    }
}
