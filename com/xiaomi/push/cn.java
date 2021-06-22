package com.xiaomi.push;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    public int f41178a;

    /* renamed from: a  reason: collision with other field name */
    public long f186a;

    /* renamed from: a  reason: collision with other field name */
    public String f187a;

    /* renamed from: b  reason: collision with root package name */
    public long f41179b;

    /* renamed from: c  reason: collision with root package name */
    public long f41180c;

    public cn() {
        this(0, 0L, 0L, null);
    }

    public cn(int i2, long j, long j2, Exception exc) {
        this.f41178a = i2;
        this.f186a = j;
        this.f41180c = j2;
        this.f41179b = System.currentTimeMillis();
        if (exc != null) {
            this.f187a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f41178a;
    }

    public cn a(JSONObject jSONObject) {
        this.f186a = jSONObject.getLong("cost");
        this.f41180c = jSONObject.getLong("size");
        this.f41179b = jSONObject.getLong("ts");
        this.f41178a = jSONObject.getInt("wt");
        this.f187a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m204a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f186a);
        jSONObject.put("size", this.f41180c);
        jSONObject.put("ts", this.f41179b);
        jSONObject.put("wt", this.f41178a);
        jSONObject.put("expt", this.f187a);
        return jSONObject;
    }
}
