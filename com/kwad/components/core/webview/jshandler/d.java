package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "base64";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.j jVar = new com.kwad.components.core.webview.tachikoma.b.j();
        try {
            jVar.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        a aVar = new a();
        if (TextUtils.isEmpty(jVar.data)) {
            aVar.data = "";
        } else {
            aVar.data = new String(com.kwad.sdk.core.a.c.Ci().encode(jVar.data.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
        }
        cVar.a(aVar);
    }
}
