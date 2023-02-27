package com.xiaomi.push;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class cp {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f181a;

    /* renamed from: a  reason: collision with other field name */
    public String f182a;
    public long b;
    public long c;

    public cp() {
        this(0, 0L, 0L, null);
    }

    public cp(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f181a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f182a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cp a(JSONObject jSONObject) {
        this.f181a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f182a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m251a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f181a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f182a);
        return jSONObject;
    }
}
