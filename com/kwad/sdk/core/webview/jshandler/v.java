package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class v implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c a;

    /* renamed from: b  reason: collision with root package name */
    public a f56670b = new a();

    /* loaded from: classes4.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int a;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerVideoListener";
    }

    public void a(int i2) {
        com.kwad.sdk.core.webview.kwai.c cVar = this.a;
        if (cVar != null) {
            a aVar = this.f56670b;
            aVar.a = i2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}
