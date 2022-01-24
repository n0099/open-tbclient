package com.kwad.sdk.splashscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public abstract class a extends com.kwad.sdk.core.download.a.c {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57805b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f57806c;

    public a(AdTemplate adTemplate) {
        this.f57805b = adTemplate;
        this.f57806c = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    private void b(int i2) {
        a(e.a(this.f57805b, this.f57806c, i2));
    }

    @Override // com.kwad.sdk.core.download.a.c
    public void a(int i2) {
        b(4);
    }

    public void a(AdTemplate adTemplate) {
        this.f57805b = adTemplate;
    }

    public abstract void a(String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        b(7);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        b(8);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        b(0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        b(12);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i2) {
        b(2);
    }
}
