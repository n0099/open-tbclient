package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f37400a;

    /* renamed from: b  reason: collision with root package name */
    public String f37401b;

    public c(int i, String str) {
        this.f37400a = i;
        this.f37401b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f37400a);
            jSONObject.put("body", this.f37401b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
