package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.sdk.core.download.kwai.a {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Context mContext;

    public a(Context context, AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mContext = context;
    }

    private void X(int i) {
        Z(com.kwad.sdk.core.response.a.b.cb(this.mAdInfo) ? e.a(this.mAdTemplate, this.mAdInfo, i) : com.kwad.sdk.core.response.a.b.cd(this.mAdInfo) ? e.c(this.mAdInfo, i) : e.a(this.mAdInfo, i));
    }

    public abstract void Z(String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        X(7);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        X(8);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        X(0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        X(12);
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        X(4);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        X(2);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
