package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;
/* loaded from: classes3.dex */
public abstract class c implements KsAppDownloadListener {
    public String a;

    public c() {
    }

    public c(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public void a(int i2) {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }
}
