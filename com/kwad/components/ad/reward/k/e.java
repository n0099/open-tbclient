package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    public a xe;

    /* loaded from: classes10.dex */
    public interface a {
        void iU();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xe = null;
    }

    public final void a(a aVar) {
        this.xe = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.xe;
        if (aVar != null) {
            aVar.iU();
        }
    }
}
