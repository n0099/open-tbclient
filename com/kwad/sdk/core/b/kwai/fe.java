package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fe implements com.kwad.sdk.core.d<StatusInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.a = jSONObject.optInt("personalRecommend");
        statusInfo.b = jSONObject.optInt("programmaticRecommend");
        StatusInfo.SplashAdInfo splashAdInfo = new StatusInfo.SplashAdInfo();
        statusInfo.c = splashAdInfo;
        splashAdInfo.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        statusInfo.d = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(optJSONArray.optJSONObject(i));
                statusInfo.d.add(fVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "personalRecommend", statusInfo.a);
        com.kwad.sdk.utils.r.a(jSONObject, "programmaticRecommend", statusInfo.b);
        com.kwad.sdk.utils.r.a(jSONObject, "splashAdInfo", statusInfo.c);
        com.kwad.sdk.utils.r.a(jSONObject, "taskStats", statusInfo.d);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo statusInfo, JSONObject jSONObject) {
        a2(statusInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        return b2(statusInfo, jSONObject);
    }
}
