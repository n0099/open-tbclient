package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f6245a;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("actionId")) {
                this.f6245a = jSONObject.optString("actionId");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "actionId", this.f6245a);
        return jSONObject;
    }
}
