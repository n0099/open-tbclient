package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static LiveInfo A(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) ? adTemplate.mLiveInfo : (LiveInfo) invokeL.objValue;
    }

    public static boolean B(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            return sceneImpl != null && sceneImpl.getPageScene() == 2;
        }
        return invokeL.booleanValue;
    }

    public static boolean C(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
            AdStyleInfo q = b.q(adTemplate);
            AdInfo j = j(adTemplate);
            return (q.playEndInfo.showLandingPage == 1) && !a.y(j) && !(ag.a(a.C(j)) ^ true) && (ag.a(a.B(j)) ^ true);
        }
        return invokeL.booleanValue;
    }

    public static String D(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) ? c(adTemplate) ? a.h(j(adTemplate)) : d.L(k(adTemplate)) : (String) invokeL.objValue;
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, adTemplate)) == null) ? adTemplate.realShowType == 4 && adTemplate.mLiveInfo != null : invokeL.booleanValue;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, adTemplate)) == null) ? adTemplate.realShowType == 1 && adTemplate.photoInfo != null : invokeL.booleanValue;
    }

    public static boolean c(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, adTemplate)) == null) ? (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean d(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) ? adTemplate.realShowType == 3 : invokeL.booleanValue;
    }

    public static long e(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adTemplate)) == null) ? adTemplate.posId : invokeL.longValue;
    }

    public static int f(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adTemplate)) == null) ? adTemplate.contentType : invokeL.intValue;
    }

    public static long g(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adTemplate)) == null) ? adTemplate.llsid : invokeL.longValue;
    }

    public static String h(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adTemplate)) == null) ? adTemplate.extra : (String) invokeL.objValue;
    }

    public static String i(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adTemplate)) == null) ? adTemplate.impAdExtra : (String) invokeL.objValue;
    }

    @NonNull
    public static AdInfo j(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adTemplate)) == null) {
            AdInfo adInfo = adTemplate.adInfoList.get(0);
            if (adInfo == null) {
                com.kwad.sdk.core.d.a.d("AdTemplateHelper", "adInfo in null");
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adTemplate)) == null) ? adTemplate.photoInfo : (PhotoInfo) invokeL.objValue;
    }

    public static String l(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adTemplate)) == null) ? c(adTemplate) ? a.a(j(adTemplate)) : d.b(k(adTemplate)) : (String) invokeL.objValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c m(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adTemplate)) == null) ? com.kwad.sdk.core.config.c.S() ? o(adTemplate) : c(adTemplate) ? a.U(j(adTemplate)) : d.D(k(adTemplate)) : (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    public static com.kwad.sdk.core.response.model.c n(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adTemplate)) == null) ? c(adTemplate) ? a.W(j(adTemplate)) : d.E(k(adTemplate)) : (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c o(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adTemplate)) == null) ? c(adTemplate) ? a.V(j(adTemplate)) : d.E(k(adTemplate)) : (com.kwad.sdk.core.response.model.c) invokeL.objValue;
    }

    public static String p(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adTemplate)) == null) ? b(adTemplate) ? d.h(k(adTemplate)) : a.g(j(adTemplate)) : (String) invokeL.objValue;
    }

    public static String q(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adTemplate)) == null) {
            if (c(adTemplate)) {
                AdInfo j = j(adTemplate);
                if (a.y(j)) {
                    String o = a.o(j);
                    if (!ag.a(o)) {
                        return o;
                    }
                }
                return j.advertiserInfo.portraitUrl;
            }
            return d.r(k(adTemplate));
        }
        return (String) invokeL.objValue;
    }

    public static String r(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adTemplate)) == null) ? b(adTemplate) ? d.s(k(adTemplate)) : a.p(j(adTemplate)) : (String) invokeL.objValue;
    }

    public static long s(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, adTemplate)) == null) ? c(adTemplate) ? a.F(j(adTemplate)) : d.m(k(adTemplate)) : invokeL.longValue;
    }

    public static long t(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, adTemplate)) == null) ? c(adTemplate) ? a.G(j(adTemplate)) : d.n(k(adTemplate)) : invokeL.longValue;
    }

    @Nullable
    public static String u(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, adTemplate)) == null) {
            if (c(adTemplate)) {
                AdInfo j = j(adTemplate);
                if (a.y(j)) {
                    String q = a.q(j);
                    if (!ag.a(q)) {
                        return TNCManager.TNC_PROBE_HEADER_SECEPTOR + q;
                    }
                } else {
                    String r = a.r(j);
                    if (!ag.a(r)) {
                        return TNCManager.TNC_PROBE_HEADER_SECEPTOR + r;
                    }
                }
                return j.advertiserInfo.userName;
            }
            return d.p(k(adTemplate));
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String v(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, adTemplate)) == null) {
            if (c(adTemplate)) {
                AdInfo j = j(adTemplate);
                if (a.y(j)) {
                    String q = a.q(j);
                    if (!ag.a(q)) {
                        return q;
                    }
                } else {
                    String r = a.r(j);
                    if (!ag.a(r)) {
                        return r;
                    }
                }
                return j.advertiserInfo.rawUserName;
            }
            return d.q(k(adTemplate));
        }
        return (String) invokeL.objValue;
    }

    public static String w(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, adTemplate)) == null) ? c(adTemplate) ? a.n(j(adTemplate)) : d.a(k(adTemplate)) : (String) invokeL.objValue;
    }

    public static String x(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, adTemplate)) == null) ? c(adTemplate) ? a.n(j(adTemplate)) : d.u(k(adTemplate)) : (String) invokeL.objValue;
    }

    public static String y(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, adTemplate)) == null) ? c(adTemplate) ? j(adTemplate).advertiserInfo.adAuthorText : d.t(k(adTemplate)) : (String) invokeL.objValue;
    }

    public static long z(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, adTemplate)) == null) ? b(adTemplate) ? d.k(k(adTemplate)) : c(adTemplate) ? a.k(j(adTemplate)) : adTemplate.hashCode() : invokeL.longValue;
    }
}
