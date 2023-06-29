package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
/* loaded from: classes10.dex */
public final class ad implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c Lb;
    public a MP = new a();

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.Lb = cVar;
    }

    public final void at(int i) {
        com.kwad.sdk.core.webview.kwai.c cVar = this.Lb;
        if (cVar != null) {
            a aVar = this.MP;
            aVar.status = i;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerVideoListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Lb = null;
    }
}
