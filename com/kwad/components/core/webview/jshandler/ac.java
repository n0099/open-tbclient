package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;
    public b Wu;

    /* loaded from: classes10.dex */
    public interface b {
        void c(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    public ac(com.kwad.sdk.core.webview.b bVar) {
        this.VP = bVar;
    }

    public final void a(b bVar) {
        this.Wu = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        b bVar = this.Wu;
        if (bVar != null) {
            bVar.c(aVar);
        } else {
            aVar.width = this.VP.Ov.getWidth();
            aVar.height = this.VP.Ov.getHeight();
        }
        cVar.a(aVar);
    }
}
