package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f11115a;

    /* renamed from: b  reason: collision with root package name */
    private String f11116b;

    public c(int i, String str) {
        this.f11115a = i;
        this.f11116b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f11115a);
            jSONObject.put("body", this.f11116b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
