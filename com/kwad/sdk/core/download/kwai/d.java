package com.kwad.sdk.core.download.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.core.e.b {
    public int a;
    public e b;
    @NonNull
    public AdBaseFrameLayout c;
    @NonNull
    public AdTemplate d;
    @Nullable
    public com.kwad.sdk.core.download.a.b e;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.e;
        if (bVar != null) {
            bVar.i();
        }
    }
}
