package com.qq.e.comm.plugin.ab.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f12016a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f12017b;

    public b(String str, JSONObject jSONObject) {
        this.f12016a = str;
        this.f12017b = jSONObject;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("try {");
        sb.append("bridge.dispatch").append("({'type':'").append(this.f12016a).append("','param':").append(this.f12017b == null ? "null" : JSONObject.quote(this.f12017b.toString())).append("})");
        sb.append("} catch(e) { console.log(e) }");
        return sb.toString();
    }
}
