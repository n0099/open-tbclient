package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f58383b = KsAdSDKImpl.get().isPersonalRecommend() ? 1 : 0;

    /* renamed from: c  reason: collision with root package name */
    public int f58384c = KsAdSDKImpl.get().isProgrammaticRecommend() ? 1 : 0;

    /* renamed from: d  reason: collision with root package name */
    public List<TaskStat> f58385d = com.kwad.sdk.core.c.a.b();

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.a = jSONObject.optInt("dataFlowAutoStartSwitch", -1);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        int i2 = this.a;
        if (i2 >= 0) {
            t.a(jSONObject, "dataFlowAutoStartSwitch", i2);
        }
    }
}
