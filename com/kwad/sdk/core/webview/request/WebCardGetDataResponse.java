package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final String TAG = "WebCardGetDataResponse";
    public static final long serialVersionUID = 2407409365862659643L;
    public String data;

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("data");
            com.kwad.sdk.core.e.b.d(TAG, "WebCardGetDataResponse dataStr=" + optString);
            if (ax.dT(optString)) {
                return;
            }
            this.data = d.getResponseData(optString);
            com.kwad.sdk.core.e.b.d(TAG, "WebCardGetDataResponse data=" + this.data);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        r.putValue(json, "data", this.data);
        return json;
    }
}
