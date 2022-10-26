package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.u;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ar implements com.kwad.sdk.core.d {
    public static void a(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == JSONObject.NULL) {
            aVar.templateId = "";
        }
        aVar.abz = jSONObject.optString("template_show_type");
        if (jSONObject.opt("template_show_type") == JSONObject.NULL) {
            aVar.abz = "";
        }
        aVar.abA = jSONObject.optInt("award_task_name");
    }

    public static JSONObject b(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "template_id", aVar.templateId);
        }
        String str2 = aVar.abz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "template_show_type", aVar.abz);
        }
        int i = aVar.abA;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "award_task_name", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((u.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((u.a) bVar, jSONObject);
    }
}
