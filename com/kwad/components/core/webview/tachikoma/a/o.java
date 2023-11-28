package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class o extends w {
    public a ZA;

    /* loaded from: classes10.dex */
    public interface a {
        boolean isMuted();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMuteStateListener";
    }

    public final void a(a aVar) {
        this.ZA = aVar;
    }

    public final void c(com.kwad.components.core.webview.tachikoma.b.m mVar) {
        super.b(mVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        if (this.ZA != null) {
            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
            mVar.aaa = this.ZA.isMuted();
            cVar.a(mVar);
        }
    }
}
