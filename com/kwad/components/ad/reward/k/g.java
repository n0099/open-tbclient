package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    public int xi;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public g(int i) {
        this.xi = i;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.f fVar = new com.kwad.components.core.webview.tachikoma.b.f();
        fVar.ZU = this.xi;
        cVar.a(fVar);
    }
}
