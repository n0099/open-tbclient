package com.kwad.sdk.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class aa implements com.kwad.sdk.core.webview.kwai.a {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56395b;

    /* renamed from: c  reason: collision with root package name */
    public a f56396c;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a();
    }

    public aa(Context context, AdTemplate adTemplate) {
        this.a = context;
        this.f56395b = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "showPlayable";
    }

    public void a(a aVar) {
        this.f56396c = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = this.f56396c;
        boolean a2 = aVar != null ? aVar.a() : true;
        com.kwad.sdk.core.d.a.a("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + a2);
        if (a2) {
            com.kwad.sdk.core.page.a.a(this.a, this.f56395b);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
