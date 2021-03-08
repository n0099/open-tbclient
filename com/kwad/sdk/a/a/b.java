package com.kwad.sdk.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.e.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f5426a;
    @NonNull
    public KsNativeAd.VideoPlayListener b;
    @NonNull
    public AdBaseFrameLayout c;
    @NonNull
    public AdTemplate d;
    @Nullable
    public com.kwad.sdk.core.download.b.b e;
    @NonNull
    public com.kwad.sdk.a.c.a f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        if (this.e != null) {
            this.e.f();
        }
        this.f.e();
    }
}
