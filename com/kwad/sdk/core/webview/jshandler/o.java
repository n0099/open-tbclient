package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o implements com.kwad.sdk.core.webview.kwai.a {
    public a a;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.kwad.sdk.core.webview.kwai.i iVar);
    }

    public o(a aVar) {
        this.a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "openNewPage";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.webview.kwai.i iVar = new com.kwad.sdk.core.webview.kwai.i();
        try {
            iVar.parseJson(new JSONObject(str));
            if (this.a != null) {
                this.a.a(iVar);
            }
        } catch (Exception e2) {
            cVar.a(-1, "");
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}
