package com.xiaomi.push;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    public int f37396a;

    /* renamed from: a  reason: collision with other field name */
    public long f186a;

    /* renamed from: a  reason: collision with other field name */
    public String f187a;

    /* renamed from: b  reason: collision with root package name */
    public long f37397b;

    /* renamed from: c  reason: collision with root package name */
    public long f37398c;

    public cn() {
        this(0, 0L, 0L, null);
    }

    public cn(int i2, long j, long j2, Exception exc) {
        this.f37396a = i2;
        this.f186a = j;
        this.f37398c = j2;
        this.f37397b = System.currentTimeMillis();
        if (exc != null) {
            this.f187a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f37396a;
    }

    public cn a(JSONObject jSONObject) {
        this.f186a = jSONObject.getLong("cost");
        this.f37398c = jSONObject.getLong("size");
        this.f37397b = jSONObject.getLong("ts");
        this.f37396a = jSONObject.getInt("wt");
        this.f187a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m205a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f186a);
        jSONObject.put("size", this.f37398c);
        jSONObject.put("ts", this.f37397b);
        jSONObject.put("wt", this.f37396a);
        jSONObject.put("expt", this.f187a);
        return jSONObject;
    }
}
