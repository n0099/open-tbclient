package com.kwad.sdk.f.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.f.a;
/* loaded from: classes8.dex */
public class b extends com.kwad.sdk.core.e.b {
    @NonNull
    public a.InterfaceC2120a a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f55419b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f55420c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f55421d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55422e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.f.b.a f55423f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.f55422e;
        if (bVar != null) {
            bVar.i();
        }
        this.f55423f.e();
    }
}
