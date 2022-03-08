package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.ReportInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class dm implements com.kwad.sdk.core.d<ReportInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(ReportInfo reportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        reportInfo.reportId = jSONObject.optInt("reportId");
        reportInfo.content = jSONObject.optString("content");
        if (jSONObject.opt("content") == JSONObject.NULL) {
            reportInfo.content = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(ReportInfo reportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "reportId", reportInfo.reportId);
        com.kwad.sdk.utils.t.a(jSONObject, "content", reportInfo.content);
        return jSONObject;
    }
}
