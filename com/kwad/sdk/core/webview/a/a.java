package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC2114a a;

    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2114a {
        void a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "callButtonImpressionWhenFinish";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC2114a interfaceC2114a = this.a;
        if (interfaceC2114a != null) {
            interfaceC2114a.a();
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
