package com.kwad.sdk.utils;

import java.util.Map;
/* loaded from: classes8.dex */
public final class ad {
    public Map<String, com.kwad.sdk.core.webview.a> anM;
    public Map<String, com.kwad.sdk.core.webview.kwai.c> anN;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.anM.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        this.anN.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a dK(String str) {
        return this.anM.get(str);
    }

    public final com.kwad.sdk.core.webview.kwai.c dL(String str) {
        return this.anN.get(str);
    }

    public final void release() {
        for (com.kwad.sdk.core.webview.a aVar : this.anM.values()) {
            aVar.mX();
        }
        this.anM.clear();
        this.anN.clear();
    }
}
