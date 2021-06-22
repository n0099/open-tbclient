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
    public KsNativeAd.AdInteractionListener f32305a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f32306b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32307c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32308d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32309e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.a.c.a f32310f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.b.b bVar = this.f32309e;
        if (bVar != null) {
            bVar.f();
        }
        this.f32310f.e();
    }
}
