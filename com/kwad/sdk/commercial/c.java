package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class c {
    public static int bU(int i) {
        if (i == -1) {
            return 100010;
        }
        if (i == -2) {
            return 100011;
        }
        return i;
    }

    public static BusinessType aS(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return BusinessType.OTHER;
        }
        return bT(e.dJ(adTemplate));
    }

    public static BusinessType bT(int i) {
        if (i == 3) {
            return BusinessType.AD_FULLSCREEN;
        }
        if (i == 2) {
            return BusinessType.AD_REWARD;
        }
        if (i == 4) {
            return BusinessType.AD_SPLASH;
        }
        if (i == 13) {
            return BusinessType.AD_INTERSTITIAL;
        }
        if (i == 1) {
            return BusinessType.AD_FEED;
        }
        if (i == 10000) {
            return BusinessType.AD_NATIVE;
        }
        return BusinessType.OTHER;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate aT(AdTemplate adTemplate) {
        String str;
        SceneImpl sceneImpl = adTemplate.mAdScene;
        if (sceneImpl == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.cb(adTemplate).adDataV2;
        int adStyle = sceneImpl.getAdStyle();
        if (adStyle != 2) {
            if (adStyle != 3) {
                if (adStyle != 4) {
                    if (adStyle != 13) {
                        str = "";
                    } else {
                        str = adDataV2.interstitialCardInfo.templateId;
                    }
                } else {
                    str = adDataV2.splashPlayCardTKInfo.templateId;
                }
            } else {
                str = adDataV2.fullScreenInfo.templateId;
            }
        } else {
            str = adDataV2.neoTKInfo.templateId;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : com.kwad.sdk.core.response.b.b.cc(adTemplate)) {
            if (bg.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return com.kwad.sdk.core.response.b.b.k(adTemplate, str);
    }
}
