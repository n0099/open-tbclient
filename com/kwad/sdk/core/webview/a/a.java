package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0318a a;

    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0318a {
        void a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "callButtonImpressionWhenFinish";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC0318a interfaceC0318a = this.a;
        if (interfaceC0318a != null) {
            interfaceC0318a.a();
        }
        c();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }

    public void c() {
    }
}
