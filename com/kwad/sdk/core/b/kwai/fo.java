package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.yy.hiidostatis.inner.GeneralConfigTool;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class fo implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt(StatConstants.KEY_EXT_TASK_TYPE);
        fVar.count = jSONObject.optInt("count");
        fVar.acW = jSONObject.optLong(GeneralConfigTool.KEY_LAST_MODIFIED_TIME);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = fVar.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adStyle", i);
        }
        int i2 = fVar.taskType;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, StatConstants.KEY_EXT_TASK_TYPE, i2);
        }
        int i3 = fVar.count;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "count", i3);
        }
        long j = fVar.acW;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, GeneralConfigTool.KEY_LAST_MODIFIED_TIME, j);
        }
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
