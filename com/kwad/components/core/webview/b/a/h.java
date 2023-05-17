package com.kwad.components.core.webview.b.a;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class h extends com.kwad.sdk.core.response.kwai.a {
    public int NP;
    public int NQ = -1;

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.r.putValue(jSONObject, "insertScreenAdShowStrategy", this.NP);
        int i = this.NQ;
        if (i != -1) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "triggerType", i);
        }
        return jSONObject;
    }
}
