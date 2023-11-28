package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dm implements com.kwad.sdk.core.d<AdStyleInfo.ExposeTagInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        exposeTagInfo.text = jSONObject.optString("text");
        if (JSONObject.NULL.toString().equals(exposeTagInfo.text)) {
            exposeTagInfo.text = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = exposeTagInfo.text;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "text", exposeTagInfo.text);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        a2(exposeTagInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        return b2(exposeTagInfo, jSONObject);
    }
}
