package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29707a = e.f29724a;

    /* renamed from: b  reason: collision with root package name */
    public int f29708b;

    /* renamed from: c  reason: collision with root package name */
    public String f29709c;

    public b(int i2, String str) {
        this.f29708b = 0;
        this.f29709c = "";
        this.f29708b = i2;
        this.f29709c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29707a);
            jSONObject.put("sdkThreadCount", this.f29708b);
            jSONObject.put("sdkThreadNames", this.f29709c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
