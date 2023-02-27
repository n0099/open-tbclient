package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public final class d implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.components.core.webview.b.a.h NC;

    public d(com.kwad.components.core.webview.b.a.h hVar) {
        this.NC = hVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.webview.b.a.h hVar = this.NC;
        if (hVar != null) {
            cVar.a(hVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "getKsAdExtraData";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
