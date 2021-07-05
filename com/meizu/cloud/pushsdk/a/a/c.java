package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f40042a;

    /* renamed from: b  reason: collision with root package name */
    public String f40043b;

    public c(int i2, String str) {
        this.f40042a = i2;
        this.f40043b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f40042a);
            jSONObject.put("body", this.f40043b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
