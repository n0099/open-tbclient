package com.kwad.sdk.e.kwai;

import com.tachikoma.core.component.network.TKErrorInner;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f implements com.kwad.sdk.e.e<TKErrorInner> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public void a(TKErrorInner tKErrorInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKErrorInner.name = jSONObject.optString("name");
        tKErrorInner.code = jSONObject.optInt("code");
        tKErrorInner.msg = jSONObject.optString("msg");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKErrorInner tKErrorInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.e.f.a(jSONObject, "name", tKErrorInner.name);
        com.kwad.sdk.e.f.a(jSONObject, "code", tKErrorInner.code);
        com.kwad.sdk.e.f.a(jSONObject, "msg", tKErrorInner.msg);
        return jSONObject;
    }
}
