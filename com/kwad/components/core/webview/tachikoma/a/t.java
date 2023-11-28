package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    public a ZC;

    /* loaded from: classes10.dex */
    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.b.t tVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ZC = null;
    }

    public final void a(a aVar) {
        this.ZC = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ZC != null) {
            com.kwad.components.core.webview.tachikoma.b.t tVar = new com.kwad.components.core.webview.tachikoma.b.t();
            try {
                try {
                    tVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.ZC.b(tVar);
            }
        }
    }
}
