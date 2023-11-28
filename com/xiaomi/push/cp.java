package com.xiaomi.push;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cp {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f177a;

    /* renamed from: a  reason: collision with other field name */
    public String f178a;
    public long b;
    public long c;

    public cp() {
        this(0, 0L, 0L, null);
    }

    public cp(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f177a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f178a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cp a(JSONObject jSONObject) {
        this.f177a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f178a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m344a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f177a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f178a);
        return jSONObject;
    }
}
