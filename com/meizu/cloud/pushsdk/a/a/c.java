package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f74459a;

    /* renamed from: b  reason: collision with root package name */
    public String f74460b;

    public c(int i2, String str) {
        this.f74459a = i2;
        this.f74460b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f74459a);
            jSONObject.put("body", this.f74460b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
