package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class k extends com.kwad.sdk.core.response.a.a {
    public int ZW;
    public int ZX = -1;
    public int ZY;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.t.putValue(jSONObject, "insertScreenAdShowStrategy", this.ZW);
        com.kwad.sdk.utils.t.putValue(jSONObject, "isAutoShow", this.ZY);
        int i = this.ZX;
        if (i != -1) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i);
        }
        return jSONObject;
    }
}
