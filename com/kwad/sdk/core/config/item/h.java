package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class h extends b<com.kwad.sdk.core.network.idc.kwai.a> {
    public h() {
        super("idc", new com.kwad.sdk.core.network.idc.kwai.a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(sx());
            return;
        }
        com.kwad.sdk.core.network.idc.kwai.a aVar = new com.kwad.sdk.core.network.idc.kwai.a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
