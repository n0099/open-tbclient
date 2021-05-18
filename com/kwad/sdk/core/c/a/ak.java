package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.p;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ak implements com.kwad.sdk.core.c<p.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f33001a = jSONObject.optInt("itemClickType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "itemClickType", aVar.f33001a);
        return jSONObject;
    }
}
