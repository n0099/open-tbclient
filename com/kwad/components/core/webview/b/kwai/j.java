package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.b.a.s;
/* loaded from: classes8.dex */
public class j extends e {
    public boolean Dv = true;

    public final void a(s sVar) {
        com.kwad.sdk.core.e.b.d("RegisterVideoProgress", "setData enable: " + this.Dv);
        if (sVar != null) {
            com.kwad.sdk.core.e.b.d("RegisterVideoProgress", "setData data: " + sVar.toJson());
        }
        if (this.Dv) {
            super.b(sVar);
        }
    }

    @Override // com.kwad.components.core.webview.b.kwai.e, com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        super.a(str, cVar);
    }

    public final void aD(boolean z) {
        this.Dv = false;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerVideoProgressListener";
    }
}
