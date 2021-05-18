package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29593a = e.f29610a;

    /* renamed from: b  reason: collision with root package name */
    public int f29594b;

    /* renamed from: c  reason: collision with root package name */
    public String f29595c;

    public b(int i2, String str) {
        this.f29594b = 0;
        this.f29595c = "";
        this.f29594b = i2;
        this.f29595c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29593a);
            jSONObject.put("sdkThreadCount", this.f29594b);
            jSONObject.put("sdkThreadNames", this.f29595c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
