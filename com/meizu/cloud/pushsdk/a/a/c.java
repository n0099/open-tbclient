package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f67184a;

    /* renamed from: b  reason: collision with root package name */
    public String f67185b;

    public c(int i2, String str) {
        this.f67184a = i2;
        this.f67185b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f67184a);
            jSONObject.put("body", this.f67185b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
