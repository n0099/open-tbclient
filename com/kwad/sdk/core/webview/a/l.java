package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l implements com.kwad.sdk.core.webview.kwai.a {
    public a a;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.kwad.sdk.core.webview.a.kwai.d dVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.a != null) {
            com.kwad.sdk.core.webview.a.kwai.d dVar = new com.kwad.sdk.core.webview.a.kwai.d();
            try {
                dVar.parseJson(new JSONObject(str));
                this.a.a(dVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}
