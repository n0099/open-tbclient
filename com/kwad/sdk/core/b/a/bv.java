package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bv implements com.kwad.sdk.core.d<y.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(aVar.templateId)) {
            aVar.templateId = "";
        }
        aVar.axc = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(aVar.axc)) {
            aVar.axc = "";
        }
        aVar.axd = jSONObject.optInt("award_task_name");
        aVar.axe = jSONObject.optInt("jumps_liveroom_type");
        aVar.axf = jSONObject.optInt("universe_feature_freg");
        aVar.axh = jSONObject.optInt("is_special_preload");
        aVar.axi = jSONObject.optInt("card_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_id", aVar.templateId);
        }
        String str2 = aVar.axc;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_show_type", aVar.axc);
        }
        int i = aVar.axd;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "award_task_name", i);
        }
        int i2 = aVar.axe;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jumps_liveroom_type", i2);
        }
        int i3 = aVar.axf;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universe_feature_freg", i3);
        }
        int i4 = aVar.axh;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_special_preload", i4);
        }
        int i5 = aVar.axi;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "card_type", i5);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
