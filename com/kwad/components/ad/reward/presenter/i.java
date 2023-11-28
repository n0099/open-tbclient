package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class i {
    public static boolean x(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bH(dP) && (aVar = gVar.oK) != null && aVar.pU()) || com.kwad.components.ad.reward.a.b.k(dP) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.gz()) {
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(dP) || !com.kwad.sdk.core.response.b.a.at(dP)) {
            return false;
        }
        return true;
    }
}
