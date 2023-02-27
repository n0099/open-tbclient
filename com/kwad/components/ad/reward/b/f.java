package com.kwad.components.ad.reward.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class f implements com.kwad.sdk.core.webview.kwai.a {
    public d nr;

    public f(d dVar) {
        this.nr = dVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.nr != null) {
                        f.this.nr.a(bVar);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.nr = null;
    }
}
