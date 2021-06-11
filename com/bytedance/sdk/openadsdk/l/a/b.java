package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29625a = e.f29642a;

    /* renamed from: b  reason: collision with root package name */
    public int f29626b;

    /* renamed from: c  reason: collision with root package name */
    public String f29627c;

    public b(int i2, String str) {
        this.f29626b = 0;
        this.f29627c = "";
        this.f29626b = i2;
        this.f29627c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29625a);
            jSONObject.put("sdkThreadCount", this.f29626b);
            jSONObject.put("sdkThreadNames", this.f29627c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
