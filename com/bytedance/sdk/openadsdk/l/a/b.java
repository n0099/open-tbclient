package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f30348a = e.f30365a;

    /* renamed from: b  reason: collision with root package name */
    public int f30349b;

    /* renamed from: c  reason: collision with root package name */
    public String f30350c;

    public b(int i2, String str) {
        this.f30349b = 0;
        this.f30350c = "";
        this.f30349b = i2;
        this.f30350c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f30348a);
            jSONObject.put("sdkThreadCount", this.f30349b);
            jSONObject.put("sdkThreadNames", this.f30350c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
