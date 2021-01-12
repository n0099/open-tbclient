package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BatchReportResult extends BaseResultData implements com.kwad.sdk.core.b {
    private long interval;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getResult() {
        return this.result;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        e.a(jSONObject.optString("egid"));
        this.interval = jSONObject.optLong("interval");
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "interval", this.interval);
        return json;
    }
}
