package com.kwad.sdk.splashscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f34811a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsVideoPlayConfig f34812b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34813c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f34814d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f34815e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34816f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public KsScene f34817g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.b f34818h;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f34815e;
        if (aVar != null) {
            aVar.f();
        }
    }
}
