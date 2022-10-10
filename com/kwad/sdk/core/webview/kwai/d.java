package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public final class d implements a {
    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull c cVar) {
        cVar.onError(-1, "DefaultHandler response data");
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
