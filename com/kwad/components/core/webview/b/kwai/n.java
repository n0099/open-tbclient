package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class n implements com.kwad.sdk.core.webview.kwai.a {
    public a NI;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.kwad.components.core.webview.b.a.i iVar);
    }

    public final void a(a aVar) {
        this.NI = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.NI != null) {
            com.kwad.components.core.webview.b.a.i iVar = new com.kwad.components.core.webview.b.a.i();
            try {
                iVar.parseJson(new JSONObject(str));
                this.NI.a(iVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.NI = null;
    }
}
