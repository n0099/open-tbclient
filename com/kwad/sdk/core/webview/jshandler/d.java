package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;
    public b b;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int a;
        public int b;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "width", this.a);
            com.kwad.sdk.utils.t.a(jSONObject, "height", this.b);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(a aVar);
    }

    public d(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "getContainerLimit";
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = new a();
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.a = this.a.d.getWidth();
            aVar.b = this.a.d.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
