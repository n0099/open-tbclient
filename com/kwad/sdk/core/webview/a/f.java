package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.core.webview.kwai.a {
    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.webview.a.kwai.a aVar = new com.kwad.sdk.core.webview.a.kwai.a();
        aVar.a = com.kwad.sdk.core.config.b.t();
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
