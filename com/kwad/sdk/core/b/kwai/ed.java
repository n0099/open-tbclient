package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.kwad.sdk.core.request.model.TaskStat;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ed implements com.kwad.sdk.core.d<TaskStat> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(TaskStat taskStat, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        taskStat.adStyle = jSONObject.optInt("adStyle");
        taskStat.taskType = jSONObject.optInt(StatConstants.KEY_EXT_TASK_TYPE);
        taskStat.count = jSONObject.optInt("count");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(TaskStat taskStat, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adStyle", taskStat.adStyle);
        com.kwad.sdk.utils.t.a(jSONObject, StatConstants.KEY_EXT_TASK_TYPE, taskStat.taskType);
        com.kwad.sdk.utils.t.a(jSONObject, "count", taskStat.count);
        return jSONObject;
    }
}
