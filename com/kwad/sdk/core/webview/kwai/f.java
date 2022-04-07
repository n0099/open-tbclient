package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f implements com.kwad.sdk.core.b {
    public final int a = 1;
    public final com.kwad.sdk.core.b b;

    public f(com.kwad.sdk.core.b bVar) {
        this.b = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "result", this.a);
        t.a(jSONObject, "data", this.b);
        return jSONObject;
    }
}
