package com.qq.e.comm.plugin.s;

import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f12451a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f12452b;

    public e(JSONObject jSONObject) {
        this.f12452b = jSONObject;
        this.f12451a = jSONObject == null ? null : jSONObject.optJSONObject("playcfg");
    }

    public JSONObject a() {
        return this.f12452b;
    }

    public String toString() {
        return this.f12452b == null ? "{}" : this.f12452b.toString();
    }
}
