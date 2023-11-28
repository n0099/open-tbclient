package com.kwad.sdk.core.b.a;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.kwad.components.core.webview.jshandler.bb;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ju implements com.kwad.sdk.core.d<bb.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(bb.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.XN = jSONObject.optInt(TaskStatus.key);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(bb.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.XN;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, TaskStatus.key, i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(bb.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(bb.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
