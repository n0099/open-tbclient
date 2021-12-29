package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveStatusResultData extends BaseResultData {
    public static final long serialVersionUID = 4029640509861990549L;
    public LiveStatus liveStatus = new LiveStatus();

    /* loaded from: classes3.dex */
    public static class LiveStatus implements b, Serializable {
        public static final long serialVersionUID = -5609658944971506312L;
        public String liveStreamId;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.liveStreamId = jSONObject.optString("liveStreamId");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "liveStreamId", this.liveStreamId);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        LiveStatus liveStatus = this.liveStatus;
        return liveStatus == null || at.a(liveStatus.liveStreamId);
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("data");
            if (at.a(optString)) {
                return;
            }
            this.liveStatus.parseJson(new JSONObject(d.b(optString)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "data", this.liveStatus);
        return json;
    }
}
