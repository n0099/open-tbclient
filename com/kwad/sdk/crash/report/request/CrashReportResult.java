package com.kwad.sdk.crash.report.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CrashReportResult extends BaseResultData implements com.kwad.sdk.core.b {
    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getResult() {
        return this.result;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return super.toJson();
    }
}
