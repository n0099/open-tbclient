package com.qq.e.comm.plugin.ab.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f12015a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f12016b;

    public b(String str, JSONObject jSONObject) {
        this.f12015a = str;
        this.f12016b = jSONObject;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("try {");
        sb.append("bridge.dispatch").append("({'type':'").append(this.f12015a).append("','param':").append(this.f12016b == null ? "null" : JSONObject.quote(this.f12016b.toString())).append("})");
        sb.append("} catch(e) { console.log(e) }");
        return sb.toString();
    }
}
