package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f74079a;

    /* renamed from: b  reason: collision with root package name */
    public String f74080b;

    public c(int i2, String str) {
        this.f74079a = i2;
        this.f74080b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f74079a);
            jSONObject.put("body", this.f74080b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
