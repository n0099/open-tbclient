package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class k implements com.kwad.sdk.core.webview.kwai.a {
    public b LA;
    public final com.kwad.sdk.core.webview.b Lk;

    /* loaded from: classes9.dex */
    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.r.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.r.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(a aVar);
    }

    public k(com.kwad.sdk.core.webview.b bVar) {
        this.Lk = bVar;
    }

    public final void a(b bVar) {
        this.LA = bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        a aVar = new a();
        b bVar = this.LA;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.width = this.Lk.Gl.getWidth();
            aVar.height = this.Lk.Gl.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
