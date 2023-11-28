package com.kwad.components.ad.g.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.c.c;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    public c nr;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    public final void eD() {
        c cVar = this.nr;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nr = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.nr = cVar;
    }
}
