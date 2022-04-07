package com.kwad.sdk.e.kwai;

import com.kuaishou.tachikoma.api.app.TKError;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e implements com.kwad.sdk.e.e<TKError> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public void a(TKError tKError, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKError.name = jSONObject.optString("name");
        tKError.code = jSONObject.optInt("code");
        tKError.msg = jSONObject.optString("msg");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKError tKError, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.e.f.a(jSONObject, "name", tKError.name);
        com.kwad.sdk.e.f.a(jSONObject, "code", tKError.code);
        com.kwad.sdk.e.f.a(jSONObject, "msg", tKError.msg);
        return jSONObject;
    }
}
