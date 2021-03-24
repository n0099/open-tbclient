package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29750a = e.f29766a;

    /* renamed from: b  reason: collision with root package name */
    public int f29751b;

    /* renamed from: c  reason: collision with root package name */
    public String f29752c;

    public b(int i, String str) {
        this.f29751b = 0;
        this.f29752c = "";
        this.f29751b = i;
        this.f29752c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29750a);
            jSONObject.put("sdkThreadCount", this.f29751b);
            jSONObject.put("sdkThreadNames", this.f29752c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
