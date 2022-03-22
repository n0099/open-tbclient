package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.ReportAction;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ai implements com.kwad.sdk.core.d<ReportAction.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(ReportAction.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("posIdWidth");
        aVar.f39697b = jSONObject.optInt("posIdHeight");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(ReportAction.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "posIdWidth", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "posIdHeight", aVar.f39697b);
        return jSONObject;
    }
}
