package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class z implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c Lb;

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.Lb = cVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    public final void kU() {
        com.kwad.sdk.core.webview.kwai.c cVar = this.Lb;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Lb = null;
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.kwai.c cVar = this.Lb;
        if (cVar != null) {
            cVar.a(null);
        }
    }
}
