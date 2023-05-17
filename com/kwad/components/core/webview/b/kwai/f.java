package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f implements com.kwad.sdk.core.webview.kwai.a {
    public void a(com.kwad.components.core.webview.b.a.j jVar) {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.webview.b.a.j jVar = new com.kwad.components.core.webview.b.a.j();
        try {
            jVar.parseJson(new JSONObject(str));
            a(jVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "openURL";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
