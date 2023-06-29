package com.kwad.components.core.webview.b;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0654a Nb;

    /* renamed from: com.kwad.components.core.webview.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0654a {
        void ii();
    }

    public a(InterfaceC0654a interfaceC0654a) {
        this.Nb = interfaceC0654a;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC0654a interfaceC0654a = this.Nb;
        if (interfaceC0654a != null) {
            interfaceC0654a.ii();
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
