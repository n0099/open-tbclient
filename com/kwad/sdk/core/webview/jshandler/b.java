package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34703a;

    /* renamed from: b  reason: collision with root package name */
    public a f34704b;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public b(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        this.f34703a = aVar;
        this.f34704b = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34704b.a();
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
