package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.TaskStat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dy implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.j> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.request.model.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.b = jSONObject.optInt("personalRecommend");
        jVar.c = jSONObject.optInt("programmaticRecommend");
        jVar.d = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                TaskStat taskStat = new TaskStat();
                taskStat.parseJson(optJSONArray.optJSONObject(i));
                jVar.d.add(taskStat);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.request.model.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "personalRecommend", jVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "programmaticRecommend", jVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "taskStats", jVar.d);
        return jSONObject;
    }
}
