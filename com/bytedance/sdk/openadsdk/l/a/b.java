package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29522a = e.f29539a;

    /* renamed from: b  reason: collision with root package name */
    public int f29523b;

    /* renamed from: c  reason: collision with root package name */
    public String f29524c;

    public b(int i2, String str) {
        this.f29523b = 0;
        this.f29524c = "";
        this.f29523b = i2;
        this.f29524c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29522a);
            jSONObject.put("sdkThreadCount", this.f29523b);
            jSONObject.put("sdkThreadNames", this.f29524c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
