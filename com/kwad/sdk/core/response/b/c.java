package com.kwad.sdk.core.response.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class c {
    public static boolean a(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static boolean a(AdTemplate adTemplate, Context context) {
        if (adTemplate == null) {
            return false;
        }
        return (b.j(adTemplate) || k(adTemplate)) && !a.a(g(adTemplate), context);
    }

    public static long b(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int c(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long d(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String e(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String f(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo g(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo == null) {
            com.kwad.sdk.core.d.a.e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    public static PhotoInfo h(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String i(@NonNull AdTemplate adTemplate) {
        return a(adTemplate) ? a.a(g(adTemplate)) : d.a(h(adTemplate));
    }

    @NonNull
    public static LiveInfo j(@NonNull AdTemplate adTemplate) {
        return adTemplate.mLiveInfo;
    }

    public static boolean k(@NonNull AdTemplate adTemplate) {
        AdStyleInfo k = b.k(adTemplate);
        AdInfo g2 = g(adTemplate);
        return (k.playEndInfo.showLandingPage3 == 1) && !a.v(g2) && !(ag.a(a.A(g2)) ^ true) && (ag.a(a.y(g2)) ^ true);
    }
}
