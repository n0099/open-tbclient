package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f37056a;

    /* renamed from: b  reason: collision with root package name */
    public String f37057b;

    public c(int i2, String str) {
        this.f37056a = i2;
        this.f37057b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f37056a);
            jSONObject.put("body", this.f37057b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
