package com.kwad.components.ad.draw.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.c.a.c;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes8.dex */
public final class b extends com.kwad.sdk.mvp.a {
    @Nullable
    public KsDrawAd.AdInteractionListener aJ;
    @NonNull
    public com.kwad.components.ad.draw.b.a aL;
    @NonNull
    public com.kwad.components.ad.draw.a.a.a ba;
    @Nullable
    public com.kwad.components.ad.i.b bb;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public c mApkDownloadHelper;
    @NonNull
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.aL.release();
    }
}
