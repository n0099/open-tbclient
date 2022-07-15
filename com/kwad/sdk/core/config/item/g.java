package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g extends b<com.kwad.sdk.core.network.idc.kwai.a> {
    public g() {
        super("idc", new com.kwad.sdk.core.network.idc.kwai.a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) {
            a((g) c());
            return;
        }
        com.kwad.sdk.core.network.idc.kwai.a aVar = new com.kwad.sdk.core.network.idc.kwai.a();
        aVar.parseJson(optJSONObject);
        a((g) aVar);
    }
}
