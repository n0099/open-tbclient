package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class g implements com.kwad.sdk.core.webview.kwai.a {
    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "getKsAdConfig";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (com.kwad.sdk.core.config.b.aP() != null) {
            cVar.a(com.kwad.sdk.core.config.b.aP());
        } else {
            cVar.a(-1, "no config data");
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
