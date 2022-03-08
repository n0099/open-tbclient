package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class dl implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.m> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.bN = jSONObject.optString("ua");
        if (jSONObject.opt("ua") == JSONObject.NULL) {
            mVar.bN = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "ua", mVar.bN);
        return jSONObject;
    }
}
