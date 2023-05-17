package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public final class f implements com.kwad.sdk.core.webview.kwai.a {
    public int tN;

    public f(int i) {
        this.tN = i;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.webview.b.a.e eVar = new com.kwad.components.core.webview.b.a.e();
        eVar.NN = this.tN;
        cVar.a(eVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
