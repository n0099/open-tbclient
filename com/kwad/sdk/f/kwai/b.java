package com.kwad.sdk.f.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.f.a;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.e.b {
    @NonNull
    public a.InterfaceC0320a a;
    @NonNull
    public KsNativeAd.VideoPlayListener b;
    @NonNull
    public AdBasePvFrameLayout c;
    @NonNull
    public AdTemplate d;
    @Nullable
    public com.kwad.sdk.core.download.a.b e;
    @NonNull
    public com.kwad.sdk.f.b.a f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.e;
        if (bVar != null) {
            bVar.i();
        }
        this.f.e();
    }
}
