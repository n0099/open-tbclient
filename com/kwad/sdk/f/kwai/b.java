package com.kwad.sdk.f.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.f.a;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.core.e.b {
    @NonNull
    public a.InterfaceC2141a a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f57069b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f57070c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f57071d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57072e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.f.b.a f57073f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.f57072e;
        if (bVar != null) {
            bVar.i();
        }
        this.f57073f.e();
    }
}
