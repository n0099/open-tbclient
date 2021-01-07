package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    private int f14221a;

    /* renamed from: a  reason: collision with other field name */
    private long f259a;

    /* renamed from: a  reason: collision with other field name */
    private String f260a;

    /* renamed from: b  reason: collision with root package name */
    private long f14222b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.f14221a = i;
        this.f259a = j;
        this.c = j2;
        this.f14222b = System.currentTimeMillis();
        if (exc != null) {
            this.f260a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f14221a;
    }

    public cu a(JSONObject jSONObject) {
        this.f259a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong("size");
        this.f14222b = jSONObject.getLong("ts");
        this.f14221a = jSONObject.getInt("wt");
        this.f260a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m235a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f259a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.f14222b);
        jSONObject.put("wt", this.f14221a);
        jSONObject.put("expt", this.f260a);
        return jSONObject;
    }
}
