package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC2097a a;

    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2097a {
        void a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "callButtonImpressionWhenFinish";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC2097a interfaceC2097a = this.a;
        if (interfaceC2097a != null) {
            interfaceC2097a.a();
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
