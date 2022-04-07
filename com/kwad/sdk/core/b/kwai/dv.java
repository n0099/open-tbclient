package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dv implements com.kwad.sdk.core.d<AdMatrixInfo.SplashInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdMatrixInfo.SplashInfo splashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.SplashInteractionInfo splashInteractionInfo = new AdMatrixInfo.SplashInteractionInfo();
        splashInfo.interactionInfo = splashInteractionInfo;
        splashInteractionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdMatrixInfo.SplashInfo splashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "interactionInfo", splashInfo.interactionInfo);
        return jSONObject;
    }
}
