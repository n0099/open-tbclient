package com.kwad.sdk.draw.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.e.b {
    @Nullable
    public KsDrawAd.AdInteractionListener a;
    @NonNull
    public AdBaseFrameLayout b;
    @NonNull
    public AdTemplate c;
    @Nullable
    public com.kwad.sdk.core.download.a.b d;
    @NonNull
    public com.kwad.sdk.draw.b.a e;
    @NonNull
    public com.kwad.sdk.draw.a.a.a f;
    @Nullable
    public com.kwad.sdk.i.b g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.d;
        if (bVar != null) {
            bVar.i();
        }
        this.e.e();
    }
}
