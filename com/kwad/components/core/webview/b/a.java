package com.kwad.components.core.webview.b;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0607a Nb;

    /* renamed from: com.kwad.components.core.webview.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0607a {
        void ii();
    }

    public a(InterfaceC0607a interfaceC0607a) {
        this.Nb = interfaceC0607a;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC0607a interfaceC0607a = this.Nb;
        if (interfaceC0607a != null) {
            interfaceC0607a.ii();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
