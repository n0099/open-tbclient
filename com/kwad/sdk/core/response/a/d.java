package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.NewsInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.at;
/* loaded from: classes7.dex */
public class d {
    public static boolean a(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 6 || adTemplate.mLiveInfo == null || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        return adTemplate.realShowType == 1 && adTemplate.photoInfo != null;
    }

    public static boolean c(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static boolean d(@NonNull AdTemplate adTemplate) {
        return adTemplate.realShowType == 5 && adTemplate.newsInfo != null;
    }

    public static long e(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int f(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long g(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String h(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String i(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo j(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo == null) {
            com.kwad.sdk.core.d.a.e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    public static PhotoInfo k(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static NewsInfo l(@NonNull AdTemplate adTemplate) {
        return adTemplate.newsInfo;
    }

    public static String m(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.a(j(adTemplate)) : f.a(k(adTemplate));
    }

    public static String n(@NonNull AdTemplate adTemplate) {
        return b(adTemplate) ? f.d(k(adTemplate)) : a.i(j(adTemplate));
    }

    public static String o(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.au(j(adTemplate)) : d(adTemplate) ? e.g(l(adTemplate)) : f.i(k(adTemplate));
    }

    public static long p(@NonNull AdTemplate adTemplate) {
        return b(adTemplate) ? f.e(k(adTemplate)) : c(adTemplate) ? a.l(j(adTemplate)) : d(adTemplate) ? e.a(l(adTemplate)) : adTemplate.hashCode();
    }

    public static int q(@NonNull AdTemplate adTemplate) {
        if (b(adTemplate)) {
            return f.f(k(adTemplate));
        }
        if (d(adTemplate)) {
            return e.b(l(adTemplate));
        }
        return 0;
    }

    @NonNull
    public static LiveInfo r(@NonNull AdTemplate adTemplate) {
        return adTemplate.mLiveInfo;
    }

    @Deprecated
    public static boolean s(@NonNull AdTemplate adTemplate) {
        AdStyleInfo h2 = c.h(adTemplate);
        AdInfo j = j(adTemplate);
        return (h2.playEndInfo.showLandingPage3 == 1) && !a.B(j) && !(at.a(a.aJ(j)) ^ true) && (at.a(a.G(j)) ^ true);
    }

    public static int t(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) {
            return 0;
        }
        return sceneImpl.getAdStyle();
    }

    public static boolean u(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo j = j(adTemplate);
        return a.B(j) && !a.aG(j) && w(adTemplate) == 2;
    }

    public static boolean v(AdTemplate adTemplate) {
        return (adTemplate == null || a.B(j(adTemplate)) || w(adTemplate) != 3) ? false : true;
    }

    public static int w(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return j(adTemplate).adBaseInfo.taskType;
    }

    public static String x(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.ay(j(adTemplate)) : f.o(k(adTemplate));
    }

    public static long y(AdTemplate adTemplate) {
        return j(adTemplate).adBaseInfo.creativeId;
    }
}
