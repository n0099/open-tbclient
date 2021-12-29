package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i implements com.kwad.sdk.core.b {
    public g a;

    public static i a() {
        i iVar = new i();
        iVar.a = g.a();
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "modeInfo", this.a);
        return jSONObject;
    }
}
