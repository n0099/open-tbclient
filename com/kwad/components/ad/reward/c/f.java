package com.kwad.components.ad.reward.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    public d qf;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    public f(d dVar) {
        this.qf = dVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.qf != null) {
                        f.this.qf.a(bVar);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qf = null;
    }
}
