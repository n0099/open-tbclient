package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.b.a.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k implements com.kwad.sdk.core.webview.kwai.a {
    public void a(o oVar) {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        o oVar = new o();
        try {
            oVar.parseJson(new JSONObject(str));
            a(oVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "showTKDialog";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
