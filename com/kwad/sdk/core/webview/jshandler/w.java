package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.request.WebCardGetDataResponse;
import com.kwad.sdk.core.webview.request.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c a;

    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public String a;
        public String b;
        public String c;
    }

    private void a(a aVar) {
        new com.kwad.sdk.core.webview.request.b().a(aVar, new b.a() { // from class: com.kwad.sdk.core.webview.jshandler.w.1
            @Override // com.kwad.sdk.core.webview.request.b.a
            public void a() {
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public void a(int i, String str) {
                if (w.this.a != null) {
                    w.this.a.a(i, str);
                }
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public void a(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
                if (w.this.a != null) {
                    w.this.a.a(webCardGetDataResponse);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "requestData";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.a = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            a(aVar);
        } catch (JSONException e) {
            com.kwad.sdk.core.webview.kwai.c cVar2 = this.a;
            if (cVar2 != null) {
                cVar2.a(-1, "data parse json error.");
            }
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
    }
}
