package com.kwad.sdk.utils;

import java.util.Map;
/* loaded from: classes10.dex */
public final class af {
    public Map<String, com.kwad.sdk.core.webview.a> aNM;
    public Map<String, com.kwad.sdk.core.webview.c.c> aNN;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.aNM.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aNN.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a fS(String str) {
        return this.aNM.get(str);
    }

    public final com.kwad.sdk.core.webview.c.c fT(String str) {
        return this.aNN.get(str);
    }

    public final void release() {
        for (com.kwad.sdk.core.webview.a aVar : this.aNM.values()) {
            aVar.oa();
        }
        this.aNM.clear();
        this.aNN.clear();
    }
}
