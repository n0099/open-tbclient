package com.xiaomi.push;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    public int f37467a;

    /* renamed from: a  reason: collision with other field name */
    public long f186a;

    /* renamed from: a  reason: collision with other field name */
    public String f187a;

    /* renamed from: b  reason: collision with root package name */
    public long f37468b;

    /* renamed from: c  reason: collision with root package name */
    public long f37469c;

    public cn() {
        this(0, 0L, 0L, null);
    }

    public cn(int i2, long j, long j2, Exception exc) {
        this.f37467a = i2;
        this.f186a = j;
        this.f37469c = j2;
        this.f37468b = System.currentTimeMillis();
        if (exc != null) {
            this.f187a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f37467a;
    }

    public cn a(JSONObject jSONObject) {
        this.f186a = jSONObject.getLong("cost");
        this.f37469c = jSONObject.getLong("size");
        this.f37468b = jSONObject.getLong("ts");
        this.f37467a = jSONObject.getInt("wt");
        this.f187a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m205a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f186a);
        jSONObject.put("size", this.f37469c);
        jSONObject.put("ts", this.f37468b);
        jSONObject.put("wt", this.f37467a);
        jSONObject.put("expt", this.f187a);
        return jSONObject;
    }
}
