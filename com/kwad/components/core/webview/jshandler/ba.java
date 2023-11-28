package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
/* loaded from: classes10.dex */
public final class ba implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.c.c VH;
    public a XM = new a();

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerVideoListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VH = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VH = cVar;
    }

    public final void aL(int i) {
        com.kwad.sdk.core.webview.c.c cVar = this.VH;
        if (cVar != null) {
            a aVar = this.XM;
            aVar.status = i;
            cVar.a(aVar);
        }
    }
}
