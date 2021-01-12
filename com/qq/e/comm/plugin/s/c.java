package com.qq.e.comm.plugin.s;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    int f12447a;

    /* renamed from: b  reason: collision with root package name */
    String f12448b;
    String c;
    String d;
    String e;

    public c(JSONObject jSONObject) {
        this.f12447a = jSONObject.optInt("type");
        this.f12448b = jSONObject.optString("cta_txt");
        this.c = jSONObject.optString("form_url");
        this.d = jSONObject.optString("consult_url");
        this.e = jSONObject.optString("tel");
    }

    public int a() {
        return this.f12447a;
    }

    public String b() {
        return this.f12448b;
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
