package com.kwad.sdk.e.kwai;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.kuaishou.tachikoma.api.app.TKBaseResponse;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.e.e<TKBaseResponse> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public void a(TKBaseResponse tKBaseResponse, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKBaseResponse.body = jSONObject.optString(TtmlNode.TAG_BODY);
        tKBaseResponse.statusCode = jSONObject.optInt("statusCode");
        tKBaseResponse.allHeaderFields = jSONObject.optString("allHeaderFields");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKBaseResponse tKBaseResponse, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.e.f.a(jSONObject, TtmlNode.TAG_BODY, tKBaseResponse.body);
        com.kwad.sdk.e.f.a(jSONObject, "statusCode", tKBaseResponse.statusCode);
        com.kwad.sdk.e.f.a(jSONObject, "allHeaderFields", tKBaseResponse.allHeaderFields);
        return jSONObject;
    }
}
