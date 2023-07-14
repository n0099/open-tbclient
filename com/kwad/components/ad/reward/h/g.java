package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class g implements com.kwad.sdk.core.webview.kwai.a {
    public a tO;

    /* loaded from: classes10.dex */
    public interface a {
        void id();
    }

    public g(a aVar) {
        this.tO = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = this.tO;
        if (aVar != null) {
            aVar.id();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.tO = null;
    }
}
