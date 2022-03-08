package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class k extends i {
    public boolean a = true;

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerVideoProgressListener";
    }

    public void a(com.kwad.sdk.core.webview.a.kwai.f fVar) {
        com.kwad.sdk.core.d.a.a("RegisterVideoProgress", "setData enable: " + this.a);
        if (fVar != null) {
            com.kwad.sdk.core.d.a.a("RegisterVideoProgress", "setData data: " + fVar.toJson());
        }
        if (this.a) {
            super.a((com.kwad.sdk.core.response.kwai.a) fVar);
        }
    }

    public void a(boolean z) {
        this.a = z;
    }
}
