package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.core.webview.kwai.a {
    public a a;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.kwad.sdk.core.webview.a.kwai.c cVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "clickCall";
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public void a(com.kwad.sdk.core.webview.a.kwai.c cVar) {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.webview.a.kwai.c cVar2 = new com.kwad.sdk.core.webview.a.kwai.c();
        try {
            cVar2.parseJson(new JSONObject(str));
            if (this.a != null) {
                this.a.a(cVar2);
            }
            a(cVar2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}
