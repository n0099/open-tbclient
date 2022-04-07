package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = -1;
    public int b = KsAdSDKImpl.get().isPersonalRecommend() ? 1 : 0;
    public int c = KsAdSDKImpl.get().isProgrammaticRecommend() ? 1 : 0;
    public List<TaskStat> d = com.kwad.sdk.core.c.a.b();

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.a = jSONObject.optInt("dataFlowAutoStartSwitch", -1);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        int i = this.a;
        if (i >= 0) {
            t.a(jSONObject, "dataFlowAutoStartSwitch", i);
        }
    }
}
