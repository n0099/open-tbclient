package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public String packageName;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "isAppInstalled";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean VG;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "isInstalled", this.VG);
            return jSONObject;
        }
    }

    public static boolean aA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.kwad.sdk.utils.ak.an(ServiceProvider.getContext(), str);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        a aVar = new a();
        aVar.VG = aA(bVar.packageName);
        cVar.a(aVar);
    }
}
