package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ag implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getScreenOrientation";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    /* loaded from: classes10.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int screenOrientation;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenOrientation", this.screenOrientation);
            return jSONObject;
        }
    }

    public ag(com.kwad.sdk.core.webview.b bVar) {
        this.VP = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.VP.FE()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        KsAdSDKImpl.get().getContext();
        aVar.screenOrientation = !com.kwad.sdk.utils.ai.Kx() ? 1 : 0;
        cVar.a(aVar);
    }
}
