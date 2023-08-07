package com.kwad.components.ad.f.kwai.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.kwai.c;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public c kr;

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull c cVar) {
        this.kr = cVar;
    }

    public final void ey() {
        c cVar = this.kr;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.kr = null;
    }
}
