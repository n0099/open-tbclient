package com.kwad.sdk.core.response.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ax;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class d {
    public static AdTemplate a(List list, long j, int i) {
        if (j >= 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdTemplate adTemplate = (AdTemplate) it.next();
                if (b(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(AdTemplate adTemplate, long j, int i) {
        long ca = ca(adTemplate);
        int bK = bK(adTemplate);
        if (i > 0) {
            if (ca == j && bK == i) {
                return true;
            }
        } else if (ca == j) {
            return true;
        }
        return false;
    }

    public static boolean bI(AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long bJ(AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int bK(AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    public static int bL(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) {
            return 0;
        }
        return sceneImpl.getAdStyle();
    }

    public static int bM(AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long bN(AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String bO(AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String bP(AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    public static AdInfo bQ(AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? (AdInfo) adTemplate.adInfoList.get(0) : null;
        if (adInfo == null) {
            com.kwad.sdk.core.e.b.e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    public static PhotoInfo bR(AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String bS(AdTemplate adTemplate) {
        return bI(adTemplate) ? a.A(bQ(adTemplate)) : f.a(bR(adTemplate));
    }

    public static String bT(AdTemplate adTemplate) {
        e uV = uV();
        String uW = uV == null ? "" : uV.uW();
        return TextUtils.isEmpty(uW) ? uW : a.L(bQ(adTemplate));
    }

    public static String bU(AdTemplate adTemplate) {
        if (bI(adTemplate)) {
            return a.bn(bQ(adTemplate));
        }
        e uV = uV();
        return uV == null ? "" : uV.uX();
    }

    public static long bV(AdTemplate adTemplate) {
        if (bI(adTemplate)) {
            return a.O(bQ(adTemplate));
        }
        e uV = uV();
        return uV == null ? adTemplate.hashCode() : uV.uY();
    }

    public static int bW(AdTemplate adTemplate) {
        e uV = uV();
        if (uV == null) {
            return 0;
        }
        return uV.uZ();
    }

    public static boolean bX(AdTemplate adTemplate) {
        AdStyleInfo bG = c.bG(adTemplate);
        AdInfo bQ = bQ(adTemplate);
        return (bG.playEndInfo.showLandingPage3 == 1 || a.ab(bQ)) && !a.am(bQ) && !(ax.dT(a.bM(bQ)) ^ true) && (ax.dT(a.ar(bQ)) ^ true);
    }

    public static int bY(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return bQ(adTemplate).adBaseInfo.taskType;
    }

    public static String bZ(AdTemplate adTemplate) {
        return bI(adTemplate) ? a.bC(bQ(adTemplate)) : f.c(bR(adTemplate));
    }

    public static long ca(AdTemplate adTemplate) {
        return bQ(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean cb(AdTemplate adTemplate) {
        return bQ(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean cc(AdTemplate adTemplate) {
        return cd(adTemplate) || ce(adTemplate);
    }

    public static boolean cd(AdTemplate adTemplate) {
        int f = f(adTemplate, true);
        return f == 1 || f == 2;
    }

    public static boolean ce(AdTemplate adTemplate) {
        int f = f(adTemplate, false);
        return f == 1 || f == 2;
    }

    public static int cf(AdTemplate adTemplate) {
        return bQ(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean e(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo bQ = bQ(adTemplate);
        return a.am(bQ) && !a.bQ(bQ) && !z && bY(adTemplate) == 2;
    }

    public static int f(AdTemplate adTemplate, boolean z) {
        AdInfo bQ = bQ(adTemplate);
        if (bK(adTemplate) == 3) {
            AdMatrixInfo.AdDataV2 adDataV2 = bQ.adMatrixInfo.adDataV2;
            int i = z ? adDataV2.actionBarInfo.cardType : adDataV2.endCardInfo.cardType;
            if (i == 5) {
                return 1;
            }
            return i == 6 ? 2 : -1;
        }
        return bQ.adBaseInfo.mABParams.playableStyle;
    }

    public static boolean p(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo bQ = bQ(adTemplate);
        return (a.am(bQ) || a.bQ(bQ) || bY(adTemplate) != 3) ? false : true;
    }

    public static e uV() {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        if (dVar != null) {
            return dVar.lw();
        }
        return null;
    }
}
