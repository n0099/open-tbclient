package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.yy.hiidostatis.inner.GeneralConfigTool;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fo implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt(StatConstants.KEY_EXT_TASK_TYPE);
        fVar.count = jSONObject.optInt("count");
        fVar.acW = jSONObject.optLong(GeneralConfigTool.KEY_LAST_MODIFIED_TIME);
    }

    public static JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.f) bVar, jSONObject);
    }
}
