package com.kwad.components.ad.reward.k;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class u {
    @Nullable
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    public static u D(AdTemplate adTemplate) {
        u uVar = new u();
        uVar.setAdTemplate(adTemplate);
        return uVar;
    }

    public static u a(AdTemplate adTemplate, com.kwad.components.core.c.a.c cVar) {
        u uVar = new u();
        uVar.setAdTemplate(adTemplate);
        uVar.setApkDownloadHelper(cVar);
        return uVar;
    }

    private void setAdTemplate(@Nullable AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(@Nullable com.kwad.components.core.c.a.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Nullable
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Nullable
    public final com.kwad.components.core.c.a.c getApkDownloadHelper() {
        return this.mApkDownloadHelper;
    }
}
