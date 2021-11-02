package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f67185a;

    /* renamed from: b  reason: collision with root package name */
    public String f67186b;

    public c(int i2, String str) {
        this.f67185a = i2;
        this.f67186b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f67185a);
            jSONObject.put("body", this.f67186b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
