package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.components.core.webview.tachikoma.b.k Zs;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdExtraData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public g(com.kwad.components.core.webview.tachikoma.b.k kVar) {
        this.Zs = kVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.k kVar = this.Zs;
        if (kVar != null) {
            cVar.a(kVar);
        }
    }
}
