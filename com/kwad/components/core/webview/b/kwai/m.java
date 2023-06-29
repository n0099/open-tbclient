package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.b.a.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class m implements com.kwad.sdk.core.webview.kwai.a {
    public a NH;

    /* loaded from: classes10.dex */
    public interface a {
        void b(q qVar);
    }

    public final void a(a aVar) {
        this.NH = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (this.NH != null) {
            q qVar = new q();
            try {
                try {
                    qVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.NH.b(qVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.NH = null;
    }
}
