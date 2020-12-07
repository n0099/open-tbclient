package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f4074a;
    private String b;

    public c(int i, String str) {
        this.f4074a = i;
        this.b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f4074a);
            jSONObject.put("body", this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
