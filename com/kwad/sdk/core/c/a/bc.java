package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.ReportInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bc implements com.kwad.sdk.core.c<ReportInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(ReportInfo reportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        reportInfo.reportId = jSONObject.optInt("reportId");
        reportInfo.content = jSONObject.optString("content");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(ReportInfo reportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "reportId", reportInfo.reportId);
        com.kwad.sdk.utils.o.a(jSONObject, "content", reportInfo.content);
        return jSONObject;
    }
}
