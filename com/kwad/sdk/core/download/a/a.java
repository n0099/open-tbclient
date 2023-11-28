package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;
/* loaded from: classes10.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }

    public a() {
    }

    public final String nN() {
        return this.downloadId;
    }

    public a(String str) {
        this.downloadId = str;
    }
}
