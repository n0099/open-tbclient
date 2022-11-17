package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.u;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ar implements com.kwad.sdk.core.d<u.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(u.a aVar, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(u.a aVar, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(u.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(u.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
