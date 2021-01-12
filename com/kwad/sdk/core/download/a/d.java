package com.kwad.sdk.core.download.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes4.dex */
public class d extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public int f9098a;

    /* renamed from: b  reason: collision with root package name */
    protected e f9099b;
    protected KsDrawAd.AdInteractionListener c;
    @NonNull
    public AdBaseFrameLayout d;
    @NonNull
    public AdTemplate e;
    @Nullable
    public com.kwad.sdk.core.download.b.b f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        if (this.f != null) {
            this.f.f();
        }
    }
}
