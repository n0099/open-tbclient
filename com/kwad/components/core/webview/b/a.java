package com.kwad.components.core.webview.b;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0644a Nb;

    /* renamed from: com.kwad.components.core.webview.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0644a {
        void ii();
    }

    public a(InterfaceC0644a interfaceC0644a) {
        this.Nb = interfaceC0644a;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        InterfaceC0644a interfaceC0644a = this.Nb;
        if (interfaceC0644a != null) {
            interfaceC0644a.ii();
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
