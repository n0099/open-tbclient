package com.qq.e.comm.plugin.ab.b;

import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f11718a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f11719b;

    public b(String str, JSONObject jSONObject) {
        this.f11718a = str;
        this.f11719b = jSONObject;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("try {");
        sb.append("bridge.dispatch").append("({'type':'").append(this.f11718a).append("','param':").append(this.f11719b == null ? "null" : JSONObject.quote(this.f11719b.toString())).append("})");
        sb.append("} catch(e) { console.log(e) }");
        return sb.toString();
    }
}
