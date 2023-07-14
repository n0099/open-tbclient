package com.kwad.components.core.webview.b;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0659a Nb;

    /* renamed from: com.kwad.components.core.webview.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0659a {
        void ii();
    }

    public a(InterfaceC0659a interfaceC0659a) {
        this.Nb = interfaceC0659a;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC0659a interfaceC0659a = this.Nb;
        if (interfaceC0659a != null) {
            interfaceC0659a.ii();
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
