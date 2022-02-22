package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class r implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c a;

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }

    public void c() {
        com.kwad.sdk.core.webview.kwai.c cVar = this.a;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    public void d() {
        com.kwad.sdk.core.webview.kwai.c cVar = this.a;
        if (cVar != null) {
            cVar.a(-1, "deep link error");
        }
    }
}
