package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class m implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.core.webview.a.c f9604a;

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f9604a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f9604a = null;
    }

    public void c() {
        if (this.f9604a != null) {
            this.f9604a.a(null);
        }
    }

    public void d() {
        if (this.f9604a != null) {
            this.f9604a.a(-1, "deep link error");
        }
    }
}
