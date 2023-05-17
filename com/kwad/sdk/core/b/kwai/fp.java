package com.kwad.sdk.core.b.kwai;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.kwad.components.core.webview.jshandler.ae;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class fp implements com.kwad.sdk.core.d<ae.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ae.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.MQ = jSONObject.optInt(TaskStatus.key);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ae.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.MQ;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, TaskStatus.key, i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ae.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ae.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
