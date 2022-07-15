package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e implements com.kwad.sdk.core.b {
    public com.kwad.sdk.core.b a;

    public static e a() {
        e eVar = new e();
        k kVar = (k) ServiceProvider.a(k.class);
        if (kVar != null) {
            eVar.a = kVar.a();
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "modeInfo", this.a);
        return jSONObject;
    }
}
