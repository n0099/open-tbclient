package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class g implements f {
    public AdInfo a;

    public g(AdTemplate adTemplate) {
        this.a = com.kwad.sdk.core.response.a.d.i(adTemplate);
    }

    @Override // com.kwad.sdk.core.download.f
    public final void a(String str) {
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
    public final String b() {
        return this.a.downloadId;
    }

    @Override // com.kwad.sdk.core.download.f
    public final void b(String str, h hVar) {
    }

    @Override // com.kwad.sdk.core.download.f
    public final String c() {
        return this.a.adBaseInfo.appPackageName;
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
}
