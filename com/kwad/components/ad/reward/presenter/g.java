package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class g {
    public static boolean r(com.kwad.components.ad.reward.k kVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = kVar.mAdTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if ((com.kwad.sdk.core.response.a.a.aY(bQ) && (aVar = kVar.mk) != null && aVar.od()) || com.kwad.sdk.core.response.a.b.bg(adTemplate) || com.kwad.components.ad.reward.kwai.b.j(bQ) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.kwai.b.gh()) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.am(bQ) && com.kwad.sdk.core.response.a.a.aa(bQ);
    }
}
