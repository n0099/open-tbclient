package com.kwad.components.core.webview.b;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0601a Nb;

    /* renamed from: com.kwad.components.core.webview.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0601a {
        void ii();
    }

    public a(InterfaceC0601a interfaceC0601a) {
        this.Nb = interfaceC0601a;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC0601a interfaceC0601a = this.Nb;
        if (interfaceC0601a != null) {
            interfaceC0601a.ii();
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
