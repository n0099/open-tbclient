package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29436a = e.f29452a;

    /* renamed from: b  reason: collision with root package name */
    public int f29437b;

    /* renamed from: c  reason: collision with root package name */
    public String f29438c;

    public b(int i, String str) {
        this.f29437b = 0;
        this.f29438c = "";
        this.f29437b = i;
        this.f29438c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29436a);
            jSONObject.put("sdkThreadCount", this.f29437b);
            jSONObject.put("sdkThreadNames", this.f29438c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
