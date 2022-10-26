package com.kwad.sdk.core.b.kwai;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.kwad.components.core.webview.jshandler.ae;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fp implements com.kwad.sdk.core.d {
    public static void a(ae.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.MQ = jSONObject.optInt(TaskStatus.key);
    }

    public static JSONObject b(ae.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.MQ;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, TaskStatus.key, i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ae.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ae.a) bVar, jSONObject);
    }
}
