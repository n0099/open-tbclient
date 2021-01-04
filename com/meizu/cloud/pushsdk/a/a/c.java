package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f11414a;

    /* renamed from: b  reason: collision with root package name */
    private String f11415b;

    public c(int i, String str) {
        this.f11414a = i;
        this.f11415b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f11414a);
            jSONObject.put("body", this.f11415b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
