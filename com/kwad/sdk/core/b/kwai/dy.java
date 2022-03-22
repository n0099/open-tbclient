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
        jVar.f39844b = jSONObject.optInt("personalRecommend");
        jVar.f39845c = jSONObject.optInt("programmaticRecommend");
        jVar.f39846d = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                TaskStat taskStat = new TaskStat();
                taskStat.parseJson(optJSONArray.optJSONObject(i));
                jVar.f39846d.add(taskStat);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.request.model.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "personalRecommend", jVar.f39844b);
        com.kwad.sdk.utils.t.a(jSONObject, "programmaticRecommend", jVar.f39845c);
        com.kwad.sdk.utils.t.a(jSONObject, "taskStats", jVar.f39846d);
        return jSONObject;
    }
}
