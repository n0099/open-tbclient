package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f38181a;

    /* renamed from: b  reason: collision with root package name */
    public String f38182b;

    public c(int i2, String str) {
        this.f38181a = i2;
        this.f38182b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f38181a);
            jSONObject.put("body", this.f38182b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
