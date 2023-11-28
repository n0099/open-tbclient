package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class v implements com.kwad.sdk.core.webview.c.a {
    public void a(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void b(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void c(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void d(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.webview.tachikoma.b.x xVar = new com.kwad.components.core.webview.tachikoma.b.x();
        try {
            xVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.1
            @Override // java.lang.Runnable
            public final void run() {
                if (xVar.sH()) {
                    v.this.a(xVar);
                } else if (xVar.sJ()) {
                    v.this.d(xVar);
                } else if (xVar.sI()) {
                    v.this.c(xVar);
                } else if (xVar.isFailed()) {
                    v.this.b(xVar);
                }
            }
        });
    }
}
