package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class d implements com.kwad.sdk.core.webview.kwai.a {
    public a a;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "clickGift";
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}
