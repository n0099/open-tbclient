package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class v implements com.kwad.sdk.core.webview.c.a {
    public a ZE;

    /* loaded from: classes10.dex */
    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.b.m mVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ZE = null;
    }

    public final void a(a aVar) {
        this.ZE = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ZE != null) {
            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
            try {
                mVar.parseJson(new JSONObject(str));
                this.ZE.b(mVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
