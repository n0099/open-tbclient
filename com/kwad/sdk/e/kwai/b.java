package com.kwad.sdk.e.kwai;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tachikoma.core.component.network.delegate.TKBaseResponseInner;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements com.kwad.sdk.e.e<TKBaseResponseInner> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public void a(TKBaseResponseInner tKBaseResponseInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKBaseResponseInner.body = jSONObject.optString(TtmlNode.TAG_BODY);
        tKBaseResponseInner.statusCode = jSONObject.optInt("statusCode");
        tKBaseResponseInner.allHeaderFields = jSONObject.optString("allHeaderFields");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKBaseResponseInner tKBaseResponseInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.e.f.a(jSONObject, TtmlNode.TAG_BODY, tKBaseResponseInner.body);
        com.kwad.sdk.e.f.a(jSONObject, "statusCode", tKBaseResponseInner.statusCode);
        com.kwad.sdk.e.f.a(jSONObject, "allHeaderFields", tKBaseResponseInner.allHeaderFields);
        return jSONObject;
    }
}
