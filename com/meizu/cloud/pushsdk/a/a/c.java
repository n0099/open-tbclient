package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f11415a;

    /* renamed from: b  reason: collision with root package name */
    private String f11416b;

    public c(int i, String str) {
        this.f11415a = i;
        this.f11416b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f11415a);
            jSONObject.put("body", this.f11416b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
