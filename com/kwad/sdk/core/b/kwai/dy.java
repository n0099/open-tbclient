package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.TaskStat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class dy implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.j> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.request.model.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.f54741b = jSONObject.optInt("personalRecommend");
        jVar.f54742c = jSONObject.optInt("programmaticRecommend");
        jVar.f54743d = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                TaskStat taskStat = new TaskStat();
                taskStat.parseJson(optJSONArray.optJSONObject(i2));
                jVar.f54743d.add(taskStat);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.request.model.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "personalRecommend", jVar.f54741b);
        com.kwad.sdk.utils.t.a(jSONObject, "programmaticRecommend", jVar.f54742c);
        com.kwad.sdk.utils.t.a(jSONObject, "taskStats", jVar.f54743d);
        return jSONObject;
    }
}
