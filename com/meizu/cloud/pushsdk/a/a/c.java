package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f11117a;

    /* renamed from: b  reason: collision with root package name */
    private String f11118b;

    public c(int i, String str) {
        this.f11117a = i;
        this.f11118b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f11117a);
            jSONObject.put("body", this.f11118b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
