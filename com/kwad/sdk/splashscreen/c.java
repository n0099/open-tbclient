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
    public KsSplashScreenAd.SplashScreenAdInteractionListener f36658a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsVideoPlayConfig f36659b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36660c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f36661d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f36662e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36663f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public KsScene f36664g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.b f36665h;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f36662e;
        if (aVar != null) {
            aVar.f();
        }
    }
}
