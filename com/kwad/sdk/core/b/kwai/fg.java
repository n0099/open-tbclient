package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.yy.hiidostatis.inner.GeneralConfigTool;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fg implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.a = jSONObject.optInt("adStyle");
        fVar.b = jSONObject.optInt(StatConstants.KEY_EXT_TASK_TYPE);
        fVar.c = jSONObject.optInt("count");
        fVar.d = jSONObject.optLong(GeneralConfigTool.KEY_LAST_MODIFIED_TIME);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "adStyle", fVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, StatConstants.KEY_EXT_TASK_TYPE, fVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "count", fVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, GeneralConfigTool.KEY_LAST_MODIFIED_TIME, fVar.d);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }
}
