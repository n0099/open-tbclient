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
    public AdBaseFrameLayout f58959b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f58960c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58961d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f58962e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.draw.a.a.a f58963f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.i.b f58964g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.f58961d;
        if (bVar != null) {
            bVar.i();
        }
        this.f58962e.e();
    }
}
