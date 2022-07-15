package com.kwad.sdk.core.webview.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.core.webview.request.WebCardGetDataResponse;
import com.kwad.sdk.core.webview.request.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b implements com.kwad.sdk.core.webview.kwai.a {
    public c a;

    @KsJson
    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public String a;
        public String b;
        public String c;
    }

    private void a(a aVar) {
        new com.kwad.sdk.core.webview.request.b().a(aVar, new b.a() { // from class: com.kwad.sdk.core.webview.a.b.1
            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void a(int i, String str) {
                if (b.this.a != null) {
                    b.this.a.a(i, str);
                }
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void a(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
                if (b.this.a != null) {
                    b.this.a.a(webCardGetDataResponse);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        return "requestData";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull c cVar) {
        this.a = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            a(aVar);
        } catch (JSONException e) {
            c cVar2 = this.a;
            if (cVar2 != null) {
                cVar2.a(-1, "data parse json error.");
            }
            com.kwad.sdk.core.d.b.b(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        this.a = null;
    }
}
