package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class k {
    public static void h(g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if ((!com.kwad.sdk.core.response.b.a.bH(dP) || (aVar = gVar.oK) == null || !aVar.pU()) && !com.kwad.components.ad.reward.a.b.k(dP) && !adTemplate.mXiaomiAppStoreDetailViewOpen && com.kwad.sdk.core.response.b.a.aF(dP) && com.kwad.sdk.core.response.b.a.at(dP) && !adTemplate.hasEnterAdWebViewLandPageActivity) {
            gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
            DownloadLandPageActivity.launch(context, adTemplate, true);
        }
    }
}
