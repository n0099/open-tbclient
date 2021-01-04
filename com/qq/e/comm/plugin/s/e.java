package com.qq.e.comm.plugin.s;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f12748a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f12749b;

    public e(JSONObject jSONObject) {
        this.f12749b = jSONObject;
        this.f12748a = jSONObject == null ? null : jSONObject.optJSONObject("playcfg");
    }

    public JSONObject a() {
        return this.f12749b;
    }

    public String toString() {
        return this.f12749b == null ? "{}" : this.f12749b.toString();
    }
}
