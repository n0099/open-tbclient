package com.kwad.sdk.core.webview.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final String TAG = "WebCardGetDataResponse";
    public static final long serialVersionUID = 2407409365862659643L;
    public String data;

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a(TAG, "jo=" + jSONObject.toString());
        String optString = jSONObject.optString("egid");
        if (!TextUtils.isEmpty(optString)) {
            e.a(optString);
        }
        try {
            String optString2 = jSONObject.optString("data");
            com.kwad.sdk.core.d.a.a(TAG, "WebCardGetDataResponse dataStr=" + optString2);
            if (at.a(optString2)) {
                return;
            }
            this.data = d.b(optString2);
            com.kwad.sdk.core.d.a.a(TAG, "WebCardGetDataResponse data=" + this.data);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "data", this.data);
        return json;
    }
}
