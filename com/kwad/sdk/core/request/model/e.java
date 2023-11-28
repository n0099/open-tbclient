package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e implements com.kwad.sdk.core.b {
    public com.kwad.sdk.core.b ayG;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    public static e DV() {
        e eVar = new e();
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            eVar.ayG = kVar.yc();
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "modeInfo", this.ayG);
        return jSONObject;
    }
}
