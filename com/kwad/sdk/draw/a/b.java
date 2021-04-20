package com.kwad.sdk.draw.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.e.b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f34812a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34813b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34814c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34815d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f34816e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.draw.b.b.a f34817f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public c f34818g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.b.b bVar = this.f34815d;
        if (bVar != null) {
            bVar.f();
        }
        this.f34816e.e();
    }
}
