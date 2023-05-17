package com.kwad.components.ad.e.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.e.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
/* loaded from: classes9.dex */
public final class b extends com.kwad.sdk.mvp.a {
    @NonNull
    public KsNativeAd.VideoPlayListener jA;
    @NonNull
    public c.a jC;
    @NonNull
    public AdBasePvFrameLayout jK;
    @NonNull
    public com.kwad.components.ad.e.b.a jM;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.jM.release();
    }
}
