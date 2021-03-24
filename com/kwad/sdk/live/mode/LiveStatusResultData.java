package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LiveStatusResultData extends BaseResultData {
    public static final long serialVersionUID = 4029640509861990549L;
    public LiveStatus liveStatus = new LiveStatus();

    /* loaded from: classes6.dex */
    public static class LiveStatus implements b, Serializable {
        public static final long serialVersionUID = -5609658944971506312L;
        public String liveStreamId;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.liveStreamId = jSONObject.optString("liveStreamId");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "liveStreamId", this.liveStreamId);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        LiveStatus liveStatus = this.liveStatus;
        return liveStatus == null || ag.a(liveStatus.liveStreamId);
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("data");
            if (ag.a(optString)) {
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
        o.a(json, "data", this.liveStatus);
        return json;
    }
}
