package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g implements com.kwad.sdk.core.b {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;

    public static g a() {
        return new g();
    }

    public final void a(String str) {
        this.e = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "user_id", this.d);
        r.a(jSONObject, "thirdUserId", this.e);
        int i = this.a;
        if (i != 0) {
            r.a(jSONObject, "thirdAge", i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            r.a(jSONObject, "thirdGender", i2);
        }
        r.a(jSONObject, "thirdInterest", this.c);
        return jSONObject;
    }
}
