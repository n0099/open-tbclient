package com.qq.e.comm.plugin.s;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f12749a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f12750b;

    public e(JSONObject jSONObject) {
        this.f12750b = jSONObject;
        this.f12749a = jSONObject == null ? null : jSONObject.optJSONObject("playcfg");
    }

    public JSONObject a() {
        return this.f12750b;
    }

    public String toString() {
        return this.f12750b == null ? "{}" : this.f12750b.toString();
    }
}
