package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.b.a.n;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class j implements com.kwad.sdk.core.webview.kwai.a {
    public a tP;

    /* loaded from: classes10.dex */
    public interface a {
        void d(n nVar);
    }

    public final void a(a aVar) {
        this.tP = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.tP != null) {
            n nVar = new n();
            try {
                nVar.parseJson(new JSONObject(str));
                this.tP.d(nVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.tP = null;
    }
}
