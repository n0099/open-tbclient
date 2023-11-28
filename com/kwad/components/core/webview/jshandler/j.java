package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.util.UUID;
/* loaded from: classes10.dex */
public final class j implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "uuid";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        aVar.data = UUID.randomUUID().toString();
        cVar.a(aVar);
    }
}
