package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class p implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34786a;

    /* renamed from: b  reason: collision with root package name */
    public a f34787b = new a();

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34788a;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerVideoListener";
    }

    public void a(int i) {
        com.kwad.sdk.core.webview.a.c cVar = this.f34786a;
        if (cVar != null) {
            a aVar = this.f34787b;
            aVar.f34788a = i;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34786a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34786a = null;
    }
}
