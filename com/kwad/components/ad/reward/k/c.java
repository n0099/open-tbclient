package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public class c implements com.kwad.sdk.core.webview.c.a {
    public a xc;

    /* loaded from: classes10.dex */
    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    public void iV() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xc = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        iV();
    }
}
