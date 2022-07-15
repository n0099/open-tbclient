package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f implements com.kwad.sdk.core.b {
    public final int a = 1;
    public final com.kwad.sdk.core.b b;

    public f(com.kwad.sdk.core.b bVar) {
        this.b = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "result", this.a);
        r.a(jSONObject, "data", this.b);
        return jSONObject;
    }
}
