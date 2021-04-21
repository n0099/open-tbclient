package com.bytedance.sdk.openadsdk.l.a;

import com.bytedance.sdk.openadsdk.l.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f29444a = e.f29460a;

    /* renamed from: b  reason: collision with root package name */
    public int f29445b;

    /* renamed from: c  reason: collision with root package name */
    public String f29446c;

    public b(int i, String str) {
        this.f29445b = 0;
        this.f29446c = "";
        this.f29445b = i;
        this.f29446c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f29444a);
            jSONObject.put("sdkThreadCount", this.f29445b);
            jSONObject.put("sdkThreadNames", this.f29446c);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
