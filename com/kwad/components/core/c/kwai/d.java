package com.kwad.components.core.c.kwai;

import androidx.annotation.Nullable;
import com.kwad.components.core.c.kwai.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes9.dex */
public final class d extends com.kwad.sdk.mvp.a {
    @Nullable
    public b DG;
    public b.C0633b DH;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
    }
}
