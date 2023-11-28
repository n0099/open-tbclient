package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
/* loaded from: classes10.dex */
public final class e {
    @Nullable
    public static g DY() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.tt();
        }
        return null;
    }

    public static boolean F(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dP = dP(adTemplate);
        if (a.aF(dP) || a.cO(dP) || dX(adTemplate) != 3) {
            return false;
        }
        return true;
    }

    public static boolean dH(@NonNull AdTemplate adTemplate) {
        if (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) {
            return false;
        }
        return true;
    }

    public static long dI(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int dJ(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int dK(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
            return sceneImpl.getAdStyle();
        }
        return 0;
    }

    public static int dL(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long dM(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String dN(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String dO(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo dP(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo;
        if (adTemplate.adInfoList.size() > 0) {
            adInfo = adTemplate.adInfoList.get(0);
        } else {
            adInfo = null;
        }
        if (adInfo == null) {
            com.kwad.sdk.core.e.c.e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    public static PhotoInfo dQ(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String dR(@NonNull AdTemplate adTemplate) {
        if (dH(adTemplate)) {
            return a.K(dP(adTemplate));
        }
        return h.a(dQ(adTemplate));
    }

    public static String dS(@NonNull AdTemplate adTemplate) {
        return dP(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String dT(@NonNull AdTemplate adTemplate) {
        String Ec;
        g DY = DY();
        if (DY == null) {
            Ec = "";
        } else {
            Ec = DY.Ec();
        }
        if (TextUtils.isEmpty(Ec)) {
            return Ec;
        }
        return a.Y(dP(adTemplate));
    }

    public static String dU(@NonNull AdTemplate adTemplate) {
        if (dH(adTemplate)) {
            return a.cf(dP(adTemplate));
        }
        g DY = DY();
        if (DY == null) {
            return "";
        }
        return DY.Ed();
    }

    public static long dV(@NonNull AdTemplate adTemplate) {
        if (dH(adTemplate)) {
            return a.ab(dP(adTemplate));
        }
        g DY = DY();
        if (DY == null) {
            return adTemplate.hashCode();
        }
        return DY.Ee();
    }

    public static int dW(@NonNull AdTemplate adTemplate) {
        g DY = DY();
        if (DY == null) {
            return 0;
        }
        return DY.Ef();
    }

    public static int dX(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return dP(adTemplate).adBaseInfo.taskType;
    }

    public static String dY(@NonNull AdTemplate adTemplate) {
        if (dH(adTemplate)) {
            return a.cA(dP(adTemplate));
        }
        return h.c(dQ(adTemplate));
    }

    public static long dZ(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dP(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean ea(AdTemplate adTemplate) {
        if (dP(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow) {
            return true;
        }
        return false;
    }

    public static boolean eb(@NonNull AdTemplate adTemplate) {
        int j = j(adTemplate, true);
        if (j == 1 || j == 2) {
            return true;
        }
        return false;
    }

    public static boolean ec(@NonNull AdTemplate adTemplate) {
        int j = j(adTemplate, false);
        if (j != 1 && j != 2) {
            return false;
        }
        return true;
    }

    public static int ed(@NonNull AdTemplate adTemplate) {
        return dP(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean ee(@NonNull AdTemplate adTemplate) {
        AdInfo dP = dP(adTemplate);
        int dJ = dJ(adTemplate);
        if (dP.adStyleConfInfo.adPushDownloadJumpType == 0 && dJ == 17 && a.aF(dP)) {
            return true;
        }
        return false;
    }

    public static int ef(@NonNull AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig == null) {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.yE();
            }
            return 800;
        }
        return adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (c(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j, int i) {
        AdTemplate a = a(list, j, i);
        if (a == null) {
            return false;
        }
        long dZ = dZ(a);
        int dJ = dJ(a);
        if (i > 0) {
            if (dZ != j || dJ != i) {
                return false;
            }
        } else if (dZ != j) {
            return false;
        }
        return true;
    }

    public static boolean c(AdTemplate adTemplate, long j, int i) {
        long dZ = dZ(adTemplate);
        int dJ = dJ(adTemplate);
        if (i > 0) {
            if (dZ == j && dJ == i) {
                return true;
            }
        } else if (dZ == j) {
            return true;
        }
        return false;
    }

    public static boolean i(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dP = dP(adTemplate);
        if (!a.aF(dP) || a.cO(dP) || z || dX(adTemplate) != 2) {
            return false;
        }
        return true;
    }

    public static int j(@NonNull AdTemplate adTemplate, boolean z) {
        int i;
        AdInfo dP = dP(adTemplate);
        if (dJ(adTemplate) == 3) {
            AdMatrixInfo.AdDataV2 adDataV2 = dP.adMatrixInfo.adDataV2;
            if (z) {
                i = adDataV2.actionBarInfo.cardType;
            } else {
                i = adDataV2.endCardInfo.cardType;
            }
            if (i == 5) {
                return 1;
            }
            if (i == 6) {
                return 2;
            }
            return -1;
        }
        return dP.adBaseInfo.mABParams.playableStyle;
    }
}
