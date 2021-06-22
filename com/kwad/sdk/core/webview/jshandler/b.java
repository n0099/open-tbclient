package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35060a;

    /* renamed from: b  reason: collision with root package name */
    public a f35061b;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public b(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        this.f35060a = aVar;
        this.f35061b = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f35061b.a();
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
