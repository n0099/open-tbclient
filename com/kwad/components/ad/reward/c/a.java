package com.kwad.components.ad.reward.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class a implements KsInnerAd {
    @NonNull
    public final AdTemplate mAdTemplate;
    public final int oQ;

    public a(@NonNull AdTemplate adTemplate, int i) {
        this.mAdTemplate = adTemplate;
        this.oQ = i;
    }

    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.oQ;
    }
}
