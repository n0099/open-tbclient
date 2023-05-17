package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements com.kwad.sdk.core.webview.kwai.a {
    public void a(com.kwad.components.core.webview.b.a.f fVar) {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.webview.b.a.f fVar = new com.kwad.components.core.webview.b.a.f();
        try {
            fVar.parseJson(new JSONObject(str));
            a(fVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "commonLog";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
