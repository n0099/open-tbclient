package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    public a xd;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.b.p pVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xd = null;
    }

    public final void a(a aVar) {
        this.xd = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.p pVar = new com.kwad.components.core.webview.tachikoma.b.p();
        try {
            pVar.parseJson(new JSONObject(str));
            if (this.xd != null) {
                this.xd.a(pVar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
