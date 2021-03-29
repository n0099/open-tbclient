package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class m implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34391a;

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34391a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34391a = null;
    }

    public void c() {
        com.kwad.sdk.core.webview.a.c cVar = this.f34391a;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    public void d() {
        com.kwad.sdk.core.webview.a.c cVar = this.f34391a;
        if (cVar != null) {
            cVar.a(-1, "deep link error");
        }
    }
}
