package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class d implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34038a;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("actionId")) {
                this.f34038a = jSONObject.optString("actionId");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "actionId", this.f34038a);
        return jSONObject;
    }
}
