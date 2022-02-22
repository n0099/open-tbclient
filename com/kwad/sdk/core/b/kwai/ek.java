package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ek implements com.kwad.sdk.core.d<URLPackage> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        uRLPackage.identity = jSONObject.optString("identity");
        if (jSONObject.opt("identity") == JSONObject.NULL) {
            uRLPackage.identity = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "page", uRLPackage.page);
        com.kwad.sdk.utils.t.a(jSONObject, "identity", uRLPackage.identity);
        return jSONObject;
    }
}
