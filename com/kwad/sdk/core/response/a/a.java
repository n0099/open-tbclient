package com.kwad.sdk.core.response.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.c.a.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements b {
    public void afterParseJson(@Nullable JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        v.a(this).a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject a2 = v.a(this).a(this);
        afterToJson(a2);
        return a2;
    }
}
