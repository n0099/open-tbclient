package com.kwad.sdk.commercial.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class a {
    public static void a(@Nullable SceneImpl sceneImpl, long j, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(0.01d).a(com.kwad.sdk.commercial.c.bT(sceneImpl.getAdStyle())).L("ad_sdk_ad_parse_performance", "").u(c.zW().ct(str).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bB(@NonNull AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, "llsid", "");
            }
            if (e.dZ(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo dP = e.dP(adTemplate);
            int i = dP.adBaseInfo.adOperationType;
            if (i == 1) {
                String cL = com.kwad.sdk.core.response.b.a.cL(dP);
                if (bn.gt(cL)) {
                    c(adTemplate, "download_url", cL);
                }
            } else if (i == 2) {
                String aS = com.kwad.sdk.core.response.b.a.aS(dP);
                if (bn.gt(aS)) {
                    c(adTemplate, "h5_url", aS);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature N = com.kwad.sdk.core.response.b.a.N(dP);
            int i2 = N.featureType;
            String str = N.materialUrl;
            if (i2 == 1) {
                if (bn.gt(str)) {
                    c(adTemplate, "video_url", str);
                }
            } else if (i2 == 2) {
                if (bn.gt(str)) {
                    c(adTemplate, EditHeadActivityConfig.IMAGE_URL, str);
                }
            } else if (i2 == 3) {
                long cg = com.kwad.sdk.core.response.b.a.cg(dP);
                String bg = com.kwad.sdk.core.response.b.a.bg(dP);
                if (cg == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(bg)) {
                    c(adTemplate, "live_stream_id", bg);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(0.01d).a(com.kwad.sdk.commercial.c.aS(adTemplate)).L("ad_sdk_ad_data_performance", "error_name").u(b.zV().cr(str).cs(str2).setAdTemplate(adTemplate)));
    }

    public static void e(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }
}
