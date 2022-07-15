package com.kwad.sdk.core.download.kwai;

import com.kwad.sdk.api.KsAppDownloadListener;
/* loaded from: classes5.dex */
public abstract class a implements KsAppDownloadListener {
    public String d;

    public a() {
    }

    public a(String str) {
        this.d = str;
    }

    public void a(int i) {
    }

    public final String o() {
        return this.d;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }
}
