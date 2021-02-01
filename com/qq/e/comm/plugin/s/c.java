package com.qq.e.comm.plugin.s;

import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    int f12449a;

    /* renamed from: b  reason: collision with root package name */
    String f12450b;
    String c;
    String d;
    String e;

    public c(JSONObject jSONObject) {
        this.f12449a = jSONObject.optInt("type");
        this.f12450b = jSONObject.optString("cta_txt");
        this.c = jSONObject.optString("form_url");
        this.d = jSONObject.optString("consult_url");
        this.e = jSONObject.optString("tel");
    }

    public int a() {
        return this.f12449a;
    }

    public String b() {
        return this.f12450b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}
