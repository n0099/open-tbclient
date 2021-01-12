package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class b implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9559a;

    /* renamed from: b  reason: collision with root package name */
    private a f9560b;

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public b(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        this.f9559a = aVar;
        this.f9560b = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f9560b.a();
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
