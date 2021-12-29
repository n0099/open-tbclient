package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n implements com.kwad.sdk.core.webview.kwai.a {
    public a a;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.kwad.sdk.core.webview.a.kwai.b bVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "updateVideoMuteState";
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.a != null) {
            com.kwad.sdk.core.webview.a.kwai.b bVar = new com.kwad.sdk.core.webview.a.kwai.b();
            try {
                bVar.parseJson(new JSONObject(str));
                this.a.a(bVar);
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
