package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class au implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c VH;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VH = null;
    }

    public final void onFailed() {
        com.kwad.sdk.core.webview.c.c cVar = this.VH;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.c.c cVar = this.VH;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VH = cVar;
    }
}
