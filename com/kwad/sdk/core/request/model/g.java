package com.kwad.sdk.core.request.model;

import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class g implements com.kwad.sdk.core.b {
    public String acX;
    public String acY;
    public int acZ;
    public int ada;
    public String adb;

    public static g uT() {
        return new g();
    }

    public final void cu(String str) {
        this.acY = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "user_id", this.acX);
        r.putValue(jSONObject, "thirdUserId", this.acY);
        int i = this.acZ;
        if (i != 0) {
            r.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = this.ada;
        if (i2 != 0) {
            r.putValue(jSONObject, "thirdGender", i2);
        }
        r.putValue(jSONObject, "thirdInterest", this.adb);
        return jSONObject;
    }
}
