package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class i implements com.kwad.sdk.core.webview.c.a {
    public a Zv;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.kwad.sdk.core.webview.d.b.a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "notifyClickAd";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public i(a aVar) {
        this.Zv = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        a aVar2 = this.Zv;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }
}
