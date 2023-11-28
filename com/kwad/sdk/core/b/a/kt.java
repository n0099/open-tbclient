package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class kt implements com.kwad.sdk.core.d<WebCloseStatus> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webCloseStatus.interactSuccess = jSONObject.optBoolean("interactSuccess");
        webCloseStatus.closeType = jSONObject.optInt("closeType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = webCloseStatus.interactSuccess;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interactSuccess", z);
        }
        int i = webCloseStatus.closeType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeType", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        a2(webCloseStatus, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        return b2(webCloseStatus, jSONObject);
    }
}
