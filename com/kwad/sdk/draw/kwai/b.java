package com.kwad.sdk.draw.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.e.b {
    @Nullable
    public KsDrawAd.AdInteractionListener a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f56783b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56784c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56785d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f56786e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.draw.a.a.a f56787f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.i.b f56788g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.f56785d;
        if (bVar != null) {
            bVar.i();
        }
        this.f56786e.e();
    }
}
