package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bl implements com.kwad.sdk.core.c<URLPackage> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        uRLPackage.identity = jSONObject.optString("identity");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "page", uRLPackage.page);
        com.kwad.sdk.utils.o.a(jSONObject, "identity", uRLPackage.identity);
        return jSONObject;
    }
}
