package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes4.dex */
public class c {
    @NonNull
    public static LiveInfo A(@NonNull AdTemplate adTemplate) {
        return adTemplate.mLiveInfo;
    }

    public static boolean B(@NonNull AdTemplate adTemplate) {
        return adTemplate.mAdScene != null && adTemplate.mAdScene.getPageScene() == 2;
    }

    public static boolean C(@NonNull AdTemplate adTemplate) {
        AdStyleInfo q = b.q(adTemplate);
        AdInfo j = j(adTemplate);
        return (q.playEndInfo.showLandingPage == 1) && !a.y(j) && !(!ag.a(a.C(j))) && (!ag.a(a.B(j)));
    }

    public static String D(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.h(j(adTemplate)) : d.L(k(adTemplate));
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        return adTemplate.realShowType == 4 && adTemplate.mLiveInfo != null;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        return adTemplate.realShowType == 1 && adTemplate.photoInfo != null;
    }

    public static boolean c(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static boolean d(@NonNull AdTemplate adTemplate) {
        return adTemplate.realShowType == 3;
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
        AdInfo adInfo = adTemplate.adInfoList.get(0);
        if (adInfo == null) {
            com.kwad.sdk.core.d.a.d("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    public static PhotoInfo k(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String l(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.a(j(adTemplate)) : d.b(k(adTemplate));
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c m(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.config.c.S() ? o(adTemplate) : c(adTemplate) ? a.U(j(adTemplate)) : d.D(k(adTemplate));
    }

    public static com.kwad.sdk.core.response.model.c n(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.W(j(adTemplate)) : d.E(k(adTemplate));
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.c o(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.V(j(adTemplate)) : d.E(k(adTemplate));
    }

    public static String p(@NonNull AdTemplate adTemplate) {
        return b(adTemplate) ? d.h(k(adTemplate)) : a.g(j(adTemplate));
    }

    public static String q(@NonNull AdTemplate adTemplate) {
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

    public static String r(@NonNull AdTemplate adTemplate) {
        return b(adTemplate) ? d.s(k(adTemplate)) : a.p(j(adTemplate));
    }

    public static long s(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.F(j(adTemplate)) : d.m(k(adTemplate));
    }

    public static long t(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.G(j(adTemplate)) : d.n(k(adTemplate));
    }

    @Nullable
    public static String u(@NonNull AdTemplate adTemplate) {
        if (c(adTemplate)) {
            AdInfo j = j(adTemplate);
            if (a.y(j)) {
                String q = a.q(j);
                if (!ag.a(q)) {
                    return "@" + q;
                }
            } else {
                String r = a.r(j);
                if (!ag.a(r)) {
                    return "@" + r;
                }
            }
            return j.advertiserInfo.userName;
        }
        return d.p(k(adTemplate));
    }

    @Nullable
    public static String v(@NonNull AdTemplate adTemplate) {
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

    public static String w(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.n(j(adTemplate)) : d.a(k(adTemplate));
    }

    public static String x(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? a.n(j(adTemplate)) : d.u(k(adTemplate));
    }

    public static String y(@NonNull AdTemplate adTemplate) {
        return c(adTemplate) ? j(adTemplate).advertiserInfo.adAuthorText : d.t(k(adTemplate));
    }

    public static long z(@NonNull AdTemplate adTemplate) {
        return b(adTemplate) ? d.k(k(adTemplate)) : c(adTemplate) ? a.k(j(adTemplate)) : adTemplate.hashCode();
    }
}
