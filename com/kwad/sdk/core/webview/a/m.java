package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m implements com.kwad.sdk.core.webview.kwai.a {
    public a a;

    /* loaded from: classes5.dex */
    public interface a {
        void a(com.kwad.sdk.core.webview.a.kwai.e eVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "skipVideo";
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.a != null) {
            com.kwad.sdk.core.webview.a.kwai.e eVar = new com.kwad.sdk.core.webview.a.kwai.e();
            try {
                try {
                    eVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.a.a(eVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}
