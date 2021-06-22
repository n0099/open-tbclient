package com.kwad.sdk.draw.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.e.b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f35272a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f35273b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f35274c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35275d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f35276e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.draw.b.b.a f35277f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public c f35278g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.b.b bVar = this.f35275d;
        if (bVar != null) {
            bVar.f();
        }
        this.f35276e.e();
    }
}
