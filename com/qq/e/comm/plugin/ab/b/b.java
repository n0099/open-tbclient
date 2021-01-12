package com.qq.e.comm.plugin.ab.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f11716a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f11717b;

    public b(String str, JSONObject jSONObject) {
        this.f11716a = str;
        this.f11717b = jSONObject;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("try {");
        sb.append("bridge.dispatch").append("({'type':'").append(this.f11716a).append("','param':").append(this.f11717b == null ? "null" : JSONObject.quote(this.f11717b.toString())).append("})");
        sb.append("} catch(e) { console.log(e) }");
        return sb.toString();
    }
}
