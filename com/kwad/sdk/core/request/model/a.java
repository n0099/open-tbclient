package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.core.b {
    public int a;
    public String b;
    public String c;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "level", this.a);
        t.a(jSONObject, "ssid", this.b);
        t.a(jSONObject, "bssid", this.c);
        return jSONObject;
    }
}
