package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f37690a;

    /* renamed from: b  reason: collision with root package name */
    public String f37691b;

    public c(int i, String str) {
        this.f37690a = i;
        this.f37691b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f37690a);
            jSONObject.put("body", this.f37691b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
