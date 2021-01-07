package com.kwad.sdk.draw.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.e.b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f9974a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f9975b;
    @NonNull
    public AdTemplate c;
    @Nullable
    public com.kwad.sdk.core.download.b.b d;
    @NonNull
    public com.kwad.sdk.draw.c.a e;
    @NonNull
    public com.kwad.sdk.draw.b.b.a f;
    @Nullable
    public c g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        if (this.d != null) {
            this.d.f();
        }
        this.e.e();
    }
}
