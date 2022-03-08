package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC2109a a;

    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2109a {
        void a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "callButtonImpressionWhenFinish";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC2109a interfaceC2109a = this.a;
        if (interfaceC2109a != null) {
            interfaceC2109a.a();
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
