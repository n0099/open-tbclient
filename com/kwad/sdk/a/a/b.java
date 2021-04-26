package com.kwad.sdk.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.e.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f32457a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f32458b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32459c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32460d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32461e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.a.c.a f32462f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.b.b bVar = this.f32461e;
        if (bVar != null) {
            bVar.g();
        }
        this.f32462f.e();
    }
}
