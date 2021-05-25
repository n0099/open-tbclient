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
    public KsSplashScreenAd.SplashScreenAdInteractionListener f33985a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsVideoPlayConfig f33986b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f33987c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f33988d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f33989e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33990f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public KsScene f33991g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.b f33992h;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f33989e;
        if (aVar != null) {
            aVar.f();
        }
    }
}
