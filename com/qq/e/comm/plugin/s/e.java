package com.qq.e.comm.plugin.s;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f12449a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f12450b;

    public e(JSONObject jSONObject) {
        this.f12450b = jSONObject;
        this.f12449a = jSONObject == null ? null : jSONObject.optJSONObject("playcfg");
    }

    public JSONObject a() {
        return this.f12450b;
    }

    public String toString() {
        return this.f12450b == null ? "{}" : this.f12450b.toString();
    }
}
