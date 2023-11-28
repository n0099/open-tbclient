package com.kwad.sdk.core.webview.c;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class d implements a {
    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        cVar.onError(-1, "DefaultHandler response data");
    }
}
