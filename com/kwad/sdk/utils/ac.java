package com.kwad.sdk.utils;

import java.util.Map;
/* loaded from: classes7.dex */
public class ac {
    public Map<String, com.kwad.sdk.core.download.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, com.kwad.sdk.core.webview.kwai.c> f41344b;

    public com.kwad.sdk.core.download.a.b a(String str) {
        return this.a.get(str);
    }

    public void a() {
        for (com.kwad.sdk.core.download.a.b bVar : this.a.values()) {
            bVar.j();
        }
        this.a.clear();
        this.f41344b.clear();
    }

    public void a(String str, com.kwad.sdk.core.download.a.b bVar) {
        this.a.put(str, bVar);
    }

    public void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f41344b.put(str, cVar);
    }

    public com.kwad.sdk.core.webview.kwai.c b(String str) {
        return this.f41344b.get(str);
    }
}
