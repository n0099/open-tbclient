package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public final class d implements com.kwad.sdk.core.webview.kwai.a {
    public a tM;

    /* loaded from: classes8.dex */
    public interface a {
        void id();
    }

    public final void a(a aVar) {
        this.tM = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = this.tM;
        if (aVar != null) {
            aVar.id();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.tM = null;
    }
}
