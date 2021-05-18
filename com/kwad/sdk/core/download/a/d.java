package com.kwad.sdk.core.download.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public int f32206a;

    /* renamed from: b  reason: collision with root package name */
    public e f32207b;

    /* renamed from: c  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f32208c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f32209d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32210e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32211f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.b.b bVar = this.f32211f;
        if (bVar != null) {
            bVar.g();
        }
    }
}
