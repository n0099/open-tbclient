package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class i extends b<com.kwad.sdk.core.network.idc.a.b> {
    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
    }

    public i() {
        super("idc", new com.kwad.sdk.core.network.idc.a.b());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            com.kwad.sdk.core.network.idc.a.b bVar = new com.kwad.sdk.core.network.idc.a.b();
            bVar.parseJson(optJSONObject);
            setValue(bVar);
            return;
        }
        setValue(Bx());
    }
}
