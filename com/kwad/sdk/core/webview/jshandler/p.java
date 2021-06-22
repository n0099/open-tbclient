package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class p implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f35146a;

    /* renamed from: b  reason: collision with root package name */
    public a f35147b = new a();

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f35148a;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerVideoListener";
    }

    public void a(int i2) {
        com.kwad.sdk.core.webview.a.c cVar = this.f35146a;
        if (cVar != null) {
            a aVar = this.f35147b;
            aVar.f35148a = i2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f35146a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f35146a = null;
    }
}
