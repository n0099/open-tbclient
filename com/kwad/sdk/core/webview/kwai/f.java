package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b agl;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.agl = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "result", this.result);
        r.a(jSONObject, "data", this.agl);
        return jSONObject;
    }
}
