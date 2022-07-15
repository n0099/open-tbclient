package com.kwad.sdk.utils;

import java.util.Map;
/* loaded from: classes5.dex */
public final class ab {
    public Map<String, com.kwad.sdk.core.webview.a> a;
    public Map<String, com.kwad.sdk.core.webview.kwai.c> b;

    public final com.kwad.sdk.core.webview.a a(String str) {
        return this.a.get(str);
    }

    public final void a() {
        for (com.kwad.sdk.core.webview.a aVar : this.a.values()) {
            aVar.j();
        }
        this.a.clear();
        this.b.clear();
    }

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.a.put(str, aVar);
    }

    public final void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        this.b.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.kwai.c b(String str) {
        return this.b.get(str);
    }
}
