package com.kwad.sdk.splashscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public abstract class a extends com.kwad.sdk.core.download.a.c {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f60037b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f60038c;

    public a(AdTemplate adTemplate) {
        this.f60037b = adTemplate;
        this.f60038c = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    private void b(int i2) {
        a(e.a(this.f60037b, this.f60038c, i2));
    }

    @Override // com.kwad.sdk.core.download.a.c
    public void a(int i2) {
        b(4);
    }

    public void a(AdTemplate adTemplate) {
        this.f60037b = adTemplate;
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
