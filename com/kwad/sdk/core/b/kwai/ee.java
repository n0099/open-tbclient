package com.kwad.sdk.core.b.kwai;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.kwad.sdk.core.webview.jshandler.x;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ee implements com.kwad.sdk.core.d<x.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt(TaskStatus.key);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, TaskStatus.key, aVar.a);
        return jSONObject;
    }
}
