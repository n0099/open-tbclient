package com.kwad.sdk.splashscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.sdk.core.download.a.c {
    public AdTemplate b;
    public AdInfo c;

    public a(AdTemplate adTemplate) {
        this.b = adTemplate;
        this.c = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    private void b(int i) {
        a(e.a(this.b, this.c, i));
    }

    @Override // com.kwad.sdk.core.download.a.c
    public void a(int i) {
        b(4);
    }

    public void a(AdTemplate adTemplate) {
        this.b = adTemplate;
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
    public void onProgressUpdate(int i) {
        b(2);
    }
}
