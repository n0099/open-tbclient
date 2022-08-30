package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class g implements f {
    public AdInfo mAdInfo;

    public g(AdTemplate adTemplate) {
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, int i2, int i3) {
    }

    @Override // com.kwad.sdk.core.download.f
    public void a(String str, int i, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, int i, String str2, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str, String str2, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void al(String str) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void b(String str, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void c(String str, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void d(String str, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final void e(String str, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final String mJ() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.f
    public final String mK() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }
}
