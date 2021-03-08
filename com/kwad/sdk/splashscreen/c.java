package com.kwad.sdk.splashscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f7099a;
    @NonNull
    public KsVideoPlayConfig b;
    @NonNull
    public AdTemplate c;
    @NonNull
    public AdBaseFrameLayout d;
    @Nullable
    public com.kwad.sdk.splashscreen.b.a e;
    public com.kwad.sdk.core.download.b.b f;
    @NonNull
    public KsScene g;
    public com.kwad.sdk.core.i.b h;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        if (this.e != null) {
            this.e.f();
        }
    }
}
