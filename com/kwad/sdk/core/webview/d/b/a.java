package com.kwad.sdk.core.webview.d.b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import org.json.JSONException;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public final class a extends com.kwad.sdk.core.response.a.a {
    public String KM;
    public boolean Kq;
    @Deprecated
    public boolean Xl;
    public int Xn;
    public c Xo;
    public int aDH;
    public int aDI;
    public AdTemplate adTemplate;
    public int kk;
    public boolean KC = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aDJ = false;
    public boolean aDK = false;

    public final boolean FS() {
        if (1 == this.Xn) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.kk == 0 && this.aDI == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                    this.kk = optJSONObject.getInt("itemClickType");
                    this.aDI = optJSONObject.getInt("sceneType");
                    this.aDJ = optJSONObject.optBoolean("isCallbackOnly");
                }
                String optString = jSONObject.optString("adTemplate");
                if (!bg.isNullString(optString)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        AdTemplate adTemplate = new AdTemplate();
                        this.adTemplate = adTemplate;
                        adTemplate.parseJson(jSONObject2);
                        com.kwad.sdk.commercial.f.a.bB(this.adTemplate);
                    } catch (JSONException e) {
                        ServiceProvider.b(e);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
