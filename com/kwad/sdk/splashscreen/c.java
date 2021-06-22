package com.kwad.sdk.splashscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f37511a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsVideoPlayConfig f37512b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f37513c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f37514d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f37515e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37516f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public KsScene f37517g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.b f37518h;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar = this.f37515e;
        if (aVar != null) {
            aVar.f();
        }
    }
}
