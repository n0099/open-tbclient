package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fm implements com.kwad.sdk.core.d {
    public static void a(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.acS = jSONObject.optInt("personalRecommend");
        statusInfo.acT = jSONObject.optInt("programmaticRecommend");
        StatusInfo.SplashAdInfo splashAdInfo = new StatusInfo.SplashAdInfo();
        statusInfo.acU = splashAdInfo;
        splashAdInfo.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        statusInfo.acV = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(optJSONArray.optJSONObject(i));
                statusInfo.acV.add(fVar);
            }
        }
    }

    public static JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = statusInfo.acS;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "personalRecommend", i);
        }
        int i2 = statusInfo.acT;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "programmaticRecommend", i2);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "splashAdInfo", statusInfo.acU);
        com.kwad.sdk.utils.r.putValue(jSONObject, "taskStats", statusInfo.acV);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo) bVar, jSONObject);
    }
}
