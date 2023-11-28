package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class m implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.b VP;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cancelAppDownload";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String url;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", this.url);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.url = jSONObject.optString("url");
        }
    }

    public m(com.kwad.sdk.core.webview.b bVar) {
        this.VP = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String str2 = aVar.url;
            if (TextUtils.isEmpty(str2)) {
                cVar.onError(-1, "no download url specified");
                return;
            }
            com.kwad.sdk.core.download.a.cZ(str2);
            cVar.a(null);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            cVar.onError(-1, th.getMessage());
        }
    }
}
