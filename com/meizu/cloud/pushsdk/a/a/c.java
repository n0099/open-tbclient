package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f37245a;

    /* renamed from: b  reason: collision with root package name */
    public String f37246b;

    public c(int i2, String str) {
        this.f37245a = i2;
        this.f37246b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f37245a);
            jSONObject.put("body", this.f37246b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
