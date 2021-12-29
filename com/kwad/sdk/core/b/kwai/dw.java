package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dw implements com.kwad.sdk.core.d<AdMatrixInfo.SplashInteractionInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdMatrixInfo.SplashInteractionInfo splashInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashInteractionInfo.interactiveStyle = jSONObject.optInt("interactiveStyle");
        AdMatrixInfo.ShakeInfo shakeInfo = new AdMatrixInfo.ShakeInfo();
        splashInteractionInfo.shakeInfo = shakeInfo;
        shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdMatrixInfo.SplashInteractionInfo splashInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "interactiveStyle", splashInteractionInfo.interactiveStyle);
        com.kwad.sdk.utils.t.a(jSONObject, "shakeInfo", splashInteractionInfo.shakeInfo);
        return jSONObject;
    }
}
