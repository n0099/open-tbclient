package com.kwad.sdk.core.response.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.at;
import java.util.List;
/* loaded from: classes5.dex */
public final class d {
    @Nullable
    public static e a() {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        if (dVar != null) {
            return dVar.l();
        }
        return null;
    }

    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (a(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static boolean a(AdTemplate adTemplate, long j, int i) {
        long t = t(adTemplate);
        int c = c(adTemplate);
        if (i > 0) {
            if (t == j && c == i) {
                return true;
            }
        } else if (t == j) {
            return true;
        }
        return false;
    }

    public static boolean a(AdTemplate adTemplate, boolean z) {
        return adTemplate != null && a.I(i(adTemplate)) && !z && r(adTemplate) == 2;
    }

    public static int b(@NonNull AdTemplate adTemplate, boolean z) {
        AdInfo i = i(adTemplate);
        if (c(adTemplate) == 3) {
            AdMatrixInfo.AdDataV2 adDataV2 = i.adMatrixInfo.adDataV2;
            int i2 = z ? adDataV2.actionBarInfo.cardType : adDataV2.endCardInfo.cardType;
            if (i2 == 5) {
                return 1;
            }
            return i2 == 6 ? 2 : -1;
        }
        return i.adBaseInfo.mABParams.playableStyle;
    }

    public static long b(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int c(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    public static int d(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) {
            return 0;
        }
        return sceneImpl.getAdStyle();
    }

    public static int e(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long f(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String g(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String h(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo i(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo == null) {
            com.kwad.sdk.core.d.b.e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    public static PhotoInfo j(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String k(@NonNull AdTemplate adTemplate) {
        return a(adTemplate) ? a.b(i(adTemplate)) : f.a(j(adTemplate));
    }

    public static String l(@NonNull AdTemplate adTemplate) {
        e a = a();
        String a2 = a == null ? "" : a.a();
        return TextUtils.isEmpty(a2) ? a2 : a.l(i(adTemplate));
    }

    public static String m(@NonNull AdTemplate adTemplate) {
        if (a(adTemplate)) {
            return a.aE(i(adTemplate));
        }
        e a = a();
        return a == null ? "" : a.b();
    }

    public static long n(@NonNull AdTemplate adTemplate) {
        if (a(adTemplate)) {
            return a.m(i(adTemplate));
        }
        e a = a();
        return a == null ? adTemplate.hashCode() : a.c();
    }

    public static int o(@NonNull AdTemplate adTemplate) {
        e a = a();
        if (a == null) {
            return 0;
        }
        return a.d();
    }

    public static boolean p(@NonNull AdTemplate adTemplate) {
        AdStyleInfo e = c.e(adTemplate);
        AdInfo i = i(adTemplate);
        return (e.playEndInfo.showLandingPage3 == 1 || a.y(i)) && !a.I(i) && !(at.a(a.bc(i)) ^ true) && (at.a(a.N(i)) ^ true);
    }

    public static boolean q(AdTemplate adTemplate) {
        return (adTemplate == null || a.I(i(adTemplate)) || r(adTemplate) != 3) ? false : true;
    }

    public static int r(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return i(adTemplate).adBaseInfo.taskType;
    }

    public static String s(@NonNull AdTemplate adTemplate) {
        return a(adTemplate) ? a.aS(i(adTemplate)) : f.c(j(adTemplate));
    }

    public static long t(AdTemplate adTemplate) {
        return i(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean u(AdTemplate adTemplate) {
        return i(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean v(@NonNull AdTemplate adTemplate) {
        return w(adTemplate) || x(adTemplate);
    }

    public static boolean w(@NonNull AdTemplate adTemplate) {
        int b = b(adTemplate, true);
        return b == 1 || b == 2;
    }

    public static boolean x(@NonNull AdTemplate adTemplate) {
        int b = b(adTemplate, false);
        return b == 1 || b == 2;
    }

    public static int y(@NonNull AdTemplate adTemplate) {
        return i(adTemplate).adBaseInfo.ecpm;
    }
}
