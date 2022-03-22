package com.kwad.sdk.f.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.f.a;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.e.b {
    @NonNull
    public a.InterfaceC1981a a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f40467b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f40468c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f40469d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40470e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.f.b.a f40471f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.core.download.a.b bVar = this.f40470e;
        if (bVar != null) {
            bVar.i();
        }
        this.f40471f.e();
    }
}
