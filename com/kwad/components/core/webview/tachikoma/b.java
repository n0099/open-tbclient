package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public a Yb;

    /* loaded from: classes10.dex */
    public interface a {
        void dL();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public b(a aVar) {
        this.Yb = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.Yb;
        if (aVar != null) {
            aVar.dL();
        }
    }
}
