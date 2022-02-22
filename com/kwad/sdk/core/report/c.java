package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class c extends com.kwad.sdk.core.response.kwai.a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f56263b;

    public JSONObject a() {
        JSONObject json = toJson();
        if (this.f56263b != null) {
            json.remove("mMergeJsonData");
            ax.a(json, this.f56263b);
        }
        return json;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.f56263b = jSONObject.optJSONObject("mMergeJsonData");
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.f56263b;
        if (jSONObject2 != null) {
            t.a(jSONObject, "mMergeJsonData", jSONObject2);
        }
    }
}
