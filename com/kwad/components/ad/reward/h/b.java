package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public class b implements com.kwad.sdk.core.webview.kwai.a {
    public a tK;

    /* loaded from: classes10.dex */
    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        ie();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    public void ie() {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.tK = null;
    }
}
