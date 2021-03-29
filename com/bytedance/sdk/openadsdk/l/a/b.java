package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29751a = e.f29767a;

    /* renamed from: b  reason: collision with root package name */
    public int f29752b;

    /* renamed from: c  reason: collision with root package name */
    public String f29753c;

    public b(int i, String str) {
        this.f29752b = 0;
        this.f29753c = "";
        this.f29752b = i;
        this.f29753c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29751a);
            jSONObject.put("sdkThreadCount", this.f29752b);
            jSONObject.put("sdkThreadNames", this.f29753c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
