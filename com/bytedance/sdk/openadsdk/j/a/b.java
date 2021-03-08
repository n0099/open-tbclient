package com.bytedance.sdk.openadsdk.j.a;

import com.bytedance.sdk.openadsdk.j.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f4862a = e.f4866a;
    private int b;
    private String c;

    public b(int i, String str) {
        this.b = 0;
        this.c = "";
        this.b = i;
        this.c = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cupCount", this.f4862a);
            jSONObject.put("sdkThreadCount", this.b);
            jSONObject.put("sdkThreadNames", this.c);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
