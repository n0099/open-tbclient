package com.xiaomi.push;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    public int f40706a;

    /* renamed from: a  reason: collision with other field name */
    public long f186a;

    /* renamed from: a  reason: collision with other field name */
    public String f187a;

    /* renamed from: b  reason: collision with root package name */
    public long f40707b;

    /* renamed from: c  reason: collision with root package name */
    public long f40708c;

    public cn() {
        this(0, 0L, 0L, null);
    }

    public cn(int i, long j, long j2, Exception exc) {
        this.f40706a = i;
        this.f186a = j;
        this.f40708c = j2;
        this.f40707b = System.currentTimeMillis();
        if (exc != null) {
            this.f187a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f40706a;
    }

    public cn a(JSONObject jSONObject) {
        this.f186a = jSONObject.getLong("cost");
        this.f40708c = jSONObject.getLong("size");
        this.f40707b = jSONObject.getLong("ts");
        this.f40706a = jSONObject.getInt("wt");
        this.f187a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m203a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f186a);
        jSONObject.put("size", this.f40708c);
        jSONObject.put("ts", this.f40707b);
        jSONObject.put("wt", this.f40706a);
        jSONObject.put("expt", this.f187a);
        return jSONObject;
    }
}
